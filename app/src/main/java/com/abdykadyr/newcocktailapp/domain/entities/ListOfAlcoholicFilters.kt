package com.abdykadyr.newcocktailapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListOfAlcoholicFilters (

    @SerializedName("drinks")
    @Expose
    val alcoholicFilters: List<AlcoholicFilter>? = null

        )