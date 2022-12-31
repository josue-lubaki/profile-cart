package ca.josuelubaki.profilecard.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ca.josuelubaki.profilecard.UserProfile
import ca.josuelubaki.profilecard.ui.theme.lightGreen
import coil.compose.rememberAsyncImagePainter


@Composable
fun ProfileCard(userProfile : UserProfile, clickAction : () -> Unit) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable(
                onClick = { clickAction.invoke() },
                onClickLabel = "Click to see user details"
            ),
        elevation = 8.dp,
        backgroundColor = Color.White,
    ) {
        val (name, status, pictureUrl) = userProfile
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(pictureUrl, status)
            ProfileContent(name, status)
        }
    }
}

@Composable
fun ProfilePicture(pictureUrl : String, onlineStatus : Boolean, imageSize : Dp = 72.dp) {
    Card(
        shape = CircleShape,
        border= BorderStroke(
            width = 2.dp,
            color =
            if(onlineStatus)
                MaterialTheme.colors.lightGreen
            else Color.Red),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {

        Image(
            painter = rememberAsyncImagePainter(pictureUrl),
            contentDescription = "Profile Picture",
            modifier = Modifier.size(imageSize),
            contentScale = ContentScale.Crop,
        )

        /* AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(pictureUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.profile_woman),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(72.dp).clip(CircleShape)
        ) */
    }
}

@Composable
fun ProfileContent(
    userName : String,
    onlineStatus : Boolean,
    horizontalAlignment : Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = horizontalAlignment
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides
                    if(onlineStatus) ContentAlpha.high
                    else ContentAlpha.medium
        ) {
            Text(
                text = userName,
                style = MaterialTheme.typography.h5
            )
        }

        CompositionLocalProvider(
            LocalTextStyle provides MaterialTheme.typography.body2,
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(
                text = if (onlineStatus) "Active now" else "Offline",
            )
        }
    }
}