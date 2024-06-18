package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import modelos.bd;

import java.io.IOException;
import java.util.Date;

public class apiExchange {

    public void fApiObtenerMonto(String pMonedaActual,
                                 String pNombreMonedaActual,
                                 String pMonedaConvertir,
                                 String pNombreMonedaConvertir,
                                 double pMontoConvertir) throws IOException {

        Date fechaHora = new Date();

        Gson gson = new GsonBuilder ().setPrettyPrinting().create();
        ConsumiendoMoneda miMonedaConvertir = new ConsumiendoMoneda();
        String infoMoneda = gson.toJson(miMonedaConvertir.ConvertirMonto(pMonedaActual, pMonedaConvertir, pMontoConvertir));

        // Convertir el JSON a un objeto JsonObject
        JsonObject objetoJson = gson.fromJson(infoMoneda, JsonObject.class);
        double tipoCambio = objetoJson.getAsJsonPrimitive ( "conversion_rate" ).getAsDouble ();
        double valor = objetoJson.getAsJsonPrimitive ( "conversion_result" ).getAsDouble ();

        System.out.println("El valor convertido es: " + valor);
        setDatos(pMonedaActual,
                 pNombreMonedaActual,
                 pMonedaConvertir,
                 pNombreMonedaConvertir,
                 pMontoConvertir,
                 valor,
                 tipoCambio,
                 fechaHora);
        //return valor;

    }

    public void setDatos(String pMonedaActual ,
                         String pNombreMonedaActual,
                         String pMonedaConvertir,
                         String pNombreMonedaConvertir,
                         double pMontoConvertir,
                         double valor ,
                         double tipoCambio ,
                         Date hoy) throws IOException {

        bd addDatos = new bd ();
        addDatos.bdHistorialConversion (pMonedaActual,
                                        pNombreMonedaActual,
                                        pMonedaConvertir,
                                        pNombreMonedaConvertir,
                                        pMontoConvertir,
                                        valor ,
                                        tipoCambio ,
                                        hoy);
    }
}
