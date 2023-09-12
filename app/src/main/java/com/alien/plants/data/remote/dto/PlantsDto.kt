package com.alien.plants.data.remote.dto

data class PlantsDto(
    val `data`: List<Data>,
    val links: LinksX,
    val meta: Meta
)