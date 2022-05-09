package com.abdykadyr.newcocktailapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AlcoholicFilter(

    @SerializedName("strAlcoholic")
    @Expose
    val alcoholicFilter: String? = null

)
