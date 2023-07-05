package puzzle;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class PicPuzzle extends JFrame implements ActionListener {

    JButton btn[];
    int game[];
    Image pic;
    Image pic2;
    BufferedImage img[];
    int clickCount;
    int firstNum;
    int secondNum;
    int count;				
	long S_Timer;
	public long Timer;
	EndGame endgame = new EndGame();
   
    public PicPuzzle(int n) {
    	int row=n,col=n;
       MediaTracker tracker = new MediaTracker(this);
       pic = Toolkit.getDefaultToolkit().getImage("Horder.jpg");
       pic2 = Toolkit.getDefaultToolkit().getImage("white.jpg");
       tracker.addImage(pic, 0);
       tracker.addImage(pic2, 0);
            try { 
                  tracker.waitForAll(); 
            }
            catch (InterruptedException e) { }
            int width = pic.getWidth(this)/col;
            int height = pic.getHeight(this)/row;
            setSize(new Dimension(width*col,height*row));

            img = new BufferedImage[row*col];
            int cnt=0;
            for(int i=0;i<row;i++){
               for(int j=0;j<col;j++){
                   img[cnt] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
                   Graphics g = img[cnt].getGraphics();
                   g.drawImage(pic, 0, 0, width, height,
                                    j*width, i*height,(j+1)*width, (i+1)*height,this);
                   cnt++;
                }
             }
             
             game = new int[row*col];

             btn = new JButton[row*col];
             for(int i=0;i<row*col;i++){
                 btn[i] = new JButton();
                 btn[i].addActionListener(this);
                 add(btn[i]);
             }
             Shuffle shuffle = new Shuffle(n, game, btn, img, pic2);
             Music bgm = new Music();
            
             S_Timer = System.currentTimeMillis();
             setLayout(new GridLayout(row,col));
             setTitle("시원한 바다 퍼즐 게임");
             setLocation(500,100);
             setResizable(false);
             setVisible(true);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
         }

public void actionPerformed(ActionEvent e) {

       JButton curBtn = (JButton)e.getSource();
       

       for(int i=0; i < btn.length; i++){
         if(curBtn.getIcon().equals(btn[i].getIcon())){
            secondNum = i;
            break;
         }
       }

       if(clickCount==0){
          clickCount++;
          firstNum = secondNum;
       } else {
          if(firstNum!=secondNum){
         Icon c=btn[firstNum].getIcon();
         Icon a=btn[secondNum].getIcon();
         btn[firstNum].setIcon(a);
         btn[secondNum].setIcon(c);
       

         int t = game[firstNum];
         game[firstNum] = game[secondNum];
         game[secondNum] = t;
         count++;
         if(endgame.gameOver(game)){
             long E_Timer = System.currentTimeMillis();
     		Timer = (E_Timer - S_Timer) / 1000;
          JOptionPane.showMessageDialog(this, "퍼즐 완성!"+" 옮긴횟수: "+count+"번,"+" 걸린 시간: "+Timer+"초");

        }

         }
          clickCount = 0;
     }   
   }   
}

