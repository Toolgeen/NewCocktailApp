package com.abdykadyr.newcocktailapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.abdykadyr.newcocktailapp.data.database.AppDatabase
import com.abdykadyr.newcocktailapp.data.mapper.CocktailMapper
import com.abdykadyr.newcocktailapp.data.network.ApiFactory
import com.abdykadyr.newcocktailapp.domain.entities.*
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class RepositoryImpl(
    private val application: Application
) : Repository {

    private val cocktailInfoDao = AppDatabase.getInstance(application).cocktailInfoDAO()
    private val mapper = CocktailMapper()
    private val apiService = ApiFactory.apiService

    override fun getCocktailById(idDrink: Int): LiveData<CocktailInfo> {
        return Transformations.map(cocktailInfoDao.getCocktail(idDrink)) {
                mapper.mapCocktailDbModelToEntity(it)
        }
    }

    fun clearDb() { cocktailInfoDao.clearDb() }

    override fun loadDataFromDb(): LiveData<List<CocktailInfo>> {
        return Transformations.map(cocktailInfoDao.getCocktailList()) {
            it.map {
                mapper.mapCocktailDbModelToEntity(it)
            }
        }
    }

    override suspend fun getCocktailsByName(nameDrink: String): LiveData<List<CocktailInfo>> {
        try {
            val cocktailsByNameDto = apiService.getCocktailsByName(nameDrink)
            val cocktailsByName = mapper.mapListOfCocktailsContainerToListOfCocktailsDto(cocktailsByNameDto)
            val dbCocktailList = cocktailsByName?.map { mapper.mapCocktailDtoToModel(it) }
            if (dbCocktailList != null) {
                cocktailInfoDao.insertCocktailList(dbCocktailList)
            }
        } catch (e: Exception) {
        }
        return loadDataFromDb()
    }

    override suspend fun getIngredientByName(nameIngredient: String): LiveData<IngredientInfo> {
        TODO("From ethernet")
    }

    override suspend fun getListOfAlcoholic(): List<AlcoholicFilter> {
        var listOfFilters = mutableListOf<AlcoholicFilter>()
        try {
            val alcoholicFiltersContainerDto = apiService.getAlcoholic()
            val filtersDto = mapper.mapAlcoholicFilterContainerToFiltersDto(alcoholicFiltersContainerDto)
            val filters = filtersDto?.map { mapper.mapAlcoholicFilterDtoToFilter(it) }
            if (filters != null) {
                listOfFilters.addAll(filters)
            }
        } catch (e: Exception) {
        }
        return listOfFilters
    }

    override suspend fun getListOfCategories(): List<CategoryFilter> {
        var listOfFilters = mutableListOf<CategoryFilter>()
        try {
            val categoriesFiltersContainerDto = apiService.getCategories()
            val filtersDto = mapper.mapCategoriesFilterContainerToFiltersDto(categoriesFiltersContainerDto)
            val filters = filtersDto?.map { mapper.mapCategoryFilterDtoToFilter(it) }
            if (filters != null) {
                listOfFilters.addAll(filters)
            }
        } catch (e: Exception) {
        }
        return listOfFilters
    }

    override suspend fun getListOfIngredients(): List<IngredientFilter> {
        var listOfFilters = mutableListOf<IngredientFilter>()
        try {
            val ingredientFiltersContainerDto = apiService.getIngredients()
            val filtersDto = mapper.mapIngredientFilterContainerToFiltersDto(ingredientFiltersContainerDto)
            val filters = filtersDto?.map { mapper.mapIngredientFilterDtoToFilter(it) }
            if (filters != null) {
                listOfFilters.addAll(filters)
            }
        } catch (e: Exception) {
        }
        return listOfFilters
    }

    override suspend fun searchByIngredient(ingredientFilter: IngredientFilter): LiveData<List<CocktailInfo>> {
        val filter = ingredientFilter.strFilter
        if (filter != null) {
            try {
                val cocktailsByNameDto = apiService.getCocktailsByIngredient(filter)
                val cocktailsByName = mapper.mapListOfCocktailsContainerToListOfCocktailsDto(cocktailsByNameDto)
                val dbCocktailList = cocktailsByName?.map { mapper.mapCocktailDtoToModel(it) }
                if (dbCocktailList != null) {
                    cocktailInfoDao.insertCocktailList(dbCocktailList)
                }
            } catch (e: Exception) {
            }
        }
        return loadDataFromDb()
    }

    override suspend fun searchByAlcoholic(alcoholicFilter: AlcoholicFilter): LiveData<List<CocktailInfo>> {
        val filter = alcoholicFilter.strFilter
        if (filter != null) {
            try {
                val cocktailsByNameDto = apiService.getCocktailsByIngredient(filter)
                val cocktailsByName = mapper.mapListOfCocktailsContainerToListOfCocktailsDto(cocktailsByNameDto)
                val dbCocktailList = cocktailsByName?.map { mapper.mapCocktailDtoToModel(it) }
                if (dbCocktailList != null) {
                    cocktailInfoDao.insertCocktailList(dbCocktailList)
                }
            } catch (e: Exception) {
            }
        }
        return loadDataFromDb()
    }

    override suspend fun searchByCategory(categoryFilter: CategoryFilter): LiveData<List<CocktailInfo>> {
        val filter = categoryFilter.strFilter
        if (filter != null) {
            try {
                val cocktailsByNameDto = apiService.getCocktailsByIngredient(filter)
                val cocktailsByName = mapper.mapListOfCocktailsContainerToListOfCocktailsDto(cocktailsByNameDto)
                val dbCocktailList = cocktailsByName?.map { mapper.mapCocktailDtoToModel(it) }
                if (dbCocktailList != null) {
                    cocktailInfoDao.insertCocktailList(dbCocktailList)
                }
            } catch (e: Exception) {
            }
        }
        return loadDataFromDb()
    }
}
