package com.abdykadyr.newcocktailapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CocktailInfoDao {

    @Query("SELECT * FROM full_cocktail_list ORDER BY strDrink")
    fun getCocktailList(): LiveData<List<CocktailInfoDbModel>>

    @Query("SELECT * FROM full_cocktail_list WHERE idDrink == :idDrinkSearch" )
    fun getCocktail(idDrinkSearch: Int): LiveData<CocktailInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktailList(cocktailListDbModel: List<CocktailInfoDbModel>)


    @Query("DELETE FROM full_cocktail_list")
    fun clearDb()

}