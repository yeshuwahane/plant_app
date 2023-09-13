package com.alien.plants.domain.use_case.remove_plant

import com.alien.plants.data.local.repository.LocalPlantRepositoryImpl
import com.alien.plants.domain.model.PlantModel
import javax.inject.Inject

class RemovePlantUseCase @Inject constructor(val repositoryImpl: LocalPlantRepositoryImpl) {

    suspend operator fun invoke(plantModel: PlantModel){
        repositoryImpl.removePlant(plantModel)
    }

}