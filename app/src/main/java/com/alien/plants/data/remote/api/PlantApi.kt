package com.alien.plants.data.remote.api

import com.alien.plants.data.remote.dto.PlantsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PlantApi {


    @GET("v1/plants?filter_not%5Bedible_part%5D=null")
    suspend fun getEdiblePlants(@Query("token") key:String):PlantsDto

    @GET("v1/plants?")
    suspend fun getAllPlants(@Query("token")key: String):PlantsDto

}