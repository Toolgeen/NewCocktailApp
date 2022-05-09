package com.abdykadyr.newcocktailapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abdykadyr.newcocktailapp.domain.entities.CocktailFullInfo
import com.abdykadyr.newcocktailapp.domain.entities.ListOfCocktails

interface CocktailInfoDao {

    @Query("SELECT * FROM full_cocktail_list ORDER BY strDrink" )
    fun getCocktailList(): LiveData<List<ListOfCocktails>>

    @Query("SELECT * FROM full_cocktail_list WHERE idDrink == idDrink LIMIT 1" )
    fun getCocktailInfo(idDrink: Int): LiveData<CocktailFullInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPriceList(priceList: List<CocktailFullInfo>)

}