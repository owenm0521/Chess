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
		
	}
	
	public void start() {
		/*
		 * while(true){
		 * 		game logic 
		 * 		checkmate/exit - break 
		 * }
		 */
		return; 
	}
	
	//takes source,dest from input 
	public void move(String source, String dest) {
		//get piece type as pos source
		//check move
			//if legal - pass move to board to update board 
			//if illegal - exception/warning message 
		
	}
	
	public boolean checkmate_check() {
		return false; 
	}
	
	
}
