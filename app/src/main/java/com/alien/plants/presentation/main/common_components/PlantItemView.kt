package com.alien.plants.presentation.main.common_components

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alien.plants.domain.model.PlantModel
import com.alien.plants.presentation.detail.PlantDetailActivity
import com.alien.plants.presentation.detail.PlantDetailViewModel
import com.alien.plants.presentation.main.MainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlantItemView(plantModel: PlantModel, context: Context, mainViewModel: MainViewModel) {

    Box(
        modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .padding(10.dp)
            .combinedClickable(
                onClick = {
                    mainViewModel.forDetailActivity(plantModel)
                    val intent = Intent(context, PlantDetailActivity::class.java)
                    context.startActivity(intent)

                },
                onLongClick = {
                    mainViewModel.addToMyGarden(plantModel)
                    Toast
                        .makeText(context, "Added to My Garden", Toast.LENGTH_SHORT)
                        .show()
                }

            )
    ) {

        AsyncImage(
            model = plantModel.image_url, contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop


        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(MaterialTheme.colorScheme.secondaryContainer),
            contentAlignment = Alignment.Center,
        )
        {
            Text(
                text = plantModel.common_name.toString(),
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace,

                )
        }

    }
}