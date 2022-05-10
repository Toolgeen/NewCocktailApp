package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.repository.Repository

class SearchByIngredientUseCase(private val repository: Repository) {

    suspend operator fun invoke(strIngredient: String) =
        repository.searchByIngredient(strIngredient)
}