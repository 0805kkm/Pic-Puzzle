package puzzle;

import java.awt.Image;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

public class Shuffle {
	
	public Shuffle(int n,int game[],JButton btn[], BufferedImage img[], Image pic2) {
 		int row=n,col=n;
 		EndGame End = new EndGame();
        Random rnd = new Random();
     
        do{
        for(int i=0;i<row*col;i++)
               game[i] = 0;

        for(int i=0;i<row*col;i++){
               int temp = 0;
               do{
                  temp = rnd.nextInt(row*col);
               }while(game[temp]!=0);
                   game[temp] = i;
         }
     } while(End.gameOver(game));

        for(int i=0; i<row*col;i++){
           btn[i].setIcon(new ImageIcon(img[game[i]]));
           if(i==row*col-1) {
           btn[i].setIcon(new ImageIcon(pic2));
           }
        }
    }
}
