package modelos;

import com.google.gson.JsonArray;

import java.io.IOException;
import java.util.ArrayList;

import static api.readJson.*;
import static api.saveJson.*;

public class bdCatMonedas {

    public void bdRegistrarMoneda(String pCodMoneda,
                                  String pNombreMoneda) throws IOException {

        verificaDirectorio ();

        ArrayList<CatMoneda> array = new ArrayList<> ( );
        CatMoneda addDatos = new CatMoneda();

        addDatos.setCodigoMoneda ( pCodMoneda );
        addDatos.setNombreMoneda ( pNombreMoneda );

        ArrayList<CatMoneda> leerJsonCopy = leerJsonCatMonedas ( );

        if (leerJsonCopy != null) {
            array.addAll ( leerJsonCopy );
        }

        array.add ( addDatos );

        saveCatMonedas ( array );

        array.clear ();
    }

    public static void bdGetHistorialCatMonedas() throws IOException {

        JsonArray JarrayCat = leerJsonArrayCatMoendas ();

        System.out.println ( """
                ************************************************************************
                                        Monedas Disponibles a Convertir
                ************************************************************************
                """ );
        System.out.printf ( "|%15s|%35s|%n" , "Codigo Moneda" , "Descripcion"  );

        if (JarrayCat != null) {

            for (int i = 0; i < JarrayCat.size (); i++) {
                String codigoMoneda = JarrayCat.get ( i ).getAsJsonObject ().get ( "CodigoMoneda" ).toString ();
                String nombreMoneda = JarrayCat.get ( i ).getAsJsonObject ().get ( "NombreMoneda" ).toString ();

                String repcodigoMoneda = codigoMoneda.replaceAll("\"", "");
                String repnombreMoneda = nombreMoneda.replaceAll("\"", "");

                System.out.printf("|%15s|%35s|%n"
                        , repcodigoMoneda
                        , repnombreMoneda
                );
            }

        }
    }

    public static boolean bdValidaRegistroMoneda (String pCodMoneda) throws IOException {

        JsonArray JarrayCat = leerJsonArrayCatMoendas ( );
        boolean bol = false;

        if (JarrayCat != null) {
            for (int i = 0; i < JarrayCat.size ( ); i++) {
                String codigoMoneda = JarrayCat.get ( i ).getAsJsonObject ( ).get ( "CodigoMoneda" ).toString ( );
                String repcodigoMoneda = codigoMoneda.replaceAll ( "\"" , "" );

                if (repcodigoMoneda.equals ( pCodMoneda )) {
                    bol = true;
                    break;
                }
            }
        }
        return bol;
    }

    public static String bdNombreMoneda (String pCodMoneda) throws IOException {

        JsonArray JarrayCat = leerJsonArrayCatMoendas ( );

        String descripcionMoneda = "";
        if (JarrayCat != null) {
            for (int i = 0; i < JarrayCat.size ( ); i++) {
                String codigoMoneda = JarrayCat.get ( i ).getAsJsonObject ( ).get ( "CodigoMoneda" ).toString ( );
                String nombreMoneda = JarrayCat.get ( i ).getAsJsonObject ( ).get ( "NombreMoneda" ).toString ( );
                String repcodigoMoneda = codigoMoneda.replaceAll ( "\"" , "" );
                String repNombreMoneda = nombreMoneda.replaceAll ( "\"" , "" );

                if (repcodigoMoneda.equals ( pCodMoneda )) {
                    descripcionMoneda = repNombreMoneda;
                    break;
                }
            }
        }
        return descripcionMoneda;
    }

}
