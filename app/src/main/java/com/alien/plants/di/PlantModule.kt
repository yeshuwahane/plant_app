package com.alien.plants.di

import com.alien.plants.data.remote.api.PlantApi
import com.alien.plants.data.remote.api.RetrofitInstance
import com.alien.plants.data.remote.repository.PlantRepositoryImpl
import com.alien.plants.domain.repository.PlantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class PlantModule {

    @Provides
    @Singleton
    fun providePlantApi():PlantApi{
        return RetrofitInstance.getRetrofitInstance().create(PlantApi::class.java)
    }

    @Provides
    @Singleton
    fun providePlantRepository(repositoryImpl: PlantRepositoryImpl):PlantRepository{
        return repositoryImpl
    }


}