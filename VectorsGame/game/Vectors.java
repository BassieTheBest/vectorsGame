package game;

import java.util.Scanner;

public class Vectors {
	private int row;
	private int column;
	private String[][] board = new String[8][8];
	private String CP = "h";
	Scanner scanner = new Scanner(System.in);
	private int HScore = 0;
	private int CScore = 0;
	private int LHS;
	private int LRS;
	private int turns = 15;
	private int curTurn = 0;
	
	public void run() {
		setFirst();
		setBoard();
		turnAmount();
		while (curTurn < turns) {
			info();
			showBoard();
			move();
			score();	
		}
	}
	
	
	public void setFirst() {
		System.out.print("Who foes first: Human (h) or Robot (r): ");
		CP = scanner.nextLine();
		while (CP.charAt(0) != 104 && CP.charAt(0) != 114) {
			System.out.print("Please try again: ");
			CP = scanner.nextLine();
		}
		
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
	
	public void info() {
		System.out.println("**************************************\n"
				+ "- V E C T O R S                      *\n"
				+ "**************************************");
		System.out.printf("- High Score: %9s – %-5d %6s\n", "NAME", -54, "*");
		System.out.println("**************************************");
		System.out.printf("- Player Score: %5d Last Round %3d %-1s\n", HScore, LHS, "*");
		System.out.printf("- Computer Score: %3d Last Round %3d %-1s\n", CScore, LRS, "*");
		System.out.println("**************************************");
		System.out.printf("- Turn %3d of %3d %20s\n", curTurn, turns, "*");
		System.out.println("**************************************\n");
		
	}
	
	public void showBoard() {
		int tr;
		int tc;
		System.out.printf("%3d%4d%4d%4d%4d%4d%4d%4d\n", 0, 1, 2, 3, 4, 5, 6, 7);
		for (tr = 0; tr < 8; tr++) {
			System.out.println("---------------------------------");
			for (tc = 0; tc < 8; tc++) {
				System.out.printf("|%-3s", board[tr][tc]);
			}
			System.out.printf("| %d\n", tr);
		}
		System.out.println("---------------------------------");
		System.out.println("SB: " + this.row + " " + this.column);
		if (CP.equals("h")) {
			System.out.printf("Player(%s) Turn(row col): %d %d\n\n", "r", this.getRow(), this.getCol());
		}
		else {
			System.out.printf("Player(%s) Turn(row col): %d %d\n\n", "h", this.getRow(), this.getCol());
		}
		
	}
	
	public void turnAmount() {
		boolean good = false;
		int index;
		int counter = 0;
		System.out.println("How many turns do you want: ");
		String tempAmount = scanner.nextLine();
		
		while (!good) {
			for (index = 0; index < tempAmount.length(); index++) {
				if (tempAmount.charAt(index) >= 48 && tempAmount.charAt(index) <= 57) {
					counter++;
				}
			}
			if (counter == tempAmount.length() && counter <= 6) {
				turns = Integer.parseInt(tempAmount);
				good = true;
			}
			else {
				System.out.println("Didn't work\nHow many turns do you want: ");
				tempAmount = scanner.nextLine();
				counter = 0;
			}
			
		}
		System.out.println(turns);
	}
	
	public void move() {
		boolean empty = false;
		System.out.print("(row): ");
		String tempRow = scanner.nextLine();
		
		System.out.print("(column): ");
		String tempCol = scanner.nextLine();
		
		if (tempRow.length() == 1 && tempCol.length() == 1) {
			if (tempRow.charAt(0) >= 48 && tempRow.charAt(0) <= 55) {
			this.setRow(Integer.parseInt(tempRow));
			}
			if (tempCol.charAt(0) >= 48 && tempCol.charAt(0) <= 55) {
			this.setCol(Integer.parseInt(tempCol));
			}
			
		}
		
		while (!empty) {
			while ((row < 0 || row > 7) || (column < 0 || column > 7)) {
			System.out.print("Try again (row): ");
			tempRow = scanner.nextLine();
			
			System.out.print("Try again (column): ");
			tempCol = scanner.nextLine();
			if (tempRow.length() == 1 && tempCol.length() == 1) {
				if (tempRow.charAt(0) >= 48 && tempRow.charAt(0) <= 55) {
				this.setRow(Integer.parseInt(tempRow));
				}
				if (tempCol.charAt(0) >= 48 && tempCol.charAt(0) <= 55) {
				this.setCol(Integer.parseInt(tempCol));
				}
			}
			
			}
			if (board[row][column].equals(" h") || board[row][column].equals(" r")) { // The space before the letter is to make sure it matches what we put down
				this.setRow(-1);
				this.setCol(-1);
				}
			else {
				empty = true;
				}
		}
		
		curTurn++;
		
		if (CP.equals("h")) {
			board[getRow()][getCol()] = " h"; // To make it fit properly, the space is for
			CP = "r";
		}
		else {
			board[getRow()][getCol()] = " r"; // To make it fit properly, the space is for
			CP = "h";
		}
		System.out.println("M: " + row + " " + column);
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	
	public void setCol(int col) {
		this.column = col;
	}
	public int getCol() {
		return column;
	}
	
	
	public void score() {
		int HPointCounter = 0;
		int CPointCounter = 0;
		
		LHS = HScore;
		LRS = CScore;
		HScore = 0;
		CScore = 0;
		
		int tr;
		int tc;
		
		for (tr = 0; tr < 8; tr++) {
			for (tc = 0; tc <8; tc++) {
				if (board[tr][tc].equals(" h")) {
					HPointCounter++;
					if (HPointCounter == 5) {
						HScore += 4;
					}
					else if (HPointCounter == 4) {
						HScore += 2;
					}
					else if (HPointCounter == 3) {
						HScore += 4;
					}
					if (tc == 7) {
						HPointCounter = 0;
					}
				}
				else {
					HPointCounter = 0;
				}
				
				if (board[tr][tc].equals(" r")) {
					CPointCounter++;
					if (CPointCounter == 5) {
						CScore += 4;
					}
					else if (CPointCounter == 4) {
						CScore += 2;
					}
					else if (CPointCounter == 3) {
						CScore += 4;
					}
					if (tc == 7) {
						CPointCounter = 0;
					}
				}
				else {
					CPointCounter = 0;
				}	
			}
		}
		
		for (tc = 0; tc < 8; tc++) {
			for (tr = 0; tr <8; tr++) {
				if (board[tr][tc].equals(" h")) {
					HPointCounter++;
					if (HPointCounter == 5) {
						HScore += 4;
					}
					else if (HPointCounter == 4) {
						HScore += 2;
					}
					else if (HPointCounter == 3) {
						HScore += 4;
					}
					if (tr == 7) {
						HPointCounter = 0;
					}
				}
				else {
					HPointCounter = 0;
				}
				
				if (board[tr][tc].equals(" r")) {
					CPointCounter++;
					if (CPointCounter == 5) {
						CScore += 4;
					}
					else if (CPointCounter == 4) {
						CScore += 2;
					}
					else if (CPointCounter == 3) {
						CScore += 4;
					}
					if (tr == 7) {
						CPointCounter = 0;
					}
				}
				else {
					CPointCounter = 0;
				}
			}
		}
		System.out.println("S: " + row + " " + column);
	}
}