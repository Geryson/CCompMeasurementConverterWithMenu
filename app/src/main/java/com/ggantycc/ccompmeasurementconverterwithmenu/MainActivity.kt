package com.ggantycc.ccompmeasurementconverterwithmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ggantycc.ccompmeasurementconverterwithmenu.ui.MainMenuScreen
import com.ggantycc.ccompmeasurementconverterwithmenu.ui.screen.AboutScreen
import com.ggantycc.ccompmeasurementconverterwithmenu.ui.screen.HelpScreen
import com.ggantycc.ccompmeasurementconverterwithmenu.ui.screen.LengthScreen
import com.ggantycc.ccompmeasurementconverterwithmenu.ui.screen.TemperatureScreen
import com.ggantycc.ccompmeasurementconverterwithmenu.ui.theme.CCompMeasurementConverterWithMenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CCompMeasurementConverterWithMenuTheme {
                ConverterAppNavHost()
            }
        }
    }
}

@Composable
fun ConverterAppNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    startDestination: String = "mainmenu"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("mainmenu") {
            MainMenuScreen(
                onNavigateToLength = { navController.navigate("length") },
                onNavigateToTemperature = { navController.navigate("temperature") },
//                onNavigateToWeight = { navController.navigate("weight") },
                onNavigateToAbout = { navController.navigate("about") },
                onNavigateToHelp = { navController.navigate("help") }
            )
        }
        composable("length") {
            LengthScreen(
                onNavigateToMainMenu = { navController.navigate("mainmenu") }
            )
        }
        composable("temperature") {
            TemperatureScreen(
                onNavigateToMainMenu = { navController.navigate("mainmenu") }
            )
        }
//        composable("weight") {
//            WeightScreen(
//                onNavigateToMainMenu = { navController.navigate("mainmenu") }
//            )
//        }
        composable("about") {
            AboutScreen(
                onNavigateToMainMenu = { navController.navigate("mainmenu") }
            )
        }
        composable("help") {
            HelpScreen(
                onNavigateToMainMenu = { navController.navigate("mainmenu") }
            )
        }
    }
}