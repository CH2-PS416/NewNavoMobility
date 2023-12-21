package com.bangkit.navomobility.ui.screen.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bangkit.navomobility.R
import com.bangkit.navomobility.ui.components.CircleImage
import com.bangkit.navomobility.ui.components.ThemeSwitcher
import com.bangkit.navomobility.ui.navigation.NavoMobilityAppRouter
import com.bangkit.navomobility.ui.navigation.Screen
import com.bangkit.navomobility.ui.screen.register.RegisterViewModel

@Composable
fun ProfileScreen(
    registerViewModel: RegisterViewModel,
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(80.dp),
            ) {
                Box (
                ){
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .heightIn(60.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        CircleImage()
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(
                            text = stringResource(id = R.string.user_name),
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            textAlign = TextAlign.Left,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_edit),
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                NavoMobilityAppRouter.navigateTo(Screen.EditProfileScreen)
                            }
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(80.dp)
                    .border(
                        BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(16.dp)
                    )
            ){
                Surface(
                    color = Color.White
                ){
                    Column (
                        modifier = Modifier
                            .padding(8.dp)
                    ){
                        Row (
                            modifier = Modifier
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.ic_theme),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                            Column {
                                Text(
                                    text = stringResource(id = R.string.theme),
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    textAlign = TextAlign.Left,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    text = stringResource(id = R.string.theme_detail),
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    textAlign = TextAlign.Left,
                                    style = MaterialTheme.typography.bodySmall
                                )

                            }
                            Spacer(modifier = Modifier.weight(1f))
                            ThemeSwitcher (
                                darkTheme = darkTheme,
                                size = 24.dp,
                                padding = 5.dp,
                                onClick = onThemeUpdated
                            )
                        }
                        Spacer(modifier = Modifier.padding(4.dp))
                        Row (
                            modifier = Modifier
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.ic_logout),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                            Column {
                                Text(
                                    text = stringResource(id = R.string.logout),
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    textAlign = TextAlign.Left,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    text = stringResource(id = R.string.logout_detail),
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    textAlign = TextAlign.Left,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                painter = painterResource(id = R.drawable.ic_forward),
                                contentDescription = null,
                                modifier = Modifier.clickable {
                                    registerViewModel.logout()
                                }
                            )
                        }
                    }
                }
            }
        }

    }
}