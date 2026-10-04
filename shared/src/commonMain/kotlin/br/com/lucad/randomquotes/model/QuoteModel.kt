package br.com.lucad.randomquotes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * 
 *
 * created on 04/10/2026
 * @author Lucas Goncalves
 */
@Serializable
data class QuoteModel(
    @SerialName("quote")
    val quote: String,
    @SerialName("author")
    val author: String
)
