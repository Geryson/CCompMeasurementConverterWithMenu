package com.ggantycc.ccompmeasurementconverterwithmenu.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LengthScreenViewModel : ViewModel() {
    var currentLength by mutableStateOf(0.0)
        private set

    fun convertLength(fromUnit: String, toUnit: String): Double {
        // Your conversion logic here
        return currentLength
    }
}