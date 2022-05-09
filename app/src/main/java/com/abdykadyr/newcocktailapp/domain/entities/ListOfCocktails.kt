package com.abdykadyr.newcocktailapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListOfCocktails(

    @SerializedName("drinks")
    @Expose
    val data: List<CocktailFullInfo>? = null

)