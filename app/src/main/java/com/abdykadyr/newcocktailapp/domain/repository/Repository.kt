package com.abdykadyr.newcocktailapp.domain.repository

import com.abdykadyr.newcocktailapp.domain.entities.*

interface Repository {

    fun getCocktailById(idDrink : Int) : CocktailInfo
    fun getCocktailsByFirstLetter(firstLetter: String) : ListOfCocktails
    fun getCocktailsByName(nameDrink: String) : ListOfCocktails
    fun getIngredientByName(nameIngredient : String) : IngredientInfo
    fun getListOfAlcoholic(alcoholicFilter: AlcoholicFilter) : ListOfAlcoholicFilters
    fun getListOfCategories(categoryFilter: CategoryFilter) : ListOfCategoriesFilters
    fun getListOfIngredients(ingredientFilter: IngredientFilter) : ListOfIngredients
    fun searchByIngredient(strIngredient: String) : ListOfCocktails

}