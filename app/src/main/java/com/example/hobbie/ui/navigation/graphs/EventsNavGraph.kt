package com.example.hobbie.ui.navigation.graphs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun EventsNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.EVENTS,
        startDestination = "pendentes"
    ) {
        composable(
            route = "pendentes"
        ) {
            Text(text = "Pendentes")
        }

        composable(
            route = "confirmados"
        ) {
            Text(text = "Confirmados")
        }

        composable(
            route = "meus-eventos"
        ) {
            Text(text = "Meus Eventos")
        }
    }
}