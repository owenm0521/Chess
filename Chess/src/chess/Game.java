package chess;

import java.util.Scanner;

//game logic 
public class Game {
	
	Player white = new Player("white"); 
	Player black = new Player("black"); 
	Board board = new Board(white, black); 
	
	
	
	public void newGame() {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Start new game? ");
		String str = sc.nextLine().toLowerCase(); 
		if(!(str.equals("yes") || str.equals("y"))) {
			return; 
		}
		board.createBoard(); 
		board.populateBoard();  
		board.printBoard(); 
		start(); 
		
	}
	
	public void start() {
		white.turn = true; 
		Scanner sc = new Scanner(System.in); 
		String source; 
		String dest; 
		while(true){
			while(true) {
			 System.out.println(white.turn ? "White's move." : "Black's move."); 
			 
			 source = sc.nextLine().toLowerCase();
			 String current_loc = source.split(" ")[0];
			 String new_loc = source.split(" ")[1];
			 
			 Character playerTurn = white.turn ? 'w' : 'b'; 
				 boolean turn = board.move(playerTurn, current_loc, new_loc); //calls piece check move function 
				 if(turn) {
					 break;
				 }
			 }
			 white.turn = !white.turn; 
			 black.turn = !black.turn; 
			 break; //on checkmate, resignation, draw
		 }
		return; 
	}
	
	
	
	public boolean checkmate_check() {
		return false; 
	}
	
	
}
