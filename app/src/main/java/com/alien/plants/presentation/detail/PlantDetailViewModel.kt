package com.alien.plants.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alien.plants.comman.Constant
import com.alien.plants.domain.model.PlantModel
import com.alien.plants.domain.use_case.remove_plant.RemovePlantUseCase
import com.alien.plants.domain.use_case.save_plant.SavePlantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantDetailViewModel @Inject constructor(val removePlantUseCase: RemovePlantUseCase,val savePlantUseCase: SavePlantUseCase): ViewModel() {

    val finishActivity : MutableLiveData<Boolean> = MutableLiveData(false)


    fun removePlant(plantModel: PlantModel){
        viewModelScope.launch {
            removePlantUseCase(plantModel)
        }
    }

    fun addToMyGarden(plantModel: PlantModel){
        viewModelScope.launch {
            savePlantUseCase(plantModel)
        }
    }

    fun finishActivity(){
        finishActivity.value = true
    }




}