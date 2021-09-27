package ApiTest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    String base_url;
    public String testing(String sendUrl, String type) throws IllegalStateException, IOException {
        URL url = new URL(this.base_url + sendUrl);
        StringBuilder sb = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(type);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        int status = con.getResponseCode();
        System.out.println(status);
        while((inputLine = in.readLine()) != null){
            sb.append(inputLine);
        }
        in.close();
        con.disconnect();
        return sb.toString();
    }
    public HttpUtil(String a){
        this.base_url = a;
    }
}
