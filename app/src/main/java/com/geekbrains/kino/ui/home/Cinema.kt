package com.geekbrains.kino.ui.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cinema(
    val cinema_year: Int = 0,
    val cinema_raiting: Double = 0.0
) : Parcelable

fun getDefaultCinema() = AboutCinema("КИНО", 2020, 10.0)

fun getWorldCinema(): List<Cinema> {
    return listOf(
        Cinema(2020, 10.0),
        Cinema(2019, 9.0)
        )
}

fun getRussianCinema(): List<Cinema> {
    return listOf(
        Cinema(2020, 3.0),
        Cinema(2019, 5.0)
    )
}
