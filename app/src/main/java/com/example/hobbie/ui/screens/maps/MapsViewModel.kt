package com.example.hobbie.ui.screens.maps

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.hobbie.models.EventItem
import com.example.hobbie.repository.EventRepository
import com.example.hobbie.repository.FilterRepository
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("MissingPermission")
@HiltViewModel
class MapsViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val filterRepository: FilterRepository,
    @ApplicationContext appContext: Context,
) : ViewModel() {
    private val locationClient = LocationServices.getFusedLocationProviderClient(appContext)
    val events: StateFlow<List<EventItem>> get() = eventRepository.events

    val isBottomSheetOpen = filterRepository.isBottomSheetOpen

    private val _userLocation = MutableStateFlow<LatLng?>(null)

    val userLocation: StateFlow<LatLng?> get() = _userLocation

    private val _infoWindowEvent = MutableStateFlow<EventItem?>(null)

    val infoWindowEvent: StateFlow<EventItem?> get() = _infoWindowEvent

    private val _isMapLoaded = MutableStateFlow(false)

    val isMapLoaded: StateFlow<Boolean> get() = _isMapLoaded

    val mapDefaultLocation = LatLng(-24.9465856, -63.0136597)

    val mapDefaultZoom = 13f

    private val _cameraPositionState = MutableStateFlow<CameraPositionState>(
        CameraPositionState(
            position = CameraPosition.fromLatLngZoom(mapDefaultLocation, 0f)
        )
    )

    val cameraPositionState: StateFlow<CameraPositionState> get() = _cameraPositionState

    suspend fun onMapLoaded() {
        Log.d("location", "onMapLoaded")

        _isMapLoaded.emit(true)

        moveCameraPositionToEvents()
    }

    suspend fun onInfoWindowOpen(event: EventItem) {
        _infoWindowEvent.emit(event)
    }

    fun onEventClick(navController: NavController) {
        navController.navigate("event/${infoWindowEvent.value?.id}")
    }

    suspend fun moveCameraPositionToUserLocation() {
        if (
//            isMapLoaded.value &&
            userLocation.value != null
        ) {
            _cameraPositionState.emit(
                CameraPositionState(
                    position = CameraPosition.fromLatLngZoom(
                        LatLng(
                            userLocation.value!!.latitude,
                            userLocation.value!!.longitude
                        ), 13f
                    )
                )
            )
        }
    }

    suspend fun moveCameraPositionToEvents() {
        val eventsLength = events.value

        val eventsMean = events.value
            .fold(Pair(0.0, 0.0)) { acc, eventItem ->
                Pair(
                    acc.first + eventItem.latitude,
                    acc.second + eventItem.longitude)
            }

        val latLngMean = LatLng(
            eventsMean.first / eventsLength.size,
            eventsMean.second / eventsLength.size
        )

        _cameraPositionState.emit(
            CameraPositionState(
                position = CameraPosition.fromLatLngZoom(
                    latLngMean, mapDefaultZoom
                )
            )
        )
    }

    suspend fun onInfoWindowClose() {
        _infoWindowEvent.emit(null)
    }

    fun onChangeBottomSheetState() {
        filterRepository.onChangeBottomSheetState()
    }

    init {
        viewModelScope.launch {
            Log.d("location", "init")

//            this.async {
                eventRepository.getEvents()
//            }

//            this.async {
                val call = locationClient.getCurrentLocation(
                    Priority.PRIORITY_HIGH_ACCURACY,
                    null
                )

                call.addOnCompleteListener {
                    Log.d("location", "addOnCompleteListener")
                    Log.d("location", "result: ${it.result.toString()}")
                    Log.d("location", "latitude: ${it.result.latitude} longitude: ${it.result.longitude}")
                    _userLocation.tryEmit(LatLng(it.result.latitude, it.result.longitude))
                }

                moveCameraPositionToEvents()
//            }

            Log.d("location", "depois")
        }
    }
}