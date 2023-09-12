package com.alien.plants.presentation.main.my_garden

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.alien.plants.domain.model.PlantModel
import com.alien.plants.presentation.main.components.PlantItemView

@Composable
fun MyGardenScreen() {

}

@Composable
fun PlantListScreen(
    plants: List<PlantModel>,
    modifier: Modifier = Modifier,
    context: Context
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.testTag("plant_list"),
        contentPadding = PaddingValues(
            horizontal = 10.dp,
            vertical = 10.dp
        )
    ) {
        items(plants){
            PlantItemView(plantModel = it,context)
        }
    }
}
