package com.example.serviciospsp;import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyStore;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class ClienteAhorcado {
    private static final String HOST = "localhost";
    private static final int PUERTO = 12345;
    private static final String ALMACEN_SRV = "C:/Users/Guillermo/OneDrive/Documentos/programacion_Guillermo/DAM2/ServiciosPSp/AlmacenSrv";
    private static final String CONTRASENA_ALMACEN_SRV = "1234567";

    public static void main(String[] args) {
        try {
            System.setProperty("javax.net.ssl.trustStore", ALMACEN_SRV);
            System.setProperty("javax.net.ssl.trustStorePassword", CONTRASENA_ALMACEN_SRV);

            SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket clienteSocket = (SSLSocket) socketFactory.createSocket(HOST, PUERTO);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);
            BufferedReader entradaUsuarioConsola = new BufferedReader(new InputStreamReader(System.in));

            String mensajeServidor;
            while ((mensajeServidor = entrada.readLine()) != null) {
                System.out.println("Servidor: " + mensajeServidor);
                if (mensajeServidor.contains("Ingrese su nombre de usuario:") || mensajeServidor.contains("Ingrese su contraseña:")) {
                    String respuestaUsuario = entradaUsuarioConsola.readLine();
                    salida.println(respuestaUsuario);
                } else if (mensajeServidor.contains("¡Bienvenido al juego de ahorcado de deporte!")) {
                    jugarAhorcado(entrada, salida, entradaUsuarioConsola);
                }
            }

            clienteSocket.close();
            entrada.close();
            salida.close();
            entradaUsuarioConsola.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void jugarAhorcado(BufferedReader entrada, PrintWriter salida, BufferedReader entradaUsuarioConsola) throws Exception {
        int MAX_INTENTOS = 7;

        String palabraAdivinar = entrada.readLine().split(": ")[1];
        char[] palabraOculta = new char[palabraAdivinar.length()];
        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = '_';
        }

        int intentosRestantes = MAX_INTENTOS;
        boolean juegoFinalizado = false;

        salida.println("Palabra a adivinar: " + new String(palabraOculta));

        while (!juegoFinalizado) {
            salida.println("Intentos restantes: " + intentosRestantes);
            salida.println("Ingresa una letra o la palabra completa: ");

            String entradaUsuario = entradaUsuarioConsola.readLine();

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
                } else if (entradaUsuario.length() == palabraAdivinar.length()) {
                    if (entradaUsuario.equalsIgnoreCase(palabraAdivinar)) {
                        salida.println("¡Ganaste! La palabra era: " + palabraAdivinar);
                        juegoFinalizado = true;
                    } else {
                        intentosRestantes--;
                    }
                } else {
                    salida.println("Entrada inválida. Ingresa una letra o la palabra completa.");
                }

                if (intentosRestantes == 0) {
                    salida.println("¡Perdiste! La palabra era: " + palabraAdivinar);
                    juegoFinalizado = true;
                }

                if (!new String(palabraOculta).contains("_")) {
                    salida.println("¡Ganaste! La palabra era: " + palabraAdivinar);
                    juegoFinalizado = true;
                }
            }
        }
    }
}
