package com.abdykadyr.newcocktailapp.data.mapper

import com.abdykadyr.newcocktailapp.data.database.CocktailInfoDbModel
import com.abdykadyr.newcocktailapp.data.network.model.*
import com.abdykadyr.newcocktailapp.domain.entities.AlcoholicFilter
import com.abdykadyr.newcocktailapp.domain.entities.CategoryFilter
import com.abdykadyr.newcocktailapp.domain.entities.CocktailInfo
import com.abdykadyr.newcocktailapp.domain.entities.IngredientFilter

class CocktailMapper {

    fun mapCocktailDtoToModel(dto: CocktailInfoDto) = CocktailInfoDbModel(
        idDrink = dto.idDrink,
        strDrink = dto.strDrink,
        strDrinkThumb = dto.strDrinkThumb,
        strTags = dto.strTags,
        strCategory = dto.strCategory,
        strIBA = dto.strIBA,
        strAlcoholic = dto.strAlcoholic,
        strGlass = dto.strGlass,
        strInstructions = dto.strInstructions,
        strIngredient1 = dto.strIngredient1,
        strIngredient2 = dto.strIngredient2,
        strIngredient3 = dto.strIngredient3,
        strIngredient4 = dto.strIngredient4,
        strIngredient5 = dto.strIngredient5,
        strIngredient6 = dto.strIngredient6,
        strIngredient7 = dto.strIngredient7,
        strIngredient8 = dto.strIngredient8,
        strIngredient9 = dto.strIngredient9,
        strIngredient10 = dto.strIngredient10,
        strIngredient11 = dto.strIngredient11,
        strIngredient12 = dto.strIngredient12,
        strIngredient13 = dto.strIngredient13,
        strIngredient14 = dto.strIngredient14,
        strIngredient15 = dto.strIngredient15,
        strMeasure1 = dto.strMeasure1,
        strMeasure2 = dto.strMeasure2,
        strMeasure3 = dto.strMeasure3,
        strMeasure4 = dto.strMeasure4,
        strMeasure5 = dto.strMeasure5,
        strMeasure6 = dto.strMeasure6,
        strMeasure7 = dto.strMeasure7,
        strMeasure8 = dto.strMeasure8,
        strMeasure9 = dto.strMeasure9,
        strMeasure10 = dto.strMeasure10,
        strMeasure11 = dto.strMeasure11,
        strMeasure12 = dto.strMeasure12,
        strMeasure13 = dto.strMeasure13,
        strMeasure14 = dto.strMeasure14,
        strMeasure15 = dto.strMeasure15
        )

    fun mapCocktailDbModelToEntity(dbModel: CocktailInfoDbModel) =  CocktailInfo (
        idDrink = dbModel.idDrink,
        strDrink = dbModel.strDrink,
        strDrinkThumb = dbModel.strDrinkThumb,
        strTags = dbModel.strTags,
        strCategory = dbModel.strCategory,
        strIBA = dbModel.strIBA,
        strAlcoholic = dbModel.strAlcoholic,
        strGlass = dbModel.strGlass,
        strInstructions = dbModel.strInstructions,
        strIngredient1 = dbModel.strIngredient1,
        strIngredient2 = dbModel.strIngredient2,
        strIngredient3 = dbModel.strIngredient3,
        strIngredient4 = dbModel.strIngredient4,
        strIngredient5 = dbModel.strIngredient5,
        strIngredient6 = dbModel.strIngredient6,
        strIngredient7 = dbModel.strIngredient7,
        strIngredient8 = dbModel.strIngredient8,
        strIngredient9 = dbModel.strIngredient9,
        strIngredient10 = dbModel.strIngredient10,
        strIngredient11 = dbModel.strIngredient11,
        strIngredient12 = dbModel.strIngredient12,
        strIngredient13 = dbModel.strIngredient13,
        strIngredient14 = dbModel.strIngredient14,
        strIngredient15 = dbModel.strIngredient15,
        strMeasure1 = dbModel.strMeasure1,
        strMeasure2 = dbModel.strMeasure2,
        strMeasure3 = dbModel.strMeasure3,
        strMeasure4 = dbModel.strMeasure4,
        strMeasure5 = dbModel.strMeasure5,
        strMeasure6 = dbModel.strMeasure6,
        strMeasure7 = dbModel.strMeasure7,
        strMeasure8 = dbModel.strMeasure8,
        strMeasure9 = dbModel.strMeasure9,
        strMeasure10 = dbModel.strMeasure10,
        strMeasure11 = dbModel.strMeasure11,
        strMeasure12 = dbModel.strMeasure12,
        strMeasure13 = dbModel.strMeasure13,
        strMeasure14 = dbModel.strMeasure14,
        strMeasure15 = dbModel.strMeasure15
    )

    fun mapAlcoholicFilterContainerToFiltersDto(dto: AlcoholicFilterContainerDto) =
        dto.alcoholicFilterDtos

    fun mapAlcoholicFilterDtoToFilter(dto: AlcoholicFilterDto) = AlcoholicFilter (
        strFilter = dto.alcoholicFilter
            )

    fun mapCategoriesFilterContainerToFiltersDto(dto: CategoriesFilterContainerDto) =
        dto.categoriesFilterDtos

    fun mapCategoryFilterDtoToFilter(dto: CategoryFilterDto) = CategoryFilter (
        strFilter = dto.strCategory
    )

    fun mapIngredientFilterContainerToFiltersDto(dto: IngredientFilterContainerDto) =
        dto.ingredientsFilterDtos

    fun mapIngredientFilterDtoToFilter(dto: IngredientFilterDto) = IngredientFilter (
        strFilter = dto.ingredientFilter
    )

    fun mapListOfCocktailsContainerToListOfCocktailsDto(dto: ListOfCocktailsContainerDto) =
        dto.listOfCocktailDtos

    fun mapListOfIngredientsContainerToListOfIngredientsDto(dto: ListOfIngredientsContainerDto) =
        dto.listOfIngredientsDtos

}

