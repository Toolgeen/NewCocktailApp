package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.repository.Repository

class GetCocktailsByNameUseCase(private val repository: Repository) {

    suspend operator fun invoke(nameDrink: String) = repository.getCocktailsByName(nameDrink)

}