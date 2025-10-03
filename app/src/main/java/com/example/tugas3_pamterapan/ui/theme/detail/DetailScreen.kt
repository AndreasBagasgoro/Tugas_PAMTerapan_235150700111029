package com.example.tugas3_pamterapan.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas3_pamterapan.model.UserData
import com.example.tugas3_pamterapan.ui.theme.Tugas3_PAMTerapanTheme

@Composable
fun DetailScreen(
    userData: UserData,
    onRegisterAgainClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Halaman Detail", style = MaterialTheme.typography.headlineLarge)

        Text("NIM: ${userData.nim}", style = MaterialTheme.typography.bodyLarge)
        Text("Nama: ${userData.nama}", style = MaterialTheme.typography.bodyLarge)

        Button(
            onClick = onRegisterAgainClick,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("DAFTAR")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    val sampleUser = UserData("235150700111029", "Andreas Bagasgoro", "", "")
    Tugas3_PAMTerapanTheme {
        DetailScreen(sampleUser, {})
    }
}
