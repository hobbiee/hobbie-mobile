package com.example.hobbie.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hobbie.ui.screens.home.HomeScreen
import com.example.hobbie.ui.screens.login.LoginScreen


@Composable
fun RootNavigationGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
//        startDestination = Destinations.LOGIN.route,
        startDestination = Graph.HOME,
        route = Graph.ROOT
    ) {

        // AQUI VAI ENTRAR UMA NESTED NAVIGATION P CRIAR USUÁRIO E TODA AS FIRULAS DELE
        // MAS, UM PROBLEMA DE CADA VEZ
        composable(
            route = Destinations.LOGIN.route
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
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
}












        // AQUI VAI ENTRAR UMA NESTED NAVIGATION P CRIAR USUÁRIO E TODA AS FIRULAS DELE
        // MAS, UM PROBLEMA DE CADA VEZ
//        composable(
//            route = Destinations.LOGIN.route
//        ) {
//            LoginScreen(
//                navController = navController
//            )
//        }
//
//        composable(
//            route = Destinations.HOME.route
//        ) {
//            HomeScreen()
//        }

//        navigation(
//            startDestination = Destinations.HOME.route,
//            route = Destinations.HOME.route
//        ) {
//
//            composable(
//                route = Destinations.HOME.route
//            ) {
//                HomeScreen()
//            }
//        }


