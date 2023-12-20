package com.bangkit.navomobility.ui.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.Flag
import androidx.compose.material.icons.rounded.LocationCity
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material.icons.rounded.PhotoCamera
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bangkit.navomobility.R
import com.bangkit.navomobility.ui.components.addedcomponent.Menu
import com.bangkit.navomobility.ui.theme.NavoMobilityTheme


/**
 * TODO change name
 */
@Composable
fun ProfileTemp(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = null,
            modifier = Modifier
                .shadow(elevation = 12.dp)
                .size(100.dp)
                .clip(MaterialTheme.shapes.medium)
        )

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "Vincent Guillebaud",
            style = MaterialTheme.typography.h6
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(text = "UI/UX Designer", style = MaterialTheme.typography.body2)
    }
}

@Composable
fun ProfileCardInfo(icon: ImageVector, color: Color, text1: String, text2: String) {
    ConstraintLayout {
        val (iconRef, text1Ref, text2Ref) = createRefs()
        val barrier = createEndBarrier(iconRef, margin = 10.dp)

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(38.dp)
                .clip(MaterialTheme.shapes.small)
                .background(color = color.copy(alpha = 0.2f))
                .constrainAs(iconRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        ) {
            Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(18.dp))
        }

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = text1,
                style = MaterialTheme.typography.body2,
                fontSize = 12.sp,
                modifier = Modifier.constrainAs(text1Ref) {
                    top.linkTo(iconRef.top)
                    start.linkTo(barrier)
                }
            )
        }

        Text(
            text = text2,
            style = MaterialTheme.typography.button,
            modifier = Modifier.constrainAs(text2Ref) {
                // baseline.linkTo(iconRef.bo)
                bottom.linkTo(iconRef.bottom, margin = (-4).dp)
                start.linkTo(barrier)
            }
        )
    }
}

@Composable
fun ProfileCard() {
    Card(
        elevation = 8.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 30.dp)
        ) {
            ProfileCardInfo(
                icon = Icons.Rounded.LocationCity,
                color = Color.Blue,
                text1 = "City",
                text2 = "32+"
            )

            ProfileCardInfo(
                icon = Icons.Rounded.Flag,
                color = Color.Blue,
                text1 = "Country",
                text2 = "22+"
            )

            ProfileCardInfo(
                icon = Icons.Rounded.Place,
                color = Color.Blue,
                text1 = "Km",
                text2 = "8.5k"
            )
        }
    }
}

@Composable
fun ProfileButton(
    text: String,
    icon: ImageVector,
    color: Color
) {
    Button(
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.medium,
        contentPadding = PaddingValues(all = 14.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(color = color.copy(alpha = 0.2f))
            ) {
                Icon(icon, contentDescription = null, tint = color)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = text,
                style = MaterialTheme.typography.button,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Rounded.ArrowForwardIos,
                contentDescription = null,
                // modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun Profile(
    navBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(all = 24.dp)
            .verticalScroll(state = scrollState)
    ) {
        Menu(pressBack = navBack)

        ProfileTemp(modifier = Modifier.padding(vertical = 44.dp))

        ProfileCard()

        Spacer(modifier = Modifier.height(32.dp))

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            ProfileButton(text = "Visited Country", icon = Icons.Rounded.Flag, color = Color.Blue)
            ProfileButton(
                text = "Visited City",
                icon = Icons.Rounded.LocationCity,
                color = Color.Blue
            )
            ProfileButton(
                text = "Photo Gallery",
                icon = Icons.Rounded.PhotoCamera,
                color = Color.Blue
            )
            ProfileButton(text = "Trips Map", icon = Icons.Rounded.Map, color = Color.Blue)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardInfoPreview() {
    NavoMobilityTheme {
        ProfileCardInfo(
            icon = Icons.Rounded.Flag,
            color = Color.Blue,
            text1 = "Country",
            text2 = "22+"
        )
    }
}

@Preview
@Composable
fun ProfileCardPreview() {
    NavoMobilityTheme {
        ProfileCard()
    }
}

@Preview
@Composable
fun ProfileButtonPreview() {
    NavoMobilityTheme {
        ProfileButton(text = "Visited Country", icon = Icons.Rounded.Flag, color = Color.Blue)
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProfileScreenPreview() {
    NavoMobilityTheme {
        Surface(color = MaterialTheme.colors.background) {
            Profile(navBack = {})
        }
    }
}