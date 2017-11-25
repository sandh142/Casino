package Casino;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RunTTT {
	 public static void main(String args [])
	    {
		 JOptionPane.showConfirmDialog(null,"Welcome to my world! \n Wanna play our new multiplayer game?","Warning",JOptionPane.YES_NO_CANCEL_OPTION);
		 JOptionPane.showMessageDialog(null,"This game is known as Tic Tac Toe \n Click ok to start."); 
		 TicTacToeGame ttt = new TicTacToeGame();
	       ttt.setVisible(false);
	    }
}
