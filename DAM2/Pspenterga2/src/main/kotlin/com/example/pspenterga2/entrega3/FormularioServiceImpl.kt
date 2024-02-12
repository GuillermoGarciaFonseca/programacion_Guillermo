package com.example.pspenterga2.entrega3
import java.rmi.RemoteException
import java.rmi.server.UnicastRemoteObject

class FormularioServiceImpl : UnicastRemoteObject(), FormularioService {
    @Throws(RemoteException::class)
    override fun enviarFormulario(nombre: String, edad: Int): String {
        return "¡Formulario recibido! Nombre: $nombre, Edad: $edad"
    }
}