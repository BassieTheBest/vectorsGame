package game;

public class Driver {

	public static void main(String[] args) {
		
		Vectors game = new Vectors();
		
		
		game.setBoard();
		game.info();
		game.showBoard();
		game.setFirst();
		game.move();
		game.showBoard();
		game.move();
		game.showBoard();
		game.move();
		game.showBoard();

	}

}
