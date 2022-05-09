package com.exam.foodsearchcaintro.domain.use_case

import com.exam.foodsearchcaintro.common.Resource
import com.exam.foodsearchcaintro.data.model.toDomainMealDetails
import com.exam.foodsearchcaintro.domain.model.MealDetails
import com.exam.foodsearchcaintro.domain.repository.MealDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMealDetailsUseCase @Inject constructor(private val repository: MealDetailsRepository) {

    operator fun invoke(id: String): Flow<Resource<List<MealDetails>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getMealDetails(id)
            val domainData = if (!data.meals.isNullOrEmpty())
                    data.meals.map { it -> it.toDomainMealDetails() }
            else emptyList()
            emit(Resource.Success(data = domainData))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {

        }
    }


}