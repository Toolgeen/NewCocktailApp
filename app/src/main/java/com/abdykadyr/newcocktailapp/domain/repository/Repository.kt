package com.abdykadyr.newcocktailapp.domain.repository

import androidx.lifecycle.LiveData
import com.abdykadyr.newcocktailapp.domain.entities.*

interface Repository {

    fun getCocktailById(idDrink: Int) : LiveData<CocktailInfo>
    fun loadDataFromDb() : LiveData<List<CocktailInfo>>
    suspend fun getCocktailsByName(nameDrink: String) : LiveData<List<CocktailInfo>>
    suspend fun getIngredientByName(nameIngredient : String) : LiveData<IngredientInfo>
    suspend fun getListOfAlcoholic() : List<AlcoholicFilter>
    suspend fun getListOfCategories() : List<CategoryFilter>
    suspend fun getListOfIngredients() : List<IngredientFilter>
    suspend fun searchByIngredient(ingredientFilter: IngredientFilter) : LiveData<List<CocktailInfo>>
    suspend fun searchByAlcoholic(alcoholicFilter: AlcoholicFilter) : LiveData<List<CocktailInfo>>
    suspend fun searchByCategory(categoryFilter: CategoryFilter) : LiveData<List<CocktailInfo>>

}