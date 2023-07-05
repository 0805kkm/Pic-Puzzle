package puzzle;

import java.io.File;
import javax.sound.sampled.*;

public class Music {
	public Music(){
	       try {
	    	   		  File bgm=new File("bgm.wav");
	                  AudioInputStream ais = AudioSystem.getAudioInputStream(bgm);
	                  Clip clip = AudioSystem.getClip();
	                  clip.stop();
	                  clip.open(ais);
	                  clip.loop(3);
	                  clip.start();
	             }
	             catch (Exception ex) { }
	}

}
