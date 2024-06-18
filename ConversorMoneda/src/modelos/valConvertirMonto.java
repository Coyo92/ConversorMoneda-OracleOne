package modelos;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.Scanner;

public class valConvertirMonto {

    private static boolean validacionDe = false;

    public static double valConvMonto (String Mensage) throws IOException {

        Scanner lectura = new Scanner ( System.in );
        String monto;
        double montoConvertido = 0;

        do {

            System.out.println ( Mensage );
            monto = lectura.nextLine ( );

            if (!isNumberDouble ( monto )) {
                validacionDe = false;
                System.out.println ( "Solo numeros!" );
            } else {
                validacionDe = true;
                montoConvertido = Double.parseDouble (monto);
            }

        } while (!validacionDe);

        return montoConvertido;
    }

    public static double valMenu (String Mensage) throws IOException {

        Scanner lectura = new Scanner ( System.in );
        String opcion;
        int opcionInt = 0;

        do {

            System.out.println ( Mensage );
            opcion = lectura.nextLine ( );

            if (!isNumberInt ( opcion )) {
                validacionDe = false;
            } else {
                validacionDe = true;
                opcionInt = Integer.parseInt (opcion);
            }

        } while (!validacionDe);

        return opcionInt;
    }

    public static boolean isNumberDouble(String n) {
        try {
            Double.parseDouble(n);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean isNumberInt(String n) {
        try {
            Integer.parseInt (n);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
