package com.alien.plants.data.local.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plant_entity")
data class PlantEntity(
    @PrimaryKey(autoGenerate = true)val pId:Int?,
    @ColumnInfo(name = "author") val author: String? = "",
    @ColumnInfo(name = "bibliography")val bibliography: String? = "",
    @ColumnInfo(name = "common_name")val common_name: String? = "",
    @ColumnInfo(name = "family")val family: String? = "",
    @ColumnInfo(name = "family_common_name")val family_common_name: String? = "",
    @ColumnInfo(name = "genus")val genus: String? = "",
    @ColumnInfo(name = "genus_id")val genus_id: Int? =0,
    @ColumnInfo(name = "id")val id: Int? =0,
    @ColumnInfo(name = "image_url")val image_url: String? = "",
    @ColumnInfo(name = "rank")val rank: String? = "",
    @ColumnInfo(name = "scientific_name")val scientific_name: String? = "",
    @ColumnInfo(name = "slug")val slug: String? = "",
    @ColumnInfo(name = "status")val status: String? = "",
    @ColumnInfo(name = "year")val year: Int? =0,
)