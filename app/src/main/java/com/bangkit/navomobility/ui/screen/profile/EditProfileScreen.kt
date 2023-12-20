package com.bangkit.navomobility.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bangkit.navomobility.R
import com.bangkit.navomobility.ui.components.CircleImage
import com.bangkit.navomobility.ui.components.ProfileCard

@Composable
fun EditProfileScreen(
    onBackClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                contentAlignment = Alignment.CenterStart // Tengahkan ikon secara horizontal
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { onBackClick() }
                )
            }
            Spacer(modifier = Modifier.padding(16.dp))
            CircleImage()
            Spacer(modifier = Modifier.padding(16.dp))
            ProfileCard(
                teks = stringResource(R.string.user_name),
                image = R.drawable.ic_person
            )
            Spacer(modifier = Modifier.padding(8.dp))
            ProfileCard(
                teks = stringResource(R.string.user_email),
                image = R.drawable.ic_email
            )
            Spacer(modifier = Modifier.padding(8.dp))
            ProfileCard(
                teks = stringResource(R.string.user_phone),
                image = R.drawable.ic_phone
            )
            Spacer(modifier = Modifier.padding(8.dp))
            ProfileCard(
                teks = stringResource(R.string.user_password),
                image = R.drawable.ic_password
            )
        }
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun EditProfileScreenPreview(){
    EditProfileScreen(
        onBackClick = {}
    )
}