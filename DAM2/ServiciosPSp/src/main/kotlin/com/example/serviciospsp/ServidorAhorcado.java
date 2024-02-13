package com.example.serviciospsp;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.SSLSocket;
import java.util.Arrays;
import java.util.Random;

public class ServidorAhorcado {
    private static final int PUERTO = 12345;
    private static final String ALMACEN_SRV = "C:/Users/Guillermo/OneDrive/Documentos/programacion_Guillermo/DAM2/ServiciosPSp/AlmacenSrv";
    private static final String CONTRASENA_ALMACEN_SRV = "1234567";
    private static final String[] PALABRAS_DEPORTE = {"futbol", "baloncesto", "tenis", "atletismo", "natacion", "ciclismo", "golf", "boxeo", "voleibol", "rugby", "hockey", "badminton", "esgrima", "karate", "surf", "ski", "snowboard", "taekwondo", "escalada", "patinaje", "buceo", "yoga", "pilates", "windsurf", "kitesurf", "paracaidismo", "canotaje", "rafting", "paddle", "parkour", "slackline", "equitacion", "triathlon", "maraton", "crossfit", "kickboxing", "gimnasia", "judo", "baseball", "softball", "waterpolo", "squash", "triatlon", "remo", "handball"};

    public static void main(String[] args) {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");

            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(new FileInputStream(ALMACEN_SRV), CONTRASENA_ALMACEN_SRV.toCharArray());

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, CONTRASENA_ALMACEN_SRV.toCharArray());

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);

            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

            SSLServerSocketFactory socketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) socketFactory.createServerSocket(PUERTO);
            serverSocket.setNeedClientAuth(true);

            System.out.println("Servidor iniciado. Esperando conexiones...");
            while (true) {
                SSLSocket clienteSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");

                Thread hiloCliente = new Thread(new ClienteHandler(clienteSocket));
                hiloCliente.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ClienteHandler implements Runnable {
        private final SSLSocket clienteSocket;
        private final String palabraAdivinar;
        private char[] palabraOculta;
        private int intentosRestantes;
        private boolean juegoFinalizado;

        public ClienteHandler(SSLSocket clienteSocket) {
            this.clienteSocket = clienteSocket;
            this.palabraAdivinar = PALABRAS_DEPORTE[new Random().nextInt(PALABRAS_DEPORTE.length)];
            this.palabraOculta = new char[palabraAdivinar.length()];
            Arrays.fill(palabraOculta, '_');
            this.intentosRestantes = 7; // Inicializamos con 7 intentos
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
            } catch (Exception e) {
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
    }
}
