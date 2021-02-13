package com.geekbrains.kino.ui.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AboutCinema(
    val aboutCinema: String,
    val cinemaYear: Int,
    val cinemaRaiting: Double
) : Parcelable
