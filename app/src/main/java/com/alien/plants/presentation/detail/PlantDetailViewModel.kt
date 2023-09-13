package com.alien.plants.presentation.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alien.plants.comman.Constant
import com.alien.plants.domain.model.PlantModel
import com.alien.plants.domain.use_case.remove_plant.RemovePlantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantDetailViewModel @Inject constructor(val removePlantUseCase: RemovePlantUseCase): ViewModel() {

    val plantDetailState = MutableStateFlow(PlantModel())

    fun getPlantDetail(){
        /*TODO()*/
    }

    fun removePlant(plantModel: PlantModel){
        viewModelScope.launch {
            removePlantUseCase(plantModel)
        }
    }




}