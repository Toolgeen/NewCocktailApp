package com.abdykadyr.newcocktailapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdykadyr.newcocktailapp.R
import com.abdykadyr.newcocktailapp.domain.entities.CocktailInfo


class CocktailListAdapter: RecyclerView.Adapter<CocktailListAdapter.CocktailListViewHolder>() {

    var cocktailList: List<CocktailInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class CocktailListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvCocktailName = view.findViewById<TextView>(R.id.tvCocktailName)
        val tvCategory = view.findViewById<TextView>(R.id.tvCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailListViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.cocktail_item,
            parent,
            false
        )
        return CocktailListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CocktailListViewHolder, position: Int) {
        val cocktail = cocktailList[position]
        with(holder) {
            tvCocktailName.text = cocktail.strDrink
            tvCategory.text = cocktail.strCategory
        }
    }

    override fun getItemCount(): Int {
        return cocktailList.size
    }

}