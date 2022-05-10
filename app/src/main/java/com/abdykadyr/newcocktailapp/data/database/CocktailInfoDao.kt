package com.abdykadyr.newcocktailapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CocktailInfoDao {

    @Query("SELECT * FROM full_cocktail_list ORDER BY strDrink")
    fun getCocktailList(): LiveData<List<CocktailInfoDbModel>>

    @Query("SELECT * FROM full_cocktail_list WHERE idDrink == :idDrinkSearch" )
    fun getCocktail(idDrinkSearch: Int): LiveData<CocktailInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktailList(cocktailListDbModel: List<CocktailInfoDbModel>)

}