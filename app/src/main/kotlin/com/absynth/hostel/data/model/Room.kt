package com.absynth.hostel.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rooms")
data class Room(
    @PrimaryKey
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