package game;

public class Driver {

	public static void main(String[] args) {
		
		Vectors game = new Vectors();
		
		game.setBoard();
		game.info();
		game.move(250, 6);

	}

}
