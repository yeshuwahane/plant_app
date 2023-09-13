package com.alien.plants.domain.use_case.save_plant

import android.content.Context
import androidx.room.Room
import com.alien.plants.data.local.dto.PlantEntity
import com.alien.plants.data.local.PlantDatabase
import com.alien.plants.data.local.repository.LocalPlantRepositoryImpl
import com.alien.plants.domain.model.PlantModel
import javax.inject.Inject

class SavePlantUseCase @Inject constructor(val repositoryImpl: LocalPlantRepositoryImpl) {

    suspend operator fun invoke(plantModel: PlantModel){
        repositoryImpl.savePlant(plantModel)
    }

}