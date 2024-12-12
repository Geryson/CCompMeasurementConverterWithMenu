package com.ggantycc.ccompmeasurementconverterwithmenu.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LengthScreenViewModel : ViewModel() {
    var inputValue by mutableStateOf("")
    var convertedValue by mutableStateOf("-")

    data class Conversion(val unit: String, val factor: Double)
    val conversions = listOf(
        Conversion("km -> mi", 0.621371),
        Conversion("km -> yd", 1093.61),
        Conversion("km -> ft", 3280.84),
        Conversion("mi -> km", 1.60934),
        Conversion("mi -> yd", 1760.0),
        Conversion("mi -> ft", 5280.0)
    )

    fun convert(conversionFactor: Double) {
        convertedValue =
            if (inputValue.toDoubleOrNull() != null) {
                (inputValue.toDouble() * conversionFactor).toString()
            } else {
                "Invalid input"
            }
    }
}