package chess;

import java.util.ArrayList;

public class Player {
	String color; 
	boolean turn = false; 
	ArrayList<Piece> pieces = new ArrayList<Piece>(); 
	
	public Player(String color) {
		this.color = color; 
		for(int i = 0; i < 8; i++) {
			this.pieces.add(new Pawn(this.color)); 
		}
		this.pieces.add(new Rook(this.color)); 
		this.pieces.add(new Knight(this.color)); 
		this.pieces.add(new Bishop(this.color)); 
		this.pieces.add(new Queen(this.color)); 
		this.pieces.add(new King(this.color)); 
		this.pieces.add(new Bishop(this.color)); 
		this.pieces.add(new Knight(this.color)); 
		this.pieces.add(new Rook(this.color)); 
	}
}
