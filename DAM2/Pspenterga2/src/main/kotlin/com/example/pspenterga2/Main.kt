package com.example.pspenterga2

import java.util.concurrent.Executors

fun main() {
    val numberOfThreads = 5 // Número de hilos que deseas crear

    val executorService = Executors.newFixedThreadPool(numberOfThreads)

    for (i in 0 until numberOfThreads) {
        // Crea y ejecuta tareas en paralelo
        executorService.execute(MiTarea())
    }

    // Cierra el ExecutorService cuando ya no lo necesitas
    executorService.shutdown()
}

class MiTarea : Runnable {
    override fun run() {
        // Aquí colocas el código que deseas ejecutar en paralelo en cada hilo
        println("Hola desde un hilo")
    }
}
