public class Game {
	
		private String winner = "nobody" ;
		private int countMoves = 0;
		private int countBlack = 16;
		private int countWhite = 16;
		
		private Board board = new Board();
		
	public static void main (String args[]) {
		
		Game game = new Game();
		
    
    do {
		
		game.actions ("Black player", "White", true, true);
		game.actions ("White player", "Black", false, false);
		
	     game.countMoves++;
		 if (game.countMoves > 10000) game.winner = "Friendship";
	
    } while (game.winner == "nobody");
	
	 System.out.println();
     System.out.println("Game over! " + game.winner + " is win!\nCount moves: " + game.countMoves);
	
	}
	
	
	
	private String getWinner(Piece[][] desc, String player, boolean whiteBool) {
		String whoWin = "nobody";
		
	stop: {
		int avaibleMove = 0;
		for (int xFrom=0; xFrom<8; xFrom++) {
		 for(int yFrom=0; yFrom<8; yFrom++) {
			   if ((desc[xFrom][yFrom] != null) && (desc[xFrom][yFrom].isWhite() == whiteBool)) {
				  
				  
				  for (int xTo=0; xTo<8; xTo++) {
		            for(int yTo=0; yTo<8; yTo++) {
						
						
				   if (desc[xTo][yTo] == null || desc[xFrom][yFrom].isWhite() != desc[xTo][yTo].isWhite() ) {
						
				
				
				     if (((desc[xFrom][yFrom].whatPrice() == 1) && (desc[xFrom][yFrom].isValid(xFrom, yFrom, xTo, yTo))
						 
						 && (desc[xTo][yTo] != null && (Math.abs(xTo - xFrom) == 1) || (desc[xTo][yTo] == null && (xTo == xFrom))))  ||
						
                        ((desc[xFrom][yFrom].whatPrice() > 1) && (desc[xFrom][yFrom].isValid(xFrom, yFrom, xTo, yTo))) ) {
							
							avaibleMove++;
						}
				   }	
				   
					if (avaibleMove > 0) break stop;
					
					}
				  }
			  }
		 }
		}
		if (avaibleMove == 0) whoWin = player;
		}
		return whoWin;
	}
	
	


	private int countPieces(Piece[][] desc, boolean whiteBool) {
	
	int countPcs = 0;
	   for (int t=0; t<8; t++) {
		 for(int f=0; f<8; f++) {
			  if ((desc[t][f] != null) && (desc[t][f].isWhite() == whiteBool)) countPcs++;
		 }
	   }
	   return countPcs;
	}
	
	
	
	
   private void makeMove(Piece[][] desc, String player, boolean whiteBool, int whitePcs, int blackPcs) {
	   boolean next = false;
	do {
		    int xFrom = (int)(Math.random() * 8);
			int yFrom = (int)(Math.random() * 8); 
			
			
			  if ((desc[xFrom][yFrom] != null) && (desc[xFrom][yFrom].isWhite() == whiteBool)) {
				  
			    int xTo = (int)(Math.random() * 8);
			    int yTo = (int)(Math.random() * 8);
				
				
				    if (desc[xTo][yTo] == null || desc[xFrom][yFrom].isWhite() != desc[xTo][yTo].isWhite() ) {
						
				
				
				     if (((desc[xFrom][yFrom].whatPrice() == 1) && (desc[xFrom][yFrom].isValid(xFrom, yFrom, xTo, yTo))
						 
						 && (desc[xTo][yTo] != null && (Math.abs(xTo - xFrom) == 1) || (desc[xTo][yTo] == null && (xTo == xFrom))))  ||
						
                        ((desc[xFrom][yFrom].whatPrice() > 1) && (desc[xFrom][yFrom].isValid(xFrom, yFrom, xTo, yTo))) ) {
							
						 desc[xTo][yTo] = desc[xFrom][yFrom];
					     desc[xFrom][yFrom] = null;
				
						 System.out.println(player + " player get " + desc[xTo][yTo] + " from: " + xFrom + " " + yFrom + "\nand set to: " + xTo + " " + yTo + "\n" + blackPcs + " Black and " + whitePcs + " White figures in game\n");
						 
						 next = true;
					  }
					
				    }
			  }
				
		  } while (!next);
		 
	}
	
	
	
	private void actions (String winColor, String moveColor, boolean winBool, boolean moveBool) {
	  
	         if (winner != "nobody") return;
	     winner = getWinner(board.doska, winColor, winBool);
		 if (winner != "nobody") return;
		 makeMove(board.doska, moveColor, moveBool, countWhite, countBlack);
	     countWhite = countPieces(board.doska, true);
		 countBlack = countPieces(board.doska, false);
	  
	}
		 
	
}



