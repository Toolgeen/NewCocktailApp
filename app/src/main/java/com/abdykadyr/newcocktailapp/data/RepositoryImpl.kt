package com.abdykadyr.newcocktailapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.abdykadyr.newcocktailapp.data.api.ApiFactory
import com.abdykadyr.newcocktailapp.data.database.AppDatabase
import com.abdykadyr.newcocktailapp.domain.entities.*
import com.abdykadyr.newcocktailapp.domain.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.lang.RuntimeException

object RepositoryImpl : Repository {

    val compositeDisposable = CompositeDisposable()
    private var listOfCocktails: ListOfCocktails = ListOfCocktails()
    private lateinit var listOfIngredients: ListOfIngredients
    private lateinit var listOfIngredientFilters: ListOfIngredientFilters
    private lateinit var listOfCategoriesFilters: ListOfCategoriesFilters
    private lateinit var listOfAlcoholicFilters: ListOfAlcoholicFilters

    override fun getCocktailById(idDrink: Int, db : AppDatabase): LiveData<CocktailInfo> {
        return db.cocktailInfoDAO().getCocktail(idDrink)
    }

    override fun getCocktailsByFirstLetter(firstLetter: String): List<CocktailInfo>? {
        val disposable: Disposable =  ApiFactory.apiService.getCocktailsByFirstLetter(firstLetter)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { listOfCocktails = it }
            },{
                Log.d("TEST_OF_LOADING_DATA", "failure to load data")
            })
        compositeDisposable.add(disposable)
        return listOfCocktails.listOfCocktails
    }

    override fun getCocktailsByName(nameDrink: String): List<CocktailInfo>? {

        val disposable: Disposable =  ApiFactory.apiService.getCocktailsByName("nameDrink")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { listOfCocktails = it }
            },{
                Log.d("TEST_OF_LOADING_DATA", "failure to load data")
            })
        compositeDisposable.add(disposable)
        return listOfCocktails.listOfCocktails

    }

    override fun getIngredientByName(nameIngredient: String): IngredientInfo {

        val disposable: Disposable =  ApiFactory.apiService.getIngredientByName(nameIngredient)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { listOfIngredients = it }
            },{
                Log.d("TEST_OF_LOADING_DATA", "failure to load data")
            })
        compositeDisposable.add(disposable)
        return listOfIngredients.ingredients?.get(0) ?: throw RuntimeException("getIngredientByName returned null")
    }

    override fun getListOfAlcoholic(alcoholicFilter: AlcoholicFilter): List<AlcoholicFilter> {
        TODO("Not yet implemented")
    }

    override fun getListOfCategories(categoryFilter: CategoryFilter): List<CategoryFilter> {
        TODO("Not yet implemented")
    }

    override fun getListOfIngredients(ingredientFilter: IngredientFilter): List<IngredientInfo> {
        TODO("Not yet implemented")
    }

    override fun searchByIngredient(strIngredient: String): List<CocktailInfo> {
        TODO("Not yet implemented")
    }


}