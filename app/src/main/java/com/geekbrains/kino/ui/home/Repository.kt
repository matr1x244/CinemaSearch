package com.geekbrains.kino.ui.home

interface Repository { // забираем данные

    fun getCinemaFromServer(): Cinema

    fun getFromLocalStorageCinameRus(): List<Cinema>

    fun getFromLocalStorageCinemaWorld(): List<Cinema>
}