package com.bangkit.navomobility.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun QuestionnaireCard(
    teks: String,
    image: Int,
    selected: Boolean,
    placeSelected: (placeName: String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(60.dp),
    ) {
        Box (
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = if (selected) MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                )
                .clickable {
                    placeSelected(teks)
                },
                contentAlignment = Alignment.CenterStart
            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(60.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(24.dp),
                    painter = painterResource(id = image),
                    contentDescription = "Icon Place"
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = teks,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}
