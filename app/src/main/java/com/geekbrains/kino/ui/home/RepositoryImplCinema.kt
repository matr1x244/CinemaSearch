package com.geekbrains.kino.ui.home

class RepositoryImplCinema : RepositoryCinema { // возвращаем данные
    override fun getCinemaFromServer(): Cinema {
        return Cinema()
    }

    override fun getCinemaFromLocalStorage(): Cinema {
        return Cinema()
    }

}