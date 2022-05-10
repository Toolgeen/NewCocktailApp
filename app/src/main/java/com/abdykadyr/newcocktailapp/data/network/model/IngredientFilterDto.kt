package com.abdykadyr.newcocktailapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class IngredientFilterDto(

    @SerializedName("strIngredient1")
    @Expose
    val ingredientFilter: String? = null
)

