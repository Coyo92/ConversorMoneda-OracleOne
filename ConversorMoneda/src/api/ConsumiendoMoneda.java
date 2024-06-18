package api;
import com.google.gson.Gson;
import modelos.ConversionMoneda;
import modelos.TodasLasMonedas;
import modelos.filtroMoneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumiendoMoneda {
    private static final String KEY = "1f2aa7388a8963a19d76c40c";
    private static final String URL = "https://v6.exchangerate-api.com/v6/" + KEY + "/latest/";
    private static final String URLMONEDAS = "https://v6.exchangerate-api.com/v6/" + KEY + "/codes";
    private static final String URLMONTO = "https://v6.exchangerate-api.com/v6/" + KEY + "/pair/";

    public TodasLasMonedas catMonedas() {
        URI urlAPI = URI.create(URLMONEDAS);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlAPI)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TodasLasMonedas.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se encontraron monedas en el catalogo");
        }
    }

    public filtroMoneda BuscarMoneda(String pMonedaOrigen, String pMonedaConvertir) {
        URI urlAPIMoneda = URI.create(URL + pMonedaOrigen);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlAPIMoneda)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), filtroMoneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Moneda no encontrada");
        }
    }

    public ConversionMoneda ConvertirMonto(String pMonedaOrigen, String pMonedaConvertir, double pMontoConvertir) {
        URI urlAPIConversion = URI.create(URLMONTO + pMonedaOrigen + "/" + pMonedaConvertir + "/" + pMontoConvertir);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlAPIConversion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversionMoneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Moneda no encontrada");
        }
    }

}
