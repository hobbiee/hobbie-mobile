package com.example.hobbie.ui.screens.event

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hobbie.models.EventItem
import com.example.hobbie.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val id = savedStateHandle.get<String>("id") ?: "1"
    private val _events: StateFlow<List<EventItem>> get() = eventRepository.events

    val event: StateFlow<EventItem?> = _events.map { events ->
        events.firstOrNull{ it.id.toString() == id }
    }.stateIn(viewModelScope, started = SharingStarted.WhileSubscribed(), initialValue = null)

    init {
        viewModelScope.launch {
            eventRepository.getEvents()
        }
    }
}