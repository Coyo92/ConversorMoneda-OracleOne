package modelos;

import api.saveJson;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static api.readJson.leerJson;
import static api.readJson.leerJsonArray;

public class bd {

    public void bdHistorialConversion(String pMonedaActual , String pNombreMonedaActual , String pMonedaAConvertir , String pNombreMonedaConvertir, double pMontoConvertir, double valor , double tipoCambio , Date hoy) throws IOException {

        ArrayList<historialConversion> array = new ArrayList<> ( );
        historialConversion addDatos = new historialConversion();

        addDatos.setNombreMoneda ( pNombreMonedaActual );
        addDatos.setCodigoMoneda ( pMonedaActual );
        addDatos.setCodigoMonedaConvertir ( pMonedaAConvertir );
        addDatos.setNombreMonedaConvertir ( pNombreMonedaConvertir );
        addDatos.setMonto ( pMontoConvertir );
        addDatos.setMontoConvertido ( valor );
        addDatos.setTipoCambio ( tipoCambio );
        addDatos.setFechaRegistro ( hoy );

        ArrayList<historialConversion> leerJsonCopy = leerJson ( );

        if (leerJsonCopy != null) {
            array.addAll ( leerJsonCopy );
        }

        array.add ( addDatos );

        saveJson.saveWriteJson ( array );

        array.clear ();
    }

    public static void obtenerBDHistorial() throws IOException {

        JsonArray Jarray = leerJsonArray ();

        System.out.printf ( "|%15s|%18s|%16s|%16s|%15s|%29s|%n" , "Moneda Origen" , "Moneda Conversion" , "Monto Original" , "Monto Convertido" , "Tipo de Cambio" , "Fecha" );

        if (Jarray != null) {

            for (int i = 0; i < Jarray.size (); i++) {
                String CodigoMoneda = Jarray.get ( i ).getAsJsonObject ().get ( "CodigoMoneda" ).toString ().replaceAll ( "\"" , ""  );
                String CodigoMonedaConvertir = Jarray.get ( i ).getAsJsonObject ().get ( "CodigoMonedaConvertir" ).toString ().replaceAll ( "\"" , ""  );
                Double Monto = Jarray.get ( i ).getAsJsonObject ().get ( "Monto" ).getAsDouble ( );
                Double MontoConvertido = Jarray.get ( i ).getAsJsonObject ().get ( "MontoConvertido" ).getAsDouble ( );
                Double TipoCambio = Jarray.get ( i ).getAsJsonObject ().get ( "TipoCambio" ).getAsDouble ( );
                String FechaRegistro = Jarray.get ( i ).getAsJsonObject ().get ( "FechaRegistro" ).toString ().replaceAll ( "\"" , ""  );

                System.out.printf("|%15s|%18s|%16.4f|%16.4f|%15.4f|%30s|%n"
                        , CodigoMoneda
                        , CodigoMonedaConvertir
                        , Monto
                        , MontoConvertido
                        , TipoCambio
                        , FechaRegistro
                );
            }

        }
    }
}
