import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private final HttpClient client = HttpClient.newHttpClient();

    public String obtenerTasasDeCambio(String monedaBase) throws IOException, InterruptedException {
        //String url = BASE_URL + API_KEY + "/latest/" + monedaBase;
        String url = "https://v6.exchangerate-api.com/v6/f005113220a60e6d22e50c9e/latest/"+ monedaBase;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la API: código " + response.statusCode());
        }

        return response.body(); // JSON en formato String
    }
}

