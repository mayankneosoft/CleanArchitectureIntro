package com.exam.foodsearchcaintro.domain.repository

import com.exam.foodsearchcaintro.data.model.MealsDTO

interface MealDetailsRepository {

    suspend fun getMealDetails(id:String): MealsDTO

}