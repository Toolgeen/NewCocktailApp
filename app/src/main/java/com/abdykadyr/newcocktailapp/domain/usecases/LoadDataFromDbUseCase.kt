package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.repository.Repository

class LoadDataFromDbUseCase(private val repository: Repository) {

    operator fun invoke() = repository.loadDataFromDb()

}