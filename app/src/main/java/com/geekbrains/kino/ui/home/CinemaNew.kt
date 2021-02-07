package com.geekbrains.kino.ui.home

data class CinemaNew(
    val cinema: Cinema = getDefaultCinema(),
    val year: Int = 2020,
    val raiting: Int = 5
)

fun getDefaultCinema() = Cinema()

class Cinema() {

}
