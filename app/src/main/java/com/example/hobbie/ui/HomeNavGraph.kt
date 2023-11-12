package com.example.hobbie.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hobbie.ui.screens.home.HomeScreen

@Composable
fun HomeNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = "home_nav",
        startDestination = Destinations.HOME.route
    ){
        composable(
            route = Destinations.HOME.route
        ) {
            HomeScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeLayout(
    navController: NavHostController  = rememberNavController(),
) {
    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .clip(RoundedCornerShape(percent = 100)),
                containerColor = Color.White,
            ) {
                NavigationBarItem(selected = true, onClick = { /*TODO*/ }, icon = { /*TODO*/ })

                NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = { /*TODO*/ })

                NavigationBarItem(selected = false , onClick = { /*TODO*/ }, icon = { /*TODO*/ })

                NavigationBarItem(selected = false , onClick = { /*TODO*/ }, icon = { /*TODO*/ })
            }
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxSize()
                    .background(color = Color(0xFFF1E8DA)),

            ) {
                HomeNavGraph(
                    navController = navController
                )
            }
        }
    )
}

