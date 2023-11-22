package com.example.hobbie.ui.screens.maps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hobbie.ui.shared.BottomSheetFilter.BottomSheet
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapsScreen() {
    val mapsViewModel: MapsViewModel = hiltViewModel()

    val userLocation = mapsViewModel.userLocation.collectAsState().value

    Box(

    ) {
        if (userLocation != null) {
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(userLocation, 10f)
            }

            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            ) {
                Marker(
                    state = MarkerState(position = userLocation),
                    title = "Singapore",
                    snippet = "Marker in Singapore"
                )
            }
        }
    }

    Button(
        onClick = {
            mapsViewModel.onChangeBottomSheetState()
        }
    ) {
        Text(text = mapsViewModel.isBottomSheetOpen.value.toString())
    }

    BottomSheet(
        isBottomSheetOpen = mapsViewModel.isBottomSheetOpen.value,
        onChangeBottomSheetState = {
            mapsViewModel.onChangeBottomSheetState()
        }
    )
}

@Composable
fun Map() {
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = singapore),
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }
}
