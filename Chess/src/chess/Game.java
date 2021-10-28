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
		boolean checkmate = false;
		boolean draw = false; 
		boolean resign = false; 
		while(true){
			while(true) {
			 System.out.println(white.turn ? "White's move." : "Black's move."); 
			 
			 source = sc.nextLine().toLowerCase();
			 String promotion = "Q";
			 
			 if (source == "resign") {
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
			 			 System.out.println("Checkmate!");
						 System.out.println(white.turn ? "White wins!" : "Black wins!.");
						 return;
					 }
					 break;
				 }
			 }
			if(source == "draw") {
				 break;
			 }
			 else if (source == "resign") {
				 break;
			 }
			 white.turn = !white.turn; 
			 black.turn = !black.turn; 
//			 break; on checkmate, resignation, draw
		 }
		if(draw) {
			System.out.println("draw"); 
		}
		if(resign) {
			System.out.println(white.turn ? "Black wins!" : "White wins!."); 
		}
		return; 
	}
	
	
}
