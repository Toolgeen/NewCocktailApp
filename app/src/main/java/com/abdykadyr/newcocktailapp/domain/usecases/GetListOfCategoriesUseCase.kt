package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.entities.CategoryFilter
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class GetListOfCategoriesUseCase(private val repository: Repository) {

    suspend operator fun invoke(categoryFilter: CategoryFilter) =
        repository.getListOfCategories(categoryFilter)
}
