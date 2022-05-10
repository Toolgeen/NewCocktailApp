package com.abdykadyr.newcocktailapp.domain.repository

import androidx.lifecycle.LiveData
import com.abdykadyr.newcocktailapp.data.database.AppDatabase
import com.abdykadyr.newcocktailapp.domain.entities.*

interface Repository {

    fun getCocktailById(idDrink: Int, db : AppDatabase) : LiveData<CocktailInfo>
    fun getCocktailsByFirstLetter(firstLetter: String) : List<CocktailInfo>?
    fun getCocktailsByName(nameDrink: String) : List<CocktailInfo>?
    fun getIngredientByName(nameIngredient : String) : IngredientInfo?
    fun getListOfAlcoholic(alcoholicFilter: AlcoholicFilter) : List<AlcoholicFilter>?
    fun getListOfCategories(categoryFilter: CategoryFilter) : List<CategoryFilter>?
    fun getListOfIngredients(ingredientFilter: IngredientFilter) : List<IngredientInfo>?
    fun searchByIngredient(strIngredient: String) : List<CocktailInfo>?

}