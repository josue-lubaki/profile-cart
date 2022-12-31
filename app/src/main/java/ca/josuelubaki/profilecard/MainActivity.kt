package ca.josuelubaki.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.josuelubaki.profilecard.ui.theme.ProfileCardTheme
import ca.josuelubaki.profilecard.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCardTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(usersList : List<UserProfile> = userProfileList) {
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

@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                modifier = Modifier.padding(12.dp)
            )
         },
        title = { Text("Application Users")}
    )
}

@Composable
fun ProfileCard(userProfile : UserProfile) {
    val (name, status, drawable) = userProfile

    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = 8.dp,
        backgroundColor = Color.White,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(drawable, status)
            ProfileContent(name, status)
        }
    }
}

@Composable
fun ProfilePicture(drawableId : Int, onlineStatus : Boolean) {
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
            painter = painterResource(id = drawableId),
            contentDescription = "content description",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent(userName : String, onlineStatus : Boolean) {
   Column(
       modifier = Modifier
           .padding(8.dp)
           .fillMaxWidth()
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

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    ProfileCardTheme(darkTheme = false) {
        MainScreen()
    }
}