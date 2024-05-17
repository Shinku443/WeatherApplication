package com.example.weatherapplication.composeversion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherapplication.remote.data.Weather
import timber.log.Timber


@Composable
fun MainWeatherScreen(
    navController: NavController,
    viewModel: WeatherViewModel = hiltViewModel()
) {
    var showLatLonDialog = remember { mutableStateOf(false) }
    var isLoading by remember { viewModel.isLoadingCompose }
    var selectedLat by remember { mutableStateOf("") }
    var selectedLon by remember { mutableStateOf("") }

    Surface(
        Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Button(onClick = { showLatLonDialog.value = true }) {
                Text("Lat Long: ")
            }

            if (isLoading) {
                CircularProgressIndicator()
            } else {
                if (showLatLonDialog.value) {
                    Column {

                        LatLongInputDialog(
                            showDialog = showLatLonDialog.value,
                            selectedLocation = {
                                selectedLat = it.first
                                selectedLon = it.second
                                viewModel.testVal.value = selectedLat
                                viewModel.getWeatherLatLong(selectedLat, selectedLon)
                            },
                            onDismiss = { showLatLonDialog.value = false })

                        //WeatherImage()
                    }

                }

            }
            //Lat Long
            //Weather picture
            //Temps


        }

    }
}


@Composable
fun WeatherImage(weather: Weather) {

}

@Composable
fun LatLongInputDialog(
    showDialog: Boolean,
    selectedLocation: (Pair<String, String>) -> Unit,
    onDismiss: () -> Unit
) {
    var latText by remember { mutableStateOf("") }
    var lonText by remember { mutableStateOf("") }
    if (showDialog) {
        AlertDialog(
            title = {
                Text("Enter location")
            },
            text = {
                Column {
                    TextField(value = latText, onValueChange = {
                        latText = it
                    }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
                    TextField(value = lonText, onValueChange = {
                        lonText = it
                    }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
                }
            },
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(onClick = {
                    selectedLocation(Pair(latText, lonText))
                    onDismiss()
                }) {
                    Text("OK")
                }
            },
            dismissButton = {}
        )
    }
}