package br.com.lucad.randomquotes.ui

/**
 *
 * 
 *
 * created on 04/10/2026
 * @author Lucas Goncalves
 */
sealed interface QuoteUiState {
    object Loading: QuoteUiState
    data class Success(val quote: String, val author: String): QuoteUiState
    data class Error(val error: String): QuoteUiState
}