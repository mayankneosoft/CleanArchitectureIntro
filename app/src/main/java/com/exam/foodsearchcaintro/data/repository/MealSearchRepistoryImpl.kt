package com.exam.foodsearchcaintro.data.repository

import com.exam.foodsearchcaintro.data.model.MealsDTO
import com.exam.foodsearchcaintro.data.remote.FoodSearchAPI
import com.exam.foodsearchcaintro.domain.repository.MealSearchRepository

class MealSearchRepistoryImpl(private val mealSearchAPI: FoodSearchAPI) : MealSearchRepository {

    override suspend fun getMealSearch(s: String): MealsDTO {
        return mealSearchAPI.getSearchMealList(s)
    }
}