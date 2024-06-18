package principal;
//Api
import api.apiExchange;
//Modelos
import modelos.Menu;
import modelos.bdCatMonedas;
//Librerias Java
import java.io.IOException;

import static modelos.bdCatMonedas.bdNombreMoneda;
import static modelos.bdCatMonedas.bdValidaRegistroMoneda;
import static modelos.valConvertirMoneda.valExisteMoneda;
import static modelos.valConvertirMonto.*;
import static modelos.valRegistraMoneda.valRegMoneda;

public class Main {
    public static void main(String[] args) throws IOException {

        Menu.mostrarBienvenida ( );
        Menu.mostrarInstrucciones ( );
        Menu.mostrarCatMonedas ( );

        int opcion;

        do {

            opcion = (int) valMenu("Seleccione una opcion disponible el menu: ");

            switch (opcion) {
                case 0:
                    System.out.println ( Menu.CERRARPROGRAMA );
                    break;
                case 1:
                    convertir ( );
                    break;
                case 2:
                    System.out.println ( Menu.mostrarCatMonedas ( ) );
                    break;
                case 3:
                    addMoneda ( );
                    break;
                case 4:
                    System.out.println ( Menu.mostrarHistorial ( ) );
                    break;
                case 5:
                    System.out.println ( Menu.mostrarInstrucciones ( ) );
                    break;
                default:
                    System.out.println ( """
                            Petición Denegada, Por favor, selecciona una opción válida. 🛠️""" );
            }

        } while (opcion != 0);

        System.out.println ( "Operación finalizada. ¡Hasta luego!" );
    }

    // Método para realizar la conversión utilizando la clase apiExchange
    private static void convertir() throws IOException {

        double monto = valConvMonto("Digite el Importe: ");


        String pCodMonedaActual = valExisteMoneda("De: ");
        String pCodMonedaAConvertir = valExisteMoneda("A: ");

        String pNombreMonedaActual = bdNombreMoneda(pCodMonedaActual);
        String pNombreMonedaConvertir = bdNombreMoneda(pCodMonedaAConvertir);

        apiExchange conversorMoneda = new apiExchange();
        conversorMoneda.fApiObtenerMonto(pCodMonedaActual, pNombreMonedaActual, pCodMonedaAConvertir, pNombreMonedaConvertir, monto);
    }

    private static void addMoneda() throws IOException {

        String pCodMonedaActual = valRegMoneda( "Digite el codigo de la moneda: ",
                                             "Petición Denegada, La moneda no puede ser nula!",
                                              "Longitud");

        String descripcionMoneda = valRegMoneda( "Digite la descripcion de la moneda: ",
                                              "Petición Denegada, La descripcion no puede ser nula!",
                                               "");

        boolean validacion = bdValidaRegistroMoneda(pCodMonedaActual);

        if (!validacion) {

            bdCatMonedas registrarMoneda = new bdCatMonedas ( );
            registrarMoneda.bdRegistrarMoneda ( pCodMonedaActual , descripcionMoneda );

        } else {
            System.out.println ( "Petición Denegada, La moneda ingresada ya se encuentra registrada!" );
        }
    }

}