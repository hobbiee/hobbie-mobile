package com.example.hobbie.ui.navigation.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hobbie.ui.navigation.bar.EventsTopBar
import com.example.hobbie.ui.navigation.graphs.EventsNavGraph

@Composable
fun EventsLayout(
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        topBar = {
            EventsTopBar(
                navController = navController
            )
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .background(color = Color(0xFFF1E8DA)),
            ) {
                EventsNavGraph(
                    navController = navController
                )
            }
        }
    )
}