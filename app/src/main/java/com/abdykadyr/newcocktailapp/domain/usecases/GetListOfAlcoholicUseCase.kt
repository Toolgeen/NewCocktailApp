package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.repository.Repository
import com.abdykadyr.newcocktailapp.domain.entities.AlcoholicFilter

class GetListOfAlcoholicUseCase(private val repository: Repository) {

    operator fun invoke(alcoholicFilter: AlcoholicFilter) =
        repository.getListOfAlcoholic(alcoholicFilter)
}
