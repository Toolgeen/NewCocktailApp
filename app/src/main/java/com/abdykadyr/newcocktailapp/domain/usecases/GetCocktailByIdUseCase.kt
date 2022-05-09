package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.entities.CocktailInfo
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class GetCocktailByIdUseCase(private val repository: Repository) {

    operator fun invoke(idDrink : Int) : CocktailInfo {
        return repository.getCocktailById(idDrink)
    }

}