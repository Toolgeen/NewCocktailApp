package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.entities.IngredientFilter
import com.abdykadyr.newcocktailapp.domain.entities.ListOfIngredients
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class GetListOfIngredientsUseCase(private val repository: Repository) {

    operator fun invoke(ingredientFilter: IngredientFilter) : ListOfIngredients {
        return repository.getListOfIngredients(ingredientFilter)
    }

}