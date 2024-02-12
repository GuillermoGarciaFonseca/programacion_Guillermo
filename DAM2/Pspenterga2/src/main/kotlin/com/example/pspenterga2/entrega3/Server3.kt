package com.example.pspenterga2.entrega3

import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry

fun main() {
    try {
        val service = FormularioServiceImpl()

        val registry: Registry = LocateRegistry.createRegistry(1234)
        registry.rebind("FormularioService", service)

        println("Servidor RMI iniciado. Esperando conexiones...")
    } catch (e: Exception) {
        println("Error en el servidor: ${e.message}")
        e.printStackTrace()
    }
}