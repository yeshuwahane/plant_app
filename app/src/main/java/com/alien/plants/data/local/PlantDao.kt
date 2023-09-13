package com.alien.plants.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.alien.plants.data.local.dto.PlantEntity

@Dao
interface PlantDao {

    @Query("SELECT * FROM plant_entity")
    suspend fun getAllPlants():List<PlantEntity>

    @Insert
    suspend fun addPlant(vararg plantEntity: PlantEntity)

    @Delete
    suspend fun removePlant(plantEntity: PlantEntity)

    @Update
    suspend fun addForActivity(plantEntity: PlantEntity)







}