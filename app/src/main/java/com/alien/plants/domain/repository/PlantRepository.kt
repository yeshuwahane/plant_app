package com.alien.plants.domain.repository

import com.alien.plants.domain.model.PlantModel

interface PlantRepository {

    suspend fun getEdiblePlants():List<PlantModel>
    suspend fun getAllPlants():List<PlantModel>
}