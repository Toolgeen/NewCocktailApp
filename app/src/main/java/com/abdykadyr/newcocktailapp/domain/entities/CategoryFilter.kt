package com.abdykadyr.newcocktailapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryFilter (

    @SerializedName("strCategory")
    @Expose
    val strCategory: String? = null
        )