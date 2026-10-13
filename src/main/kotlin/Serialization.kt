package com.logue

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

/**
 * Configura la negociación de contenido utilizando kotlinx.serialization con JSON.
 */
fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}
