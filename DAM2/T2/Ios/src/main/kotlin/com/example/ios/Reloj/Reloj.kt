package com.example.ios.Reloj
import java.text.SimpleDateFormat
import java.util.Date

class Reloj : Thread() {
    override fun run() {
        val formatoHora = SimpleDateFormat("HH:mm:ss")

        while (true) {
            val horaActual = formatoHora.format(Date())
            println("Hora actual: $horaActual")

            // Comprueba si la hora actual coincide con la hora de la alarma
            if (horaActual == "08:00:00") {
                println("¡Alarma!")
                // Agrega aquí la lógica para activar la alarma
            }

            try {
                sleep(1000) // Espera 1 segundo antes de actualizar la hora nuevamente
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}