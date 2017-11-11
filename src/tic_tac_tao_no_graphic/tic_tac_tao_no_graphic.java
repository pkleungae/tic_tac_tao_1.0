package tic_tac_tao_no_graphic;

import java.util.Scanner;

public class tic_tac_tao_no_graphic {
	// Name-constants to represent the seeds and cell contents
	public static final int CROSS = 1;
	public static final int EMPTY = 0;
	public static final int NOUGHT = 2;
	//state value
	public static final int PLAYING = 1;
	public static final int ENDED = -1;
	public static final int xWon = 2;
	public static final int oWon= 3;
	public static final int DRAW= 0;
	
	//no_of  row and col
	public static final int row = 3;
	public static final int column = 3;
	
	//table
	public static int[][] table = new int[row][column];
	//scanner
	public static Scanner in = new Scanner(System.in);
	// currentPlayer
	public  static int currentPlayer;
	public  static int currentState;
	
	//
	
	
	private static void initGame() {
		System.out.println("intructrion for refering corrdinate input");
		for (int i = 0; i<row;i++) {
			for (int j=0; j<column; j++ ) {
				
				System.out.printf("[%d][%d]",i+1,j+1);
				if (j != column -1) {
				System.out.printf("|");
				}
				
			}
			System.out.print("\n");
		}
		
		for (int i = 0; i<row;i++) {
			for (int j=0; j<column; j++ ) {
				table[i][j] = EMPTY;
			}
		}
		
		currentState = PLAYING; // ready to play
		
	     currentPlayer = CROSS;  // cross plays first
		
	}

	private static void playMove(int currentPlayer2) {
		// TODO Auto-generated method stub
		
		if (currentPlayer == CROSS) {
		System.out.println("Input x location");
		}else
			System.out.println("Input o location");
		
		int row = in.nextInt() - 1;  // array index starts at 0 instead of 1
        int col = in.nextInt() - 1;
        
        if (isValid(row,col)) {
        	table[row][col] = currentPlayer;
        }
        else 
        	System.out.println("Please ENTER VALID location");
        
        
	}
	
	private static boolean isValid(int row ,int col) {
		//entered non empty block
		if (table[row][col]!= 0)
			return false;
		else
			return true;
	}

	private static void upDatingGame(int currentPlayer2) {
		// TODO Auto-generated method stub
		if(!isFinished()) {
		// Switch player
		currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
		}
		
		
		
		
		
	}
	private static boolean isFinished() {
		// TODO Auto-generated method stub
		if(hasWon()) {
			
			return true;
		}
		
		if(isDraw()) {
			currentState = DRAW;
			return true;
		}
		
		
		return false;
	}
	
	private static boolean hasWon() {
		// TODO Auto-generated method stub
		//consider if x won
		if ((table[0][0] == CROSS && table[0][1] == CROSS && table[0][2] == CROSS)||
				(table[1][0] == CROSS && table[1][1] == CROSS && table[1][2] == CROSS)||
				(table[2][0] == CROSS && table[2][1] == CROSS && table[2][2] == CROSS)||
			(table[0][0] == CROSS && table[1][0] == CROSS && table[2][0] == CROSS)||
				(table[0][1] == CROSS && table[1][1] == CROSS && table[2][1] == CROSS)||
				(table[0][2] == CROSS && table[1][2] == CROSS && table[2][2] == CROSS)||
			(table[0][0] == CROSS && table[1][1] == CROSS && table[2][2] == CROSS)||
			(table[0][2] == CROSS && table[1][1] == CROSS && table[2][0] == CROSS)
			
				) {
			currentState = xWon;
			return true;
		}
		//consider if o won
		else if((table[0][0] == NOUGHT && table[0][1] == NOUGHT && table[0][2] == NOUGHT)||
				(table[1][0] == NOUGHT && table[1][1] == NOUGHT && table[1][2] == NOUGHT)||
				(table[2][0] == NOUGHT && table[2][1] == NOUGHT && table[2][2] == NOUGHT)||
			(table[0][0] == NOUGHT && table[1][0] == NOUGHT && table[2][0] == NOUGHT)||
				(table[0][1] == NOUGHT && table[1][1] == NOUGHT && table[2][1] == NOUGHT)||
				(table[0][2] == NOUGHT && table[1][2] == NOUGHT && table[2][2] == NOUGHT)||
			(table[0][0] == NOUGHT && table[1][1] == NOUGHT && table[2][2] == NOUGHT)||
			(table[0][2] == NOUGHT && table[1][1] == NOUGHT && table[2][0] == NOUGHT)
				
				){
			currentState = oWon;
			return true;
		}
		return false;
	}

	private static boolean isDraw() {
		// TODO Auto-generated method stub
		for (int i = 0; i < row; i++) {
	         for (int j = 0; j < column; j++) {
	            if (table[i][j] == EMPTY) {
	               return false;  // an empty cell found, not draw, exit
	            }
	         }
	      }
	      return true;  // no empty cell, it's a draw
	
	}

	private static void printGame() {
		// TODO Auto-generated method stub
		
		for (int i=0;i<row ;i++) {
			for (int j=0; j < column; j++) {
				printCell(i,j);//print cell
				if (j != column -1) {
		               System.out.print("|"); 
		          }
				
			}
			System.out.print("\n"); 
		}
		
		
	}
	private static void printCell(int i,int j) {
		// TODO Auto-generated method stub
		char X ='X';
		char O ='O';
		if(table[i][j] == CROSS) {
			System.out.printf("%c",X);
		
		}
		else if(table[i][j] == NOUGHT) {
			System.out.printf("%c",O);
		
		}
		else
			System.out.print(" ");
		
	}

	public static void main(String args[]) {
		initGame();
		do {
		
		playMove(currentPlayer);
		upDatingGame(currentPlayer);
		printGame();
		}while (!(currentState == DRAW || currentState==xWon || currentState==oWon));
		
		
		if(currentState == xWon) {
			System.out.println("X has won");
			
		}
		else if (currentState == oWon) {
			System.out.println("O has won");
		}
		
		else if(currentState == DRAW) {
			System.out.println("It is a draw");
		}
	}

	

	
	

	
}
