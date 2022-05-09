package com.exam.foodsearchcaintro.presentation.meal_search

import com.exam.foodsearchcaintro.domain.model.Meal

data class MealSearchState(
    val isLoading: Boolean = false,
    val data: List<Meal>? = null,
    val error: String = ""
)