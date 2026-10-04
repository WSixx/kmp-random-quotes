package br.com.lucad.randomquotes.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import br.com.lucad.randomquotes.api.QuoteApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 *
 * 
 *
 * created on 04/10/2026
 * @author Lucas Goncalves
 */
class QuoteViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<QuoteUiState>(QuoteUiState.Loading)
    val uiState: StateFlow<QuoteUiState> = _uiState

    init {
        getNewQuote()
    }

    fun getNewQuote() {
        viewModelScope.launch {
            try {
                val (quote, author) = QuoteApiClient.fetchRandomQuote()
                if (quote.isBlank() || author.isBlank()) throw Exception("Quote or author is empty")
                _uiState.value = QuoteUiState.Success(quote, author)
            } catch (ex: Exception) {
                _uiState.value = QuoteUiState.Error(ex.message ?: "Unknown error")
            }
        }
    }

    companion object {
        val quoteViewModelFactory = viewModelFactory {
            initializer { QuoteViewModel() }
        }
    }
}
