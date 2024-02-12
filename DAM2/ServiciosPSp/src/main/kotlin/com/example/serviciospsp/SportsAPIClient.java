package com.example.serviciospsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SportsAPIClient {
    public static void main(String[] args) {
        try {
            String apiUrl = "https://www.sportradar.com/sportradar/api/data?format=json";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            System.out.println("Datos de fútbol:");
            System.out.println(response.toString());
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}