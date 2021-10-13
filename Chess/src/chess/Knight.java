package chess;

public class Knight implements Piece {
	
	String name; 
	String type = "Knight"; 
	
	public Knight (String color) {
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
