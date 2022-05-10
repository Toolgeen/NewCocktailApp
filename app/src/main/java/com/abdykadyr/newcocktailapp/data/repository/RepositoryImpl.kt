package com.abdykadyr.newcocktailapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.abdykadyr.newcocktailapp.data.database.AppDatabase
import com.abdykadyr.newcocktailapp.data.database.CocktailInfoDbModel
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

    override suspend fun getListOfAlcoholic(alcoholicFilter: AlcoholicFilter): List<AlcoholicFilter> {
        TODO("From ethernet")
    }

    override suspend fun getListOfCategories(categoryFilter: CategoryFilter): List<CategoryFilter> {
        TODO("From ethernet")
    }

    override suspend fun getListOfIngredients(ingredientFilter: IngredientFilter): List<IngredientFilter> {
        TODO("From ethernet")
    }

    override suspend fun searchByIngredient(strIngredient: String): LiveData<CocktailInfo> {
        TODO("From ethernet")
    }



}