package com.absynth.hostel.data.model

data class Booking(
    val id: String,
    val roomId: String,
    val roomName: String,
    val checkInDate: String,
    val checkOutDate: String,
    val guestName: String,
    val guestEmail: String,
    val guestPhone: String,
    val numberOfGuests: Int,
    val totalPrice: Double,
    val status: String = "pending",
    val createdAt: Long = System.currentTimeMillis()
)