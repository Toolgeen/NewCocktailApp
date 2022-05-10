package com.abdykadyr.newcocktailapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class IngredientFilterDto(

    @SerializedName("strstrIngredient1")
    @Expose
    val ingredientFilter: String? = null
)

