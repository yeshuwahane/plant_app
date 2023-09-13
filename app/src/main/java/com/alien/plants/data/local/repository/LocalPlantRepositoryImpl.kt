package com.alien.plants.data.local.repository

import com.alien.plants.comman.Constant
import com.alien.plants.data.local.PlantDao
import com.alien.plants.data.local.dto.PlantEntity
import com.alien.plants.data.local.mapper.toEntity
import com.alien.plants.data.local.mapper.toModel
import com.alien.plants.domain.model.PlantModel
import javax.inject.Inject

class LocalPlantRepositoryImpl @Inject constructor(
    private val plantDao: PlantDao
)  {
    suspend fun getAllPlants() = plantDao.getAllPlants().map { it.toModel() }
    suspend fun savePlant(plantModel: PlantModel){
        plantDao.addPlant(plantModel.toEntity())
    }

    suspend fun removePlant(plantModel: PlantModel){
        plantDao.removePlant(plantModel.toEntity())
    }

    suspend fun saveNextActivity(plantEntity: PlantEntity){
        plantDao.addForActivity(plantEntity)
    }



}