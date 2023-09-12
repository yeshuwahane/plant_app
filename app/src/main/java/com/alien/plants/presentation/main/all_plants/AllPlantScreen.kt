package com.alien.plants.presentation.main.all_plants

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.alien.plants.domain.model.PlantModel
import com.alien.plants.presentation.main.MainViewModel
import com.alien.plants.presentation.main.components.PlantItemView
import com.alien.plants.presentation.main.ui.theme.PlantsTheme

@Composable
fun AllPlantScreen(mainViewModel: MainViewModel,context: Context) {
    val plantsList by remember {
        mainViewModel.ediblePlantState
    }
    PlantsTheme {
        Surface {
            PlantListScreen(plants = plantsList, context = context)
        }
    }
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
