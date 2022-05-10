package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.entities.IngredientFilter
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class GetListOfIngredientsUseCase(private val repository: Repository) {

    suspend operator fun invoke() = repository.getListOfIngredients()
}