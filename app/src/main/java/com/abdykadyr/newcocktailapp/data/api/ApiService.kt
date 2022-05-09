package com.abdykadyr.newcocktailapp.data.api

import com.abdykadyr.newcocktailapp.domain.entities.CocktailFullInfo
import com.abdykadyr.newcocktailapp.domain.entities.IngredientInfo
import com.abdykadyr.newcocktailapp.domain.entities.ListOfCocktails
import com.abdykadyr.newcocktailapp.domain.entities.ListOfIngredients
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(SEARCH_COCKTAIL_BY_NAME)
    fun getCocktailsByName(
        @Query(QUERY_PARAM_COCKTAIL_NAME) cocktailName: String
    ): Single<ListOfCocktails>

    @GET(SEARCH_INGREDIENT_BY_NAME)
    fun getIngredientByName(
        @Query(QUERY_PARAM_INGREDIENT_NAME) ingredientName: String
    ): Single<ListOfIngredients>

    @GET(SEARCH_COCKTAILS_BY_FIRST_LETTER)
    fun getCocktailsByFirstLetter(
        @Query(QUERY_PARAM_FIRST_LETTER) firstLetter: String
    ): Single<ListOfCocktails>

    @GET(GET_COCKTAIL_BY_ID)
    fun getFullCocktailInfo(
        @Query(QUERY_PARAM_COCKTAIL_ID) idDrink: Int
    ): Single<CocktailFullInfo>

    @GET(GET_INGREDIENT_BY_ID)
    fun getFullIngredientInfo(
        @Query(QUERY_PARAM_INGREDIENT_ID) idIngredient: Int
    ): Single<IngredientInfo>


    companion object {

        private const val SEARCH_COCKTAILS_BY_FIRST_LETTER = "/search.php?/f="
        private const val SEARCH_COCKTAIL_BY_NAME = "/search.php?/s="
        private const val SEARCH_INGREDIENT_BY_NAME = "/search.php?/s="
        private const val GET_COCKTAIL_BY_ID = "/search.php?/i="
        private const val GET_INGREDIENT_BY_ID = "/search.php?/iid="

        private const val QUERY_PARAM_INGREDIENT_NAME = "cocktail_name"
        private const val QUERY_PARAM_COCKTAIL_NAME = "cocktail_name"
        private const val QUERY_PARAM_FIRST_LETTER = "first_letter"
        private const val QUERY_PARAM_COCKTAIL_ID = "first_letter"
        private const val QUERY_PARAM_INGREDIENT_ID = "first_letter"

    }

}