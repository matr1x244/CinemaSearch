package com.geekbrains.kino

import com.geekbrains.kino.ui.home.Cinema

sealed class AppState {
    data class Success(val CinemaData: List <Cinema>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
