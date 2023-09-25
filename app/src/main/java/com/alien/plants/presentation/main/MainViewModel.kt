package com.alien.plants.presentation.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alien.plants.comman.Constant
import com.alien.plants.comman.resource.Resource
import com.alien.plants.data.local.dto.PlantEntity
import com.alien.plants.domain.model.PlantModel
import com.alien.plants.domain.use_case.add_for_activity.AddForActivityUseCase
import com.alien.plants.domain.use_case.get_my_garden_plants.GetMyGardenPlantsUseCase
import com.alien.plants.domain.use_case.get_plants.GetAllPlantsUseCase
import com.alien.plants.domain.use_case.remove_plant.RemovePlantUseCase
import com.alien.plants.domain.use_case.save_plant.SavePlantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllPlantsUseCase: GetAllPlantsUseCase,
    val getMyGardenPlantsUseCase: GetMyGardenPlantsUseCase,
    val savePlantUseCase: SavePlantUseCase,
) : ViewModel() {

    val ediblePlantState: MutableState<List<PlantModel>> by lazy {
        mutableStateOf(emptyList())
    }
    val myGardenState: MutableState<List<PlantModel>> by lazy {
        mutableStateOf(emptyList())
    }

    suspend fun getEdiblePlants() {
        getAllPlantsUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    ediblePlantState.value = listOf(PlantModel(error = result.message))
                }

                is Resource.Loading -> {
                    ediblePlantState.value = listOf(PlantModel(isLoading = true))
                }

                is Resource.Success -> {
                    ediblePlantState.value = listOf(PlantModel(isLoading = false))
                    val response = result.data
                    Log.d("MainViewModel", "Data ${response?.listIterator()}")
                    ediblePlantState.value = response!!

                }
            }

        }.launchIn(viewModelScope)
    }

    fun getMyGarden() {
        viewModelScope.launch {
            val gardenList = getMyGardenPlantsUseCase()
            myGardenState.value = gardenList
        }

    }


    fun addToMyGarden(plantModel: PlantModel){
        viewModelScope.launch {
            savePlantUseCase(plantModel)
        }
    }




}