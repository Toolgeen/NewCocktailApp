package com.abdykadyr.newcocktailapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


 data class IngredientInfo (

    @SerializedName("idIngredient")
    @Expose
    val idIngredient: Int? = null,

    @SerializedName("strIngredient")
    @Expose
    val strIngredient: String? = null,

    @SerializedName("strDescription")
    @Expose
    val strDescription: String? = null,

    @SerializedName("strType")
    @Expose
    val strType: String? = null,

    @SerializedName("strAlcohol")
    @Expose
    val strAlcohol: String? = null

)