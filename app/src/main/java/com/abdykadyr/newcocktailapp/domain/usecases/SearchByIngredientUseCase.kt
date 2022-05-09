package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.entities.ListOfCocktails
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class SearchByIngredientUseCase(private val repository: Repository) {

    operator fun invoke(strIngredient: String) : ListOfCocktails {
        return repository.searchByIngredient(strIngredient)
    }

}