package ca.josuelubaki.profilecard

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ca.josuelubaki.profilecard.Page.USERS_LIST
import ca.josuelubaki.profilecard.Page.USER_PROFILE_DETAILS
import ca.josuelubaki.profilecard.pages.UserListPage
import ca.josuelubaki.profilecard.pages.UserProfileDetailsPage

@Composable
fun UserNavigation(usersList : List<UserProfile> = userProfileList) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination= USERS_LIST // first page to show
    ){
        composable(route= USERS_LIST) {
            UserListPage(usersList, navController)
        }
        composable(
            route= "$USER_PROFILE_DETAILS/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            UserProfileDetailsPage(navBackStackEntry.arguments!!.getInt("userId"))
        }
    }
}

object Page {
    const val USERS_LIST = "userList"
    const val USER_PROFILE_DETAILS = "userProfileDetails"
}