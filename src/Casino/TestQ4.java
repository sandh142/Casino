package Casino;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestQ4 extends JFrame {

     
    TestQ4(){
    	
    	JPanel jp = new JPanel();
    	jp.setSize(1100,1100);
    	jp.setBounds(45, 100, 500, 300);
    	ImageIcon img1 = new ImageIcon("D:\\Java3\\images\\Capture1.jpg");
		jp.add(new JLabel(img1));
		ImageIcon img2 = new ImageIcon("D:\\Java3\\images\\Capture.jpg");
		jp.add(new JLabel(img2));
		ImageIcon i1 = new ImageIcon("D:\\Java3\\week3\\Capture2.jpg");
		JButton b1 = new JButton(i1);
		ImageIcon i2 = new ImageIcon("D:\\Java3\\week3\\Capture4.jpg");
		JButton b2 = new JButton(i2);
		ImageIcon i3 = new ImageIcon("D:\\Java3\\week3\\Capture5.jpg");
		JButton b3 = new JButton(i3);
		ImageIcon i4 = new ImageIcon("D:\\Java3\\week3\\Capture3.jpg");
		JButton b4 = new JButton(i4);
    		jp.add(b1, BorderLayout.SOUTH);
    		jp.add(b2, BorderLayout.SOUTH);
    		jp.add(b3, BorderLayout.SOUTH);
    		jp.add(b4, BorderLayout.SOUTH);
      
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setContentPane(jp);
    	setVisible(true);
    	
    	
    	
    	
    	
    	
    	
    }
    
    
    
    
    
    
      	
	
}
