public interface Piece {
	public boolean isWhite();
	public int whatPrice();
    public boolean isValid(int xFrom, int yFrom, int xTo, int yTo);	
  }