package juegoDeCartas;

public class Main {

	public static void main(String[] args) {
		String mazoPath = "./src/VisorMazo/superheroes.json";
		
		Player p1 = new Player("Lucho");
		Player p2 = new Player("Rope");
		CardDeck cd1 = new CardDeck("MazoImportado");
		cd1.importCardDeck(mazoPath);
		cd1.verifyCardDeck();
		Game g1 = new Game(p1, p2, cd1, 50, p1);
		
		g1.startGame();
		

	}
					
}
