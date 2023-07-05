package puzzle;

public class EndGame {
	public boolean gameOver(int game[]) {
	    boolean gameOver=true;

	    for(int i=0;i<game.length;i++){
	       if(i!=game[i]){
	           gameOver = false;
	       }
	    }
	    
	    return gameOver;
	    } 
	} 

