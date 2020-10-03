package VisorMazo;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import juegoDeCartas.Atribut;
import juegoDeCartas.Card;
import juegoDeCartas.CardDeck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class VisorMazo {

    public static void mostrarMazo(String jsonFile) {
    	
    	CardDeck mazoNuevo = new CardDeck("Superheroes");
    	
        //URL url = getClass().getResource(jsonFile);
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                Card nuevaCarta = new Card(nombreCarta);
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                //String atributosStr = "";
                
                for (String nombreAtributo:atributos.keySet()) {
                	
                	int atributValue = atributos.getInt(nombreAtributo);
                	Atribut nuevoAtributo = new Atribut(nombreAtributo, atributValue);
                	nuevaCarta.addAtribut(nuevoAtributo);
                	
                }
                
                mazoNuevo.addCard(nuevaCarta);
                
                    
            }
            //return mazoNuevo;
            reader.close();
           

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        String mazoPath = "./src/VisorMazo/superheroes.json";
        VisorMazo.mostrarMazo(mazoPath);
    }

}

