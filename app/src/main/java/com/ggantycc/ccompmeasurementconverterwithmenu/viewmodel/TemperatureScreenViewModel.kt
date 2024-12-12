package com.ggantycc.ccompmeasurementconverterwithmenu.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TemperatureScreenViewModel : ViewModel() {
    var inputValue by mutableStateOf("")
    var convertedValue by mutableStateOf("-")

    class Conversion(val unit: String, val calculation: (Double) -> Double)
    val conversions = listOf(
        Conversion("°C -> °F", { it * 9 / 5 + 32 }),
        Conversion("°F -> °C", { (it - 32) * 5 / 9 }),
        Conversion("°C -> °K", { it + 273.15 }),
        Conversion("°K -> °C", { it - 273.15 }),
        Conversion("°F -> °K", { (it + 459.67) * 5 / 9 }),
        Conversion("°K -> °F", { it * 9 / 5 - 459.67 })
    )

    fun convert(conversionFactor: (Double) -> Double) {
        convertedValue =
            if (inputValue.toDoubleOrNull() != null) {
                conversionFactor(inputValue.toDouble()).toString()
            } else {
                "Invalid input"
            }
    }
}
