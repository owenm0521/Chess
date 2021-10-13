package chess;

public interface Piece {
	public String getName(); 
	public String getType(); 
	public char getColor();
	public boolean check_move(int c_row, int c_col, int n_row, int n_col); 
	
}