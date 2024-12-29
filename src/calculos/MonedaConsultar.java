package calculos;

import com.google.gson.Gson;
import model.MonedaDTO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MonedaConsultar {
    public MonedaDTO buscarMoneda(String monedaBase, String monedaTarget) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f5bc53f664ded792672e439d/pair/" + monedaBase + "/" + monedaTarget);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), MonedaDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró la moneda");
        }
    }

    public List<String> obtenerCodigosMoneda() {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f5bc53f664ded792672e439d/codes");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            var json = new Gson().fromJson(response.body(), Map.class);
            var supportedCodes = (List<List<String>>) json.get("supported_codes");

            List<String> codigosConNombres = new ArrayList<>();
            for (List<String> codePair : supportedCodes) {
                codigosConNombres.add(codePair.get(0) + " - " + codePair.get(1));
            }
            return codigosConNombres;
        } catch (Exception e) {
            throw new RuntimeException("No se pudieron obtener los códigos de moneda");
        }
    }


}
