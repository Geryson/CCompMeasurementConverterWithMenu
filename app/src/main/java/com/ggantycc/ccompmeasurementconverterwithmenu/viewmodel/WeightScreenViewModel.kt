package com.ggantycc.ccompmeasurementconverterwithmenu.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WeightScreenViewModel : ViewModel() {
    var inputValue by mutableStateOf("")
    var convertedValue by mutableStateOf("-")

    data class Conversion(val unit: String, val factor: Double)
    val conversions = listOf(
        Conversion("kg -> lb", 2.20462),
        Conversion("kg -> oz", 35.274),
        Conversion("lb -> kg", 0.453592),
        Conversion("lb -> oz", 16.0),
        Conversion("oz -> kg", 0.0283495),
        Conversion("oz -> lb", 0.0625)
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