package com.geekbrains.kino.ui.home

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import android.arch.lifecycle.ViewModelProviders
import android.support.design.widget.Snackbar
import com.geekbrains.kino.AppState
import com.geekbrains.kino.R
import com.geekbrains.kino.ui.home.interactors.ImageInteractorImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.item_movie.*

class HomeFragment : Fragment() {

    private val TAG = "HomeFragment"
    private lateinit var homeViewModel: HomeViewModel

    private val adapter = HomeFragmentAdapter(object : OnItemViewClickListener {
        override fun onItemViewClick(cinema: Cinema) {
            val manager = activity?.supportFragmentManager
            if (manager != null) {
                val bundle = Bundle()
                bundle.putParcelable(DetailsFragment.BUNDLE_EXTRA, cinema)
                manager.beginTransaction()
                    .add(R.id.container, DetailsFragment.newInstance(bundle))
                    .addToBackStack("")
                    .commitAllowingStateLoss()
            }
        }
    })

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.item_movie, container, false)
        homeViewModel.imageInteractor = ImageInteractorImpl()
        homeViewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) }) // !!!!!!!!!!!!!!!
        homeViewModel.fabImageLiveData.observe(viewLifecycleOwner, Observer { renderFabImage(it)}) // !!!!!!!!!!!!!!!
        mainFragmentFAB.setOnClickListener {homeViewModel.onFABClicked(renderFabImage(it)) } // !!!!!!!!!!!!!!!
        homeViewModel.getFromLocalStorageCinameRus()
        homeViewModel.getFromLocalStorageCinemaWorld()

        lifecycle.addObserver(homeViewModel) // цикл жизни

        return root
    }

     private fun renderFabImage(imageRes: Int) { // !!!!!!!!!!!!!!!
        mainFragmentFAB.setImageResource(imageRes)
    }


    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                base_cardview.visibility = View.GONE
                adapter.setCinema(appState.CinemaData)
            }
            is AppState.Loading -> {
                base_cardview.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                base_cardview.visibility = View.GONE
                Snackbar
                    .make(textView, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.reload)) { homeViewModel.getFromLocalStorageCinameRus() }
                    .show()
            }
        }
    }

        override fun onDestroy() {
            adapter.removeListener()
            super.onDestroy()
        }

    companion object {
        fun newInstance() = HomeFragment()
    }
}






