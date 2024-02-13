package com.example.serviciospsp;
import javax.net.ssl.SSLSocket;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

public class ClienteHandler implements Runnable {
    private static final int MAX_INTENTOS = 7;
    private static final String[] PALABRAS_DEPORTE = {"futbol", "baloncesto", "tenis", "atletismo", "natacion", "ciclismo", "golf", "boxeo", "voleibol", "rugby", "hockey", "badminton", "esgrima", "karate", "surf", "ski", "snowboard", "taekwondo", "escalada", "patinaje", "buceo", "yoga", "pilates", "windsurf", "kitesurf", "paracaidismo", "canotaje", "rafting", "paddle", "parkour", "slackline", "equitacion", "triathlon", "maraton", "crossfit", "kickboxing", "gimnasia", "judo", "baseball", "softball", "waterpolo", "squash", "triatlon", "remo", "handball", "squash", "squash", "squash", "squash"};
    private static final Random random = new Random();

    private SSLSocket clienteSocket;
    private String palabraAdivinar;
    private char[] palabraOculta;
    private int intentosRestantes;
    private boolean juegoFinalizado;

    public ClienteHandler(SSLSocket clienteSocket) {
        this.clienteSocket = clienteSocket;
        this.palabraAdivinar = seleccionarPalabraAleatoria();
        this.palabraOculta = new char[palabraAdivinar.length()];
        Arrays.fill(palabraOculta, '_');
        this.intentosRestantes = MAX_INTENTOS;
        this.juegoFinalizado = false;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

            salida.println("¡Bienvenido al juego de ahorcado de deporte!");
            salida.println("Palabra a adivinar: " + new String(palabraOculta));

            while (!juegoFinalizado) {
                salida.println("Intentos restantes: " + intentosRestantes);
                salida.println("Ingresa una letra o la palabra completa: ");

                String entradaUsuario = entrada.readLine();

                if (entradaUsuario != null) {
                    if (entradaUsuario.length() == 1) {
                        procesarLetra(entradaUsuario.charAt(0), salida);
                    } else if (entradaUsuario.length() == palabraAdivinar.length()) {
                        procesarPalabra(entradaUsuario, salida);
                    } else {
                        salida.println("Entrada inválida. Ingresa una letra o la palabra completa.");
                    }
                }
            }

            entrada.close();
            salida.close();
            clienteSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void procesarLetra(char letra, PrintWriter salida) {
        if (!juegoFinalizado) {
            boolean letraAdivinada = false;
            for (int i = 0; i < palabraAdivinar.length(); i++) {
                if (palabraAdivinar.charAt(i) == letra && palabraOculta[i] == '_') {
                    palabraOculta[i] = letra;
                    letraAdivinada = true;
                }
            }
            if (!letraAdivinada) {
                intentosRestantes--;
            }
            if (intentosRestantes == 0 || Arrays.equals(palabraOculta, palabraAdivinar.toCharArray())) {
                juegoFinalizado = true;
            }
            salida.println("Palabra a adivinar: " + new String(palabraOculta));
            if (juegoFinalizado) {
                if (intentosRestantes == 0) {
                    salida.println("¡Perdiste! La palabra era: " + palabraAdivinar);
                } else {
                    salida.println("¡Ganaste! La palabra era: " + palabraAdivinar);
                }
            }
        }
    }

    private void procesarPalabra(String palabra, PrintWriter salida) {
        if (!juegoFinalizado) {
            if (palabra.equalsIgnoreCase(palabraAdivinar)) {
                juegoFinalizado = true;
                salida.println("¡Ganaste! La palabra era: " + palabraAdivinar);
            } else {
                intentosRestantes--;
                if (intentosRestantes == 0) {
                    juegoFinalizado = true;
                    salida.println("¡Perdiste! La palabra era: " + palabraAdivinar);
                } else {
                    salida.println("Palabra incorrecta. Intentos restantes: " + intentosRestantes);
                }
            }
        }
    }

    private String seleccionarPalabraAleatoria() {
        int indice = random.nextInt(PALABRAS_DEPORTE.length);
        return PALABRAS_DEPORTE[indice];
    }
}
