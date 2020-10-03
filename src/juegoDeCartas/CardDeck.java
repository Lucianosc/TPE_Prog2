package juegoDeCartas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class CardDeck {
	private String name;
	private ArrayList<Card> cards;
	
	
	public CardDeck(String name) {
		super();
		this.name = name;
		cards = new ArrayList<Card>();
	}

	public void importCardDeck (String jsonFile) {
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(is);
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
            	
            	Card c = new Card(carta.getString("nombre"));
            	
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                for (String nombreAtributo : atributos.keySet()) {
                	
                	Atribut atr = new Atribut(nombreAtributo, atributos.getInt(nombreAtributo));
                	c.addAtribut(atr);
                }
                
                this.addCard(c);
            }
            reader.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Card> getCardsDeck(){
		return new ArrayList<Card>(cards);
	}

	//verifico si el mazo es par
	public boolean isPair() {
		return((cards.size() % 2) == 0);
	}
	
	public void addCard(Card c1) {
		cards.add(c1);	
	}
	
	public Card firstCard() {
		int i = 0;
		return cards.remove(i);
	} 
	
}
