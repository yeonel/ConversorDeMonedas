import com.google.gson.Gson;

public class ConversorMonedas {
    private final ApiService apiService;
    private final Gson gson = new Gson();

    public ConversorMonedas(ApiService apiService) {
        this.apiService = apiService;
    }

    public double convertir(String desde, String hacia, double cantidad) throws Exception {
        // Llamamos a la API con la moneda base
        String json = apiService.obtenerTasasDeCambio(desde);

        // Parseamos JSON a nuestro record
        RespuestaMonedas datos = gson.fromJson(json, RespuestaMonedas.class);

        // Obtenemos la tasa de cambio hacia la moneda deseada
        Double tasa = datos.conversion_rates().get(hacia);

        if (tasa == null) {
            throw new IllegalArgumentException("No existe tasa de cambio para " + hacia);
        }

        return cantidad * tasa;
    }
}
