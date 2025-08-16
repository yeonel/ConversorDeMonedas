import java.util.Map;

public record RespuestaMonedas(
        String result,
        String base_code,
        Map<String, Double> conversion_rates
) {}
