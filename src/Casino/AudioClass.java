package Casino;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;


public class AudioClass extends JFrame{
	JProgressBar current;
	JTextArea out ; 
	Thread runner;
	int num = 0 ;
	AudioInputStream audioInputStream;
	Clip clip;
	int time;
	

	AudioClass(String file){
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Music Play");
		setSize(400,500);
	
	
		
		
		try {
	        audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        time = (int)(clip.getMicrosecondLength()/(1000000));
	        System.out.println((int)(clip.getMicrosecondLength()/(60*1000000)));
	       
	        
			current = new JProgressBar(1,time);
			current.setValue(1);
			System.out.println("Total Length Of the Song in Seconds"+current.getMaximum());
			current.setStringPainted(true);
			add(current);
			
			
			
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }

	}
		
		

	public void iterate(){
		while(num<current.getMaximum()){
			current.setValue(num);
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			num +=1;
		}
		}
		
}


