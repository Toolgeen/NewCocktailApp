package com.abdykadyr.newcocktailapp.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.abdykadyr.newcocktailapp.data.repository.RepositoryImpl
import com.abdykadyr.newcocktailapp.domain.entities.AlcoholicFilter
import com.abdykadyr.newcocktailapp.domain.entities.CategoryFilter
import com.abdykadyr.newcocktailapp.domain.entities.Filter
import com.abdykadyr.newcocktailapp.domain.entities.IngredientFilter
import com.abdykadyr.newcocktailapp.domain.usecases.*
import kotlinx.coroutines.launch

class WelcomeScreenViewModel(application: Application): AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)
    private lateinit var listOfAlcoholicFilters: List<AlcoholicFilter>
    private lateinit var listOfIngredientFilters: List<IngredientFilter>
    private lateinit var listOfCategoryFilters: List<CategoryFilter>
    private val _listOfFilters = MutableLiveData<List<Filter>>()

    val listOfFilters: LiveData<List<Filter>>
        get() = _listOfFilters

    private val getListOfAlcoholicUseCase = GetListOfAlcoholicUseCase(repository)
    private val getListOfIngredientsUseCase = GetListOfIngredientsUseCase(repository)
    private val getListOfCategoriesUseCase = GetListOfCategoriesUseCase(repository)

    private val searchByAlcoholicUseCase = SearchByAlcoholicUseCase(repository)
    private val searchByCategoryUseCase = SearchByCategoryUseCase(repository)
    private val searchByIngredientUseCase = SearchByIngredientUseCase(repository)

    init {
        repository.clearDb()
        TODO("may be bad realization")
    }

    fun search(filter: Filter) {
        when (filter) {
            is AlcoholicFilter -> searchByAlcoholic(filter)
            is CategoryFilter -> searchByCategory(filter)
            is IngredientFilter -> searchByIngredient(filter)
        }
    }

    private fun searchByIngredient(filter: IngredientFilter) {
        viewModelScope.launch {  searchByIngredientUseCase(filter) }
    }

    private fun searchByCategory(filter: CategoryFilter) {
        viewModelScope.launch {  searchByCategoryUseCase(filter) }
    }

    private fun searchByAlcoholic(filter: AlcoholicFilter) {
        viewModelScope.launch {  searchByAlcoholicUseCase(filter) }
    }

    fun getListOfAlcoholicFilters() {
        viewModelScope.launch {  listOfAlcoholicFilters = getListOfAlcoholicUseCase()
            _listOfFilters.value = listOfAlcoholicFilters
        }
    }

    fun getListOfIngredientFilters() {
        viewModelScope.launch {  listOfIngredientFilters = getListOfIngredientsUseCase()
            _listOfFilters.value = listOfIngredientFilters
        }
    }

    fun getListOfCategoryFilters() {
        viewModelScope.launch {  listOfCategoryFilters = getListOfCategoriesUseCase()
            _listOfFilters.value = listOfCategoryFilters
        }
    }

}