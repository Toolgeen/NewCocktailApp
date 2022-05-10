package com.abdykadyr.newcocktailapp.data.network

import com.abdykadyr.newcocktailapp.data.network.model.*
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(SEARCH_COCKTAIL_BY_NAME)
    suspend fun getCocktailsByName(
        @Query(QUERY_PARAM_COCKTAIL_NAME) cocktailName: String
    ): ListOfCocktailsContainerDto

    @GET(SEARCH_COCKTAIL_BY_INGREDIENT)
    suspend fun getCocktailsByIngredient(
        @Query(QUERY_PARAM_INGREDIENT) ingredient: String
    ): ListOfCocktailsContainerDto

    @GET(SEARCH_COCKTAIL_BY_ALCOHOLIC)
    suspend fun getCocktailsByAlcoholic(
        @Query(QUERY_PARAM_ALCOHOLIC) alcoholic: String
    ): ListOfCocktailsContainerDto

    @GET(SEARCH_COCKTAIL_BY_CATEGORY)
    suspend fun getCocktailsByCategory(
        @Query(QUERY_PARAM_CATEGORY) category: String
    ): ListOfCocktailsContainerDto

    @GET(GET_INGREDIENT_BY_ID)
    suspend fun getIngredientById(
        @Query(QUERY_PARAM_INGREDIENT_ID) idIngredient: Int
    ): ListOfIngredientsContainerDto

    @GET(GET_COCKTAIL_BY_ID)
    suspend fun getFullCocktailInfo(
        @Query(QUERY_PARAM_COCKTAIL_ID) idDrink: Int
    ): ListOfCocktailsContainerDto

    @GET(GET_CATEGORIES)
    suspend fun getCategories(): CategoriesFilterContainerDto

    @GET(GET_ALCOHOLIC)
    suspend fun getAlcoholic(): AlcoholicFilterContainerDto

    @GET(GET_INGREDIENTS)
    suspend fun getIngredients(): IngredientFilterContainerDto

    companion object {

        private const val SEARCH_COCKTAIL_BY_NAME = "search.php?s="
        private const val SEARCH_COCKTAIL_BY_INGREDIENT = "search.php?i="
        private const val SEARCH_COCKTAIL_BY_ALCOHOLIC = "search.php?a="
        private const val SEARCH_COCKTAIL_BY_CATEGORY = "search.php?c="

        private const val GET_COCKTAIL_BY_ID = "lookup.php?i="
        private const val GET_INGREDIENT_BY_ID = "lookup.php?iid="

        private const val GET_CATEGORIES = "list.php?c=list"
        private const val GET_INGREDIENTS = "list.php?i=list"
        private const val GET_ALCOHOLIC = "list.php?a=list"

        private const val QUERY_PARAM_COCKTAIL_NAME = "cocktail_name"
        private const val QUERY_PARAM_INGREDIENT = "ingredient_name"
        private const val QUERY_PARAM_ALCOHOLIC = "alcoholic_name"
        private const val QUERY_PARAM_CATEGORY = "category_name"

        private const val QUERY_PARAM_COCKTAIL_ID = "cocktail_id"
        private const val QUERY_PARAM_INGREDIENT_ID = "ingredient_id"

    }

}