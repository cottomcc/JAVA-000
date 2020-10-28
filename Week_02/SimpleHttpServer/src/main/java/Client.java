import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Client {
    private static OkHttpClient client = new OkHttpClient();
    public static void main(String[] args) {
        try {
            System.out.println(run("http://localhost:8000/"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
