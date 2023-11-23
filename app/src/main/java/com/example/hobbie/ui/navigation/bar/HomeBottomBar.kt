package com.example.hobbie.ui.navigation.bar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun HomeBottomBar(
    navController: NavHostController,
    hideBottomBar: MutableState<Boolean>
) {
    val screens = listOf(
        HomeBottomBarScreens.Map,
        HomeBottomBarScreens.Swipe,
        HomeBottomBarScreens.Events,
        HomeBottomBarScreens.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var bottomBarState by remember { mutableStateOf(true) }
    val route = navBackStackEntry?.destination?.route ?: ""

    bottomBarState = when {
        hideBottomBar.value -> {
            false
        }
        route.contains("event") -> {
            false
        }
        else -> {
            true
        }
    }

    AnimatedVisibility(
        visible = bottomBarState,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
    ) {
        NavigationBar(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .clip(RoundedCornerShape(percent = 100))
                .zIndex(1f),
            containerColor = Color.White,
        ) {
            screens.forEach { screen ->
                NavigationBarItem(
                    selected = currentDestination?.route == screen.route,
                    onClick = {
                        if (currentDestination?.route != screen.route) {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        }
                    },
                    icon = {
                        screen.icon?.let {
                            Icon(
                                imageVector = it,
                                contentDescription = screen.title,
                                modifier = Modifier
                                    .size(32.dp),
                            )
                        }
                    },
                    modifier = Modifier,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color(0xFFFF7930),
                        unselectedIconColor = Color(0xFF44403C),
                    )
                )
            }
        }
    }
}