package com.example.tugas3_pamterapan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas3_pamterapan.ui.theme.Tugas3_PAMTerapanTheme

// Data class to hold user information
data class UserData(
    val nim: String,
    val nama: String,
    val email: String,
    val alamat: String
)

// Sealed class for navigation state
sealed class Screen {
    object Login : Screen()
    object Register : Screen()
    data class Detail(val userData: UserData) : Screen()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas3_PAMTerapanTheme {
                // State to manage the current screen displayed
                var currentScreen by remember { mutableStateOf<Screen>(Screen.Login) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (currentScreen) {
                        is Screen.Login -> {
                            LoginScreen(
                                onLoginClick = {
                                    // Dummy user data for demonstration purposes
                                    val dummyUser = UserData(
                                        "235150700111029",
                                        "Andreas Bagasgoro",
                                        "andreas@ub.ac.id",
                                        "Malang"
                                    )
                                    currentScreen = Screen.Detail(dummyUser)
                                },
                                onRegisterClick = {
                                    currentScreen = Screen.Register
                                },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        is Screen.Register -> {
                            RegistrationScreen(
                                onRegisterClick = { nim, nama, email, alamat ->
                                    val newUserData = UserData(nim, nama, email, alamat)
                                    currentScreen = Screen.Detail(newUserData)
                                },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        is Screen.Detail -> {
                            // Cast the screen to access the userData
                            val userData = (currentScreen as Screen.Detail).userData
                            DetailScreen(
                                userData = userData,
                                onRegisterAgainClick = {
                                    currentScreen = Screen.Register
                                },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }
}

// New Composable for the Login page
@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Halaman Login",
            style = MaterialTheme.typography.headlineLarge
        )

        var emailText by remember { mutableStateOf("") }
        TextField(
            value = emailText,
            onValueChange = { emailText = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        var passwordText by remember { mutableStateOf("") }
        TextField(
            value = passwordText,
            onValueChange = { passwordText = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("LOGIN")
        }

        Button(
            onClick = onRegisterClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("DAFTAR")
        }
    }
}

// Modified RegistrationScreen to handle navigation
@Composable
fun RegistrationScreen(
    onRegisterClick: (String, String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Headers NIM and Nama on separate lines
        Text(
            text = "235150700111029",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Andreas Bagasgoro",
            style = MaterialTheme.typography.headlineMedium
        )

        // Input fields
        var nimText by remember { mutableStateOf("") }
        TextField(
            value = nimText,
            onValueChange = { nimText = it },
            label = { Text("NIM") },
            modifier = Modifier.fillMaxWidth()
        )

        var namaText by remember { mutableStateOf("") }
        TextField(
            value = namaText,
            onValueChange = { namaText = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )

        var emailText by remember { mutableStateOf("") }
        TextField(
            value = emailText,
            onValueChange = { emailText = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        var alamatText by remember { mutableStateOf("") }
        TextField(
            value = alamatText,
            onValueChange = { alamatText = it },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth()
        )

        // Register button
        Button(
            onClick = {
                onRegisterClick(nimText, namaText, emailText, alamatText)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Daftar")
        }
    }
}

// New Composable for the Detail page
@Composable
fun DetailScreen(
    userData: UserData,
    onRegisterAgainClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Halaman Detail",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "NIM: ${userData.nim}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Nama: ${userData.nama}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Email: ${userData.email}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Alamat: ${userData.alamat}",
            style = MaterialTheme.typography.bodyLarge
        )

        Button(
            onClick = onRegisterAgainClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("DAFTAR")
        }
    }
}

// Previews for all screens
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Tugas3_PAMTerapanTheme {
        LoginScreen(
            onLoginClick = {},
            onRegisterClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    Tugas3_PAMTerapanTheme {
        RegistrationScreen(
            onRegisterClick = { _, _, _, _ -> }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    val sampleUser = UserData(
        nim = "235150700111029",
        nama = "Andreas Bagasgoro",
        email = "andreas@ub.ac.id",
        alamat = "Malang"
    )
    Tugas3_PAMTerapanTheme {
        DetailScreen(
            userData = sampleUser,
            onRegisterAgainClick = {}
        )
    }
}