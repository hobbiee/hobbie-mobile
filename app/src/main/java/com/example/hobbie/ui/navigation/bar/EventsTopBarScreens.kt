package com.example.hobbie.ui.navigation.bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.hobbie.ui.navigation.graphs.Graph

sealed class EventsTopBarScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Pendentes : HomeBottomBarScreens(
        route = "pendentes",
        title = "Pendentes",
        icon = Icons.Default.Home
    )

    object Confirmados : HomeBottomBarScreens(
        route = "confirmados",
        title = "Confirmados",
        icon = Icons.Default.Home
    )

    object MeusEventos : HomeBottomBarScreens(
        route = "meus-eventos",
        title = "Meus Eventos",
        icon = Icons.Default.Home
    )
}