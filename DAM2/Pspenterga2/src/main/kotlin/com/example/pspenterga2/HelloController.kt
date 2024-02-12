package com.example.pspenterga2

import java.io.File
import java.util.concurrent.atomic.AtomicBoolean

class HelloController {
    private val palabras = listOf(
        "fútbol", "baloncesto", "tenis", "golf", "natación",
        "atletismo", "ciclismo", "boxeo", "béisbol", "hockey",
        "voleibol", "rugby", "cricket", "esquí", "snowboard",
        "surf", "escalada", "karate", "taekwondo", "judo",
        "halterofilia", "gimnasia", "patinaje", "patinaje artístico",
        "triatlón", "maratón", "lucha", "piragüismo", "remo",
        "esgrima", "bádminton", "squash", "raquetbol", "ajedrez",
        "billar", "polo", "equitación", "sincronizada", "buceo",
        "motocross", "automovilismo", "vela", "tiro con arco",
        "pesca deportiva", "paracaidismo", "salto en paracaídas",
        "biatlón", "marcha atlética", "bobsleigh", "softbol"
    )

    private lateinit var palabraCorrecta: String
    private lateinit var palabraOculta: StringBuilder
    private val letrasIncorrectas = mutableListOf<Char>()
    private var intentos = 0
    private var tiempoLimiteExcedido = false

    fun jugar() {
        val continuarJuego = AtomicBoolean(true)

        val juegoThread = Thread {
            while (continuarJuego.get()) {
                iniciarJuego()
                println("¿Quieres jugar nuevamente? (s/n)")
                val respuesta = readLine()?.toLowerCase()?.trim() ?: ""

                if (respuesta != "s") {
                    continuarJuego.set(false)
                    Thread.currentThread().interrupt()
                }
            }
        }

        juegoThread.start()
        juegoThread.join()

        println("Gracias por jugar. ¡Hasta la próxima!")
    }



    fun adivinarPalabra(palabra: String) {
        val juegoThread = Thread {
            iniciarJuegoConPalabra(palabra)
        }

        juegoThread.start()
        juegoThread.join()
    }

    private fun iniciarJuego() {
        tiempoLimiteExcedido = false
        intentos = 0
        palabraCorrecta = palabras.random()
        palabraOculta = StringBuilder("*".repeat(palabraCorrecta.length))

        mostrarMensaje("Bienvenido al juego de adivinanzas. Tienes 30 segundos para adivinar una palabra.")
        revelarDosPrimerasLetras()
        mostrarMensaje("Palabra actual: $palabraOculta")

        val juegoThread = Thread {
            val inicioTiempo = System.currentTimeMillis()

            while (!tiempoLimiteExcedido) {
                intentos++
                mostrarMensaje("Adivina la palabra:")
                val letraUsuario = readLine()?.toLowerCase()?.trim()

                if (letraUsuario != null) {
                    if (letraUsuario.length == 1) {
                        if (!revelarLetra(letraUsuario[0])) {
                            letrasIncorrectas.add(letraUsuario[0])
                            mostrarMensaje("Incorrecto. Letras incorrectas: ${letrasIncorrectas.joinToString(", ")}")
                        }
                    } else if (letraUsuario == palabraCorrecta) {
                        mostrarMensaje("¡Felicidades! Adivinaste la palabra \"$palabraCorrecta\".")
                        break
                    }
                }

                if (!palabraOculta.contains('*')) {
                    mostrarMensaje("¡Felicidades! Adivinaste la palabra \"$palabraCorrecta\".")
                    break
                }

                if (intentos == palabraCorrecta.length) {
                    mostrarMensaje("Lo siento, se agotaron los intentos. La palabra correcta era \"$palabraCorrecta\".")
                    break
                }
            }

            val tiempoTranscurrido = (System.currentTimeMillis() - inicioTiempo) / 1000
            mostrarMensaje("Número de intentos: $intentos")
            mostrarMensaje("Tiempo transcurrido: $tiempoTranscurrido segundos")
            mostrarMensaje("Palabras incorrectas: ${letrasIncorrectas.joinToString(", ")}")
        }

        val temporizadorThread = Thread {
            try {
                Thread.sleep(30000)
            } catch (e: InterruptedException) {
                tiempoLimiteExcedido = true
            } finally {
                tiempoLimiteExcedido = true
            }
        }

        juegoThread.start()
        temporizadorThread.start()

        juegoThread.join()
        temporizadorThread.interrupt()
    }

