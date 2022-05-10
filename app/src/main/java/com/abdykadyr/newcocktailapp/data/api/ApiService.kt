package com.abdykadyr.newcocktailapp.data.api

import com.abdykadyr.newcocktailapp.data.model.ListOfCocktailsContainerDto
import com.abdykadyr.newcocktailapp.data.model.ListOfIngredientsContainerDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(SEARCH_COCKTAIL_BY_NAME)
    fun getCocktailsByName(
        @Query(QUERY_PARAM_COCKTAIL_NAME) cocktailName: String
    ): Single<ListOfCocktailsContainerDto>

    @GET(SEARCH_INGREDIENT_BY_NAME)
    fun getIngredientByName(
        @Query(QUERY_PARAM_INGREDIENT_NAME) ingredientName: String
    ): Single<ListOfIngredientsContainerDto>

    @GET(SEARCH_COCKTAILS_BY_FIRST_LETTER)
    fun getCocktailsByFirstLetter(
        @Query(QUERY_PARAM_FIRST_LETTER) firstLetter: String
    ): Single<ListOfCocktailsContainerDto>

    @GET(GET_COCKTAIL_BY_ID)
    fun getFullCocktailInfo(
        @Query(QUERY_PARAM_COCKTAIL_ID) idDrink: Int
    ): Single<ListOfCocktailsContainerDto>

    @GET(GET_INGREDIENT_BY_ID)
    fun getFullIngredientInfo(
        @Query(QUERY_PARAM_INGREDIENT_ID) idIngredient: Int
    ): Single<ListOfIngredientsContainerDto>


    companion object {

        private const val SEARCH_COCKTAILS_BY_FIRST_LETTER = "search.php?f="
        private const val SEARCH_COCKTAIL_BY_NAME = "search.php?s="
        private const val SEARCH_INGREDIENT_BY_NAME = "search.php?i="
        private const val GET_COCKTAIL_BY_ID = "lookup.php?i="
        private const val GET_INGREDIENT_BY_ID = "lookup.php?iid="

        private const val QUERY_PARAM_INGREDIENT_NAME = "cocktail_name"
        private const val QUERY_PARAM_COCKTAIL_NAME = "cocktail_name"
        private const val QUERY_PARAM_FIRST_LETTER = "first_letter"

        //TODO: not completed
        private const val QUERY_PARAM_COCKTAIL_ID = "first_letter"
        private const val QUERY_PARAM_INGREDIENT_ID = "first_letter"

    }

}