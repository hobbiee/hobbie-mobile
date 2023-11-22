package com.example.hobbie.ui.navigation

sealed class Destinations(
    val route: String,
    val title: String? = null,
    val icon: Int? = null
) {

    object LOGIN : Destinations("login")

    object HOME : Destinations("home")

}