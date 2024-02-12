package com.example.pspentrega

import java.io.IOException
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.net.HttpURLConnection
import java.net.URL

fun main(): Unit = runBlocking {
    val numClients = 5 // Número de clientes simulados
    val pokemonName = "pikachu" // Nombre del Pokémon que queremos consultar

    val jobs = List(numClients) {
        GlobalScope.async {
            val clientName = "Cliente $it"
            val pokemonInfo = fetchPokemonInfo(pokemonName, clientName)
            println("$clientName: $pokemonInfo")
        }
    }

    jobs.forEach { it.await() }
}

suspend fun fetchPokemonInfo(pokemonName: String, clientName: String): String {
    val apiUrl = "https://pokeapi.co/api/v2/pokemon/$pokemonName/"

    val connection = URL(apiUrl).openConnection() as HttpURLConnection
    val responseCode = connection.responseCode

    return if (responseCode == 200) {
        val pokemonData = connection.inputStream.reader().readText()
        "$clientName recibió datos del Pokémon $pokemonName: $pokemonData"
    } else {
        "$clientName: Error al conectarse a la API. Código de respuesta: $responseCode"
    }
}
