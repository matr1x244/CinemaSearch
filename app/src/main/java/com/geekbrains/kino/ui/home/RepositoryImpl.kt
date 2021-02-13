package com.geekbrains.kino.ui.home

class RepositoryImpl : Repository { // возвращаем данные
    override fun getCinemaFromServer(): Cinema {
        return Cinema()
    }

    override fun getFromLocalStorageCinameRus(): List<Cinema> {
        return getRussianCiname()
    }

    override fun getFromLocalStorageCinemaWorld(): List<Cinema> {
        return getWorldCinema()
    }

}