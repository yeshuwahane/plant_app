package com.alien.plants.domain.use_case.plant_detail

import com.alien.plants.data.local.dto.PlantEntity
import com.alien.plants.data.local.mapper.toModel
import com.alien.plants.data.local.repository.LocalPlantRepositoryImpl
import com.alien.plants.domain.model.PlantModel
import javax.inject.Inject

class GetPlantDetailUseCase @Inject constructor(val repositoryImpl: LocalPlantRepositoryImpl) {



}