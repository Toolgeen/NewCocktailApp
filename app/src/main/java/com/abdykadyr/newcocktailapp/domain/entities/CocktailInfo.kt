package com.abdykadyr.newcocktailapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CocktailInfo(

    @SerializedName("idDrink")
    @Expose
    val idDrink: Int? = null,

    @SerializedName("strDrink")
    @Expose
    val strDrink: String? = null,

    @SerializedName("strDrinkThumb")
    @Expose
    val strDrinkThumb: String? = null

)