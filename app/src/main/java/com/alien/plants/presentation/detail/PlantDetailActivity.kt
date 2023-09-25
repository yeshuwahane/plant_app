package com.alien.plants.presentation.detail

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alien.plants.domain.model.PlantModel
import com.alien.plants.presentation.detail.ui.theme.PlantsTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlantDetailActivity : ComponentActivity() {
    private val plantDetailViewModel:PlantDetailViewModel by viewModels<PlantDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val plant = intent.getStringExtra("plant")

        val plantModel = Gson().fromJson(plant,PlantModel::class.java)

        if (plant != null) {
            Log.d("alien",plant)
        }

        setContent {
            PlantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen(plantModel = plantModel)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val plant = plantDetailViewModel.plantDetailState.value
        plantDetailViewModel.removePlant(plant)
    }
}

