package com.example.hobbie.models

class Event : ArrayList<EventItem>()

data class EventItem(
    val id: Int,
    val active: Boolean,
    val adminAvatar: String,
    val adminName: String,
    val capacity: Int,
    val categories: List<String>,
    val date: String,
    val description: String,
    val distance: Double,
    val endTime: String,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val numberOfParticipants: Int,
    val startTime: String,
    val thumbnail: String? = "https://variety.com/wp-content/uploads/2021/07/Rick-Astley-Never-Gonna-Give-You-Up.png?w=1024",
)