package com.abdykadyr.newcocktailapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListOfIngredientFilters(

    @SerializedName("drinks")
    @Expose
    val ingredientsFilters: List<IngredientFilter>? = null

)
