package com.abdykadyr.newcocktailapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


 data class IngredientInfo (

    val idIngredient: Int? = null,
    val strIngredient: String? = null,
    val strDescription: String? = null,
    val strType: String? = null,
    val strAlcohol: String? = null

)