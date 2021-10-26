package chess;

public class Pawn implements Piece {
	
	String name; 
	String type = "Pawn"; 
	String color;
	
	int num_moves = 0; 
	boolean moved2 = false; 
	
	public boolean getmoved() {
		return moved2;
	}
	
	public Pawn (String color) {
		this.name = "" + color.charAt(0) + type.charAt(0) + " "; 
	}
	
	public String getName() {
		return this.name; 
	}
	public String getType() {
		return this.type; 
	}
	
	public char getColor() {
		return this.name.charAt(0);
	}
	
	public boolean getEnPassant() {
		if (num_moves == 1 && moved2) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean check_move(int c_row, int c_col, int n_row, int n_col) {
		if(getColor() == 'w') {
			if (n_row >= c_row) {
				return false;
			}
			if (Math.abs(n_col - c_col) == 1 && c_row - n_row == 1) {
				System.out.println("white pawn to capture");
				return true;
			}
			else {
			if (n_row == (c_row - 2)) {
				if(num_moves == 0) {
					num_moves++;
					moved2 = true;
					return true;
				}
				else {
					return false;
				}
			}
			if (n_row == (c_row - 1)) {
					num_moves++;
					return true;
				}
			}
			return false;
	}
		else {
			if (n_row <= c_row) {
				return false;
			}
			if (Math.abs(n_col - c_col) == 1 && n_row - c_row == 1) {
				System.out.println("black pawn to capture");
				return true;
			}
			if (n_col < c_col || n_col > c_col) {
				return false;
			}
			else {
			if (n_row == (c_row + 2)) {
				if(num_moves == 0) {
					num_moves++;
					moved2 = true;
					return true;
				}
				else {
					return false;
				}
			}
			if (n_row == (c_row + 1)) {
					num_moves++;
					return true;
				}
			}
			return false;
		}
		}


}
