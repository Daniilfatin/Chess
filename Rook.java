public class Rook implements Piece {
	private boolean white;
	private int price;
	
	Rook(boolean bool, int worth) {
		white = bool;
		price = worth;
	}
	
	public boolean isWhite() {
		return this.white ;
	}
	
	public int whatPrice() {
		return this.price ;
	}

    
    public boolean isValid(int xFrom, int yFrom, int xTo, int yTo) {
        
		
        if(xTo == xFrom)
            return true;
        if(yTo == yFrom)
            return true;
        return false;
    }
}