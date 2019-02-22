public class King implements Piece {
	private boolean white;
	private int price;
	
	King(boolean bool, int worth) {
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
       
       if ((Math.abs(xTo - xFrom) <= 1) & (Math.abs(yTo - yFrom) <= 1))
		   return true;


        return false;
    }

}