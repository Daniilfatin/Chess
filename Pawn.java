public class Pawn implements Piece {
	private boolean white;
	private int price;
	
	Pawn(boolean bool, int worth) {
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
       
		if((this.white) & (Math.abs(xTo - xFrom) == 1 & yTo == yFrom + 1))
			return true;
		if((this.white) & (xTo == xFrom) & (yTo == yFrom + 1))
            return true;
		if((!this.white) & (Math.abs(xTo - xFrom) == 1 & yTo == yFrom - 1))
			return true;
        if((!this.white) & (xTo == xFrom) & (yTo == yFrom - 1))
            return true;
        
        return false;
    }
	

}