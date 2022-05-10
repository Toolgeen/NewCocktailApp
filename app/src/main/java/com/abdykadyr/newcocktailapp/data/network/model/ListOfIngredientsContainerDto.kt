package com.abdykadyr.newcocktailapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ListOfIngredientsContainerDto (

    @SerializedName("ingredients")
    @Expose
    val listOfIngredientsDtos: List<IngredientInfoDto>? = null
)