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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas3_PAMTerapanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegistrationScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun RegistrationScreen(modifier: Modifier = Modifier) {
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
        // Field for NIM
        var nimText by remember { mutableStateOf("") }
        TextField(
            value = nimText,
            onValueChange = { nimText = it },
            label = { Text("NIM") },
            modifier = Modifier.fillMaxWidth()
        )

        // Field for Nama
        var namaText by remember { mutableStateOf("") }
        TextField(
            value = namaText,
            onValueChange = { namaText = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )

        // Field for Email
        var emailText by remember { mutableStateOf("") }
        TextField(
            value = emailText,
            onValueChange = { emailText = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        // Field for Alamat
        var alamatText by remember { mutableStateOf("") }
        TextField(
            value = alamatText,
            onValueChange = { alamatText = it },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth()
        )

        // Register button
        Button(
            onClick = { /* No action */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Daftar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    Tugas3_PAMTerapanTheme {
        RegistrationScreen()
    }
}