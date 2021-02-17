package com.geekbrains.kino.ui.home

interface Repository { // забираем данные

    fun getCinemaFromServer(): Cinema

    fun getFromLocalStorageCinemaRus(): List<Cinema>

    fun getFromLocalStorageCinemaWorld(): List<Cinema>
}