package com.abdykadyr.newcocktailapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListOfCocktailsContainerDto(

    @SerializedName("drinks")
    @Expose
    val listOfCocktailDtos: List<CocktailInfoDto>?

)