package com.logue

/**
 * Punto de entrada principal para la aplicación backend de Logue utilizando el motor Netty.
 *
 * @param args Argumentos pasados por la línea de comandos.
 */
fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}
