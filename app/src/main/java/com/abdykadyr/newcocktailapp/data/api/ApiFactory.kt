package com.abdykadyr.newcocktailapp.data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "www.thecocktaildb.com/api/json/v1/1"

    const val BASE_COCKTAIL_IMAGE_URL = "https://www.thecocktaildb.com/images/media/drink/"
    const val BASE_INGREDIENT_IMAGE_URL = "https://www.thecocktaildb.com/images/ingredients/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(ApiService::class.java)


}