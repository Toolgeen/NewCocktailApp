package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.repository.Repository
import com.abdykadyr.newcocktailapp.domain.entities.AlcoholicFilter

class GetListOfAlcoholicUseCase(private val repository: Repository) {

    suspend operator fun invoke() = repository.getListOfAlcoholic()
}
