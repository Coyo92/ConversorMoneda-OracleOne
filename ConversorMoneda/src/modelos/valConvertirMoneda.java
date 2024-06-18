package modelos;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import static modelos.bdCatMonedas.bdValidaRegistroMoneda;

public class valConvertirMoneda {

    private static boolean validacionDe = true;

    public static String valExisteMoneda (String Mensage) throws IOException {

        Scanner lectura = new Scanner ( System.in );
        String codMoneda;

        do {

            System.out.println ( Mensage );
            codMoneda = lectura.nextLine ( );

            boolean bol = bdValidaRegistroMoneda ( codMoneda );

            if (Objects.equals ( codMoneda , "" )) {
                validacionDe = false;
                System.out.println ( "Petición Denegada, La moneda ingresada no puede ser nula!" );
            } else if (!bol) {
                validacionDe = false;
                System.out.println ( "Petición Denegada, La moneda ingresada no se encuentra registrada!" );
            }

        } while (!validacionDe);

        return codMoneda;
    }

}
