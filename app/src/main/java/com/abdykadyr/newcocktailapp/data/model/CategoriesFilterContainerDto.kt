package com.abdykadyr.newcocktailapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoriesFilterContainerDto(

    @SerializedName("drinks")
    @Expose
    val categoriesFilterDtos: List<CategoryFilterDto>? = null

)
