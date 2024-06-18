package api;
import com.google.gson.*;
import modelos.CatMoneda;
import modelos.historialConversion;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class saveJson {

    public static final String FILENAME = "historialConversion.json";
    public static final String FILENAMECATMONEDA = "HistorialCatMoendas.json";

    public static void saveWriteJson(ArrayList<historialConversion> array) throws IOException {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        try {
            FileWriter escritura = new FileWriter(FILENAME);
            escritura.write ( gson.toJson ( array ));
            escritura.flush ();
            escritura.close();
        } catch (IOException e) {
            System.err.print("Error: " + e);
        }
    }

    public static void saveCatMonedas(ArrayList<CatMoneda> array) throws IOException {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        try {
            FileWriter escritura = new FileWriter(FILENAMECATMONEDA);
            escritura.write ( gson.toJson ( array ));
            escritura.flush ();
            escritura.close();
        } catch (IOException e) {
            System.err.print("Error: " + e);
        }
    }

    public static boolean checkFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

    public static void verificaDirectorio () {
        File direcotry = new File(FILENAMECATMONEDA);

        boolean check = checkFileExists(direcotry);

        if (!check) {
            try {
                FileWriter escritura = new FileWriter(FILENAMECATMONEDA);
                escritura.write ( "");
                escritura.flush ();
                escritura.close();
            } catch (IOException e) {
                System.err.print("Error: " + e);
            }
        }
    }

}
