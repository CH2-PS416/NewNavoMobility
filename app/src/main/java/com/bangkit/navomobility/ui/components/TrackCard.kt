package com.bangkit.navomobility.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bangkit.navomobility.R

@Composable
fun TrackCard(
    tujuan: String,
    asal: String,
    jam_berangkat: String,
    jam_sampai: String,
    jarak: String,
    status: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(60.dp),
        colors = CardDefaults.cardColors(),
    ) {
        Surface (
            color = Color.White
        ){
            Column(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color.Green
                    )
                    .padding(16.dp),
            ) {
                Text(
                    text = "$asal - $tujuan",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(24.dp),
                        painter = painterResource(id = R.drawable.ic_go),
                        contentDescription = "Icon Place"
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                    Text(
                        text = "$jam_berangkat WIB",
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(modifier = Modifier.padding(2.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(24.dp),
                        painter = painterResource(id = R.drawable.ic_finish),
                        contentDescription = "Icon Place"
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                    Text(
                        text = "$jam_sampai WIB",
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(modifier = Modifier.padding(2.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(24.dp),
                        painter = painterResource(id = R.drawable.ic_jarak),
                        contentDescription = "Icon Place"
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                    Text(
                        text = jarak,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = "Status: $status",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}