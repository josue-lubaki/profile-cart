package ca.josuelubaki.profilecard.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


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
        title = { Text("Application Users") }
    )
}
