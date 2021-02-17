package com.geekbrains.kino.ui.home

class RepositoryImpl : Repository { // возвращаем данные
    override fun getCinemaFromServer(): Cinema {
        return Cinema()
    }

    override fun getFromLocalStorageCinemaRus(): List<Cinema> {
        return getRussianCinema()
    }

    override fun getFromLocalStorageCinemaWorld(): List<Cinema> {
        return getWorldCinema()
    }

}