package ca.josuelubaki.profilecard.pages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ca.josuelubaki.profilecard.UserProfile
import ca.josuelubaki.profilecard.components.AppBar
import ca.josuelubaki.profilecard.components.ProfileCard
import ca.josuelubaki.profilecard.ui.theme.ProfileCardTheme
import ca.josuelubaki.profilecard.userProfileList


@Composable
fun UserListPage(usersList : List<UserProfile> = userProfileList) {
    Scaffold(
        topBar = { AppBar() }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(content = {
                items(usersList){
                    ProfileCard(it)
                }
            })
        }
    }
}

@Preview(showBackground = false)
@Composable
fun UserListPagePreview() {
    ProfileCardTheme(darkTheme = false) {
        UserListPage()
    }
}