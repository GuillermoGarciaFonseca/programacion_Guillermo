package com.example.pspentregafinal

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import javax.net.ssl.SSLSocketFactory

object ClienteAhorcado {
    private const val HOST = "localhost"
    private const val PUERTO = 12345
    private const val ALMACEN_SRV = "C:/Users/Guillermo/OneDrive/Documentos/programacion_Guillermo/DAM2/ServiciosPSp/AlmacenSrv"
    private const val CONTRASENA_ALMACEN_SRV = "1234567"

    @JvmStatic
    fun main(args: Array<String>) {
        try {
            System.setProperty("javax.net.ssl.trustStore", ALMACEN_SRV)
            System.setProperty("javax.net.ssl.trustStorePassword", CONTRASENA_ALMACEN_SRV)

            val socketFactory = SSLSocketFactory.getDefault() as SSLSocketFactory
            val clienteSocket = socketFactory.createSocket(HOST, PUERTO)

            val entrada = BufferedReader(InputStreamReader(clienteSocket.inputStream))
            val salida = PrintWriter(clienteSocket.outputStream, true)
            val entradaUsuarioConsola = BufferedReader(InputStreamReader(System.`in`))

            var mensajeServidor: String?
            while (entrada.readLine().also { mensajeServidor = it } != null) {
                println("Servidor: $mensajeServidor")
                when {
                    mensajeServidor?.contains("Ingrese su nombre de usuario:") == true || mensajeServidor?.contains("Ingrese su contraseña:") == true -> {
                        val respuestaUsuario = entradaUsuarioConsola.readLine()
                        salida.println(respuestaUsuario)
                    }
                    mensajeServidor?.contains("¡Bienvenido al juego de ahorcado de deporte!") == true -> jugarAhorcado(entrada, salida, entradaUsuarioConsola)
                }
            }

            clienteSocket.close()
            entrada.close()
            salida.close()
            entradaUsuarioConsola.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Throws(Exception::class)
    private fun jugarAhorcado(entrada: BufferedReader, salida: PrintWriter, entradaUsuarioConsola: BufferedReader) {
        val MAX_INTENTOS = 7

        val palabraAdivinar = entrada.readLine().split(": ")[1]
        val palabraOculta = CharArray(palabraAdivinar.length) { '_' }

        var intentosRestantes = MAX_INTENTOS
        var juegoFinalizado = false

        salida.println("Palabra a adivinar: ${String(palabraOculta)}")

        while (!juegoFinalizado) {
            salida.println("Intentos restantes: $intentosRestantes")
            salida.println("Ingresa una letra o la palabra completa: ")

            val entradaUsuario = entradaUsuarioConsola.readLine()

            if (entradaUsuario != null) {
                when {
                    entradaUsuario.length == 1 -> {
                        var letraAdivinada = false
                        for (i in palabraAdivinar.indices) {
                            if (palabraAdivinar[i] == entradaUsuario[0] && palabraOculta[i] == '_') {
                                palabraOculta[i] = entradaUsuario[0]
                                letraAdivinada = true
                            }
                        }
                        if (!letraAdivinada) {
                            intentosRestantes--
                        }
                    }
                    entradaUsuario.length == palabraAdivinar.length -> {
                        if (entradaUsuario.equals(palabraAdivinar, ignoreCase = true)) {
                            salida.println("¡Ganaste! La palabra era: $palabraAdivinar")
                            juegoFinalizado = true
                        } else {
                            intentosRestantes--
                        }
                    }
                    else -> salida.println("Entrada inválida. Ingresa una letra o la palabra completa.")
                }

                if (intentosRestantes == 0) {
                    salida.println("¡Perdiste! La palabra era: $palabraAdivinar")
                    juegoFinalizado = true
                }

                if (!String(palabraOculta).contains('_')) {
                    salida.println("¡Ganaste! La palabra era: $palabraAdivinar")
                    juegoFinalizado = true
                }
            }
        }
    }
}
