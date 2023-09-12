package com.alien.plants.presentation.main.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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

@Composable
fun PlantItemView(plantModel: PlantModel,context: Context) {

    Box(
        modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .padding(10.dp)
            .clickable {
                Toast
                    .makeText(context, "Plant ${plantModel.id.toString()}", Toast.LENGTH_SHORT)
                    .show()
            }
    ){

        AsyncImage(model = plantModel.image_url, contentDescription = null,
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
            Text(text = plantModel.common_name.toString(),
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace,

                )
        }

    }
}