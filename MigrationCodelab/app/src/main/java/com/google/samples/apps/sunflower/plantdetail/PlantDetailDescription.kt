
package com.google.samples.apps.sunflower.plantdetail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
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

@Composable
fun PlantDetailContent(plant: Plant) {
    PlantName(name = plant.name)
}

@Preview
@Composable
private fun PlantNamePreview() {
    MaterialTheme {
        PlantName(name = "Jackson")
    }
}

@Composable
private fun PlantName(name: String) {
    Text(
        text=name,
        style=MaterialTheme.typography.h5,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.margin_small))
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}