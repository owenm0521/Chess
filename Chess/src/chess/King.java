package chess;

public class King implements Piece {
	
	String name; 
	String type = "King"; 
	boolean moved = false;
	
	public King (String color) {
		this.name = "" + color.charAt(0) + type.charAt(0) + " "; 
	}
	
	public String getName() {
		return this.name; 
	}
	public String getType() {
		return this.type; 
	}
	public boolean check_move(int c_row, int c_col, int n_row, int n_col) {
		if(Math.abs(n_row - c_row) <= 1 && Math.abs(n_col - c_col) <= 1) {
			moved = true;
			return true; 
		}
		if(!moved && Math.abs(n_row - c_row) == 0 && Math.abs(n_col-c_col) == 2) {
			moved=true;
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
