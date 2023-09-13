package com.alien.plants.di

import android.content.Context
import androidx.room.Room
import com.alien.plants.data.local.PlantDao
import com.alien.plants.data.local.PlantDatabase
import com.alien.plants.data.remote.api.PlantApi
import com.alien.plants.data.remote.api.RetrofitInstance
import com.alien.plants.data.remote.repository.PlantRepositoryImpl
import com.alien.plants.domain.repository.PlantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    fun provideLocalPlantDao(plantDatabase: PlantDatabase):PlantDao{
        return plantDatabase.plantDao()
    }

    @Provides
    @Singleton
    fun provideLocalPlantDatabase(@ApplicationContext appContext:Context):PlantDatabase{
        return Room.databaseBuilder(
            appContext,PlantDatabase::class.java,
            "plant_database"
        ).build()
    }



}