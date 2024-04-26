package com.example.weatherapplication.remote

import com.example.weatherapplication.remote.data.Response
import com.example.weatherapplication.remote.data.WeatherObject
import com.example.weatherapplication.resources.Constants
import com.example.weatherapplication.resources.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/onecall?lat={latVal}&lon={longVal}&exclude={}&appid={$BuildConfig.API_KEY")

    suspend fun getWeatherLatLong(
        @Path("latVal") lat: String,
        @Path("longVal") long: String
    ):
            Response<WeatherObject>
}