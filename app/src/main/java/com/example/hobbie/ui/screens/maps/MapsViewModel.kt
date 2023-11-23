package com.example.hobbie.ui.screens.maps

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hobbie.models.EventItem
import com.example.hobbie.repository.EventRepository
import com.example.hobbie.repository.FilterRepository
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.internal.wait
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

    suspend fun onInfoWindowOpen(event: EventItem) {
        _infoWindowEvent.emit(event)
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

            this.async {
                eventRepository.getEvents()
            }

            this.async {
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
            }

            Log.d("location", "depois")
        }
    }
}