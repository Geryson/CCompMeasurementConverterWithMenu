package com.ggantycc.ccompmeasurementconverterwithmenu.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ggantycc.ccompmeasurementconverterwithmenu.viewmodel.LengthScreenViewModel

@Composable
fun LengthScreen(
    onNavigateToMainMenu: () -> Unit
) {
    val viewModel: LengthScreenViewModel = viewModel()

    Column(modifier = Modifier.padding(30.dp)) {

        OutlinedTextField(
            value = viewModel.inputValue,
            onValueChange = { newText -> viewModel.inputValue = newText.filter { it.isDigit() } },
            label = { Text("Value") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(0.dp, 20.dp)
        ) {
            items(viewModel.conversions) { conversion ->
                Button(
                    onClick = {
                        viewModel.convert(
                            conversion.factor
                        )
                    }
                ) {
                    Text(conversion.unit)
                }
            }
        }
        Text(
            viewModel.convertedValue, style = TextStyle(
                color = Color.Blue, fontWeight = FontWeight.Bold, fontSize = 30.sp
            )
        )
        OutlinedButton(
            onClick = { onNavigateToMainMenu() },
            modifier = Modifier.padding(0.dp, 20.dp)
        ) {
            Text("Back")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LengthScreenPreview() {
    LengthScreen(onNavigateToMainMenu = {})
}