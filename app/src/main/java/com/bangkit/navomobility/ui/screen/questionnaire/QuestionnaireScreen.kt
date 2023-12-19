package com.bangkit.navomobility.ui.screen.questionnaire

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bangkit.navomobility.R
import com.bangkit.navomobility.ui.components.ButtonComponent
import com.bangkit.navomobility.ui.components.QuestionnaireCard

@Composable
fun QuestionnaireScreen(
    questionnaireViewModel: QuestionnaireViewModel,
    goToHomeScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        Text(
            text = stringResource(id = R.string.question),
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(32.dp))
        QuestionnaireCard(
            teks = stringResource(id = R.string.taman_hiburan),
            image = R.drawable.tempat_wisata,
            placeSelected = {
                questionnaireViewModel.onEvent(
                    QuestionnaireUIEvent.PlaceEntered(it)
                )
            },
            selected = questionnaireViewModel.uiState.value.placeSelected == stringResource(id = R.string.taman_hiburan)
        )
        Spacer(modifier = Modifier.size(32.dp))
        QuestionnaireCard(
            teks = stringResource(id = R.string.cagar_budaya),
            image = R.drawable.cagar_budaya,
            placeSelected = {
                questionnaireViewModel.onEvent(
                    QuestionnaireUIEvent.PlaceEntered(it)
                )
            },
            selected = questionnaireViewModel.uiState.value.placeSelected == stringResource(id = R.string.cagar_budaya)
        )
        Spacer(modifier = Modifier.size(32.dp))
        QuestionnaireCard(
            teks = stringResource(id = R.string.wisata_bahari),
            image = R.drawable.wisata_bahari,
            placeSelected = {
                questionnaireViewModel.onEvent(
                    QuestionnaireUIEvent.PlaceEntered(it)
                )
            },
            selected = questionnaireViewModel.uiState.value.placeSelected == stringResource(id = R.string.wisata_bahari)
        )
        Spacer(modifier = Modifier.size(32.dp))
        QuestionnaireCard(
            teks = stringResource(id = R.string.cagar_alam),
            image = R.drawable.cagar_alam,
            placeSelected = {
                questionnaireViewModel.onEvent(
                    QuestionnaireUIEvent.PlaceEntered(it)
                )
            },
            selected = questionnaireViewModel.uiState.value.placeSelected == stringResource(id = R.string.cagar_alam)
        )
        Spacer(modifier = Modifier.size(32.dp))
        QuestionnaireCard(
            teks = stringResource(id = R.string.tempat_ibadah),
            image = R.drawable.tempat_ibadah,
            placeSelected = {
                questionnaireViewModel.onEvent(
                    QuestionnaireUIEvent.PlaceEntered(it)
                )
            },
            selected = questionnaireViewModel.uiState.value.placeSelected == stringResource(id = R.string.tempat_ibadah)
        )
        Spacer(modifier = Modifier.weight(1f))
        ButtonComponent(
            value = stringResource(id = R.string.question_button),
            onButtonClicked = {
                questionnaireViewModel.onEvent(QuestionnaireUIEvent.QuestionButtonClicked)
            },
            goToScreen = goToHomeScreen,
            isEnabled = questionnaireViewModel.allValidationPassed.value
        )
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun QuestionnaireScreenPreview() {
    QuestionnaireScreen(
        questionnaireViewModel = QuestionnaireViewModel(),
        goToHomeScreen = {}
    )
}