package com.abdykadyr.newcocktailapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryFilterDto (

    @SerializedName("strCategory")
    @Expose
    val strCategory: String? = null
        )