package ivmikhail.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * User: ivmikhail
 * Date: 03.07.2014
 * Time: 12:08
 */
public class UrlUtil {
    public static String sendPostRequest(String urlString, String query) {
        return sendPostRequest(urlString, query, null);
    }

    public static String sendPostRequest(String urlString, String query, Map<String, String> headers) {
        HttpURLConnection conn = null;
        String response = "";
        try {
            URL url = new URL(urlString);

            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(2000);
            conn.setReadTimeout(3000);

            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    conn.setRequestProperty(header.getKey(), header.getValue());
                }
            }

            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

            writer.write(query);
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String s;
            response = "";
            while((s = reader.readLine())!=null) {
                response += s + "\n";
            }
            writer.close();
            reader.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return response;
    }
}
