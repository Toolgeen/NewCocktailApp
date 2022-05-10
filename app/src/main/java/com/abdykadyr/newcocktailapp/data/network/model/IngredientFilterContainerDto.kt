package com.abdykadyr.newcocktailapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class IngredientFilterContainerDto(

    @SerializedName("drinks")
    @Expose
    val ingredientsFilterDtos: List<IngredientFilterDto>? = null

)
