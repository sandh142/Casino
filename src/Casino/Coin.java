package Casino;

import java.awt.FileDialog;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Coin extends Thread{

	/**
	 * @param args
	 */
	
		// TODO Auto-generated method stub
	
	int score = 500;
	int chances = 10;
Coin(JFrame j){
try {
	int random = (int)(Math.random()*2);
    //System.out.println(random);
	for(int i=0; i<10; i++){
		String input = JOptionPane.showInputDialog(null,"Please choose either heads or tail \n Heads = 0 , Tails = 1");
		int input1 = Integer.parseInt(input);
		if(input1 != random){
			score = score-100;
			chances--;
			JOptionPane.showMessageDialog(null,"Sorry! wrong choice"+"\n"+"Your score = "+score+"\n"+"Lives left = "+chances);
			System.out.println("Your score = "+score);
    		System.out.println("Lives left = "+chances);
		}
		else {
			score = score+200;
			JOptionPane.showMessageDialog(null,"Your score = "+score+"\n"+"Lives left = "+chances);
			System.out.println("Your score = "+score);
    		System.out.println("Lives left = "+chances);
		}
	}
}catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}}
public static void main(String[] args){
	JFrame f = new JFrame();
    int access = JOptionPane.showConfirmDialog(null,"Welcome to the coin game! \n Let's see how many times you could beat my system :) \n So, shall we begin?","Warning",JOptionPane.YES_NO_CANCEL_OPTION);
    if(access == 0){
	 Coin mt = new Coin(f);
    }else{
    	System.exit(0);
    }
}
}
