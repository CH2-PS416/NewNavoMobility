package com.bangkit.navomobility.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bangkit.navomobility.R

@Composable
fun CircleImage() {
    val painter = painterResource(R.drawable.profile_image)

    Card (
        shape = CircleShape,
        modifier = Modifier
            .padding(8.dp)
            .size(80.dp)
    ){
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}