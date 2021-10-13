package chess;


//game setup 
public class Board {
	
	Player white; 
	Player black; 
	Piece[][] board; 
	
	public Board(Player white, Player black) {
		this.white = white; this.black = black; 
		this.board = this.createBoard(); 
		
	}
	
	public class Point {
		
		int row; 
		int col; 
		
		public Point (String gridPoint) {
			this.row = 8 - Character.getNumericValue(gridPoint.charAt(1)); 
			char c = gridPoint.charAt(0); 
			switch(c) {
				case 'a': this.col = 0; break; 
				case 'b': this.col = 1; break; 
				case 'c': this.col = 2; break; 
				case 'd': this.col = 3; break; 
				case 'e': this.col = 4; break; 
				case 'f': this.col = 5; break; 
				case 'g': this.col = 6; break; 
				case 'h': this.col = 7; break; 
			}
		}
		
	}
	
	public Piece[][] createBoard() {
		Piece[][] board = new Piece[8][8]; 
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				board[i][j] = new FreeSpace(i, j); 
			}
		}
		return board; 
	}
	
	public void printBoard() {
		System.out.println(); 
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j].getName()); 
			}
			System.out.println(" " + (8-i)); 
		}
		System.out.print(" a  b  c  d  e  f  g  h \n\n");
	}
	
	public void populateBoard() {
		int bi = 1; int bj = 0;  
		for(Piece piece : black.pieces) {
			if(bj > 7) {
				bj = 0; 
				bi = 0; 
			}
			this.board[bi][bj] = piece; 
			bj++; 
		}
		
		int wi = 6; int wj = 0; 
		for(Piece piece : white.pieces) {
			if(wj > 7) {
				wj = 0; 
				wi = 7; 
			}
			this.board[wi][wj] = piece; 
			wj++; 
		}
	}
	
	
	//takes source,dest from input 
	public void move(Character playerTurn, String s, String d) {
		//String to point
		Point source = new Point(s); 
		Point dest = new Point(d); 
		
		//get piece 
		Piece piece = board[source.row][source.col]; 
		
		//check that source piece corresponds with player piece 
		if(piece.getName().charAt(0) != playerTurn) {
			System.out.println("Not ur piece bitch!"); 
			//do something 
			return; 
		}
		
		
		piece.check_move(); // -> conditional, check legality of move by piece type 
			//if legal - pass move to update board 
			updateBoard(source, dest);
			//if illegal - exception/warning message 
			
		//print updated board
		printBoard();
			
	}
	
	
	//takes source, dest from Game.move, updates Game board 
	public void updateBoard(Point source, Point dest) {
		board[dest.row][dest.col] = board[source.row][source.col]; 
		board[source.row][source.col] = new FreeSpace(source.row, source.col); 
		return; 
	}

}
