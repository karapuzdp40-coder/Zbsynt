package com.absynth.hostel.data.model

data class Room(
    val id: String,
    val name: String,
    val type: String,
    val description: String,
    val pricePerNight: Double,
    val capacity: Int,
    val amenities: String = "",
    val images: String = "",
    val available: Boolean = true,
    val rating: Double = 4.8,
    val reviews: Int = 142
)