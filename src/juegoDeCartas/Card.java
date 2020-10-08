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
	public String getRandomAtrName() {
		int i = 0;
//		String aux = "";
		int atributsQ = atributs.size();
		i = (int) Math.floor((Math.random()*atributsQ));
		
		return atributs.get(i).getName();	
	}
//	
//	public boolean containsAtribut(Atribut atr) {
//		if(!atributs.contains(atr)) {
//			return false;
//		}
//		return true;
//	}
//	
	//reveer, agarro un atributo de la carta por medio
	//del nombre del atributo que eligio el jugador que inicio la ronda
	
	public Atribut getAtrByName(String nameAtr) {
		for (int i = 0; i < atributs.size(); i++) {
			
			System.out.println(nameAtr);
			System.out.println(atributs.get(i).getName());
			
			if (nameAtr == (atributs.get(i).getName())) {
				System.out.println("hola");
				return atributs.get(i);
			}
		}
		return null;
	}
	
//	public boolean verifyCard(Card card) {
//		
//		if(this.getAtributsQuantity() == card.getAtributsQuantity()) {
//			
//			for (int i = 0 ; i< this.atributs.size();i++) {
//				Atribut atribut = this.atributs.get(i);
//				
//				if(!card.containsAtribut(atribut)) {
//					return false;
//				}
//			}
//			return true;
//		}
//		
//		return false;
//	}
	
	public int getAtributsQuantity() {
		return atributs.size();
	}
	
	public boolean compareCard(Card c) {
		if(!this.atributs.containsAll(c.getAtributs())) {
			return false;
		}
		return true;
	}
	
	//implementar metodo comparar atributos
	
//	public void  compareAtributs(String name, Card card2) {
//		Atribut at2 = card2.getByName(name);
//		if(this.getByName(name).exceedAtribut(at2)) {
//		
//		}else if(this.getByName(name).pairsAtribut(at2)) {
//			
//		}else {
//			
//		}
//	}
	
	public String toString() {
		return name+" "+atributs+"\n";
	}

}
