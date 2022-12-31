package ca.josuelubaki.profilecard.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ca.josuelubaki.profilecard.UserProfile
import ca.josuelubaki.profilecard.components.AppBar
import ca.josuelubaki.profilecard.components.ProfileContent
import ca.josuelubaki.profilecard.components.ProfilePicture
import ca.josuelubaki.profilecard.ui.theme.ProfileCardTheme
import ca.josuelubaki.profilecard.userProfileList


@Composable
fun UserProfileDetailsPage(userId : Int, navController : NavHostController?) {
    Scaffold(
        topBar = { AppBar(
            title = "User Profile Details",
            icon = Icons.Default.ArrowBack,
            iconClickAction = {
                navController?.navigateUp()
            }
        ) }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val userProfile = userProfileList.first { userProfile -> userProfile.id == userId }
            val (_, name, status, pictureUrl) = userProfile
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ProfilePicture(pictureUrl, status, imageSize = 240.dp)
                ProfileContent(name, status, horizontalAlignment = Alignment.CenterHorizontally)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileDetailsPagePreview() {
    ProfileCardTheme {
        UserProfileDetailsPage(userId = 1, navController = null)
    }
}