package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.entities.CocktailInfo
import com.abdykadyr.newcocktailapp.domain.entities.ListOfCocktails
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class GetCocktailsByNameUseCase(private val repository: Repository) {

    operator fun invoke(nameDrink: String): List<CocktailInfo>? {
        return repository.getCocktailsByName(nameDrink)
    }
}