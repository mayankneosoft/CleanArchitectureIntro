package com.exam.foodsearchcaintro.hilt


import com.exam.foodsearchcaintro.common.Constants
import com.exam.foodsearchcaintro.data.remote.FoodSearchAPI
import com.exam.foodsearchcaintro.data.repository.MealDetailsRepositoryImpl
import com.exam.foodsearchcaintro.data.repository.MealSearchRepistoryImpl
import com.exam.foodsearchcaintro.domain.repository.MealDetailsRepository
import com.exam.foodsearchcaintro.domain.repository.MealSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HIltModules {


    @Provides
    @Singleton
    fun provideFoodAPI(): FoodSearchAPI {
        return Retrofit.Builder()
             .baseUrl(Constants.BASE_URL)
             .addConverterFactory(GsonConverterFactory.create()).build()
             .create(FoodSearchAPI::class.java)
    }


    @Provides
    fun provideMealSearchRepository(searchAPI: FoodSearchAPI): MealSearchRepository {
        return MealSearchRepistoryImpl(searchAPI)
    }


    @Provides
    fun provideMealDetails(searchAPI: FoodSearchAPI): MealDetailsRepository {
        return MealDetailsRepositoryImpl(searchAPI)
    }


}