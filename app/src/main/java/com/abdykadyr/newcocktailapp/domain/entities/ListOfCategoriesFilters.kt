package com.abdykadyr.newcocktailapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListOfCategoriesFilters(

    @SerializedName("drinks")
    @Expose
    val categoriesFilters: List<CategoryFilter>? = null

)
