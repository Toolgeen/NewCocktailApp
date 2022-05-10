package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.entities.CocktailInfo
import com.abdykadyr.newcocktailapp.domain.entities.ListOfCocktails
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class GetCocktailsByFirstLetterUseCase(private val repository: Repository) {

    operator fun invoke(firstLetter: String) : List<CocktailInfo>? {
        return repository.getCocktailsByFirstLetter(firstLetter)
    }

}