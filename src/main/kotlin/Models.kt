package com.logue

import kotlinx.serialization.Serializable

/**
 * Representa la entidad completa de un usuario almacenado en el sistema.
 *
 * @property id Identificador único del usuario.
 * @property usuario Nombre de usuario para inicio de sesión.
 * @property password Contraseña en texto plano para autenticación.
 * @property rol Rol asignado al usuario (ej. NINO, TUTOR, ESPECIALISTA, ADMINISTRADOR).
 * @property nombre Nombre completo de la persona.
 */
@Serializable
data class Usuario(
    val id: Int,
    val usuario: String,
    val password: String,
    val rol: String,
    val nombre: String,
)

/**
 * Representa la solicitud recibida en el endpoint de inicio de sesión.
 *
 * @property usuario Nombre de usuario provisto en la petición.
 * @property password Contraseña provista en la petición.
 */
@Serializable
data class LoginRequest(
    val usuario: String,
    val password: String,
)

/**
 * Objeto de transferencia de datos (DTO) para exponer la información del usuario
 * de forma segura sin revelar datos sensibles como la contraseña.
 *
 * @property id Identificador único del usuario.
 * @property nombre Nombre completo del usuario.
 * @property rol Rol del usuario en la plataforma.
 */
@Serializable
data class UsuarioDto(
    val id: Int,
    val nombre: String,
    val rol: String,
)

/**
 * Representa la respuesta enviada tras intentar iniciar sesión.
 *
 * @property exito Indica si la autenticación fue exitosa.
 * @property mensaje Mensaje descriptivo del resultado del proceso.
 * @property usuario Datos del usuario autenticado o null en caso de fallar.
 */
@Serializable
data class LoginResponse(
    val exito: Boolean,
    val mensaje: String,
    val usuario: UsuarioDto? = null,
)
