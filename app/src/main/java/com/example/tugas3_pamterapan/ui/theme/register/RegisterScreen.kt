package com.example.tugas3_pamterapan.ui.register

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas3_pamterapan.ui.theme.Tugas3_PAMTerapanTheme

@Composable
fun RegisterScreen(
    onRegisterClick: (String, String, String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Halaman Daftar", style = MaterialTheme.typography.headlineLarge)

        var nim by remember { mutableStateOf("") }
        var nama by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }

        TextField(value = nim, onValueChange = { nim = it }, label = { Text("NIM") }, modifier = Modifier.fillMaxWidth())
        TextField(value = nama, onValueChange = { nama = it }, label = { Text("Nama") }, modifier = Modifier.fillMaxWidth())
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())

        Button(
            onClick = { onRegisterClick(nim, nama, email) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("SIMPAN")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    Tugas3_PAMTerapanTheme {
        RegisterScreen { _, _, _ -> }
    }
}
