package com.alien.plants.data.remote.mapper

import com.alien.plants.data.remote.dto.Data
import com.alien.plants.domain.model.PlantModel


fun Data.toModel(): PlantModel {
    return PlantModel(
        author = author,
        bibliography = bibliography,
        common_name = common_name,
        family = family,
        family_common_name = family_common_name,
        genus = genus,
        genus_id = genus_id,
        id = id,
        image_url = image_url,
        links = listOf(links.genus,links.plant,links.self),
        rank = rank
    )


}
