package chess;

public class FreeSpace implements Piece{
	String name; 
	String type; 
	
	public FreeSpace (int row, int col) {
		if((row + col) % 2 == 1){
			this.type = "black space"; 
			this.name = "## "; 
		}else {
			this.type = "white space"; 
			this.name = "   "; 
		}
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
