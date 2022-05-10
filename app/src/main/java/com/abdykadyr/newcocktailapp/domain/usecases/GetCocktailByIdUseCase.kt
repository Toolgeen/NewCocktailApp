package com.abdykadyr.newcocktailapp.domain.usecases

import androidx.lifecycle.LiveData
import com.abdykadyr.newcocktailapp.data.database.AppDatabase
import com.abdykadyr.newcocktailapp.domain.entities.CocktailInfo
import com.abdykadyr.newcocktailapp.domain.repository.Repository

class GetCocktailByIdUseCase(private val repository: Repository) {

    operator fun invoke(idDrink: Int, db : AppDatabase) : LiveData<CocktailInfo> {
        return repository.getCocktailById(idDrink, db)
    }

}