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

}
