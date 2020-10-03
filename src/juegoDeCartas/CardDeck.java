package juegoDeCartas;

import java.util.ArrayList;

public class CardDeck {
	private String name;
	private ArrayList<Card> cards;
	
	
	public CardDeck(String name) {
		super();
		this.name = name;
		cards = new ArrayList<Card>();
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
