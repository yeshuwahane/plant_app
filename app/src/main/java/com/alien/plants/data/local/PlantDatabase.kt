package com.alien.plants.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alien.plants.data.local.dto.PlantEntity


@Database(entities = [PlantEntity::class], version = 1, exportSchema = false)
abstract class PlantDatabase: RoomDatabase() {
    abstract fun plantDao(): PlantDao

}