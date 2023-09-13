package com.alien.plants.domain.use_case.get_my_garden_plants

import com.alien.plants.data.local.dto.PlantEntity
import com.alien.plants.data.local.mapper.toModel
import com.alien.plants.data.local.repository.LocalPlantRepositoryImpl
import com.alien.plants.domain.model.PlantModel
import javax.inject.Inject

class GetMyGardenPlantsUseCase @Inject constructor(val repositoryImpl: LocalPlantRepositoryImpl) {

    suspend operator fun  invoke():List<PlantModel>{
        val myGardenPlantsList = repositoryImpl.getAllPlants()
        return myGardenPlantsList
    }
}