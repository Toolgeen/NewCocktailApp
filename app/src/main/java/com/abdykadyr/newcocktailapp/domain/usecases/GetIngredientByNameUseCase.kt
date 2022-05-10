package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.repository.Repository

class GetIngredientByNameUseCase(private val repository: Repository) {

    operator fun invoke(nameIngredient : String) = repository.getIngredientByName(nameIngredient)
}