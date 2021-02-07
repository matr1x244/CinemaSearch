package com.geekbrains.kino.ui.home

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.Toast
import com.geekbrains.kino.R

class HomeFragment : Fragment() {

    private val TAG = "HomeFragment"
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.item_movie, container, false)
        val View = inflater.inflate(R.layout.item_movie, container, false)

        val observer = Observer <Any> { startReload(it) }

        homeViewModel.getCinemaFromLocalStorage()

        homeViewModel.getStartReload().observe(viewLifecycleOwner, observer)

        lifecycle.addObserver(homeViewModel) // цикл жизни

        return root
    }

    private fun startReload(data: Any?) { // Thread getStart
        Log.d(TAG, "startReload")
        Toast.makeText(context, data.toString(), Toast.LENGTH_SHORT).show()
    }

}


