package com.alien.plants.data.local.mapper

import com.alien.plants.data.local.dto.PlantEntity
import com.alien.plants.domain.model.PlantModel


fun PlantEntity.toModel(): PlantModel {
    return PlantModel(
        author = author.toString(),
        bibliography = bibliography.toString(),
        common_name = common_name.toString(),
        family = family.toString(),
        family_common_name = family_common_name.toString(),
        genus = genus.toString(),
        genus_id = genus_id?.toInt(),
        id = id?.toInt(),
        image_url = image_url.toString(),
        rank = rank.toString(),
        scientific_name = scientific_name.toString(),
        slug = slug.toString(),
        status = status.toString(),
        year = year?.toInt()
    )
}

fun PlantModel.toEntity(): PlantEntity {
    return PlantEntity(
        pId = null,
        author = author,
        bibliography = bibliography,
        common_name = common_name,
        family = family,
        family_common_name = family_common_name,
        genus = genus,
        genus_id = genus_id,
        id = id,
        image_url = image_url,
        rank = rank,
        scientific_name = scientific_name,
        slug = slug,
        status = status,
        year = year
    )
}