import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Pokemon {
    public void absolHabilidades() {
        Scanner in = new Scanner(System.in);
        String urlPokemon = "https://pokeapi.co/api/v2/pokemon/absol";
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(urlPokemon);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lecturaAbsol =bufferedReader.readLine();
            JSONObject object=new JSONObject(lecturaAbsol);
            JSONArray arrayPokemon = object.getJSONArray("abilities");
            for (int i = 0; i < arrayPokemon.length(); i++) {
                JSONObject absolabilidades = arrayPokemon.getJSONObject(i);
                System.out.println("Las Habilidades de Absol son :"+absolabilidades);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void listaPoxedex(){
        String urlPokemon = "https://pokeapi.co/api/v2/pokemon/absol";
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(urlPokemon);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lecturaAbsol =bufferedReader.readLine();
            JSONObject objecto=new JSONObject(lecturaAbsol);
            JSONArray lugarPokemon=objecto.getJSONArray("game_indices");
            for (int i = 0; i < lugarPokemon.length(); i++) {
                JSONObject lugarAbsol = lugarPokemon.getJSONObject(i);
                System.out.println("La posicion de absol en la poxedex"+lugarAbsol);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void movimientosAbsol(){
        Scanner in = new Scanner(System.in);
        System.out.println("**Elige un nivel en el que quieras saber que movimiento aprende absol (level max 100)**");
        String nivelm=in.next();
        String levelm=String.format("https://pokeapi.co/api/v2/pokemon/absol",nivelm);
        BufferedReader bufferedReader=null;
        try {
            URL url =new URL(levelm);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            bufferedReader =new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lectura=bufferedReader.readLine();
            JSONObject objecto= new JSONObject(lectura);
            JSONArray arrayMovimiento=objecto.getJSONArray("moves");
            for (int i = 0; i < arrayMovimiento.length(); i++) {
                JSONObject movimiento = arrayMovimiento.getJSONObject(i);
                System.out.println(movimiento);

            }
        } catch (MalformedURLException e) {throw new RuntimeException(e);} catch (IOException e) {throw new RuntimeException(e); }
    }
    public void formaAbsol(){
        String urlPokemon = "https://pokeapi.co/api/v2/pokemon/absol";
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(urlPokemon);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lecturaAbsol =bufferedReader.readLine();
            JSONObject objecto=new JSONObject(lecturaAbsol);
            JSONArray formaPokemon=objecto.getJSONArray("versions");
            for (int i = 0; i < formaPokemon.length(); i++) {
                JSONArray aspectoAbsol = formaPokemon.getJSONArray(i);
                System.out.println("La forma de absol"+aspectoAbsol);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void statsAbsol(){
        String urlPokemon = "https://pokeapi.co/api/v2/pokemon/absol";
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(urlPokemon);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lecturaAbsol =bufferedReader.readLine();
            JSONObject objecto=new JSONObject(lecturaAbsol);
            JSONArray statsPokemon=objecto.getJSONArray("stats");
            for (int i = 0; i < statsPokemon.length(); i++) {
                JSONObject caracteristicasbAbsol = statsPokemon.getJSONObject(i);
                System.out.println("Las caracteristicas base de absol"+caracteristicasbAbsol);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
