package com.geekbrains.kino.ui.home

interface RepositoryCinema { // забираем данные
    fun getCinemaFromServer(): Cinema
    fun getCinemaFromLocalStorage(): Cinema
}