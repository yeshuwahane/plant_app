package com.alien.plants.data.local.mapper

import com.alien.plants.data.local.dto.PlantEntity
import com.alien.plants.domain.model.PlantModel


fun PlantEntity.toModel(): PlantModel {
    return PlantModel(
        author,
        bibliography,
        common_name,
        family,
        family_common_name,
        genus,
        genus_id,
        id,
        image_url,
        links,
        rank
    )
}