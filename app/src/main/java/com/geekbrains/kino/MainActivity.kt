package com.geekbrains.kino

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTheme(R.style.AppTheme)
        Log.v(TAG, "onCreate")
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_settings
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        internetSearch() // NewsSearch - web

    }

    private fun internetSearch() {
        val newsCinema: FloatingActionButton = findViewById(R.id.FloatingActionButtonNews)
        Log.d(TAG, "internetSearch")
        newsCinema.setOnClickListener { view ->
            val addres =
                Uri.parse("https://www.kinopoisk.ru/media/news/")
            val Web = Intent(Intent.ACTION_VIEW, addres)
            Snackbar.make(view, "КиноПоиск Новости", Snackbar.LENGTH_LONG)
                .setAction("КиноПоиск Новости..", null).show()
            startActivity(Web)
        }
    }
}

