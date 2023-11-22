package com.example.hobbie.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hobbie.ui.navigation.layout.EventsLayout
import com.example.hobbie.ui.screens.event.EventScreen
import com.example.hobbie.ui.screens.home.HomeScreen
import com.example.hobbie.ui.screens.maps.MapsScreen

@Composable
fun HomeNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = "swipe"
    ){
        composable(
            route = "map"
        ) {
            MapsScreen()
        }

        composable(
            route = "swipe"
        ) {
            HomeScreen(navController)
        }

        composable(
            route = "event/{id}"
        ) {
            val id = it.arguments?.getString("id") ?: "1"

            SavedStateHandle()["id"] = id

            EventScreen(navController)
        }

        composable(
            route = Graph.EVENTS
        ) {
            EventsLayout()
        }
    }
}
