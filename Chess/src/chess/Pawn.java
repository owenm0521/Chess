package chess;

public class Pawn implements Piece {
	
	String name; 
	String type = "pawn"; 
	
	int num_moves = 0; 
	boolean moved2 = false; 
	
	public Pawn (String color) {
		this.name = "" + color.charAt(0) + type.charAt(0) + " "; 
	}
	
	public String getName() {
		return this.name; 
	}
	public String getType() {
		return this.type; 
	}
	public void check_move() {
		
	}
}
