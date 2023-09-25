package com.alien.plants.presentation.detail

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import androidx.lifecycle.Observer
import com.alien.plants.domain.model.PlantModel
import com.alien.plants.presentation.detail.ui.theme.PlantsTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlantDetailActivity : ComponentActivity() {
    private val plantDetailViewModel:PlantDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val plant = intent.getStringExtra("plant")
        val tabState = intent.getStringExtra("state")

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
                    if (tabState != null) {
                        DetailScreen(plantModel = plantModel,plantDetailViewModel,tabState,this)
                    }else{
                        Toast.makeText(this, "Some Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        plantDetailViewModel.finishActivity.observe(this, Observer {
            if (it == true){
                finish()
            }
        })
    }

}

