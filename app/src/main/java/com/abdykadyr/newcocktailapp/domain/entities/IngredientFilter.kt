package com.abdykadyr.newcocktailapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class IngredientFilter(

    @SerializedName("strstrIngredient1")
    @Expose
    val ingredientFilter: String? = null
)

