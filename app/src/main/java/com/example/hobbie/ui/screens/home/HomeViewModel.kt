package com.example.hobbie.ui.screens.home

import android.util.Log
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.SwipeableCardState
import com.example.hobbie.models.EventItem
import com.example.hobbie.repository.EventRepository
import com.example.hobbie.repository.FilterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val filterRepository: FilterRepository
) : ViewModel() {
    val events: StateFlow<List<EventItem>> get() = eventRepository.events

    val isBottomSheetOpen = filterRepository.isBottomSheetOpen

    fun onChangeBottomSheetState() {
        filterRepository.onChangeBottomSheetState()
    }

    fun onCardSwipe(direction: Direction, event: EventItem, navController: NavHostController) {
        Log.d("HomeViewModel", "onCardSwipe: ${direction.name}")
        when (direction.name) {
            "Left" -> {
                navController.navigate("event/${event.id}")
                Log.d("HomeViewModel", "onCardSwipe: LEFT")
            }
            "Right" -> {
                Log.d("HomeViewModel", "onCardSwipe: RIGHT")
            }
            else -> {
                Log.d("HomeViewModel", "onCardSwipe: NONE")}
        }
    }

    init {
        viewModelScope.launch {
            eventRepository.getEvents()
        }
    }
}
