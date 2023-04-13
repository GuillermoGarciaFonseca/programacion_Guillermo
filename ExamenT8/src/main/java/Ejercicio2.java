import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Ejercicio2 {
    public void Ejercicio2(){
        String nombre;
        Scanner in = new Scanner(System.in);
        String url = "https://api.nationalize.io/?name=";
        System.out.println("Bienvenido este es un consultor de nombres por porcentaje en paises");
        System.out.println("Dime un nombre");
        nombre= in.next();
        String.format("https://api.nationalize.io/?name=/%d/\n",nombre);
    try {
        System.out.println("Bienvenido este es un consultor de nombres por porcentaje en paises");
        System.out.println("Dime un nombre");
        nombre= in.next();
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String lectura = bufferedReader.readLine();
        JSONObject object = new JSONObject(lectura);
        JSONObject nombre2 = object.getJSONObject(nombre);
        for (int i = 0; i < nombre2.length(); i++) {
            JSONObject lista = new JSONObject(i);
            JSONObject nombrepedido =lista.getJSONObject("name");
            JSONArray paises = lista.getJSONArray("country");
        }
    } catch (MalformedURLException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    }
}