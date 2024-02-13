package com.example.psp
import java.io.*
import java.security.KeyStore
import javax.net.ssl.*



class Cliente{

    fun conectarAServidor() {
        val host = "192.168.1.100" // Cambia esta dirección IP por la dirección del servidor
        val puerto = 5556
        val keyStorePath = "/Users/Guillermo/OneDrive/Documentos/programacion_Guillermo/DAM2/PSP/AlmacenSrv"
        val keyStorePassword = "1234567"
        val keyPassword = "1234567"

        try {
            // Cargar el almacén de claves
            val keyStore = KeyStore.getInstance("JKS")
            keyStore.load(FileInputStream(keyStorePath), keyStorePassword.toCharArray())

            // Configurar el administrador de claves
            val keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())
            keyManagerFactory.init(keyStore, keyPassword.toCharArray())

            // Configurar el administrador de confianza
            val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
            trustManagerFactory.init(keyStore)

            // Configurar el contexto SSL
            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(keyManagerFactory.keyManagers, trustManagerFactory.trustManagers, null)

            // Crear el socket SSL del cliente
            val sslSocketFactory = sslContext.socketFactory
            val clienteSocket = sslSocketFactory.createSocket(host, puerto) as SSLSocket

            // Creo flujo de salida al servidor
            val flujoSalida = DataOutputStream(clienteSocket.getOutputStream())

            // Envío un saludo al servidor
            flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE")

            // Creo flujo de entrada al servidor
            val flujoEntrada = DataInputStream(clienteSocket.getInputStream())

            // El servidor me envía un mensaje
            println("Recibiendo del SERVIDOR: \n\t${flujoEntrada.readUTF()}")

            // Jugar al ahorcado
            jugarAhorcado(BufferedReader(InputStreamReader(clienteSocket.getInputStream())))

            // Cerrar streams y sockets
            flujoEntrada.close()
            flujoSalida.close()
            clienteSocket.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun jugarAhorcado(entrada: BufferedReader) {
        val MAX_INTENTOS = 7

        val palabraAdivinar = entrada.readLine().split(": ")[1]
        val palabraOculta = CharArray(palabraAdivinar.length) { '_' }

        var intentosRestantes = MAX_INTENTOS
        var juegoFinalizado = false

        println("Palabra a adivinar: ${String(palabraOculta)}")

        val entradaUsuarioConsola = BufferedReader(InputStreamReader(System.`in`))

        while (!juegoFinalizado) {
            println("Intentos restantes: $intentosRestantes")
            println("Ingresa una letra o la palabra completa: ")

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
                            println("¡Ganaste! La palabra era: $palabraAdivinar")
                            juegoFinalizado = true
                        } else {
                            intentosRestantes--
                        }
                    }

                    else -> println("Entrada inválida. Ingresa una letra o la palabra completa.")
                }

                if (intentosRestantes == 0) {
                    println("¡Perdiste! La palabra era: $palabraAdivinar")
                    juegoFinalizado = true
                }

                if (!String(palabraOculta).contains('_')) {
                    println("¡Ganaste! La palabra era: $palabraAdivinar")
                    juegoFinalizado = true
                }
            }
        }
    }
}

fun main() {
    val cliente = Cliente()
    cliente.conectarAServidor()
}
