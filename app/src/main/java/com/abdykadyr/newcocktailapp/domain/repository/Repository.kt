package com.abdykadyr.newcocktailapp.domain.repository

import androidx.lifecycle.LiveData
import com.abdykadyr.newcocktailapp.domain.entities.*

interface Repository {

    fun getCocktailById(idDrink: Int) : LiveData<CocktailInfo>
    fun loadDataFromDb() : LiveData<List<CocktailInfo>>
    suspend fun getCocktailsByName(nameDrink: String) : LiveData<List<CocktailInfo>>
    suspend fun getIngredientByName(nameIngredient : String) : LiveData<IngredientInfo>
    suspend fun getListOfAlcoholic(alcoholicFilter: AlcoholicFilter) : List<AlcoholicFilter>
    suspend fun getListOfCategories(categoryFilter: CategoryFilter) : List<CategoryFilter>
    suspend fun getListOfIngredients(ingredientFilter: IngredientFilter) : List<IngredientFilter>
    suspend fun searchByIngredient(strIngredient: String) : LiveData<CocktailInfo>

}