package com.alien.plants.presentation.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Forest
import androidx.compose.material.icons.filled.Yard
import androidx.compose.material.icons.outlined.Forest
import androidx.compose.material.icons.outlined.Yard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.lifecycleScope
import com.alien.plants.presentation.main.all_plants.AllPlantScreen
import com.alien.plants.presentation.main.my_garden.MyGardenScreen
import com.alien.plants.presentation.main.ui.theme.PlantsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tabItems = listOf(
            TabItem(
                title = "My Garden",
                unSelectedIcon = Icons.Outlined.Yard,
                selectedIcon = Icons.Filled.Yard
            ),
            TabItem(
                title = "All Plants",
                unSelectedIcon = Icons.Outlined.Forest,
                selectedIcon = Icons.Filled.Forest
            )
        )



        setContent {
            PlantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var selectedTabIndex by remember {
                        mutableIntStateOf(0)
                    }
                    val pagerState = rememberPagerState {
                        tabItems.size
                    }
                    LaunchedEffect(selectedTabIndex){
                        pagerState.animateScrollToPage(selectedTabIndex)
                    }
                    LaunchedEffect(pagerState.currentPage,pagerState.isScrollInProgress){
                        if (!pagerState.isScrollInProgress){
                        selectedTabIndex = pagerState.currentPage
                        }
                    }

                    Column(modifier = Modifier.fillMaxSize()) {
                        TabRow(selectedTabIndex = selectedTabIndex) {
                            tabItems.forEachIndexed { index, tabItem ->
                                Tab(selected = index == selectedTabIndex, onClick = {
                                    selectedTabIndex = index
                                },
                                    text = {
                                        Text(text = tabItem.title)
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (index == selectedTabIndex) tabItem.selectedIcon else tabItem.unSelectedIcon,
                                            contentDescription = tabItem.title
                                        )
                                    }
                                )
                            }
                        }

                        HorizontalPager(
                            state = pagerState, modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                        ) { index ->
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                if (index == 0){
                                    MyGardenScreen(mainViewModel = mainViewModel,this@MainActivity)
                                    mainViewModel.getMyGarden()

                                }else{
                                    AllPlantScreen(mainViewModel = mainViewModel,this@MainActivity)

                                }
                            }
                        }


                    }
                }
            }
        }


    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            mainViewModel.getEdiblePlants()
            Log.d("alien", "list: ${mainViewModel.ediblePlantState.value.listIterator()}")
            mainViewModel.getMyGarden()
            val myGardenList = mainViewModel.myGardenState.value


        }
    }
}

data class TabItem(
    val title: String,
    val unSelectedIcon: ImageVector,
    val selectedIcon: ImageVector
)


