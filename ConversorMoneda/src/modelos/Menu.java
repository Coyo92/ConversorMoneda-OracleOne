package modelos;

import java.io.IOException;

import static modelos.bd.obtenerBDHistorial;

public class Menu {


    public static final String BIENVENIDA = """
            ************************************************************************
                       Challange - Alura OracleOne
                       Conversor de Monedas - Alberto Fuentes
            ************************************************************************
            """;
    public static final String SUB_MENU = """
            ************************************************************************
                                  Menu Monedas Disponibles
            ************************************************************************
            """;
    public static final String CERRARPROGRAMA = """
            ************************************************************************
                     Conversor de Monedas - Los Valores mostrados pertenecen
                                    a la API Exchange Rate
            ************************************************************************
            """;
    public static final String INSTRUCCIONES = """
            ************************************************************************
            ******* -  Conversor de Monedas - Primer Challenge Backend  - **********
            ********************** - Instrucciones de uso - ************************
            **** 0 - Cerrar Programa (0)                                     *******
            **** 1 - Convertir Divisas (1)                                   *******
            **** 2 - Ver Catalogo de Monedas (2)                             *******
            ************************************************************************
            **** 3 - Agregar Moneda (3)                                      *******
            **** 4 - Ver Historial de Conversiones (4)                       *******
            **** 5 - Ver Instrucciones del Sistema (5)                       *******
            ************************************************************************
            """;
    public static final String HISTORIAL = """
            *********************************************************************************************************************
            ******************************* -  Conversor de Monedas - Historial de Conversiones - *******************************
            *********************************************************************************************************************
            """;

    public static void mostrarBienvenida() {
        System.out.println(BIENVENIDA);
    }

    public static void mostrarSubMenu() {
        System.out.println(SUB_MENU);
    }

    public static void mostrarSalir() {
        System.out.println(CERRARPROGRAMA);
    }

    public static String mostrarInstrucciones() {
        System.out.println(INSTRUCCIONES);
        return "";
    }

    public static String mostrarCatMonedas() throws IOException {
        bdCatMonedas.bdGetHistorialCatMonedas();
        return "";
    }

    public static String mostrarHistorial() throws IOException {

        System.out.println(HISTORIAL);
        obtenerBDHistorial ();
        return "";
    }
}
