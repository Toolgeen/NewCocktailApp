package com.abdykadyr.newcocktailapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdykadyr.newcocktailapp.R
import com.abdykadyr.newcocktailapp.domain.entities.Filter

class WelcomeScreenAdapter: RecyclerView.Adapter<WelcomeScreenAdapter.WelcomeScreenViewHolder>() {

    var onFilterItemClickListener: ((Filter) -> Unit)? = null

    var listOfFilters = listOf<Filter>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class WelcomeScreenViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvFiltersMenu: TextView = view.findViewById(R.id.tvFiltersMenu)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WelcomeScreenViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.welcome_screen_menu_item,
            parent,
            false
        )
        return WelcomeScreenViewHolder(view)
    }

    override fun onBindViewHolder(holder: WelcomeScreenViewHolder, position: Int) {
        val filter = listOfFilters[position]
        with(holder) {
            tvFiltersMenu.text = filter.strFilter
            view.setOnClickListener { onFilterItemClickListener?.invoke(filter) }
        }
    }

    override fun getItemCount(): Int {
        return listOfFilters.size
    }

}