package com.example.hobbie.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.sharp.Check
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard
import com.example.hobbie.ui.shared.BottomSheetFilter.BottomSheet
import com.example.hobbie.ui.screens.home.components.ImageAndBlur
import kotlinx.coroutines.launch

@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val homeViewModel: HomeViewModel = hiltViewModel()

    val events = homeViewModel.events.collectAsState()

    val states = events.value.map { it to rememberSwipeableCardState() }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 108.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Vitória",
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 32.sp,
                    fontWeight = FontWeight(700),
                    color = Color.Transparent,
                )
            )

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Pra voce",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                    )
                )

                Text(
                    text = "Vitória",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                    )
                )
            }

            FilledIconButton(
                onClick = {
                    homeViewModel.onChangeBottomSheetState()
                },
                modifier = Modifier,
                shape = RoundedCornerShape(size = 8.dp),
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = Color.White,
                )
            ) {
                Icon(
                    Icons.Sharp.Menu,
                    contentDescription = "Filtro",
                    tint = Color(0xFFFF7930)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            states.forEach { (event, state) ->
                if (state.swipedDirection == null) {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .fillMaxSize()
                            .swipableCard(
                                state = state,
                                blockedDirections = listOf(Direction.Down, Direction.Up),
                                onSwiped = { direction ->
                                    homeViewModel.onCardSwipe(direction, event, navController)
                                },
                                onSwipeCancel = {
                                    Log.d("Swipeable-Card", "Cancelled swipe")
                                },
                            ),
                    ) {
                        ImageAndBlur(
                            thumbnail = event.thumbnail
                        )

                        Column(
                            modifier = Modifier
                                .background(color = Color(0xFF000000))
                                .clip(RoundedCornerShape(
                                    bottomStart = 12.dp, bottomEnd = 12.dp
                                ))
                                .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
                        ) {
                            Text(
                                text = event.name,
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    lineHeight = 32.sp,
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFFFFFFF),
                                )
                            )
                            Text(
                                text = "${event.description} - ${event.date}",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    fontWeight = FontWeight(450),
                                    color = Color(0xFFFFFFFF),
                                )
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            FilledIconButton(
                                onClick = {
                                    scope.launch {
                                        homeViewModel.onCardSwipe(Direction.Right, event, navController)
                                        state.swipe(Direction.Right)
                                    }
                                    Log.d("Tinder Swipe", "Clicou nao")
                                },
                                modifier = Modifier
                                    .size(72.dp),
                                colors = IconButtonDefaults.filledIconButtonColors(
                                    containerColor = Color(0xFF000000),
                                ),
                            ) {
                                Icon(
                                    Icons.Rounded.Clear,
                                    contentDescription = "Não",
                                    tint = Color(0xFFF27121),
                                    modifier = Modifier
                                        .size(30.dp)
                                )
                            }

                            FilledIconButton(
                                onClick = {
                                    scope.launch {
                                        homeViewModel.onCardSwipe(Direction.Left, event, navController)
                                        state.swipe(Direction.Left)
                                    }
                                    Log.d("Tinder Swipe", "Clicou like")
                                },
                                modifier = Modifier
                                    .size(96.dp),
                                colors = IconButtonDefaults.filledIconButtonColors(
                                    containerColor = Color(0xFFF27121),
                                ),
                            ) {
                                Icon(
                                    Icons.Sharp.Check,
                                    contentDescription = "Não",
                                    tint = Color(0xFF000000)
                                )
                            }

                            FilledIconButton(
                                onClick = {
                                    Log.d("Tinder Swipe", "Clicou no favorito")
                                },
                                modifier = Modifier
                                    .size(72.dp),
                                colors = IconButtonDefaults.filledIconButtonColors(
                                    containerColor = Color(0xFF000000),
                                ),
                            ) {
                                Icon(
                                    Icons.Rounded.Star,
                                    contentDescription = "Não",
                                    tint = Color(0xFFF27121),
                                    modifier = Modifier
                                        .size(30.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

    }

    BottomSheet(
        isBottomSheetOpen = homeViewModel.isBottomSheetOpen.value,
        onChangeBottomSheetState = {
            homeViewModel.onChangeBottomSheetState()
        }
    )
}
