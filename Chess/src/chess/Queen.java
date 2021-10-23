package chess;

public class Queen implements Piece {
	
	String name; 
	String type = "Queen"; 
	
	public Queen (String color) {
		this.name = "" + color.charAt(0) + type.charAt(0) + " "; 
	}
	
	public String getName() {
		return this.name; 
	}
	public String getType() {
		return this.type; 
	}
	public boolean check_move(int c_row, int c_col, int n_row, int n_col) {
		if(n_col == c_col || n_row == c_row || Math.abs(n_row - c_row) == Math.abs(n_col - c_col)) {
			return true;
		}
		return false; 
	}

	@Override
	public char getColor() {
		// TODO Auto-generated method stub
		return 0;
	}
}
