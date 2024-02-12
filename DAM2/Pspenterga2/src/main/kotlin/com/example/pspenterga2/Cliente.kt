package com.example.pspenterga2

import java.lang.Exception
import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket

fun main() {
    val multigrupo = "224.0.0.251"
    val puerto = 1234
    val mensaje = "Hola, usuarios de la red!"

    try {

        val direccion = InetAddress.getByName(multigrupo)
        val socketmulti = MulticastSocket(puerto)
        socketmulti.joinGroup(direccion)

        val mensajebyte = mensaje.toByteArray()
        val enviar = DatagramPacket(mensajebyte,mensajebyte.size,direccion,puerto)
        socketmulti.send(enviar)


        while (true){

            val array = ByteArray(256)
            val recibir = DatagramPacket(array,array.size)
            socketmulti.receive(recibir)
            val mensajeC = String(recibir.data,recibir.offset,recibir.length)
            println(mensajeC)
        }


    }catch (e: Exception){
        e.printStackTrace()
    }

}