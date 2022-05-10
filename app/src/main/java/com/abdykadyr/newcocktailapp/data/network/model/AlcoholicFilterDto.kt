package com.abdykadyr.newcocktailapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AlcoholicFilterDto(

    @SerializedName("strAlcoholic")
    @Expose
    val alcoholicFilter: String? = null

)
