package com.example.weatherapplication.composeversion


import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.remote.Repository
import com.example.weatherapplication.remote.data.Response
import com.example.weatherapplication.remote.data.WeatherObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repo: Repository
) : ViewModel() {
    private val _weatherData = MutableLiveData<WeatherObject>()
    val weatherData: LiveData<WeatherObject> = _weatherData

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    val isLoadingCompose = mutableStateOf(false)
    val testVal = mutableStateOf("")

    private val _errorOccurred = MutableLiveData(false)
    val errorOccurred = _errorOccurred
    fun getWeatherLatLong(lat: String, long: String) {
        viewModelScope.launch {
            isLoadingCompose.value = true
            val result = repo.getWeatherLatLong(lat, long)
            when (result) {
                is Response.Success -> {
                    val data = result.data!!
                    _weatherData.value = WeatherObject(
                        base = data.base,
                        clouds = data.clouds,
                        cod = data.cod,
                        coord = data.coord,
                        dt = data.dt,
                        id = data.id,
                        main = data.main,
                        name = data.name,
                        sys = data.sys,
                        timezone = data.timezone,
                        visibility = data.visibility,
                        weather = data.weather,
                        wind = data.wind
                    )
                    isLoadingCompose.value = false
                }

                is Response.Loading -> {
                    _isLoading.value = true
                }

                is Response.Error -> {
                    _errorOccurred.value = true
                    isLoadingCompose.value = false
                }
            }
        }

    }

    fun getWeatherLatLongTest(lat: String, long: String) {
        viewModelScope.launch {
            repo.getWeatherLatLongTest(lat, long)
        }
    }
}