package Casino;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

 
/**
 * @author jaspreet
 *
 */
public class QLab4 extends JFrame implements ActionListener{

	
	int rand = (int)(Math.random()*100+1);
	ArrayList<JButton> jBu = new ArrayList<JButton>();
	int chance =10;
	
	JPanel pane = new JPanel();
	JFrame fr = new JFrame();
QLab4(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Game Play 'GOD'(Guess or Die)");
	
	fr.setVisible(true);
	fr.setLocation(800,0);
	fr.pack();
	fr.setSize(500,500);

	fr.setContentPane((Container) new JPanel().add(new JLabel("Welcome to the Game GOD")));
	
	  System.out.print(rand);
	GridLayout gd = new GridLayout(10,10);
    pane.setLayout(gd);
for(int i=0; i<100;i++){
	jBu.add(new JButton(String.valueOf(i+1)));
	jBu.get(i).addActionListener(this);;
	pane.add(jBu.get(i));
}
	setSize(600,500);
	setContentPane(pane);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
public void actionPerformed(ActionEvent ev) {
	// TODO Auto-generated method stub
  JButton src = (JButton)(ev.getSource());
  
  src.setBackground(Color.white);
 
    if(Integer.parseInt((((JButton)src).getText()))==rand){
    	 src.setBackground(Color.GREEN);
    	 
        JOptionPane.showMessageDialog(null, "You Won the Guess");
    	System.exit(0);
    	
    	
    }else if(Integer.parseInt(src.getText())<rand){
    	--chance;
    	Hangman hg = new Hangman();
    	hg.setChances(chance);
    	src.setEnabled(false);
    	hg.setLayout(new BorderLayout());
    	 src.setBackground(Color.white);
    	hg.add(new JLabel("Your number is less than computer's"),BorderLayout.SOUTH);
    	hg.add(new JLabel("Chances left: "+String.valueOf(chance-2)),BorderLayout.BEFORE_FIRST_LINE);
    	fr.setContentPane(hg);
    	fr.setVisible(true);
    	fr.setLocation(800,0);
    	fr.pack();
    	fr.setSize(500,500);
    	
    	
    	
    	
    	
    	
    	
    }else{
    	--chance;
    	Hangman hg = new Hangman();
    	hg.setChances(chance);
    	src.setEnabled(false);
    	hg.setLayout(new BorderLayout());
    	hg.add(new JLabel("Your number is greater than computer's"),BorderLayout.SOUTH);
    	hg.add(new JLabel("Chances Left: "+String.valueOf(chance-2)),BorderLayout.BEFORE_FIRST_LINE);
    	fr.setContentPane(hg);
    	fr.setVisible(true);
    	fr.setLocation(800,0);
    	fr.pack();
    	fr.setSize(500,500);
    	 src.setBackground(Color.BLUE);
    	
    }
}

}

