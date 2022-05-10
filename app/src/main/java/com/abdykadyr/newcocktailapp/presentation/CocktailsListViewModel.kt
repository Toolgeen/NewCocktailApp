package com.abdykadyr.newcocktailapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.abdykadyr.newcocktailapp.data.repository.RepositoryImpl
import com.abdykadyr.newcocktailapp.data.database.AppDatabase
import com.abdykadyr.newcocktailapp.domain.entities.CocktailInfo
import com.abdykadyr.newcocktailapp.domain.usecases.GetCocktailByIdUseCase
import com.abdykadyr.newcocktailapp.domain.usecases.GetCocktailsByNameUseCase
import com.abdykadyr.newcocktailapp.domain.usecases.LoadDataFromDbUseCase
import kotlinx.coroutines.launch

class CocktailsListViewModel(application: Application): AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)

    private val getCocktailsByNameUseCase = GetCocktailsByNameUseCase(repository)
    private val getCocktailByIdUseCase = GetCocktailByIdUseCase(repository)
    private val loadDataFromDbUseCase = LoadDataFromDbUseCase(repository)

    val cocktailInfoList = loadDataFromDbUseCase()

    fun getCocktailInfo(idDrink: Int) = getCocktailByIdUseCase(idDrink)

    fun searchCocktailsByName(cocktailName: String) {
        viewModelScope.launch { getCocktailsByNameUseCase(cocktailName)
            TODO("just test, launch is not ended")
        }
    }

    init {
        viewModelScope.launch { getCocktailsByNameUseCase("A")
            TODO("just test, launch is not ended")
        }
        loadDataFromDbUseCase()
    }
}