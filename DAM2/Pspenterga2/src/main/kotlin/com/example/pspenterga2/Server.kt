package com.example.pspenterga2
import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket

class AhorcadoClient {

    fun jugar() {
        val multigrupo = "224.0.0.251"
        val puerto = 1234
        val buffer = ByteArray(256)

        try {
            val direccion = InetAddress.getByName(multigrupo)
            val socketmulti = MulticastSocket(puerto)
            socketmulti.joinGroup(direccion)

            val recibir = DatagramPacket(buffer, buffer.size)

            socketmulti.receive(recibir)
            val mensajeC = String(recibir.data, recibir.offset, recibir.length)
            println(mensajeC)

            // Recibir resultado del juego
            socketmulti.receive(recibir)
            val resultadoString = String(recibir.data, recibir.offset, recibir.length)
            //val resultado = AhorcadoResponse(resultadoString)
            //println("Resultado del juego: ${resultado.mensaje}, Estado: ${resultado.estado}")

            socketmulti.leaveGroup(direccion)
            socketmulti.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun main() {
    val ahorcadoClient = AhorcadoClient()
    ahorcadoClient.jugar()
}
