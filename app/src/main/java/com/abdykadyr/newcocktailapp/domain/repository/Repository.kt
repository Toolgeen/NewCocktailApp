package com.abdykadyr.newcocktailapp.domain.repository

import androidx.lifecycle.LiveData
import com.abdykadyr.newcocktailapp.domain.entities.*

interface Repository {

    fun getCocktailById(idDrink: Int) : LiveData<CocktailInfo>
    fun getCocktailsByName(nameDrink: String) : LiveData<List<CocktailInfo>>
    fun getIngredientByName(nameIngredient : String) : LiveData<IngredientInfo>
    fun getListOfAlcoholic(alcoholicFilter: AlcoholicFilter) : List<AlcoholicFilter>
    fun getListOfCategories(categoryFilter: CategoryFilter) : List<CategoryFilter>
    fun getListOfIngredients(ingredientFilter: IngredientFilter) : List<IngredientFilter>
    fun searchByIngredient(strIngredient: String) : LiveData<CocktailInfo>

}