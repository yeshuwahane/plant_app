package com.alien.plants.domain.use_case.get_plants

import com.alien.plants.comman.resource.Resource
import com.alien.plants.domain.model.PlantModel
import com.alien.plants.domain.repository.PlantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllPlantsUseCase @Inject constructor(
    val repository: PlantRepository
) {

     suspend operator fun invoke():Flow<Resource<List<PlantModel>>> = flow {
         try {
             emit(Resource.Loading())
             val PlantsList = repository.getAllPlants()
             emit(Resource.Success(PlantsList))
         }catch (e:HttpException){
             emit(Resource.Error(e.message()))
         }catch (e:IOException){
             emit(Resource.Error("Couldn't reach server check your internet connection"))
         }
     }

}