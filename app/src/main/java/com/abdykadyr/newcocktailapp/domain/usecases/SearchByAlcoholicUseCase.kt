package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.entities.AlcoholicFilter
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class SearchByAlcoholicUseCase(private val repository: Repository) {

    suspend operator fun invoke(alcoholicFilter: AlcoholicFilter) =
        repository.searchByAlcoholic(alcoholicFilter)
}