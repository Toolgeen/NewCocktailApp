package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.entities.CocktailInfo
import com.abdykadyr.newcocktailapp.domain.entities.ListOfCocktails
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class SearchByIngredientUseCase(private val repository: Repository) {

    operator fun invoke(strIngredient: String) : List<CocktailInfo>? {
        return repository.searchByIngredient(strIngredient)
    }

}