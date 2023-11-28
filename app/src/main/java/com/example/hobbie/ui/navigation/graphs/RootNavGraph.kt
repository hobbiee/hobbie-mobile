package com.example.hobbie.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.hobbie.ui.navigation.layout.HomeLayout
import com.example.hobbie.ui.screens.authentication.login.LoginScreen
import com.example.hobbie.ui.screens.authentication.register.SignUpScreen

@Composable
fun RootNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Graph.AUTHENTICATION,
        route = Graph.ROOT
    ) {
        navigation(
            startDestination = Graph.SIGN_UP,
            route = Graph.AUTHENTICATION,
        ) {
            composable(
                route = Graph.SIGN_UP
            ) {
                SignUpScreen(navController = navController)
            }

            composable(
                route = Graph.SIGN_IN
            ) {
                LoginScreen(navController = navController)
            }
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
    const val SIGN_IN = "sign_in"
    const val SIGN_UP = "sign_up"
    const val HOME = "home"
    const val EVENTS = "events"
}
