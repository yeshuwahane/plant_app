package com.alien.plants

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import androidx.lifecycle.MutableLiveData
import com.alien.plants.domain.model.PlantModel
import com.alien.plants.domain.use_case.get_my_garden_plants.GetMyGardenPlantsUseCase
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlantWidget:GlanceAppWidget() {
    @Composable
    override fun Content() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /*
            TODO()
             */
        }
    }

}

@AndroidEntryPoint
class PlantWidgetReceiver: GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = PlantWidget()

    val coroutineScope = MainScope()

    val liveData:MutableLiveData<String> = MutableLiveData()

    @Inject
    lateinit var getMyGarden: GetMyGardenPlantsUseCase

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        getMyPlants(context)
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        getMyPlants(context)
    }


    private fun getMyPlants(context: Context){
        coroutineScope.launch {
            val myGarden = getMyGarden()
            val string = Gson().toJson(myGarden.toString())

            val glanceId =
                GlanceAppWidgetManager(context).getGlanceIds(PlantWidget::class.java).firstOrNull()

            if (glanceId != null) {
                updateAppWidgetState(context,glanceId){prefs->
                    liveData.value = string
                    Log.d("alien","Plants: $string")

                }
            }
        }
    }


}

/*
class IncrementActionCallback: ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->
            val currentCount = prefs[PlantWidget().countKey]
            if(currentCount != null) {
                prefs[PlantWidget().countKey] = currentCount + 1
            } else {
                prefs[PlantWidget().countKey] = 1
            }
        }
        PlantWidget().update(context, glanceId)
    }
}
 */