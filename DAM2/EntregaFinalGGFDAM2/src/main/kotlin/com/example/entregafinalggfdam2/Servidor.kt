package com.example.entregafinalggfdam2

import java.io.*
import java.security.KeyStore
import javax.net.ssl.*

class Servidor {

    private val usuario = "usuario1"
    private val contrasena = "password1"
    fun main() {
        val puerto = 5556
        val keyStorePath = "C:/Users/Guillermo/OneDrive/Documentos/programacion_Guillermo/DAM2/EntregaFinalGGFDAM2/AlmacenSrv"
        val keyStorePassword = "1234567"
        val keyPassword = "1234567"

        val keyStore = KeyStore.getInstance("JKS")
        keyStore.load(FileInputStream(keyStorePath), keyStorePassword.toCharArray())

        val keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())
        keyManagerFactory.init(keyStore, keyPassword.toCharArray())

        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(keyStore)

        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(keyManagerFactory.keyManagers, trustManagerFactory.trustManagers, null)

        val sslServerSocketFactory = sslContext.serverSocketFactory
        val servidorSSL = sslServerSocketFactory.createServerSocket(puerto) as SSLServerSocket

        var clienteConectado: SSLSocket? = null
        var flujoEntrada: DataInputStream? = null
        var flujoSalida: DataOutputStream? = null
        for (i in 1..2) {
            println("Esperando al cliente $i")
            val clienteConectado = servidorSSL.accept() as SSLSocket
            val flujoEntrada = DataInputStream(clienteConectado.getInputStream())

            val usuarioCliente = flujoEntrada.readUTF()
            val contraseñaCliente = flujoEntrada.readUTF()

            val respuesta = if (validarCredenciales(usuarioCliente, contraseñaCliente)) {
                // Obtener y enviar nombres aleatorios agrupados
                val nombresAgrupados = obtenerNombresAgrupados()
                almacenarNombresEnArchivo(nombresAgrupados)
                nombresAgrupados
            } else {
                "Error: Credenciales incorrectas."
            }

            val flujoSalida = DataOutputStream(clienteConectado.getOutputStream())
            flujoSalida.writeUTF(respuesta)

            flujoSalida.close()
            flujoEntrada.close()
            clienteConectado.close()
        }

        servidorSSL.close()
    }

    private fun validarCredenciales(usuarioCliente: String, contraseñaCliente: String): Boolean {
        return usuarioCliente == usuario && contraseñaCliente == contrasena
    }

    private fun obtenerNombresAgrupados(): String {
        val nombresAgrupados = mutableListOf<List<String>>()
        try {
            val archivo = File("C:/Users/Guillermo/OneDrive/Documentos/programacion_Guillermo/DAM2/EntregaFinalGGFDAM2/src/main/kotlin/com/example/entregafinalggfdam2/listagym.txt")
            val nombresArchivo = archivo.readLines().shuffled().toMutableList()
            while (nombresArchivo.isNotEmpty()) {
                val grupo = nombresArchivo.take(5)
                nombresAgrupados.add(grupo)
                nombresArchivo -= grupo
            }
        } catch (e: IOException) {
            println("Error al leer el archivo: ${e.message}")
        }
        return nombresAgrupados.joinToString("\n") { grupo ->
            grupo.joinToString(", ")
        }
    }

    private fun almacenarNombresEnArchivo(nombres: String) {
        try {
            val archivo =
                File("C:/Users/Guillermo/OneDrive/Documentos/programacion_Guillermo/DAM2/EntregaFinalGGFDAM2/src/main/kotlin/com/example/entregafinalggfdam2/grupos.txt")
            archivo.appendText("$nombres\n\n")
            println("Grupos almacenados en 'grupos.txt'")
        } catch (e: IOException) {
            println("Error al escribir en el archivo: ${e.message}")
        }
    }
}

fun main(args: Array<String>) {
    val servidor = Servidor()
    servidor.main()
}