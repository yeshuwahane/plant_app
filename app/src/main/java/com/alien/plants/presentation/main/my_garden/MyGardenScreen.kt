package com.alien.plants.presentation.main.my_garden

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alien.plants.presentation.main.MainViewModel
import com.alien.plants.presentation.main.common_components.PlantItemView

@Composable
fun MyGardenScreen(mainViewModel: MainViewModel,context: Context) {
PlantListScreen(mainViewModel = mainViewModel, context = context)
}

@Composable
fun PlantListScreen(
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier,
    context: Context
) {

    val myGarden by remember {
        mainViewModel.myGardenState
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = 10.dp,
            vertical = 10.dp
        ),
        verticalArrangement = Arrangement.Top,

    ) {
        items(myGarden){
            PlantItemView(plantModel = it,context,mainViewModel)
        }
    }

}
