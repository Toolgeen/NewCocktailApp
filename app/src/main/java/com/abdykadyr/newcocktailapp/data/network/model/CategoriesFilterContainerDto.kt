package com.abdykadyr.newcocktailapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoriesFilterContainerDto(

    @SerializedName("drinks")
    @Expose
    val categoriesFilterDtos: List<CategoryFilterDto>? = null

)
