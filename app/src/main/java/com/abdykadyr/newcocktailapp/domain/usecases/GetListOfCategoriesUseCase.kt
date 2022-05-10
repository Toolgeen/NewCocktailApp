package com.abdykadyr.newcocktailapp.domain.usecases

import com.abdykadyr.newcocktailapp.domain.entities.CategoryFilter
import com.abdykadyr.newcocktailapp.domain.entities.ListOfCategoriesFilters
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class GetListOfCategoriesUseCase(private val repository: Repository) {

    operator fun invoke(categoryFilter: CategoryFilter) : List<CategoryFilter>? {
        return repository.getListOfCategories(categoryFilter)
    }
}