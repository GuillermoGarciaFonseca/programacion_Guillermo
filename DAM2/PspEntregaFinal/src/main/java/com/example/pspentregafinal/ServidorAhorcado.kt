package com.example.pspentregafinal
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.security.KeyStore
import java.util.*
import javax.net.ssl.*

class ServidorAhorcado {
    companion object {
        private const val PUERTO = 12345
        private const val ALMACEN_SRV = "C:/Users/Guillermo/OneDrive/Documentos/programacion_Guillermo/DAM2/ServiciosPSp/AlmacenSrv"
        private const val CONTRASENA_ALMACEN_SRV = "1234567"
        private val PALABRAS_DEPORTE = arrayOf(
            "futbol", "baloncesto", "tenis", "atletismo", "natacion", "ciclismo", "golf", "boxeo", "voleibol", "rugby",
            "hockey", "badminton", "esgrima", "karate", "surf", "ski", "snowboard", "taekwondo", "escalada", "patinaje",
            "buceo", "yoga", "pilates", "windsurf", "kitesurf", "paracaidismo", "canotaje", "rafting", "paddle", "parkour",
            "slackline", "equitacion", "triathlon", "maraton", "crossfit", "kickboxing", "gimnasia", "judo", "baseball",
            "softball", "waterpolo", "squash", "triatlon", "remo", "handball"
        )

        @JvmStatic
        fun main(args: Array<String>) {
            try {
                val sslContext = SSLContext.getInstance("TLS")

                val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
                keyStore.load(FileInputStream(ALMACEN_SRV), CONTRASENA_ALMACEN_SRV.toCharArray())

                val kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())
                kmf.init(keyStore, CONTRASENA_ALMACEN_SRV.toCharArray())

                val tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
                tmf.init(keyStore)

                sslContext.init(kmf.keyManagers, tmf.trustManagers, null)

                val socketFactory = sslContext.serverSocketFactory
                val serverSocket = socketFactory.createServerSocket(PUERTO) as SSLServerSocket
                serverSocket.needClientAuth = true

                println("Servidor iniciado. Esperando conexiones...")
                while (true) {
                    val clienteSocket = serverSocket.accept() as SSLSocket
                    println("Nuevo cliente conectado.")

                    val hiloCliente = Thread(ClienteHandler(clienteSocket))
                    hiloCliente.start()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private class ClienteHandler(private val clienteSocket: SSLSocket) : Runnable {
        private val palabraAdivinar: String = PALABRAS_DEPORTE[Random().nextInt(PALABRAS_DEPORTE.size)]
        private var palabraOculta: CharArray = CharArray(palabraAdivinar.length) { '_' }
        private var intentosRestantes: Int = 7
        private var juegoFinalizado: Boolean = false

        override fun run() {
            try {
                val entrada = BufferedReader(InputStreamReader(clienteSocket.inputStream))
                val salida = PrintWriter(clienteSocket.outputStream, true)

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
            } catch (e: Exception) {
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
    }
}
