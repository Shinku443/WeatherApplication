package com.example.weatherapplication.remote

class Repository(private val apiService: ApiService) {
    suspend fun getWeatherLatLong(lat: String, long: String) =
        apiService.getWeatherLatLong(lat, long)
}