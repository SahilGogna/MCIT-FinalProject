package util;

import java.io.IOException;
import java.net.*;
import java.net.URL;
import java.util.Scanner;

public class JsonParser {

    public static String parseJsonURL(String jsonUrl) throws IOException {
        java.net.URL url = new URL(jsonUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        String inline = "";
        Scanner sc = new Scanner(url.openStream());
        while (sc.hasNext()) {
            inline += sc.nextLine();
        }
        sc.close();
        return inline;
    }

}
