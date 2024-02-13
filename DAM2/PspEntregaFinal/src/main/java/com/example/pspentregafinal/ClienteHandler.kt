package com.example.pspentregafinal

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.io.IOException
import java.util.*
import javax.net.ssl.SSLSocket

class ClienteHandler(private val clienteSocket: SSLSocket) : Runnable {
    private val MAX_INTENTOS = 7
    private val PALABRAS_DEPORTE = arrayOf(
        "futbol", "baloncesto", "tenis", "atletismo", "natacion", "ciclismo", "golf", "boxeo", "voleibol", "rugby",
        "hockey", "badminton", "esgrima", "karate", "surf", "ski", "snowboard", "taekwondo", "escalada", "patinaje",
        "buceo", "yoga", "pilates", "windsurf", "kitesurf", "paracaidismo", "canotaje", "rafting", "paddle", "parkour",
        "slackline", "equitacion", "triathlon", "maraton", "crossfit", "kickboxing", "gimnasia", "judo", "baseball",
        "softball", "waterpolo", "squash", "triatlon", "remo", "handball"
    )
    private val random = Random()

    private var palabraAdivinar: String
    private var palabraOculta: CharArray
    private var intentosRestantes: Int
    private var juegoFinalizado: Boolean

    init {
        palabraAdivinar = seleccionarPalabraAleatoria()
        palabraOculta = CharArray(palabraAdivinar.length) { '_' }
        intentosRestantes = MAX_INTENTOS
        juegoFinalizado = false
    }

    override fun run() {
        try {
            val entrada = BufferedReader(InputStreamReader(clienteSocket.getInputStream()))
            val salida = PrintWriter(clienteSocket.getOutputStream(), true)

            salida.println("¡Bienvenido al juego de ahorcado de deporte!")
            salida.println("Palabra a adivinar: ${String(palabraOculta)}")

            while (!juegoFinalizado) {
                salida.println("Intentos restantes: $intentosRestantes")
                salida.println("Ingresa una letra o la palabra completa: ")

                val entradaUsuario = entrada.readLine()

                if (entradaUsuario != null) {
                    when {
                        entradaUsuario.length == 1 -> procesarLetra(entradaUsuario[0], salida)
                        entradaUsuario.length == palabraAdivinar.length -> procesarPalabra(entradaUsuario, salida)
                        else -> salida.println("Entrada inválida. Ingresa una letra o la palabra completa.")
                    }
                }
            }

            entrada.close()
            salida.close()
            clienteSocket.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun procesarLetra(letra: Char, salida: PrintWriter) {
        if (!juegoFinalizado) {
            var letraAdivinada = false
            for (i in palabraAdivinar.indices) {
                if (palabraAdivinar[i] == letra && palabraOculta[i] == '_') {
                    palabraOculta[i] = letra
                    letraAdivinada = true
                }
            }
            if (!letraAdivinada) {
                intentosRestantes--
            }
            if (intentosRestantes == 0 || palabraOculta.contentEquals(palabraAdivinar.toCharArray())) {
                juegoFinalizado = true
            }
            salida.println("Palabra a adivinar: ${String(palabraOculta)}")
            if (juegoFinalizado) {
                if (intentosRestantes == 0) {
                    salida.println("¡Perdiste! La palabra era: $palabraAdivinar")
                } else {
                    salida.println("¡Ganaste! La palabra era: $palabraAdivinar")
                }
            }
        }
    }

    private fun procesarPalabra(palabra: String, salida: PrintWriter) {
        if (!juegoFinalizado) {
            if (palabra.equals(palabraAdivinar, ignoreCase = true)) {
                juegoFinalizado = true
                salida.println("¡Ganaste! La palabra era: $palabraAdivinar")
            } else {
                intentosRestantes--
                if (intentosRestantes == 0) {
                    juegoFinalizado = true
                    salida.println("¡Perdiste! La palabra era: $palabraAdivinar")
                } else {
                    salida.println("Palabra incorrecta. Intentos restantes: $intentosRestantes")
                }
            }
        }
    }

    private fun seleccionarPalabraAleatoria(): String {
        val indice = random.nextInt(PALABRAS_DEPORTE.size)
        return PALABRAS_DEPORTE[indice]
    }
}
