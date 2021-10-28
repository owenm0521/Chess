/**
 * @author Ali Khan and Owen Morris
 */
package chess;

import java.util.Scanner;

/**
 *  
 * Game class creates all objects for chess and plays the game
 *
 */
public class Game {
	
	/**
	 * white is the white player
	 * black is the black player
	 * board is the board of the game
	 */
	Player white = new Player("white"); 
	Player black = new Player("black"); 
	Board board = new Board(white, black); 
	

	public void newGame() {
		board.createBoard(); 
		board.populateBoard();  
		board.printBoard(); 
		start(); 
	}
	/**
	 * runs the game and scans for move input/draw offer/resignation
	 */
	public void start() {
		white.turn = true; 
		Scanner sc = new Scanner(System.in); 
		String source; 
		String dest; 
		boolean checkmate = false;
		boolean draw = false; 
		boolean resign = false; 
		while(true){
			while(true) {
			 System.out.print(white.turn ? "White's move: " : "Black's move: "); 
			 
			 source = sc.nextLine().toLowerCase();
			 String promotion = "Q";
			 
			 if (source.equals("resign")) {
				 resign = true; 
				 break;
			 }
			 String current_loc = source.split(" ")[0];
			 String new_loc = source.split(" ")[1];
			 if(source.split(" ").length == 3 && source.split(" ")[2].trim().toLowerCase().equals("draw?")) {
				 source = "draw";
				 draw = true; 
				 break;
			 }
			 else if(source.split(" ").length == 3 && source.split(" ")[2].trim().length() == 1) {
				 promotion = source.split(" ")[2];
			 }
			 
			 Character playerTurn = white.turn ? 'w' : 'b'; 
			 Character nonplayerTurn = white.turn ? 'b' : 'w'; 
			 boolean turn = board.move(playerTurn, current_loc, new_loc, promotion); //calls piece check move function 
			 	if(turn) {
			 		if(board.checkmate(nonplayerTurn)) {
			 			 System.out.println("Checkmate");
						 System.out.println(white.turn ? "White wins" : "Black wins");
						 return;
					 }
					 break;
				 }
			 }
			if(source.equals("draw")) {
				 break;
			 }
			 else if (source.equals("resign")) {
				 break;
			 }
			 white.turn = !white.turn; 
			 black.turn = !black.turn; 
		 }
		if(draw) {
			System.out.println("draw"); 
		}
		if(resign) {
			System.out.println(white.turn ? "Black wins" : "White wins"); 
		}
		return; 
	}
	
	
}
