package br.com.lucad.randomquotes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform