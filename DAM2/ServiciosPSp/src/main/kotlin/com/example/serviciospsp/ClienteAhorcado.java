package com.example.serviciospsp;
import javax.net.ssl.*;
import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.util.Scanner;

public class ClienteAhorcado {
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 12345;
    private static final String ALMACEN_SRV = "AlmacenSrv";
    private static final String CONTRASENA_ALMACEN_SRV = "1234567";

    public static void main(String[] args) {
        try {
                
            String directorioActual = System.getProperty("user.dir");

            String rutaAlmacenSrv = directorioActual + File.separator + ALMACEN_SRV;
SSLContext sslContext = SSLContext.getInstance("TLS");
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(new FileInputStream(rutaAlmacenSrv), CONTRASENA_ALMACEN_SRV.toCharArray());
            kmf.init(keyStore, CONTRASENA_ALMACEN_SRV.toCharArray());
            tmf.init(keyStore);

            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            SSLSocket socket = (SSLSocket) socketFactory.createSocket(SERVIDOR, PUERTO);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println(entrada.readLine());
            salida.println(scanner.nextLine());

            System.out.println(entrada.readLine());
            salida.println(scanner.nextLine());

            String respuestaServidor;
            while ((respuestaServidor = entrada.readLine()) != null) {
                System.out.println(respuestaServidor);
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
