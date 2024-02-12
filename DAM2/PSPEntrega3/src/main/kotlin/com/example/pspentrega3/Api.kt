package com.example.pspentrega3

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/saludo") {
                call.respondText("¡Hola! Este es un mensaje desde tu API en Kotlin.")
            }
        }
    }
    server.start(wait = true)
}