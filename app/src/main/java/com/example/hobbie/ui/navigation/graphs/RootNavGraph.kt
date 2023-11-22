package com.example.hobbie.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hobbie.ui.navigation.layout.HomeLayout
import com.example.hobbie.ui.screens.login.LoginScreen

@Composable
fun RootNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Graph.HOME,
        route = Graph.ROOT
    ) {
        // AQUI VAI ENTRAR UMA NESTED NAVIGATION P CRIAR USUÁRIO E TODA AS FIRULAS DELE
        // MAS, UM PROBLEMA DE CADA VEZ
        composable(
            route = Graph.AUTHENTICATION
        ) {
            LoginScreen(
                navController = navController
            )
        }

        composable(
            route = Graph.HOME
        ) {
            HomeLayout()
        }
    }
}

object Graph {
    const val ROOT = "root"
    const val AUTHENTICATION = "auth"
    const val HOME = "home"
    const val EVENTS = "events"
}
