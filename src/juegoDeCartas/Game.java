package juegoDeCartas;

public class Game {
	
	private Player player1;
	private Player player2;
	private CardDeck cards;
	private int maxRounds;
	private Player roundWinner;
	private String historyLog;

	public Game(Player player1, Player player2, CardDeck cards, int maxRounds, Player roundWinner) {
		this.player1 = player1;
		this.player2 = player2;
		this.cards = cards;
		this.maxRounds = maxRounds;
		this.roundWinner = roundWinner;
		historyLog = " ";
	}
	
	public String getHistoryLog() {
		return historyLog;
	}

	//sumo un registro al historial de movimientos del juego
	public void addHistoryLog(String log) {
		this.historyLog += log;
	}

	public Player getRoundWinner() {
		return roundWinner;
	}

	public void setRoundWinner(Player roundWinner) {
		this.roundWinner = roundWinner;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public CardDeck getCards() {
		return cards;
	}

	public int getMaxRounds() {
		return maxRounds;
	}

	public void setMaxRounds(int maxRounds) {
		this.maxRounds = maxRounds;
	}

	private void divideCards() {
		int total = cards.getCardsDeck().size();
		
		for (int i=1; i<=total; i++) {
			if(cards.isPair()) {
				player2.addCard(cards.firstCard());
			}else {
				player1.addCard(cards.firstCard());
			}
		}
	}
	
	private void setFirstHand() {
		if (player1.pickNumber() > player2.pickNumber()) {
			this.setRoundWinner(player1);
		}
		else {
			this.setRoundWinner(player2);
		}
	}
	
	private void play() {
		int playedRounds = 0;
		
		while ((playedRounds < maxRounds) && 
				(player1.getAmountOfCards() > 0) &&
					(player2.getAmountOfCards() > 0)) {
			
			startRound();
			
			playedRounds++;
		}
	}
	
	public void startGame() {
		divideCards();
		setFirstHand();
		play();
	}
	
	public void startRound() {
		
		String playedAtribut = roundWinner.getFirstCard().getRandomAtrName();
		Card card1 = player1.getFirstCard();
		Card card2 = player2.getFirstCard();

//			if (card1.getByName(playedAtribut)
//					.exceedAtribut(card2.getByName(playedAtribut))) {
//				
//				this.setWinner(player1 , card1, card2);
//				
//			}else if(card1.getByName(playedAtribut)
//					.pairsAtribut(card2.getByName(playedAtribut))){
//				player1.addCard(card1);
//				player2.addCard(card2);	
//			}
//			else {	
//				this.setWinner(player2 , card1, card2);	
//			}
//		System.out.println(playedAtribut);
//		System.out.println("carta1: "+card1.getAtrByName(playedAtribut));
//		System.out.println("carta2: "+card2.getAtrByName(playedAtribut));
//		

			int compare = card1.getAtrByName(playedAtribut).compareAtribut(card2.getAtrByName(playedAtribut));
			
			switch (compare) {
				case 1: 
					this.setWinner(player1 , card1, card2);
					break;
				case 0: 
					player1.addCard(card1);
					player2.addCard(card2);	
					break;
				case -1: 
					this.setWinner(player2 , card1, card2);
					break;
			}
	}
	
	private void setWinner(Player player, Card card1, Card card2) {
		player.addCard(card2);
		player.addCard(card1);
		this.setRoundWinner(player);
	}
		
}
