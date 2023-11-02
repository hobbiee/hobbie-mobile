package com.example.hobbie.ui

sealed class Destinations(
    val route: String,
    val title: String? = null,
    val icon: Int? = null
) {

    object LOGIN : Destinations("login")

    object HOME : Destinations("home")

}


//object Routes {
//    const val LOGIN = "login"
//    const val HOME = "home"
//}