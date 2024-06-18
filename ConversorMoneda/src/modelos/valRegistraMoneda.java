package modelos;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class valRegistraMoneda {

    private static boolean validacionDe = false;

    public static String valRegMoneda (String Mensage, String MessageError, String valLongitud) throws IOException {

        Scanner lectura = new Scanner ( System.in );
        String dato = null;

        do {

            System.out.println ( Mensage );
            dato = lectura.nextLine ( );

            if (Objects.equals ( dato , "" )) {
                validacionDe = false;
                System.out.println ( MessageError );
            } else if (Objects.equals ( valLongitud , "Longitud" ) && dato.length () > 3) {
                validacionDe = false;
                System.out.println ( "Petición Denegada, el codigo de moneda solo puede contener 3 caracteres!" );
            } else {
                validacionDe = true;
            }

        } while (!validacionDe);

        return dato;
    }
}
