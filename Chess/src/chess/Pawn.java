package chess;

public class Pawn implements Piece {
	
	String name; 
	String type = "pawn"; 
	String color;
	
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
	
	public char getColor() {
		return this.name.charAt(0);
	}
	
	@Override
	public boolean check_move(int c_row, int c_col, int n_row, int n_col) {
		System.out.println(getName() + " coordinates:" + "("+ c_row +","+ c_col+"), (" + n_row +","+ n_col+")");
		if(getColor() == 'w') {
		if (n_row >= c_row) {
			return false;
		}
		if (n_col > c_col || n_col < c_col) {
			return false;
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
				System.out.println("subsequent move");
				return true;
			}
		}
		return false;
	}
		else {
			if (n_row <= c_row) {
				return false;
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
					System.out.println("subsequent move");
					return true;
				}
			}
			return false;
		}
		}


}
