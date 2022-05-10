package com.abdykadyr.newcocktailapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abdykadyr.newcocktailapp.domain.entities.CocktailInfo

@Dao
interface CocktailInfoDao {

    @Query("SELECT * FROM full_cocktail_list ORDER BY strDrink")
    fun getCocktailList(): LiveData<List<CocktailInfo>>

    @Query("SELECT * FROM full_cocktail_list WHERE idDrink == :idDrinkSearch" )
    fun getCocktail(idDrinkSearch: Int): LiveData<CocktailInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCocktailList(cocktailList: List<CocktailInfo>)

}