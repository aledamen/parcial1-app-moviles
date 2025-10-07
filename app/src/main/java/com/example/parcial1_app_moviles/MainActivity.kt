package com.example.parcial1_app_moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial1_app_moviles.ui.theme.Parcial1appmovilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Parcial1appmovilesTheme {
                val navController = rememberNavController()
                val balance = rememberSaveable  { mutableDoubleStateOf(1000.0) }
                NavHost(navController, startDestination = "MainView"){
                    composable("MainView") { MainView(navController, balance) }
                    composable("ReceiptView/{amount}") { backStackEntry ->
                        val amount = backStackEntry.arguments?.getString("amount") ?: "0.0"
                        ReceiptView(navController, amount)
                    }
                }
            }
        }
    }
}