package com.exam.foodsearchcaintro.data.repository

import com.exam.foodsearchcaintro.data.model.MealsDTO
import com.exam.foodsearchcaintro.data.remote.FoodSearchAPI
import com.exam.foodsearchcaintro.domain.repository.MealDetailsRepository

class MealDetailsRepositoryImpl(private val mealSearchAPI: FoodSearchAPI) : MealDetailsRepository {

    override suspend fun getMealDetails(id: String): MealsDTO {
        return mealSearchAPI.getMealDetails(id)
    }
}