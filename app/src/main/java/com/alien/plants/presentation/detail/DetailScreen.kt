package com.alien.plants.presentation.detail

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alien.plants.domain.model.PlantModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(plantModel: PlantModel,viewModel: PlantDetailViewModel,tabState:String,context: Context) {
    val cameFrom = "remote"
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {
                    if (tabState == cameFrom) {
                        Text(text = "Add to Garden")
                    }else{
                        Text(text = "Remove from Garden")

                    }
                },
                icon = {
                    if (tabState == cameFrom){
                        Icon(Icons.Default.Add,"Add")
                    }else{
                        Icon(Icons.Default.DeleteForever,"Delete")
                    }

                },

                onClick = {
                    if (tabState == cameFrom){
                        viewModel.addToMyGarden(plantModel)
                        Toast.makeText(context, "Added to My Garden", Toast.LENGTH_SHORT).show()
                    }else{
                        viewModel.removePlant(plantModel)
                        viewModel.finishActivity()
                    }

                })
        }
    ) {paddingValue->

        Box(modifier = Modifier
            .padding(paddingValue)
            .fillMaxSize(),
            ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    AsyncImage(
                        model = plantModel.image_url, contentDescription = plantModel.family,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillParentMaxWidth()
                    )
                }

                item {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = plantModel.common_name.toString(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.headlineLarge,
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = "(Family name)",
                                style = MaterialTheme.typography.labelMedium,
                                textDecoration = TextDecoration.Underline
                            )
                            Text(
                                text = plantModel.family.toString(),
                                style = MaterialTheme.typography.headlineSmall,
                            )

                        }

                    }


                }

            }
        }
    }

}