package com.example.serviciospsp;
import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ServidorAhorcado {
    private static final int PUERTO = 12345;
    private static final String ALMACEN_SRV = "AlmacenSrv";
    private static final String CONTRASENA_ALMACEN_SRV = "1234567";
    private static final String[] PALABRAS_DEPORTE = {"futbol", "baloncesto", "tenis", "atletismo", "natacion", "ciclismo", "golf", "boxeo", "voleibol", "rugby", "hockey", "badminton", "esgrima", "karate", "surf", "ski", "snowboard", "taekwondo", "escalada", "patinaje", "buceo", "yoga", "pilates", "windsurf", "kitesurf", "paracaidismo", "canotaje", "rafting", "paddle", "parkour", "slackline", "equitacion", "triathlon", "maraton", "crossfit", "kickboxing", "gimnasia", "judo", "baseball", "softball", "waterpolo", "squash", "triatlon", "remo", "handball", "squash", "squash", "squash", "squash"};
    private static final Map<String, String> usuariosRegistrados = new HashMap<>();

    public static void main(String[] args) {
        try {
            File archivo = new File(ALMACEN_SRV);
            if (!archivo.exists()) {
                String[] cmd = {"keytool", "-genkey", "-alias", "servidor", "-keyalg", "RSA", "-keystore", ALMACEN_SRV, "-storepass", CONTRASENA_ALMACEN_SRV};
                Process proceso = Runtime.getRuntime().exec(cmd);
                proceso.waitFor();
            }

            registrarUsuario("usuario1", "password1");
            registrarUsuario("usuario2", "password2");

            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(new FileInputStream(ALMACEN_SRV), CONTRASENA_ALMACEN_SRV.toCharArray());

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, CONTRASENA_ALMACEN_SRV.toCharArray());

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new SecureRandom());

            SSLServerSocketFactory socketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) socketFactory.createServerSocket(PUERTO);
            serverSocket.setNeedClientAuth(true);

            System.out.println("Servidor iniciado. Esperando conexiones...");
            while (true) {
                SSLSocket clienteSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");

                Thread hiloCliente = new Thread(() -> {
                    try {
                        BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                        PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

                        salida.println("¡Bienvenido al juego de ahorcado de deporte!");
                        salida.println("Ingrese su nombre de usuario:");
                        String nombreUsuario = entrada.readLine();

                        salida.println("Ingrese su contraseña:");
                        String contrasena = entrada.readLine();

                        if (autenticarUsuario(nombreUsuario, contrasena)) {
                            salida.println("¡Bienvenido al juego de ahorcado de deporte!");

                            String palabraAdivinar = PALABRAS_DEPORTE[(int) (Math.random() * PALABRAS_DEPORTE.length)];
                            String datosTenis = obtenerDatosTenis();
                            salida.println("Datos de tenis:");
                            salida.println(datosTenis);

                            String datosBaloncesto = obtenerDatosBaloncesto();
                            salida.println("Datos de baloncesto:");
                            salida.println(datosBaloncesto);

                            jugarAhorcado(clienteSocket, palabraAdivinar);
                        } else {
                            salida.println("Usuario o contraseña incorrectos. Desconectando...");
                            clienteSocket.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                hiloCliente.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void registrarUsuario(String nombreUsuario, String contrasena) {
        usuariosRegistrados.put(nombreUsuario, contrasena);
    }

    private static boolean autenticarUsuario(String nombreUsuario, String contrasena) {
        if (usuariosRegistrados.containsKey(nombreUsuario)) {
            return usuariosRegistrados.get(nombreUsuario).equals(contrasena);
        }
        return false;
    }

    private static String obtenerDatosTenis() throws IOException {
        String apiUrl = "https://api.sportsdata.io/v3/tennis/scores/json";

        return hacerSolicitudAPI(apiUrl);
    }

    private static String obtenerDatosBaloncesto() throws IOException {
        String apiUrl = "https://api.sportsdata.io/v3/nba/scores/json";
        return hacerSolicitudAPI(apiUrl);
    }

    private static String hacerSolicitudAPI(String apiUrl) throws IOException {
        StringBuilder respuestaAPI = new StringBuilder();

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String linea;
        while ((linea = reader.readLine()) != null) {
            respuestaAPI.append(linea);
        }
        reader.close();

        return respuestaAPI.toString();
    }

    private static void jugarAhorcado(SSLSocket clienteSocket, String palabraAdivinar) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

            char[] palabraOculta = new char[palabraAdivinar.length()];
            Arrays.fill(palabraOculta, '_');
            int intentosRestantes = 7;
            boolean juegoFinalizado = false;

            salida.println("Palabra a adivinar: " + new String(palabraOculta));

            while (!juegoFinalizado) {
                salida.println("Intentos restantes: " + intentosRestantes);
                salida.println("Ingresa una letra o la palabra completa: ");

                String entradaUsuario = entrada.readLine();

                if (entradaUsuario != null) {
                    if (entradaUsuario.length() == 1) {
                        boolean letraAdivinada = false;
                        for (int i = 0; i < palabraAdivinar.length(); i++) {
                            if (palabraAdivinar.charAt(i) == entradaUsuario.charAt(0) && palabraOculta[i] == '_') {
                                palabraOculta[i] = entradaUsuario.charAt(0);
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
                    } else if (entradaUsuario.length() == palabraAdivinar.length()) {
                        if (entradaUsuario.equalsIgnoreCase(palabraAdivinar)) {
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

}
