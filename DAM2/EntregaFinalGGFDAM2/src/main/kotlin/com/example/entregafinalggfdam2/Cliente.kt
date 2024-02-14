package com.example.entregafinalggfdam2
import java.io.DataInputStream


import java.io.DataOutputStream
import java.io.FileInputStream
import java.security.KeyStore
import javax.net.ssl.*

class Cliente {
    fun main() {
        val host = "localhost"
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

        val sslSocketFactory = sslContext.socketFactory
        val cliente = sslSocketFactory.createSocket(host, puerto) as SSLSocket

        val flujoSalida = DataOutputStream(cliente.getOutputStream())

        flujoSalida.writeUTF("usuario1")
        flujoSalida.writeUTF("password1")

        val flujoEntrada = DataInputStream(cliente.getInputStream())

        // Recibo la respuesta del servidor
        val respuesta = flujoEntrada.readUTF()
        println("Respuesta del servidor: $respuesta")

        flujoSalida.close()
        flujoEntrada.close()
        cliente.close()
    }
}

fun main(args: Array<String>) {
    val cliente = Cliente()
    cliente.main()
}
