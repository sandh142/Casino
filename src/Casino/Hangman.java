package Casino;
import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman extends JPanel {
	
	int chances;
	public int setChances(int i){
		chances = i;
		return chances;
	}
	public int getChances(){
		return chances;
	}
	
	
	public void paintComponent(Graphics g){
		Graphics2D gd = (Graphics2D)g;
	
		
		if(getChances() == 9){
		gd.fillRect(140, 300, 100, 100); 
		}
		
		if(getChances()==8){// Box Standing
			gd.fillRect(140, 300, 100, 100); 
			gd.fillOval(180, 0,20,70);
		}

		if(getChances()==7){
			gd.fillRect(140, 300, 100, 100);
			gd.fillOval(180, 0,20,70); // This is Face
			gd.drawLine(190, 70, 190,200); // Body
			
		}

		if(getChances()==6){
			gd.fillRect(140, 300, 100, 100);
			gd.fillOval(180, 0,20,70); // This is Face
			gd.drawLine(190, 70, 190,200); // Body
			gd.drawLine(190, 90, 120, 90);  // left Arm
		}else if(getChances()==5){
			gd.fillRect(140, 300, 100, 100);
			gd.fillOval(180, 0,20,70); // This is Face
			gd.drawLine(190, 70, 190,200); // Body
			gd.drawLine(190, 90, 120, 90);  // left Arm
			gd.drawLine(190, 90, 250, 90); // right arm
		}else if(chances ==4){
			gd.fillRect(140, 300, 100, 100);
			gd.fillOval(180, 0,20,70); // This is Face
			gd.drawLine(190, 70, 190,200); // Body
			gd.drawLine(190, 90, 120, 90);  // left Arm
			gd.drawLine(190, 90, 250, 90); // right arm
			gd.drawLine(190, 200, 150, 300); // left leg
			
		}else if(chances == 3){
			gd.fillRect(140, 300, 100, 100);
			gd.fillOval(180, 0,20,70); // This is Face
			gd.drawLine(190, 70, 190,200); // Body
			gd.drawLine(190, 90, 120, 90);  // left Arm
			gd.drawLine(190, 90, 250, 90); // right arm
			gd.drawLine(190, 200, 150, 300); // left leg
			gd.drawLine(190,200,230,300);// right leg
			
		}else if(chances==2){
			gd.fillRect(140, 300, 100, 100);
			gd.fillOval(180, 0,20,70); // This is Face
			gd.drawLine(190, 70, 190,200); // Body
			gd.drawLine(190, 90, 120, 90);  // left Arm
			gd.drawLine(190, 90, 250, 90); // right arm
			gd.drawLine(190, 200, 150, 300); // left leg
			gd.drawLine(190,200,230,300);// right leg
			gd.drawArc(154, 0,70,90, 0,-180);
		}else if(chances == 1){
			gd.fillOval(180, 20,20,70); // This is Face
			gd.drawLine(190, 90, 190,220); // Body
			gd.drawLine(190, 110, 150, 160);  // left Arm
			gd.drawLine(190, 110, 230, 160); // right arm
			gd.drawLine(190, 220, 180, 320); // left leg
			gd.drawLine(190,220,200,320);// right leg
			gd.drawArc(154, 0,70,90, 0,-180);
			JOptionPane.showMessageDialog(null, "Game over Buddy! Die");
			System.exit(0);
		}
		
	}
	
	
	

}

