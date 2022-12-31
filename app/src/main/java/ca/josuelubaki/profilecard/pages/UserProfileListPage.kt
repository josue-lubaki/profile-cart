package ca.josuelubaki.profilecard.pages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import ca.josuelubaki.profilecard.Page.USER_PROFILE_DETAILS
import ca.josuelubaki.profilecard.UserProfile
import ca.josuelubaki.profilecard.components.AppBar
import ca.josuelubaki.profilecard.components.ProfileCard
import ca.josuelubaki.profilecard.ui.theme.ProfileCardTheme
import ca.josuelubaki.profilecard.userProfileList


@Composable
fun UserListPage(usersList : List<UserProfile>, navController : NavHostController?) {
    Scaffold(
        topBar = { AppBar(
            title = "Users List",
            icon = Icons.Default.Home,
        )}
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colors.background
        ) {
            LazyColumn(content = {
                items(usersList){userProfile ->
                    ProfileCard(
                        userProfile = userProfile,
                        clickAction = {
                            navController?.navigate("$USER_PROFILE_DETAILS/${userProfile.id}")
                        }
                    )
                }
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserListPagePreview() {
    ProfileCardTheme {
        UserListPage(usersList = userProfileList, navController = null)
    }
}