package chess;

public class Bishop implements Piece {
	
	String name; 
	String type = "Bishop"; 
	
	public Bishop (String color) {
		this.name = "" + color.charAt(0) + type.charAt(0) + " "; 
	}
	
	public String getName() {
		return this.name; 
	}
	public String getType() {
		return this.type; 
	}
	public boolean check_move(int c_row, int c_col, int n_row, int n_col) {
		return false;
	}

	@Override
	public char getColor() {
		// TODO Auto-generated method stub
		return 0;
	}
}
