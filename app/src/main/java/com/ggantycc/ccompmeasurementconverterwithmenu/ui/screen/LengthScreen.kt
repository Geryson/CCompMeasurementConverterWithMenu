package com.ggantycc.ccompmeasurementconverterwithmenu.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ggantycc.ccompmeasurementconverterwithmenu.ui.theme.CCompMeasurementConverterWithMenuTheme

@Composable
fun LengthScreen(
    onNavigateToMainMenu: () -> Unit
) {
    var text by remember { mutableStateOf("") }
    var convertedValue by remember { mutableStateOf("-") }
    CCompMeasurementConverterWithMenuTheme {
        Column(modifier = Modifier.padding(30.dp)) {
            fun convert(value: Double, conversionFactor: Double): String {
                return (value * conversionFactor).toString()
            }
            OutlinedTextField(
                value = text,
                onValueChange = { newText -> text = newText.filter { it.isDigit() } },
                label = { Text("Value") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            data class Conversion(val unit: String, val factor: Double)
            Row() {
                val conversions = listOf(
                    Conversion("km -> mi", 0.621371),
                    Conversion("km -> yd", 1093.61),
                    Conversion("km -> ft", 3280.84)
                )
                conversions.forEach { conversion ->
                    Button(
                        onClick = {
                            val inputValue = text.toDoubleOrNull()
                            convertedValue = if (inputValue != null) {
                                convert(inputValue, conversion.factor)
                            } else {
                                "Invalid input"
                            }
                        }
                    ) {
                        Text(conversion.unit)
                    }
                }
            }
            Row() {
                val conversions = listOf(
                    Conversion("mi -> km", 1.60934),
                    Conversion("mi -> yd", 1760.0),
                    Conversion("mi -> ft", 5280.0)
                )
                conversions.forEach { conversion ->
                    Button(
                        onClick = {
                            val inputValue = text.toDoubleOrNull()
                            convertedValue = if (inputValue != null) {
                                convert(inputValue, conversion.factor)
                            } else {
                                "Invalid input"
                            }
                        }
                    ) {
                        Text(conversion.unit)
                    }
                }
            }
            Text(
                convertedValue, style = TextStyle(
                    color = Color.Blue, fontWeight = FontWeight.Bold, fontSize = 30.sp
                )
            )
            OutlinedButton(onClick = { onNavigateToMainMenu() }, modifier = Modifier.padding(0.dp, 20.dp)) {
                Text("Back")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LengthScreenPreview() {
    LengthScreen(onNavigateToMainMenu = {})
}