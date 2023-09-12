package com.alien.plants.data.local.repository

import androidx.room.Dao
import androidx.room.Query
import com.alien.plants.data.local.dto.PlantEntity

@Dao
interface PlantDao {

    @Query("SELECT * FROM plant_entity")
    suspend fun getAllSaved():List<PlantEntity>


}