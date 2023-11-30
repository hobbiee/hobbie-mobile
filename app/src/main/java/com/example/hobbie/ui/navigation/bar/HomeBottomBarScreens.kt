package com.example.hobbie.ui.navigation.bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.hobbie.R
import com.example.hobbie.ui.navigation.graphs.Graph

sealed class HomeBottomBarScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Map : HomeBottomBarScreens(
        route = "MAP",
        title = "MAP",
        icon = Icons.Default.LocationOn
    )

    object Swipe : HomeBottomBarScreens(
        route = "SWIPE",
        title = "SWIPE",
        icon = Icons.Default.PlayArrow
    )

    object Events : HomeBottomBarScreens(
        route = Graph.EVENTS,
        title = "EVENTS",
        icon = Icons.Outlined.DateRange
    )

    object Profile : HomeBottomBarScreens(
        route = "PROFILE",
        title = "PROFILE",
        icon = Icons.Outlined.AccountCircle
    )
}