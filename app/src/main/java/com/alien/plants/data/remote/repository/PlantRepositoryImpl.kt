package com.alien.plants.data.remote.repository

import com.alien.plants.comman.Constant
import com.alien.plants.data.remote.api.PlantApi
import com.alien.plants.data.remote.mapper.toModel
import com.alien.plants.domain.model.PlantModel
import com.alien.plants.domain.repository.PlantRepository
import javax.inject.Inject


class PlantRepositoryImpl @Inject constructor(val api: PlantApi) : PlantRepository {
    override suspend fun getEdiblePlants(): List<PlantModel> {
        return api.getEdiblePlants(Constant.API_KEY).data.map { it.toModel() }
    }

    override suspend fun getAllPlants(): List<PlantModel> {
        return api.getAllPlants(Constant.API_KEY).data.map { it.toModel() }
    }



}