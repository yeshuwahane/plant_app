package com.alien.plants

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.items
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.lifecycle.MutableLiveData
import com.alien.plants.domain.model.PlantModel
import com.alien.plants.domain.use_case.get_my_garden_plants.GetMyGardenPlantsUseCase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

object PlantWidget:GlanceAppWidget() {
    val json = stringPreferencesKey("data")
    @Composable
    override fun Content() {
        val data = currentState(key = json)

        Log.d("alien","Plants: $data")

//        LazyColumn(
//            modifier = GlanceModifier
//                .fillMaxSize()
//                .background(MaterialTheme.colorScheme.background),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            items()
//        }
    }


}

@AndroidEntryPoint
class PlantWidgetReceiver: GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = PlantWidget

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
                    prefs[PlantWidget.json] = string
                    Log.d("alien","model: $string")

                }
                PlantWidget.update(context, glanceId)
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