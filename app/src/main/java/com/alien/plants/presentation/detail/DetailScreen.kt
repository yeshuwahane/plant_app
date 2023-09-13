package com.alien.plants.presentation.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alien.plants.domain.model.PlantModel

@Composable
fun DetailScreen(plantModel:PlantModel) {

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                AsyncImage(
                    model = plantModel.image_url, contentDescription = plantModel.family,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillParentMaxWidth()
                )
            }

            item {
                Text(text =plantModel.common_name.toString(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge
                    )
                Spacer(modifier = Modifier.height(10.dp))

                Text(text = plantModel.scientific_name.toString(),
                    style = MaterialTheme.typography.headlineSmall,
                    textDecoration = TextDecoration.Underline
                    )
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = plantModel.bibliography.toString(),
                    style = MaterialTheme.typography.bodyMedium
                    )

            }

        }
    }

}