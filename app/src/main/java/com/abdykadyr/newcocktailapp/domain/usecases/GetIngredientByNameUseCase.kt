package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.entities.IngredientInfo
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class GetIngredientByNameUseCase(private val repository: Repository) {

    operator fun invoke(nameIngredient : String) : IngredientInfo? {
        return repository.getIngredientByName(nameIngredient)
    }
}