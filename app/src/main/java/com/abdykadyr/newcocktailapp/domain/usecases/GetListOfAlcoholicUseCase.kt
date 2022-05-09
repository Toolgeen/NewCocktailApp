package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.entities.AlcoholicFilter
import com.abdykadyr.newcocktailapp.domain.entities.ListOfAlcoholicFilters
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class GetListOfAlcoholicUseCase(private val repository: Repository) {

    operator fun invoke(alcoholicFilter: AlcoholicFilter) : ListOfAlcoholicFilters {
        return repository.getListOfAlcoholic(alcoholicFilter)
    }
}