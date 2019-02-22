
public class Board {
	public Piece[][] doska = new Piece[8][8];
	
	
	Board(){
		cleanBoard();
		startStand(0, 1, true);
	    startStand(7, 6, false);
	}
		
	
	
	public void startStand(int pcsLine, int pawnLine, boolean whiteBool) {
		
	
	Piece Rook = new Rook(whiteBool, 5);
	Piece Bishop = new Bishop(whiteBool, 4);
	Piece Horse = new Horse(whiteBool, 3);
	Piece Queen = new Queen(whiteBool, 9);
	Piece King = new King(whiteBool, 10);
	Piece Pawn = new Pawn(whiteBool, 1);
	
	
	doska[0][pcsLine] = Rook;
	doska[7][pcsLine] = Rook;
	doska[2][pcsLine] = Bishop;
	doska[5][pcsLine] = Bishop;
	doska[1][pcsLine] = Horse;
	doska[6][pcsLine] = Horse;
	doska[3][pcsLine] = Queen;
	doska[4][pcsLine] = King;
	for (int n=0; n<8; n++) doska[n][pawnLine] = Pawn;
	}
	
	public void cleanBoard() {
		for (int i=0; i<8; i++) {
		for(int j=0; j<8; j++) {
			
    	doska[i][j] = null;
		}
	  }
	}
	
}