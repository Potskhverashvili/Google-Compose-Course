package com.example.unscramble.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unscramble.R
import com.example.unscramble.ui.theme.UnscrambleTheme

@Composable
fun GameScreen() {
    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
            .padding(mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = typography.titleLarge
        )
        GameLayout(
            onUserGussChanged = {},
            currentScrambledWord = "leeatvor",
            userGuess = "elevator",
            onKeyBoardDone = {},
            isGuessWrong = false,
            wordCount = 0,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(mediumPadding)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(mediumPadding),
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.submit),
                    fontSize = 16.sp
                )
            }

            OutlinedButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.skip),
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun GameLayout(
    currentScrambledWord: String,
    wordCount: Int,
    isGuessWrong: Boolean,
    userGuess: String,
    onUserGussChanged: (String) -> Unit,
    onKeyBoardDone: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Text(
            modifier = Modifier
                .clip(shapes.medium)
                .background(colorScheme.surfaceTint)
                .padding(horizontal = 10.dp, vertical = 4.dp)
                .align(alignment = Alignment.End),
            text = stringResource(R.string.word_count, wordCount),
            style = typography.titleMedium,
            color = colorScheme.onPrimary
        )
        Text(
            text = currentScrambledWord,
            style = typography.displayMedium
        )
        Text(
            text = stringResource(R.string.instructions),
            textAlign = TextAlign.Center,
            style = typography.titleMedium
        )
        OutlinedTextField(
            value = userGuess,
            singleLine = true,
            onValueChange = onUserGussChanged,
            label = {
                if (isGuessWrong) {
                    Text(stringResource(R.string.wrong_guess))
                } else {
                    Text(stringResource(R.string.enter_your_word))
                }
            },

            isError = isGuessWrong,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { onKeyBoardDone() }
            )
        )
    }
}

@Composable
fun GameStatus() {

}

@Composable
fun FinalScoreDialog() {

}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    UnscrambleTheme {
        GameScreen()
    }
}