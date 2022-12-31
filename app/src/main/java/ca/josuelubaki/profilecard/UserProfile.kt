package ca.josuelubaki.profilecard

data class UserProfile(val name: String, val status : Boolean, val drawable : Int)

val userProfileList = arrayListOf(
    UserProfile("Josue Lubaki", true, R.drawable.profile_boy),
    UserProfile("Anna Smith", false, R.drawable.profile_woman),
    UserProfile("John Doe", true, R.drawable.profile_man),
    UserProfile("Sarah Jordan", true, R.drawable.profile_girl),
    UserProfile("kevin Lubaki", false, R.drawable.profile_boy),
    UserProfile("Deborah Scoot", true, R.drawable.profile_woman),
    UserProfile("Paul Doe", false, R.drawable.profile_man),
    UserProfile("Chantal Belanger", false, R.drawable.profile_girl),
)