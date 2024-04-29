package com.example.weatherapplication.remote

import com.example.weatherapplication.remote.data.Response
import com.example.weatherapplication.remote.data.WeatherObject
import com.example.weatherapplication.resources.Constants.API_KEY
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class Repository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getWeatherLatLong(lat: String, long: String): Response<WeatherObject> {
        val response = try {
            apiService.getWeatherLatLong(lat, long, API_KEY)
        } catch (e: Exception) {
            return Response.Error("An unknown has occurred")
        }
        return Response.Success(response)
    }

    suspend fun getWeatherLatLongTest(lat: String, long: String): Response<WeatherObject> {
        val response = try {
            apiService.getWeatherLatLong(lat, long, API_KEY)
        } catch (e: Exception) {
            return Response.Error("Error: $e")
        }
        return Response.Success(response)
    }
}