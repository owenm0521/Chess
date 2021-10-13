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
	public void check_move() {
		//do nothing
	}
}
