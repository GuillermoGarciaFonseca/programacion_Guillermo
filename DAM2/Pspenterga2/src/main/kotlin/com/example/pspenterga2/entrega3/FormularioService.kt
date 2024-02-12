package com.example.pspenterga2.entrega3
import java.rmi.Remote
import java.rmi.RemoteException

interface FormularioService : Remote {
    @Throws(RemoteException::class)
    fun enviarFormulario(nombre: String, edad: Int): String
}
