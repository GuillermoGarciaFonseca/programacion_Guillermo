import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ligaSoccer {
    public void ligasFutbol(){
        String urlString="https://www.thesportsdb.com/api/v1/json/3/all_leagues.php";
        try{
            URL url = new URL(urlString);
            HttpURLConnection connection =(HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String lecturaCompleta = bufferedReader.readLine();
            JSONObject objetoGeneral = new JSONObject(lecturaCompleta);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
