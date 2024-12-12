package com.ggantycc.ccompmeasurementconverterwithmenu.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainMenuScreen(
    onNavigateToLength: () -> Unit,
//    onNavigateToTemperature: () -> Unit,
//    onNavigateToWeight: () -> Unit,
    onNavigateToAbout: () -> Unit,
    onNavigateToHelp: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val buttonModifier = Modifier
            .width(200.dp)

        OutlinedButton(modifier = buttonModifier, onClick = { onNavigateToLength() }) {
            Text(text = "Length")
        }
        OutlinedButton(modifier = buttonModifier, onClick = { /*TODO*/ }) {
            Text(text = "Temperature")
        }
        OutlinedButton(modifier = buttonModifier, onClick = { /*TODO*/ }) {
            Text(text = "Weight")
        }
        OutlinedButton(modifier = buttonModifier, onClick = { onNavigateToAbout() }) {
            Text(text = "About")
        }
        OutlinedButton(modifier = buttonModifier, onClick = { onNavigateToHelp() }) {
            Text(text = "Help")
        }
    }
}