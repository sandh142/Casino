package Casino;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class TicTacToeGame extends JFrame implements MouseListener 
{
    JFrame f;
    int things=2;
    int n;
    int m;
    int i=0;
    char ch[]=new char[9];
    public TicTacToeGame()         
    {
        f=new JFrame("Tic Tac Toe Game");
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(600,600);
        f.addMouseListener(this); 
        for(i=0;i<9;i++)
        ch[i]='B';
    }
    public void mouseClicked(MouseEvent e)
    {
        Graphics g=f.getGraphics();
        g.drawLine(200,0,200,600);
        g.drawLine(400,0,400,600);
        g.drawLine(0,200,600,200);
        g.drawLine(0,400,600,400);
        things--;
        int x=e.getX();
        int y=e.getY();
        if(things==1)
        {
            if(x<200&&y<200)
            {m=0;n=0;ch[0]='R';}
            if((x>200&&x<400)&&(y<200))
            {m=200;n=0;ch[1]='R';}
            if((x>400&&x<600)&&(y<200))
            {m=400;n=0;ch[2]='R';}
            if(x<200&&(y>200&&y<400))
            {m=0;n=200;ch[3]='R';}
            if((x>200&&x<400)&&(y>200&&y<400))
            {m=200;n=200;ch[4]='R';}
            if((x>400&&x<600)&&(y>200&&y<400))
            {m=400;n=200;ch[5]='R';}
            if(x<200&&(y>400&&y<600))
            {m=0;n=400;ch[6]='R';}
            if((x>200&&x<400)&&(y>400&&y<600))
            {m=200;n=400;ch[7]='R';}
            if((x>400&&x<600)&&(y>400&&y<600))
            {m=400;n=400;ch[8]='R';}
            g.setColor(Color.red);
            g.drawLine(m,n,m+199,n+199);
            g.drawLine(m+199,n,m,n+199);
        }
         if(things==0)
        {
            if(x<200&&y<200)
            {m=0;n=20;ch[0]='P';}
            if((x>200&&x<400)&&(y<200))
            {m=200;n=20;ch[1]='P';}
            if((x>400&&x<600)&&(y<200))
            {m=400;n=20;ch[2]='P';}
            if(x<200&&(y>200&&y<400))
            {m=0;n=200;ch[3]='P';}
            if((x>200&&x<400)&&(y>200&&y<400))
            {m=200;n=200;ch[4]='P';}
            if((x>400&&x<600)&&(y>200&&y<400))
            {m=400;n=200;ch[5]='P';}
            if(x<200&&(y>400&&y<600))
            {m=0;n=400;ch[6]='P';}
            if((x>200&&x<400)&&(y>400&&y<600))
            {m=200;n=400;ch[7]='P';}
            if((x>400&&x<600)&&(y>400&&y<600))
            {m=400;n=400;ch[8]='P';}
            g.setColor(Color.blue);
            g.drawOval(m+10,n+10,169,169);
            things=things+2;
        }
          for(i=0;i<9;i++) 
        {
            if(ch[i]!='B')
           {
                if(i==8)
                draw();
            }
            else
            break;
        }
          for(i=0;i<3;i++)   
        {
             if(ch[i]!='B')
            {
                if((ch[i+3]==ch[i])&&(ch[i+6]==ch[i]))
                win();
            }
        }
          for(i=0;i<2;i++)   
          {
               if(ch[i]!='B')
              {
                  if((ch[i+2]==ch[i])&&(ch[i+4]==ch[i]))
                  lose();
              }
          }
        for(i=0;i<7;i++) 
        {
             if(ch[i]!='B')
            {
                if((ch[i]==ch[i+1])&&(ch[i]==ch[i+2]))
                win();
                i=i+2;
            }
            else
            i=i+2;
        }
         if(ch[4]!='B')  
        {
            if(((ch[0]==ch[4])&&(ch[4]==ch[8]))||((ch[2]==ch[4])&&(ch[4]==ch[6])))
            win();
        }
    else if(ch[4]!='B')  
    {
        if(((ch[0]==ch[4])&&(ch[4]!=ch[8]))||((ch[0]!=ch[4])&&(ch[4]==ch[8]))||((ch[0]==ch[8])&&(ch[4]!=ch[8]))||((ch[2]==ch[6])&&(ch[4]!=ch[6]))||((ch[2]==ch[4])&&(ch[4]!=ch[6]))||((ch[2]!=ch[4])&&(ch[4]==ch[6])))
        lose();
    }
      }
    public Frame win()
    {
    	JOptionPane.showMessageDialog(null,"Congratulations! you won");
    	return null;
    }
    public Frame lose()
    {
    	JOptionPane.showMessageDialog(null,"Sorry! you lose");
    	return null;
    }
    public Frame draw()
    {
        return null;
     }
    public void mouseReleased(MouseEvent e)
    {
        System.out.print("");
    }
     public void mouseEntered(MouseEvent e)
     {
        System.out.print("");
    }
    public void mouseExited(MouseEvent e)
    {
        System.out.print("");
    }
    public void mousePressed(MouseEvent e)
    {
        System.out.print("");
    }
	//@Override
	/*public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}*/
}