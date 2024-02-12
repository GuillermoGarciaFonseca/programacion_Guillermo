package com.example.pspenterga2


import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket
import java.util.concurrent.atomic.AtomicBoolean

data class AhorcadoResponse(val mensaje: String, val estado: String)

class AhorcadoServer {

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

    fun jugar(socket: MulticastSocket) {
        val continuarJuego = AtomicBoolean(true)

        val juegoThread = Thread {
            while (continuarJuego.get()) {
                iniciarJuego(socket)
                println("¿Quieres jugar nuevamente? (s/n)")
                val respuesta = readLine()?.toLowerCase()?.trim() ?: ""

                if (respuesta != "s") {
                    continuarJuego.set(false)
                }
            }
        }

        juegoThread.start()
        juegoThread.join()

        println("Gracias por jugar. ¡Hasta la próxima!")
    }

    private fun iniciarJuego(socket: MulticastSocket) {
        tiempoLimiteExcedido = false
        intentos = 0
        palabraCorrecta = palabras.random()
        palabraOculta = StringBuilder("*".repeat(palabraCorrecta.length))

        mostrarMensaje("Bienvenido al juego del ahorcado. Tienes 30 segundos para adivinar una palabra.")
        mostrarMensaje("Palabra actual: $palabraOculta")
        revelarDosPrimerasLetras()

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

            // Enviar resultado del juego al cliente
            val resultado = AhorcadoResponse("Juego del ahorcado terminado.", if (!palabraOculta.contains('*')) "Ganaste" else "Perdiste")
            enviarResultado(socket, resultado)
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

    private fun enviarResultado(socket: MulticastSocket, resultado: AhorcadoResponse) {
        try {
            val mensaje = resultado.toString()
            val mensajebyte = mensaje.toByteArray()
            val direccion = InetAddress.getByName("224.0.0.251")
            val enviar = DatagramPacket(mensajebyte, mensajebyte.size, direccion, 1234)
            socket.send(enviar)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun main() {
    val multigrupo = "224.0.0.251"
    val puerto = 1234

    try {
        val direccion = InetAddress.getByName(multigrupo)
        val socketmulti = MulticastSocket(puerto)
        socketmulti.joinGroup(direccion)

        val ahorcadoServer = AhorcadoServer()
        ahorcadoServer.jugar(socketmulti)

        socketmulti.leaveGroup(direccion)
        socketmulti.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
