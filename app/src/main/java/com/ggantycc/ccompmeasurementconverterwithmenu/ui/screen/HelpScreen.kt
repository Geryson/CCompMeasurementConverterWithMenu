package com.ggantycc.ccompmeasurementconverterwithmenu.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HelpScreen(
    onNavigateToMainMenu: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("1. Select a conversion category", fontSize = 20.sp)
        Text("2. Type in the value to convert", fontSize = 20.sp)
        Text("3. Select the conversion type", fontSize = 20.sp)
        OutlinedButton(onClick = { onNavigateToMainMenu() }, modifier = Modifier.padding(16.dp)) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelpScreenPreview() {
    HelpScreen( onNavigateToMainMenu = {})
}