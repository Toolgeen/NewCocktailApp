package com.abdykadyr.newcocktailapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.abdykadyr.newcocktailapp.data.api.ApiFactory
import com.abdykadyr.newcocktailapp.data.database.AppDatabase
import com.abdykadyr.newcocktailapp.data.model.*
import com.abdykadyr.newcocktailapp.domain.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.lang.RuntimeException

object RepositoryImpl : Repository {

    val compositeDisposable = CompositeDisposable()
    private val listOfCocktails = mutableListOf<CocktailInfoDto>()
    private lateinit var listOfIngredientsContainerDto: ListOfIngredientsContainerDto
    private lateinit var ingredientFilterContainerDto: IngredientFilterContainerDto
    private lateinit var categoriesFilterContainerDto: CategoriesFilterContainerDto
    private lateinit var alcoholicFilterContainerDto: AlcoholicFilterContainerDto

    override fun getCocktailById(idDrink: Int, db : AppDatabase): LiveData<CocktailInfoDto> {
        return db.cocktailInfoDAO().getCocktail(idDrink)
    }

    override fun getCocktailsByFirstLetter(firstLetter: String): List<CocktailInfoDto>? {
        val disposable: Disposable =  ApiFactory.apiService.getCocktailsByFirstLetter(firstLetter)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { }
            },{
                Log.d("TEST_OF_LOADING_DATA", "failure to load data")
            })
        compositeDisposable.add(disposable)
        return listOfCocktails
    }

    override fun getCocktailsByName(nameDrink: String, db : AppDatabase): List<CocktailInfoDto>? {

        val disposable: Disposable =  ApiFactory.apiService.getCocktailsByName(nameDrink)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { db.cocktailInfoDAO().insertCocktailList(it.listOfCocktailDtos) }
            },{
                Log.d("TEST_OF_LOADING_DATA", "failure to load data")
            })
        compositeDisposable.add(disposable)
        Log.d("TEST_OF_LOADING_DATA", listOfCocktails.toString())
        return listOfCocktails

    }

    override fun getIngredientByName(nameIngredient: String): IngredientInfoDto {

        val disposable: Disposable =  ApiFactory.apiService.getIngredientByName(nameIngredient)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { listOfIngredientsContainerDto = it }
            },{
                Log.d("TEST_OF_LOADING_DATA", "failure to load data")
            })
        compositeDisposable.add(disposable)
        return listOfIngredientsContainerDto.ingredientDtos?.get(0) ?: throw RuntimeException("getIngredientByName returned null")
    }

    override fun getListOfAlcoholic(alcoholicFilterDto: AlcoholicFilterDto): List<AlcoholicFilterDto> {
        TODO("Not yet implemented")
    }

    override fun getListOfCategories(categoryFilterDto: CategoryFilterDto): List<CategoryFilterDto> {
        TODO("Not yet implemented")
    }

    override fun getListOfIngredients(ingredientFilterDto: IngredientFilterDto): List<IngredientInfoDto> {
        TODO("Not yet implemented")
    }

    override fun searchByIngredient(strIngredient: String): List<CocktailInfoDto> {
        TODO("Not yet implemented")
    }


}