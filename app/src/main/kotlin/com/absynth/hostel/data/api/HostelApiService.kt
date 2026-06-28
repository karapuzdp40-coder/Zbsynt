package com.absynth.hostel.data.api

import com.absynth.hostel.data.model.Room
import retrofit2.http.GET

interface HostelApiService {
    @GET("rooms")
    suspend fun getAllRooms(): List<Room>
}