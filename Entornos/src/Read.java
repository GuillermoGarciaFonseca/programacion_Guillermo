import org.jsoup.Jsoup;

import java.io.IOException;

public class Read {

    public static void main(String[] args) throws IOException {

        String webPage = "https://www.jesusninoc.com";

        String html = Jsoup.connect(webPage).get().html();

        System.out.println(html);
    }
}
