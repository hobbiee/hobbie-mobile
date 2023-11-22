package com.example.hobbie.ui.navigation.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun EventsTopBar(
    navController: NavHostController
) {
    val screens = listOf(
        EventsTopBarScreens.Pendentes,
        EventsTopBarScreens.Confirmados,
        EventsTopBarScreens.MeusEventos
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val route = navBackStackEntry?.destination?.route ?: ""

    NavigationBar(
        modifier = Modifier
            .height(143.dp)
            .shadow(elevation = 12.dp),
        containerColor = Color(0xFFF1E8DA),
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 24.dp, end = 24.dp),
        ){
            val boxWidth = getBoxWidth(this.maxWidth)

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedIconButton(
                        onClick = {
                            println("Clicou p voltar")
                            navController.navigate("home")
                        },
                        modifier = Modifier
                            .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                            .padding(6.dp)
                            .size(24.dp),
                        colors = IconButtonDefaults.outlinedIconButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color(0xFF000000)
                        )
                    ) {
                        Icon(
                            Icons.Rounded.ArrowBack,
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxSize(),
                        )
                    }


                    Text(
                        text = "Meus Eventos",
                        style = TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 32.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF44403C),
                        )
                    )

                    OutlinedIconButton(
                        onClick = {
                            navController.popBackStack()
                        },
                        modifier = Modifier
                            .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                            .padding(6.dp)
                            .size(24.dp),
                        colors = IconButtonDefaults.outlinedIconButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color(0xFF000000)
                        )
                    ) {
                        Icon(
                            Icons.Rounded.Add,
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxSize(),
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                LazyHorizontalGrid(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth(),
                    rows = GridCells.Fixed(1),
                ) {
                    items(screens) { screen ->
                        val isSelected = currentDestination?.route == screen.route
                        val defaultColor = if (isSelected) Color(0xFFFF7930) else Color(0xFFA8A29E)

                        Column(
                            modifier = Modifier
                                .width(boxWidth)
                                .clickable {
                                    if (currentDestination?.route != screen.route) {
                                        navController.navigate(screen.route) {
                                            popUpTo(navController.graph.startDestinationId)
                                            launchSingleTop = true
                                        }
                                    }
                                },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(10.dp))

                            Icon(
                                screen.icon,
                                contentDescription = screen.title,
                                modifier = Modifier
                                    .size(32.dp),
                                tint = defaultColor
                            )

                            Text(
                                text = screen.title,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    fontWeight = FontWeight(500),
                                    color = defaultColor,
                                )
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(5.dp)
                                    .background(color = defaultColor)
                            )

                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
}

fun getBoxWidth(rowMaxWidth: Dp): Dp {
    if (rowMaxWidth > 92.dp) {
        return 92.dp
    }
    return rowMaxWidth
}