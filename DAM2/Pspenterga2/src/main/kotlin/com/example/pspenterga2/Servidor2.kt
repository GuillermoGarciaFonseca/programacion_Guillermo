package com.example.pspenterga2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class Server {

    fun startServer() {
        val serverSocket = ServerSocket(12345)

        while (true) {
            val clientSocket = serverSocket.accept()

            val clientHandler = ClientHandler(clientSocket)
            Thread(clientHandler).start()
        }
    }

    inner class ClientHandler(private val clientSocket: Socket) : Runnable {
        override fun run() {
            try {
                val input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
                val output = PrintWriter(clientSocket.getOutputStream(), true)

                val clientMessage = input.readLine()
                println("Received from client: $clientMessage")

                val response = "Response from server"
                output.println(response)
                println("Sent to client: $response")

                clientSocket.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

fun main() {
    val server = Server()
    server.startServer()
}
