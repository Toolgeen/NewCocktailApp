package com.abdykadyr.newcocktailapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AlcoholicFilterContainerDto (

    @SerializedName("drinks")
    @Expose
    val alcoholicFilterDtos: List<AlcoholicFilterDto>? = null

        )