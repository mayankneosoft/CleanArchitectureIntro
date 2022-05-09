package com.exam.foodsearchcaintro.presentation.meal_details

import com.exam.foodsearchcaintro.domain.model.MealDetails

data class MealDetailsState(
    val isLoading: Boolean = false,
    val data: MealDetails? = null,
    val error: String = ""
) {
}