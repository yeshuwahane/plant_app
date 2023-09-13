package com.alien.plants.domain.use_case.add_for_activity

import com.alien.plants.data.local.dto.PlantEntity
import com.alien.plants.data.local.repository.LocalPlantRepositoryImpl
import javax.inject.Inject

class AddForActivityUseCase @Inject constructor(val repositoryImpl: LocalPlantRepositoryImpl) {

    suspend operator fun invoke(plantEntity: PlantEntity){
        repositoryImpl.saveNextActivity(plantEntity)
    }


}