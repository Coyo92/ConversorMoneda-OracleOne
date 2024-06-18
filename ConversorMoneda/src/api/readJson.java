package api;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import excepciones.ErrorEnConversionDeDuracionException;
import modelos.CatMoneda;
import modelos.historialConversion;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readJson {

    public static final String FILENAME = "historialConversion.json";
    public static final String FILENAMECATMONEDA = "HistorialCatMoendas.json";

    public static ArrayList<historialConversion> leerJson () throws IOException {

        try {
            Gson gson = new GsonBuilder ().setPrettyPrinting().create();
            JsonReader reader = new JsonReader(new FileReader (FILENAME));

            return gson.fromJson(reader, ArrayList.class);

        } catch (NumberFormatException e){
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        }catch (ErrorEnConversionDeDuracionException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static JsonArray leerJsonArray () throws IOException {

        try {
            Gson gson = new GsonBuilder ().setPrettyPrinting().create();
            JsonReader reader = new JsonReader(new FileReader (FILENAME));

            return gson.fromJson(reader, JsonArray.class);

        } catch (NumberFormatException e){
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        }catch (ErrorEnConversionDeDuracionException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<CatMoneda> leerJsonCatMonedas () throws IOException {

        try {
            Gson gson = new GsonBuilder ().setPrettyPrinting().create();
            JsonReader reader = new JsonReader(new FileReader (FILENAMECATMONEDA));

            return gson.fromJson(reader, ArrayList.class);

        } catch (NumberFormatException e){
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        }catch (ErrorEnConversionDeDuracionException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static JsonArray leerJsonArrayCatMoendas () throws IOException {

        try {
            Gson gson = new GsonBuilder ().setPrettyPrinting().create();
            JsonReader reader = new JsonReader(new FileReader (FILENAMECATMONEDA));

            return gson.fromJson(reader, JsonArray.class);

        } catch (NumberFormatException e){
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        }catch (ErrorEnConversionDeDuracionException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
