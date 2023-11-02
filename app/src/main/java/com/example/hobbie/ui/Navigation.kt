package com.example.hobbie.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hobbie.ui.screens.home.HomeScreen
import com.example.hobbie.ui.screens.login.LoginScreen



@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destinations.LOGIN.route
    ) {

        // AQUI VAI ENTRAR UMA NESTED NAVIGATION P CRIAR USUÁRIO E TODA AS FIRULAS DELE
        // MAS, UM PROBLEMA DE CADA VEZ
        composable(
            route = Destinations.LOGIN.route
        ) {
            LoginScreen()
        }


        composable(
            route = Destinations.HOME.route
        ) {
            HomeScreen()
        }

    }
}