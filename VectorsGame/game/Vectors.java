package game;

public class Vectors {
	private int row;
	private int column;
	private String[][] board = new String[8][8];
	public void run() {
		
	}
	
	public void setBoard() {
		for (row = 0; row < 8; row++) {
			for (column = 0; column < 8; column++) {
				board[row][column] = " ";
			}
		}
		row = 0;
		column = 0;
	}
	
	public void display() {
		System.out.println("**************************************\n"
				+ "- V E C T O R S                      *\n"
				+ "**************************************");
		System.out.printf("- High Score: %9s – %-5d %6s\n", "NAME", -54, "*");
		System.out.println("**************************************");
		System.out.printf("- Player Score: %5d Last Round %3d %-1s\n", -1, -1, "*");
		System.out.printf("- Computer Score: %3d Last Round %3d %-1s\n", -1, -1, "*");
		System.out.println("**************************************");
		System.out.printf("- Turn %3d of %3d %20s\n", -1, -12, "*");
		System.out.println("**************************************\n");
		
		
		
		System.out.printf("%3d%4d%4d%4d%4d%4d%4d%4d\n", 0, 1, 2, 3, 4, 5, 6, 7);
		for (row = 0; row < 8; row++) {
			System.out.println("---------------------------------");
			for (column = 0; column < 8; column++) {
				System.out.printf("|%-3s", board[row][column]);
			}
			System.out.printf("| %d\n", row);
		}
		System.out.println("---------------------------------");
		System.out.printf("Player(%s) Turn(row col): %d %d", "NAME", -1, -1);
	}
}