    private fun iniciarJuegoConPalabra(palabra: String) {
        tiempoLimiteExcedido = false
        intentos = 0
        palabraCorrecta = palabra
        palabraOculta = StringBuilder("*".repeat(palabraCorrecta.length))

        mostrarMensaje("Bienvenido al juego de adivinanzas. Tienes 30 segundos para adivinar una palabra.")
        revelarDosPrimerasLetras()
        mostrarMensaje("Palabra actual: $palabraOculta")

        val juegoThread = Thread {
            val inicioTiempo = System.currentTimeMillis()

            while (!tiempoLimiteExcedido) {
                intentos++
                mostrarMensaje("Adivina la palabra:")
                val letraUsuario = readLine()?.toLowerCase()?.trim()

                if (letraUsuario != null) {
                    if (letraUsuario.length == 1) {
                        if (!revelarLetra(letraUsuario[0])) {
                            letrasIncorrectas.add(letraUsuario[0])
                            mostrarMensaje("Incorrecto. Letras incorrectas: ${letrasIncorrectas.joinToString(", ")}")
                        }
                    } else if (letraUsuario == palabraCorrecta) {
                        mostrarMensaje("¡Felicidades! Adivinaste la palabra \"$palabraCorrecta\".")
                        break
                    }
                }

                if (!palabraOculta.contains('*')) {
                    mostrarMensaje("¡Felicidades! Adivinaste la palabra \"$palabraCorrecta\".")
                    break
                }

                if (intentos == palabraCorrecta.length) {
                    mostrarMensaje("Lo siento, se agotaron los intentos. La palabra correcta era \"$palabraCorrecta\".")
                    break
                }
            }

            val tiempoTranscurrido = (System.currentTimeMillis() - inicioTiempo) / 1000
            mostrarMensaje("Número de intentos: $intentos")
            mostrarMensaje("Tiempo transcurrido: $tiempoTranscurrido segundos")
            mostrarMensaje("Palabras incorrectas: ${letrasIncorrectas.joinToString(", ")}")
        }

        val temporizadorThread = Thread {
            try {
                Thread.sleep(30000)
            } catch (e: InterruptedException) {
                tiempoLimiteExcedido = true
            } finally {
                tiempoLimiteExcedido = true
            }
        }

        juegoThread.start()
        temporizadorThread.start()

        juegoThread.join()
        temporizadorThread.interrupt()
    }

    private fun revelarDosPrimerasLetras() {
        if (palabraCorrecta.length >= 2) {
            palabraOculta[0] = palabraCorrecta[0]
            palabraOculta[1] = palabraCorrecta[1]
        }

        mostrarMensaje("Palabra inicial: $palabraOculta")
    }

    private fun revelarLetra(letra: Char): Boolean {
        var letraRevelada = false
        for (i in palabraCorrecta.indices) {
            if (palabraCorrecta[i] == letra && palabraOculta[i] == '*') {
                palabraOculta[i] = letra
                letraRevelada = true
            }
        }

        mostrarMensaje("Palabra actual: $palabraOculta")
        return letraRevelada
    }

    private fun mostrarMensaje(mensaje: String) {
        println(mensaje)
    }
    fun mostrarJugador() {
        val archivo = File("jugador.txt")
        if (archivo.exists()) {
            val contenido = archivo.readText()
            println("Datos del jugador:\n$contenido")
        } else {
            println("No se encontraron datos del jugador.")
        }
    }
}
