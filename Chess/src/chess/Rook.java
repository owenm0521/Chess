package chess;

public class Rook implements Piece {
	
	String name; 
	String type = "Rook";
	boolean moved = false;
	
	public Rook (String color) {
		this.name = "" + color.charAt(0) + type.charAt(0) + " "; 
	}
	
	public String getName() {
		return this.name; 
	}
	public String getType() {
		return this.type; 
	}
	public boolean check_move(int c_row, int c_col, int n_row, int n_col) {
		if(n_col == c_col || n_row == c_row) {
			moved = true;
			return true; 
		}
		return false;
	}
	
	public boolean getmoved() {
		return moved;
	}

	@Override
	public char getColor() {
		// TODO Auto-generated method stub
		return 0;
	}
}
