package com.abdykadyr.newcocktailapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.abdykadyr.newcocktailapp.data.RepositoryImpl
import com.abdykadyr.newcocktailapp.data.database.AppDatabase
import com.abdykadyr.newcocktailapp.domain.usecases.GetCocktailsByFirstLetterUseCase
import com.abdykadyr.newcocktailapp.domain.usecases.GetCocktailsByNameUseCase

class CocktailsListViewModel(application: Application): AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val repository = RepositoryImpl
    val cocktailList = db.cocktailInfoDAO().getCocktailList()

    private val getCocktailsByFirstLetterUseCase = GetCocktailsByFirstLetterUseCase(repository)
    private val getCocktailsByNameUseCase = GetCocktailsByNameUseCase(repository)

    fun getCocktailByFistLetter(letter : String) {
        getCocktailsByFirstLetterUseCase(letter)?.let { db.cocktailInfoDAO().insertCocktailList(it) }
    }

    fun getCocktailByName(letter : String) {
        getCocktailsByFirstLetterUseCase(letter)
    }

    override fun onCleared() {
        super.onCleared()
        repository.compositeDisposable.dispose()
    }

}