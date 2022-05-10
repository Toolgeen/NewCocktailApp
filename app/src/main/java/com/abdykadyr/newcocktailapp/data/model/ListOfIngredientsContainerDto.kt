package com.abdykadyr.newcocktailapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ListOfIngredientsContainerDto (

    @SerializedName("ingredients")
    @Expose
    val ingredientDtos: List<IngredientInfoDto>? = null
)