package com.example.hobbie.repository

import com.example.hobbie.api.HobbieAPI
import com.example.hobbie.models.Event
import com.example.hobbie.models.EventItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class EventRepository @Inject constructor(
    private val hobbieAPI: HobbieAPI
) {
    private val _events = MutableStateFlow<List<EventItem>>(emptyList())

    val events: StateFlow<List<EventItem>> get() = _events

    suspend fun getEvents() {
        val result = hobbieAPI.getPlayerEvents()

        if (result.isSuccessful && result.body() != null) {
//        if (false) {
            _events.emit(result.body()!!)
        } else {
            _events.emit(
                listOf(
                    EventItem(
                        id = 1,
                        name = "Meu evento de futebol",
                        description = "Venha participar do meu evento de futebol na quadra 10",
                        date = "14/11/2023",
                        startTime = "19:0",
                        endTime = "20:34",
                        capacity = 10,
                        latitude = -20.295845,
                        longitude = -40.29005,
                        numberOfParticipants = 1,
                        thumbnail = "https://variety.com/wp-content/uploads/2021/07/Rick-Astley-Never-Gonna-Give-You-Up.png?w=1024",
                        active = true,
                        adminName = "John Doe",
                        adminAvatar = "https://hobbie.s3.amazonaws.com/1699808903278-hobbie-logo.png",
                        categories = listOf("SOCCER"),
                        distance = 385.52
                    ),
                    EventItem(
                        id = 2,
                        name = "Campeonato de Beach Soccer",
                        description = "A melhor disputa da praia",
                        date = "17/11/2023",
                        startTime = "12:20",
                        endTime = "18:20",
                        capacity = 6,
                        latitude = -20.298693,
                        longitude = -40.29137,
                        numberOfParticipants = 1,
                        thumbnail = "https://c.wallhere.com/photos/e5/d3/vertical_animation_fantasy_art-1693403.jpg!d",
                        active = true,
                        adminName = "John Doe",
                        adminAvatar = "https://hobbie.s3.amazonaws.com/1699808903278-hobbie-logo.png",
                        categories = listOf("SOCCER", "BEACH SOCCER"),
                        distance = 79.2
                    ),
                )
            )
        }
    }
}