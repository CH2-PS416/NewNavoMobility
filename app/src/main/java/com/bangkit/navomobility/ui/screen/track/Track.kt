package com.bangkit.navomobility.ui.screen.track

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bangkit.navomobility.ui.components.TrackCard

@Composable
fun Track() {
    Column (
        modifier = Modifier
            .padding(16.dp)
    ){
        TrackCard(
            tujuan = "Jakarta",
            asal = "Semarang",
            jam_berangkat = "08.00",
            jam_sampai = "11.00",
            jarak = "27 km",
            status = "On Going"
        )
    }
}

@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun JalanScreenPreview() {
    Track()
}