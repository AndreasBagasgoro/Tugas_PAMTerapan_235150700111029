package com.example.tugas3_pamterapan.navigation

import com.example.tugas3_pamterapan.model.UserData

sealed class Screen {
    object Login : Screen()
    object Register : Screen()
    data class Detail(val userData: UserData) : Screen()
}
