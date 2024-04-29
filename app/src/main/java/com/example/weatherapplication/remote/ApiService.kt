package com.example.weatherapplication.remote

import com.example.weatherapplication.remote.data.Response
import com.example.weatherapplication.remote.data.WeatherObject
import com.example.weatherapplication.resources.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("weather")
    suspend fun getWeatherLatLong(
        @Query("lat") lat: String,
        @Query("lon") long: String,
        @Query("appid") apiKey: String
    ): WeatherObject

    @GET("forecast")
    suspend fun getForecastLatLong(
        @Query("lat") lat: String,
        @Query("lon") long: String,
        @Query("appid") apiKey: String
    ): WeatherObject
}