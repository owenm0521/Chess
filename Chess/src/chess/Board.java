package chess;

import java.util.Scanner;

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
				default: this.col = -1; break; 
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
	
	public boolean checkBoard(Character playerTurn, Point source, Point dest) {
		Piece sourcePiece = board[source.row][source.col];
		Piece destPiece = board[dest.row][dest.col];
		
		if(destPiece.getName().charAt(0) == playerTurn) {
			// System.out.println("You already have a piece on that square."); 
			return false; 
		}
		
		if(sourcePiece.getType().equals("King") || sourcePiece.getType().equals("Knight")) {
			if(!board[dest.row][dest.col].getType().equals("Free Space")) {
				if (playerTurn == 'b') {
					white.pieces.remove(destPiece); 
				}else {
					black.pieces.remove(destPiece); 
				}
			}
			return true; 
		}
		
		int row = source.row; 
		int col = source.col; 
		
		boolean moveRight = false; 
		boolean moveLeft = false; 
		boolean moveUp = false;
		boolean moveDown = false; 
		if(dest.col > source.col) {
			moveRight = true; 
		}else {
			moveLeft = true; 
		}
		if(dest.row > source.row) {
			moveDown = true; 
		}else {
			moveUp = true; 
		}
		
		boolean vertical = false; 
		boolean horizontal = false; 
		boolean diagonal = false; 
		if(dest.row == source.row) {
			horizontal = true; 
		}else if(dest.col == source.col) {
			vertical = true; 
		}else {
			diagonal = true; 
		}
		
		if(sourcePiece.getType().equals("Pawn")) {
			if(board[dest.row][dest.col].getType().equals("Free Space")) {
				if(diagonal) {
					return false; 
				}
			}else {
				if (playerTurn == 'b') {
					white.pieces.remove(destPiece); 
				}else {
					black.pieces.remove(destPiece); 
				}
			}
			updatePawn(playerTurn, source, dest); 
			return true; 
		}
		
		if(diagonal) {
			while(row != dest.row && col != dest.col) {
				if(moveRight && moveUp) {
					row--; 
					col++; 
				}else if(moveRight && moveDown) {
					row++; 
					col++; 
				}else if(moveLeft && moveUp) {
					row--; 
					col--; 
				}else if(moveLeft && moveDown) {
					row++; 
					col--; 
				}else {
					return false; 
				}
				if(!board[row][col].getType().equals("Free Space")) {
					return false; 
				}
			}
		}else if(horizontal) {
			while(col != dest.col) {
				if(moveRight) {
					col++; 
				}else {
					col--; 
				}
				if(!board[row][col].getType().equals("Free Space")) {
					return false; 
				}
			}
		}else if(vertical) {
			while(row != dest.row) {
				if(moveUp) {
					row--; 
				}else {
					row++; 
				}
				if(!board[row][col].getType().equals("Free Space")) {
					return false; 
				}
			}
		}else {
			return false; 
		}
		
		if(!board[dest.row][dest.col].getType().equals("Free Space")) {
			if (playerTurn == 'b') {
				white.pieces.remove(destPiece); 
			}else {
				black.pieces.remove(destPiece); 
			}
		}
		return true; 
	}
	
	public void updatePawn(Character playerTurn, Point source, Point dest) {
		String newPieceType = ""; 
		Scanner sc = new Scanner(System.in);  
		if( (playerTurn == 'b' && dest.row == 7) || (playerTurn == 'w' && dest.row == 0) ) {
			System.out.println("You can replace your pawn with a new piece (Queen, Knight, Rook, Bishop, Pawn). Enter piece type: "); 
			newPieceType = sc.nextLine().toLowerCase(); 
			while ( !(newPieceType.equals("queen") || newPieceType.equals("knight") || newPieceType.equals("rook") || 
					newPieceType.equals("bishop") || newPieceType.equals("pawn")) ) {
				System.out.println("Invalid choice; please enter a valid piece type: ");
				newPieceType = sc.nextLine().toLowerCase(); 
			}
			sc.close(); 
		}else {
			sc.close(); 
			return; 
		}
		Piece piece = null; 
		String color = playerTurn.toString(); 
		switch(newPieceType) {
			case "queen": piece = new Queen(color); break; 
			case "knight": piece = new Knight(color); break; 
			case "rook": piece = new Rook(color); break; 
			case "bishop": piece = new Bishop(color); break; 
			// case "pawn": piece = new Pawn(color); break; 
			default: piece = new Pawn(color); break; 
		}
		board[dest.row][dest.col] = piece; 
		if(playerTurn == 'b') {
			black.pieces.remove(board[source.row][source.col]); 
			black.pieces.add(piece); 
		}else {
			white.pieces.remove(board[source.row][source.col]); 
			white.pieces.add(piece); 
		}
		return; 
	}
	
	
	//takes source,dest from input 
	public boolean move(Character playerTurn, String s, String d) {
		//String to point
		Point source = new Point(s); 
		Point dest = new Point(d); 
		
		//check piece is on board
		if(source.row < 0 || source.row > 8 || source.col == -1) {
			System.out.println("Not on board; please choose a different move");
			return false; 
		}
		
		//get piece 
		Piece piece = board[source.row][source.col]; 
		
		//check that source piece corresponds with player piece 
		if(piece.getName().charAt(0) != playerTurn) {
			System.out.println("None of your pieces are on that square; please choose a different move"); 
			//do something 
			return false; 
		}
		
		//check dest is on board
		if(dest.row < 0 || dest.row > 8 || dest.col == -1) {
			System.out.println("Not on board; please choose a different move");
			return false; 
		}
		
		
		boolean pieceLegal = piece.check_move(source.row, source.col, dest.row, dest.col); // -> conditional, check legality of move by piece type
		boolean boardLegal = checkBoard(playerTurn, source, dest); // -> conditional, check legality of move by availability of board spaces 
			//if legal - pass move to update board 
		if(pieceLegal && boardLegal) {
			updateBoard(source, dest);
		}
			//if illegal - exception/warning message 
		else {
			System.out.println("Illegal move; please choose a different move");
			return false;
		}
		//print updated board
		printBoard();
		return true;
	}
	
	
	//takes source, dest from Game.move, updates Game board 
	public void updateBoard(Point source, Point dest) {
		board[dest.row][dest.col] = board[source.row][source.col]; 
		board[source.row][source.col] = new FreeSpace(source.row, source.col); 
		return; 
	}

}
