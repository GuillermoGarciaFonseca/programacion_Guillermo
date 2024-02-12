package com.example.serviciospsp;
import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ServidorAhorcado {
    private static final int PUERTO = 12345;
    private static final String ALMACEN_SRV = "AlmacenSrv";
    private static final String CONTRASENA_ALMACEN_SRV = "1234567";
    private static final String[] PALABRAS_DEPORTE = {"futbol", "baloncesto", "tenis", "atletismo", "natacion", "ciclismo", "golf", "boxeo", "voleibol", "rugby", "hockey", "badminton", "esgrima", "karate", "surf", "ski", "snowboard", "taekwondo", "escalada", "patinaje", "buceo", "yoga", "pilates", "windsurf", "kitesurf", "paracaidismo", "canotaje", "rafting", "paddle", "parkour", "slackline", "equitacion", "triathlon", "maraton", "crossfit", "kickboxing", "gimnasia", "judo", "baseball", "softball", "waterpolo", "squash", "triatlon", "remo", "handball", "squash", "squash", "squash", "squash"};
    private static final Map<String, String> usuariosRegistrados = new HashMap<>();

    public static void main(String[] args) {
        try {
            // Generar almacén de claves si no existe
            File archivo = new File(ALMACEN_SRV);
            if (!archivo.exists()) {
                String[] cmd = {"keytool", "-genkey", "-alias", "servidor", "-keyalg", "RSA", "-keystore", ALMACEN_SRV, "-storepass", CONTRASENA_ALMACEN_SRV};
                Process proceso = Runtime.getRuntime().exec(cmd);
                proceso.waitFor();
            }

            // Registrar usuarios
            registrarUsuario("usuario1", "password1");
            registrarUsuario("usuario2", "password2");

            // Cargar el almacén de claves
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(new FileInputStream(ALMACEN_SRV), CONTRASENA_ALMACEN_SRV.toCharArray());

            // Crear el administrador de claves
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, CONTRASENA_ALMACEN_SRV.toCharArray());

            // Crear el administrador de confianza
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);

            // Configurar el contexto SSL
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new SecureRandom());

            // Crear el socket del servidor
            SSLServerSocketFactory socketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) socketFactory.createServerSocket(PUERTO);
            serverSocket.setNeedClientAuth(true);

            // Esperar conexiones entrantes
            System.out.println("Servidor iniciado. Esperando conexiones...");
            while (true) {
                SSLSocket clienteSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");

                // Manejar la conexión en un hilo separado
                Thread hiloCliente = new Thread(new ClienteHandler(clienteSocket));
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

    private static class ClienteHandler implements Runnable {
        private final SSLSocket clienteSocket;

        public ClienteHandler(SSLSocket clienteSocket) {
            this.clienteSocket = clienteSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

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
                } else {
                    salida.println("Usuario o contraseña incorrectos. Desconectando...");
                    clienteSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String obtenerDatosTenis() throws IOException {
            String apiUrl = "https://api.sportsdata.io/v3/tennis/scores/json";

            return hacerSolicitudAPI(apiUrl);
        }

        private String obtenerDatosBaloncesto() throws IOException {
             String apiUrl = "https://api.sportsdata.io/v3/nba/scores/json";
            return hacerSolicitudAPI(apiUrl);
        }

        private String hacerSolicitudAPI(String apiUrl) throws IOException {
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
    }
}
