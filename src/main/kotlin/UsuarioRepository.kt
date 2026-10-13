package com.logue

import kotlinx.serialization.json.Json

/**
 * Repositorio de usuarios que gestiona la lectura de credenciales desde un archivo JSON
 * ubicado en los recursos del servidor.
 */
object UsuarioRepository {

    private val json = Json { ignoreUnknownKeys = true }

    /**
     * Lista de usuarios cargada de forma perezosa (by lazy) desde el archivo /usuarios.json.
     * Si el archivo no existe o no se puede leer, lanza un error descriptivo.
     */
    private val usuarios: List<Usuario> by lazy {
        val inputStream = UsuarioRepository::class.java.getResourceAsStream("/usuarios.json")
            ?: throw IllegalStateException("Error crítico: No se encontró el archivo '/usuarios.json' en los recursos del proyecto.")

        val jsonText = inputStream.bufferedReader().use { it.readText() }
        json.decodeFromString<List<Usuario>>(jsonText)
    }

    /**
     * Valida las credenciales de un usuario.
     *
     * @param usuario Nombre de usuario ingresado.
     * @param password Contraseña ingresada.
     * @return El objeto [Usuario] si coinciden el usuario y la contraseña; de lo contrario, `null`.
     */
    fun validar(usuario: String, password: String): Usuario? {
        return usuarios.find { it.usuario == usuario && it.password == password }
    }
}
