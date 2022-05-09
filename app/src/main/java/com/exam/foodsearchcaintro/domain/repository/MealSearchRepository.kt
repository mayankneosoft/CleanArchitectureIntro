package com.exam.foodsearchcaintro.domain.repository

import com.exam.foodsearchcaintro.data.model.MealsDTO

interface MealSearchRepository {

    suspend fun getMealSearch(s:String): MealsDTO



}