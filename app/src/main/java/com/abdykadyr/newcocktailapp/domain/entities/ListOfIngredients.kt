package com.abdykadyr.newcocktailapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ListOfIngredients (

    @SerializedName("ingredients")
    @Expose
    val ingredients: List<IngredientInfo>? = null
)