package ca.josuelubaki.profilecard.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.josuelubaki.profilecard.AppBar
import ca.josuelubaki.profilecard.ProfileCard
import ca.josuelubaki.profilecard.ProfileContent
import ca.josuelubaki.profilecard.ProfilePicture
import ca.josuelubaki.profilecard.UserListPage
import ca.josuelubaki.profilecard.UserProfile
import ca.josuelubaki.profilecard.ui.theme.ProfileCardTheme
import ca.josuelubaki.profilecard.userProfileList


@Composable
fun UserProfileDetailsPage(userProfile : UserProfile = userProfileList[0]) {
    Scaffold(
        topBar = { AppBar() }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val (name, status, pictureUrl) = userProfile
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

@Preview(showBackground = false)
@Composable
fun UserProfileDetailsPagePreview() {
    ProfileCardTheme(darkTheme = false) {
        UserProfileDetailsPage()
    }
}