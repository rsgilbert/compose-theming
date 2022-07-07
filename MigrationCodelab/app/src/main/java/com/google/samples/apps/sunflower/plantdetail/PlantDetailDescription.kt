package com.google.samples.apps.sunflower.plantdetail

import android.content.res.Configuration
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import com.google.android.material.composethemeadapter.MdcTheme
import com.google.samples.apps.sunflower.R
import com.google.samples.apps.sunflower.data.Plant
import com.google.samples.apps.sunflower.viewmodels.PlantDetailViewModel

@Composable
fun PlantDetailDescription(plantDetailViewModel: PlantDetailViewModel) {
    val plant: Plant? by plantDetailViewModel.plant.observeAsState()
    plant?.let {
        PlantDetailContent(plant = it)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PlantDetailContentPreviewDark() {
    val plant = Plant("ID01", "Eucalyptus", "<p>This is <b>Eucalyptus</p>",  2)
    MdcTheme {
        PlantDetailContent(plant = plant)
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PlantDetailContentPreviewLight() {
    val plant = Plant("ID01", "Eucalyptus", "<p>This is <b>Eucalyptus</p>",  2)
    MdcTheme {
        PlantDetailContent(plant = plant)
    }
}

@Composable
fun PlantDetailContent(plant: Plant) {
    Surface {
        Column(Modifier.padding(dimensionResource(id = R.dimen.margin_normal))) {
            PlantName(name = plant.name)
            PlantWatering(plant)
                PlantDescription(description = plant.description)
        }
    }
}


@Composable
private fun PlantName(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h5,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.margin_small))
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Composable
fun PlantWatering(plant: Plant) {
    Column(Modifier.fillMaxWidth()) {
        PlantWateringHeader()
        PlantWateringInterval(wateringInterval = plant.wateringInterval)
    }
}


@Composable
private fun PlantWateringHeader() {
    Text(
        text = stringResource(id = R.string.watering_needs_prefix),
        color = MaterialTheme.colors.primaryVariant,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.margin_small))
            .padding(top = dimensionResource(id = R.dimen.margin_normal))
            .wrapContentWidth(Alignment.CenterHorizontally)

    )
}

@Composable
private fun PlantWateringInterval(wateringInterval: Int) {
    val context = LocalContext.current
    val resources = context.resources
    val wateringIntervalStr = resources.getQuantityString(
        R.plurals.watering_needs_suffix,
        wateringInterval, wateringInterval
    )
    Text(
        text = wateringIntervalStr,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.margin_small))
            .padding(bottom = dimensionResource(id = R.dimen.margin_small))
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Preview
@Composable
private fun PlantDescriptionPreview(){
    MaterialTheme {
        PlantDescription("<h1>Hey</h1><p>Today <b>is</b> your day </p>")
    }
}

@Composable
private fun PlantDescription(description: String) {
//     Remembers the HTML formatted description. Re-executes on a new description
//      val htmlDescription = remember(description) {
//        // calculation
//        HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT)
//    }
    val htmlDescription = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT)
    val context = LocalContext.current
    val resources = context.resources
    // Displays the TextView on the screen and updates with the HTML
    // description when inflated
    // Updates to htmlDescription will make AndroidView recompose and update the text
    AndroidView(
        factory = { context ->
            TextView(context).apply {
                movementMethod = LinkMovementMethod.getInstance()
                setTextColor(resources.getColor(R.color.color_on_surface_50))
            }
        },
        update = {
            it.text = htmlDescription
        },
        modifier = Modifier
            .background(color = MaterialTheme.colors.onSurface, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    )
}



