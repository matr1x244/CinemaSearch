package com.geekbrains.kino.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geekbrains.kino.R
import kotlinx.android.synthetic.main.item_movie.view.*

class HomeFragmentAdapter(private var onItemViewClickListener: OnItemViewClickListener?) :
    RecyclerView.Adapter<HomeFragmentAdapter.HomeViewHolder>() {

    private var CinemaData: List<Cinema> = listOf()

    fun setCinema(data: List<Cinema>) {
        CinemaData = data
        notifyDataSetChanged()
    }

    fun removeListener() {
        onItemViewClickListener = null
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(CinemaData[position])
    }

    override fun getItemCount(): Int {
        return CinemaData.size
    }

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(cinema: Cinema) {
            itemView.HomeFragmentRecyclerItemTextView.text = cinema.cinema
            itemView.setOnClickListener {
                onItemViewClickListener?.onItemViewClick(cinema)
            }
        }
    }
}