package br.com.lucad.randomquotes.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@Preview
fun App(
    viewModel: QuoteViewModel = viewModel(factory = QuoteViewModel.quoteViewModelFactory),
) {
    val uiState: QuoteUiState by viewModel.uiState.collectAsStateWithLifecycle()
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (uiState) {
                is QuoteUiState.Error -> {
                    Text(text = (uiState as QuoteUiState.Error).error)
                }

                QuoteUiState.Loading -> {
                    IndeterminateCircularIndicator(isLoading = true)
                }

                is QuoteUiState.Success -> {
                    SuccessQuote(uiState)
                }
            }
            Button(
                onClick = { viewModel.getNewQuote() },
                enabled = (uiState !is QuoteUiState.Loading)
            ) {
                Text("Buscar Quote")
            }
        }

    }
}

@Composable
fun SuccessQuote(uiState: QuoteUiState) {
    OutlinedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        border = BorderStroke(1.dp, Color.Black),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier.padding(10.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = (uiState as QuoteUiState.Success).quote, style =
                MaterialTheme.typography.headlineMedium)
            Text(text = uiState.author,
                style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun IndeterminateCircularIndicator(isLoading: Boolean) {
    var loading by remember { mutableStateOf(isLoading) }
    if (!loading) return
    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}