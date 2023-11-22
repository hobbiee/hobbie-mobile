package com.example.hobbie.ui.navigation.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hobbie.ui.navigation.bar.HomeBottomBar
import com.example.hobbie.ui.navigation.graphs.HomeNavGraph

@Composable
fun HomeLayout(
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        bottomBar = {
            HomeBottomBar(
                navController = navController
            )
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
