package com.alien.plants.domain.model

data class PlantModel(
    val author: String? = "",
    val bibliography: String? = "",
    val common_name: String? = "",
    val family: String? = "",
    val family_common_name: String? = "",
    val genus: String? = "",
    val genus_id: Int? =0,
    val id: Int? =0,
    val image_url: String? = "",
    val links: List<String>? = emptyList(),
    val rank: String? = "",
    val scientific_name: String? = "",
    val slug: String? = "",
    val status: String? = "",
    val synonyms: List<String>? = emptyList(),
    val year: Int? =0,
    val isLoading:Boolean ?= false,
    val error:String? = "",
    val dbId:Int? = null
)
