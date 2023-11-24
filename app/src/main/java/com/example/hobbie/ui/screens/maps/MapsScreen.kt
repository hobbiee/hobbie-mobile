package com.example.hobbie.ui.screens.maps

import android.widget.Spinner
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.hobbie.ui.shared.BottomSheetFilter.BottomSheet
import com.example.hobbie.ui.shared.ImageAndBlur
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch

@Composable
fun MapsScreen(
    hideBottomBar: MutableState<Boolean>,
    navController: NavController
) {
    val mapsViewModel: MapsViewModel = hiltViewModel()

    val events = mapsViewModel.events.collectAsState().value

    val infoWindowEvent = mapsViewModel.infoWindowEvent.collectAsState().value

    val cameraPositionState = mapsViewModel.cameraPositionState.collectAsState().value

    val isMapLoaded = mapsViewModel.isMapLoaded.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        FilledIconButton(
            onClick = {
                hideBottomBar.value = true
                mapsViewModel.onChangeBottomSheetState()
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .zIndex(99f)
                .padding(22.dp),
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

        Text(
            text = isMapLoaded.toString(),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .zIndex(100f),
            color = Color.Red
        )

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = {
                mapsViewModel.viewModelScope.launch {
                    mapsViewModel.onMapLoaded()
                }
            },
        ) {
            events.forEach {
                Marker(
                    state = MarkerState(position = LatLng(it.latitude, it.longitude)),
                    title = it.name,
                    snippet = it.description,
                    tag = it.id,
                    onClick = {
                        val eventClicked = events.first { event -> event.id == it.tag }

                        mapsViewModel.viewModelScope.launch {
                            if (infoWindowEvent != null) {
                                if (infoWindowEvent.id == eventClicked.id) {
                                    mapsViewModel.onInfoWindowClose()
                                    hideBottomBar.value = false
                                } else {
                                    mapsViewModel.onInfoWindowClose()
                                    mapsViewModel.onInfoWindowOpen(eventClicked)
                                    hideBottomBar.value = true
                                }
                            } else {
                                mapsViewModel.onInfoWindowOpen(eventClicked)
                                hideBottomBar.value = true
                            }
                        }

                        return@Marker true
                    }
                )
            }
        }



        if (infoWindowEvent != null) {
            AnimatedVisibility(
                visible = infoWindowEvent != null,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it }),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(290.dp)
                    .padding(12.dp)
                    .clip(RoundedCornerShape(8.dp)),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            mapsViewModel.onEventClick(
                                navController = navController,
                            )
                        }
                        .background(color = Color(0xFFF1E8DA))
                        .align(Alignment.BottomCenter),
                ) {
                    FilledIconButton(
                        onClick = {
                            mapsViewModel.viewModelScope.launch {
                                mapsViewModel.onInfoWindowClose()
                            }
                        },
                        modifier = Modifier
                            .padding(top = 10.dp, start = 10.dp)
                            .zIndex(99f),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = Color(0xFFF1E8DA),
                            contentColor = Color(0xFF000000)
                        )
                    ) {
                        Icon(
                            Icons.Filled.Clear,
                            contentDescription = "",
                            modifier = Modifier
                                .size(24.dp),
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                        ) {
                            ImageAndBlur(
                                thumbnail = infoWindowEvent.thumbnail
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(12.dp),
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = infoWindowEvent.name,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        lineHeight = 20.sp,
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF44403C),
                                    )
                                )

                                Box(
                                    modifier = Modifier
                                        .background(color = Color(0xFFFF7930), shape = RoundedCornerShape(percent = 100))
                                ) {
                                    Text(
                                        text = infoWindowEvent.capacity.toString(),
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            lineHeight = 16.sp,
                                            fontWeight = FontWeight(700),
                                            color = Color(0xFFFFFFFF),
                                        ),
                                        modifier = Modifier
                                            .padding(vertical = 4.dp, horizontal = 8.dp)
                                    )
                                }
                            }

                            Text(
                                text = "${infoWindowEvent.latitude} ${infoWindowEvent.longitude}",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF78716C),
                                )
                            )
                        }
                    }
                }
            }
        }
    }



    BottomSheet(
        isBottomSheetOpen = mapsViewModel.isBottomSheetOpen.value,
        onChangeBottomSheetState = {
            hideBottomBar.value = false
            mapsViewModel.onChangeBottomSheetState()
        }
    )
}

