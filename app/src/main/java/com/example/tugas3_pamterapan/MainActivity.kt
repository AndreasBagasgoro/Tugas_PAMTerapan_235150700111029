package com.example.tugas3_pamterapan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugas3_pamterapan.model.UserData
import com.example.tugas3_pamterapan.ui.detail.DetailScreen
import com.example.tugas3_pamterapan.ui.login.LoginScreen
import com.example.tugas3_pamterapan.ui.register.RegisterScreen
import com.example.tugas3_pamterapan.ui.theme.Tugas3_PAMTerapanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas3_PAMTerapanTheme {
                val navController = rememberNavController()

                Scaffold { innerPadding ->
                    AppNavHost(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Navigation graph
@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        // Login
        composable("login") {
            LoginScreen(
                onLoginClick = {
                    // Dummy user langsung ke detail
                    navController.navigate("detail/235150700111029/Andreas%20Bagasgoro")
                },
                onRegisterClick = {
                    navController.navigate("register")
                }
            )
        }

        // Register
        composable("register") {
            RegisterScreen(
                onRegisterClick = { nim, nama, email ->
                    // kirim nim dan nama ke detail
                    navController.navigate("detail/$nim/$nama")
                }
            )
        }

        // Detail (pakai argument route)
        composable("detail/{nim}/{nama}") { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            val nama = backStackEntry.arguments?.getString("nama") ?: ""
            val userData = UserData(nim, nama, "", "")

            DetailScreen(
                userData = userData,
                onRegisterAgainClick = {
                    navController.navigate("register")
                }
            )
        }
    }
}
