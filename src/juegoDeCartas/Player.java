package juegoDeCartas;

import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<Card> myCards;

	public Player(String name) {
		super();
		this.name = name;
		myCards = new ArrayList<Card>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addCard(Card c1) {
		myCards.add(c1);
	}
	
	public Card getFirstCard() {
		return myCards.remove(0);
	}
	
	//devuelve la totalidad de cartas
	public int getAmountOfCards() {
		return myCards.size();
	}
	
	//elije un numero al azar para ver quien empieza el juego
	public double pickNumber() {
//		int max=10;
//		int i = (int) Math.floor((Math.random()*max)+1);
//		return i;
		return Math.random();
	}
	
	public String toString() {
		return name+" "+myCards;
	}
	

}
