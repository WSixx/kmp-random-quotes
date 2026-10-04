package br.com.lucad.randomquotes.api

import br.com.lucad.randomquotes.model.QuoteModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 *
 * 
 *
 * created on 04/10/2026
 * @author Lucas Goncalves
 */
object QuoteApiClient {

    const val URL = "https://dummyjson.com/quotes/random"

    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun fetchRandomQuote(): QuoteModel {
        return httpClient.get(URL).body<QuoteModel>()
    }

}