package com.example.pspentrega
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class GYM(private val cantidadMaquinas: Int) {
    private val executor = Executors.newFixedThreadPool(cantidadMaquinas)

    fun reservarMaquina(nombreCliente: String, numeroMaquina: Int) {
        executor.submit {
            println("$nombreCliente ha reservado la máquina $numeroMaquina")
            usarMaquina(nombreCliente, numeroMaquina)
        }
    }

    private fun usarMaquina(nombreCliente: String, numeroMaquina: Int) {
        println("$nombreCliente está usando la máquina $numeroMaquina")
        Thread.sleep(3000) // Simulamos el tiempo que se tarda en usar la máquina
        println("$nombreCliente ha terminado de usar la máquina $numeroMaquina")
    }

    fun cerrarGimnasio() {
        executor.shutdown()
        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow()
            }
        } catch (e: InterruptedException) {
            executor.shutdownNow()
        }
    }
}

fun main() {
    val gimnasio = GYM(5)

    gimnasio.reservarMaquina("Raul", 1)
    gimnasio.reservarMaquina("Manolo", 2)
    gimnasio.reservarMaquina("Juan", 3)
    gimnasio.reservarMaquina("Jose", 4)
    gimnasio.reservarMaquina("Óscar", 5)
    Thread.sleep(10000)
    gimnasio.cerrarGimnasio()
}