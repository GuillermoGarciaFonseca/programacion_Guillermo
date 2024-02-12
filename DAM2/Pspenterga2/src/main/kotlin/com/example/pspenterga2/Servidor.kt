package com.example.pspenterga2

import java.net.DatagramPacket
import java.net.DatagramSocket

fun main() {
    try {
        val datagrama=DatagramSocket(6000)
        val buffer=ByteArray(1024)
        val paquete=DatagramPacket(buffer,buffer.size)
        datagrama.receive(paquete)
        println(String(paquete.data,0,paquete.length))
    }catch (e:Exception){
        e.printStackTrace()
    }
}