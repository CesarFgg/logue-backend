package com.logue

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.*

/**
 * Pruebas unitarias para verificar los endpoints del servidor Ktor.
 */
class ServerTest {

    @Test
    fun `test root endpoint`() = testApplication {
        application {
            configureSerialization()
            configureHttp()
            configureRouting()
        }
        val response = client.get("/")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Logue API", response.bodyAsText())
    }
}
