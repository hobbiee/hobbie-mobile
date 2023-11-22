package com.example.hobbie.ui.navigation.bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.hobbie.ui.navigation.graphs.Graph

sealed class HomeBottomBarScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Map : HomeBottomBarScreens(
        route = "MAP",
        title = "MAP",
        icon = Icons.Default.Home
    )

    object Swipe : HomeBottomBarScreens(
        route = "SWIPE",
        title = "SWIPE",
        icon = Icons.Default.PlayArrow
    )

    object Events : HomeBottomBarScreens(
        route = Graph.EVENTS,
        title = "EVENTS",
        icon = Icons.Default.DateRange
    )

    object Profile : HomeBottomBarScreens(
        route = "PROFILE",
        title = "PROFILE",
        icon = Icons.Default.AccountCircle
    )
}