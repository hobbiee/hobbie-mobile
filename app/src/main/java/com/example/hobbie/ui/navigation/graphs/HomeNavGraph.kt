package com.example.hobbie.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
    navController: NavHostController,
    hideBottomBar: MutableState<Boolean>
) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = "swipe"
    ){
        composable(
            route = "map"
        ) {
            MapsScreen(
                hideBottomBar = hideBottomBar,
                navController = navController
            )
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
