package com.example.tugas3_pamterapan.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas3_pamterapan.ui.theme.Tugas3_PAMTerapanTheme

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Halaman Login", style = MaterialTheme.typography.headlineLarge)

        var username by remember { mutableStateOf("") }
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        var password by remember { mutableStateOf("") }
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = onLoginClick, modifier = Modifier.fillMaxWidth()) {
            Text("LOGIN")
        }

        Button(onClick = onRegisterClick, modifier = Modifier.fillMaxWidth()) {
            Text("DAFTAR")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Tugas3_PAMTerapanTheme {
        LoginScreen({}, {})
    }
}
