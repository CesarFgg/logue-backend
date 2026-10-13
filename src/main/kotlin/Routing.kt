package com.logue

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * Configura las rutas principales de la aplicación Ktor.
 */
fun Application.configureRouting() {
    routing {
        /**
         * Endpoint raíz para verificar el estado de la API.
         */
        get("/") {
            call.respondText("Logue API")
        }

        /**
         * Endpoint de autenticación de usuarios por nombre de usuario y contraseña.
         */
        post("/login") {
            val loginReq = try {
                call.receive<LoginRequest>()
            } catch (_: Exception) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    LoginResponse(exito = false, mensaje = "Petición inválida")
                )
                return@post
            }

            val usuarioEncontrado = UsuarioRepository.validar(loginReq.usuario, loginReq.password)

            if (usuarioEncontrado != null) {
                val dto = UsuarioDto(
                    id = usuarioEncontrado.id,
                    nombre = usuarioEncontrado.nombre,
                    rol = usuarioEncontrado.rol
                )
                call.respond(
                    HttpStatusCode.OK,
                    LoginResponse(exito = true, mensaje = "Bienvenido", usuario = dto)
                )
            } else {
                call.respond(
                    HttpStatusCode.Unauthorized,
                    LoginResponse(
                        exito = false,
                        mensaje = "Usuario o contraseña incorrectos"
                    )
                )
            }
        }
    }
}
