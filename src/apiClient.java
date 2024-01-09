//import com.sun.deploy.net.HttpResponse;
//import sun.net.www.http.HttpClient;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

//import static javafx.css.StyleOrigin.USER_AGENT;

public class apiClient {

    public void testGet() {
        String url = "http://www.google.com/search?q=httpClient";

//        HttpClient client = HttpClientBuilder.create().build();
//        HttpGet request = new HttpGet(url);
//
//        // add request header
//        request.addHeader("User-Agent", USER_AGENT);
//        HttpResponse response = client.execute(request);
//
//        System.out.println("Response Code : "
//                + response.getStatusLine().getStatusCode());
//
//        BufferedReader rd = new BufferedReader(
//                new InputStreamReader(response.getEntity().getContent()));
//
//        StringBuffer result = new StringBuffer();
//        String line = "";
//        while ((line = rd.readLine()) != null) {
//            result.append(line);
//        }
    }
}
