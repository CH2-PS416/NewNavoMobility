package com.bangkit.navomobility.ui.screen.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bangkit.navomobility.R
import com.bangkit.navomobility.ui.components.ButtonComponent
import com.bangkit.navomobility.ui.components.ClickableTextComponent
import com.bangkit.navomobility.ui.components.EmailTextFieldComponent
import com.bangkit.navomobility.ui.components.PasswordTextFieldComponent
import com.bangkit.navomobility.ui.components.SocialMediaLogin
import com.bangkit.navomobility.ui.components.TextFieldComponent
import com.bangkit.navomobility.ui.navigation.NavoMobilityAppRouter
import com.bangkit.navomobility.ui.navigation.Screen
import com.bangkit.navomobility.ui.theme.NavoMobilityTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    registerViewModel: RegisterViewModel
) {
    var enteredEmail by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    NavoMobilityTheme {
        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Surface(
                modifier = modifier
                    .fillMaxSize()
                    .padding(28.dp),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    TopAppBar(
                        title = { },
                        navigationIcon = {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = stringResource(R.string.back),
                                modifier = Modifier.clickable { onBackClick() }
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    val logo: Painter = painterResource(id = R.drawable.register)
                    Image(
                        painter = logo,
                        contentDescription = null,
                        modifier = modifier
                            .size(248.dp, 165.dp)
                            .padding(16.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = stringResource(id = R.string.register),
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                        modifier = modifier
                            .fillMaxWidth()
                            .heightIn(min = 50.dp),
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center
                    )
                    TextFieldComponent(
                        labelValue = stringResource(id = R.string.name),
                        painterResource(id = R.drawable.ic_person),
                        onTextSelected = {
                            registerViewModel.onEvent(RegisterUIEvent.NameChanged(it))
                        },
                        errorStatus = registerViewModel.registrationUIState.value.nameError
                    )
                    EmailTextFieldComponent(
                        onValueChanged = {
                            enteredEmail = it
                            errorMessage = null
                        },
                        onInvalidFormat = {
                            errorMessage = "Email harus berakhir dengan @gmail.com"
                        },
                        onTextSelected = {
                            registerViewModel.onEvent(RegisterUIEvent.EmailChanged(it))
                        },
                        errorStatus = registerViewModel.registrationUIState.value.emailError
                    )
                    errorMessage?.let { message ->
                        Text(
                            text = message,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    PasswordTextFieldComponent(
                        labelValue = stringResource(id = R.string.password),
                        painterResource(id = R.drawable.ic_password),
                        onTextSelected = {
                            registerViewModel.onEvent(RegisterUIEvent.PasswordChanged(it))
                        },
                        errorStatus = registerViewModel.registrationUIState.value.passwordError
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ClickableTextComponent(
                        initialText = stringResource(R.string.initial_text_2),
                        linkText = stringResource(R.string.link_text_2),
                        onClick = {
                            NavoMobilityAppRouter.navigateTo(Screen.LoginScreen)
                        }
                    )
                    Spacer(modifier = modifier.height(34.dp))
                    ButtonComponent(
                        value = stringResource(id = R.string.register_button),
                        onButtonClicked = {
                            registerViewModel.onEvent(RegisterUIEvent.RegisterButtonClicked)
                        },
                        isEnabled = registerViewModel.allValidationPassed.value
                    )
                    Spacer(modifier = modifier.height(16.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "or SignUp with",
                            style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.outlineVariant)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            SocialMediaLogin(
                                icon = R.drawable.google,
                                text = "Google",
                                modifier = Modifier.weight(1f)) {

                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            SocialMediaLogin(
                                icon = R.drawable.facebook,
                                text = "Facebook",
                                modifier = Modifier.weight(1f)) {

                            }
                        }
                    }
                }
            }
            if (registerViewModel.registerInProgress.value) {
                CircularProgressIndicator()
            }
        }
    }
}