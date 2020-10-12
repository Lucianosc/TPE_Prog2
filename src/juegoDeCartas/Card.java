package juegoDeCartas;

import java.util.ArrayList;

public class Card {
	private String name;
	private ArrayList<Atribut> atributs;
	
	
	public Card(String name) {
		super();
		this.name = name;
		atributs = new ArrayList<Atribut>();
	}

	
	public void addAtribut(Atribut at) {
		atributs.add(at);
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Atribut> getAtributs(){
		return new ArrayList<Atribut>(atributs);
	}
	
	//calcula una posicion del arreglo de atributos al azar
	//hago un casting a int porque sino devuelve un double
	//obtengo el nombre del atributo que quiero agarrar
	public String getRandomAtr() {
		int i = 0;
		String aux = "";
		int atributsQ = atributs.size();
		
			i = (int) Math.floor((Math.random()*atributsQ));
			aux = atributs.get(i).getName();
			
		return aux;
	}
	
	public boolean containsAtribut(Atribut atr) {
		return atributs.contains(atr);
	}
	
	//Agarro el atributo de la carta por medio
	//del nombre del atributo que eligio el jugador que inicio la ronda
	
	public Atribut getAtrByName(String name ) {
		
		for(int i=0; i<atributs.size(); i++) {
			Atribut aux = atributs.get(i);
			if(aux.getName().equals(name))
				return aux;
		}
		return null;
	}
	
	
	public boolean verifyCard(Card card) {
			
			if(this.getAtributsQuantity() == card.getAtributsQuantity()) {
				
				for (int i = 0 ; i< this.atributs.size();i++) {
					Atribut atribut = this.atributs.get(i);
					
					if(!card.containsAtribut(atribut)) {
						return false;
					}
				}
				return true;
			}
			
			return false;
		}
	
	public int getAtributsQuantity() {
		return atributs.size();
	}
	
	
	@Override
	public String toString() {
		return name;
	}

}
