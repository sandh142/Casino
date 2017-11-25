package Casino;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class laser extends JFrame implements KeyListener {
	
	public static void main (String[] args){
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		new laser();
	}
	static int score = 0;
	static boolean fire2 = false;
	static boolean wmd = false;
    static int deltax[] = {0,-1, 1, 0};
    static int deltay[] = {-1, 0, 0, 1};
	static int rand[] = { (int) (Math.floor(Math.random()*8+1)), (int) (Math.floor(Math.random()*8+1)), (int) (Math.floor(Math.random()*8+1)), (int) (Math.floor(Math.random()*8+1)), (int) (Math.floor(Math.random()*8+1)), (int) (Math.floor(Math.random()*8+1)), (int) Math.floor(Math.random()*8+1), (int) Math.floor(Math.random()*8+1), (int) (Math.floor(Math.random()*8+1)) };
	static Color[] colours = new Color[9];
	static Color[] colour =  {Color.BLACK, Color.blue, Color.WHITE, Color.magenta, (new Color (255,36,0)), Color.green, Color.cyan, (new Color (66,19,130)), Color.yellow};
	static Color[][] grid = new Color[14][23];
	static int energy = 0;
	static double pulse = 0;
	static double bullet = 0;
	static double clock = 0;
	static boolean fire = false;
	static boolean up = false;
	static boolean down = false;
	static boolean left = false;
	static boolean right = false;
	static int m = 16;
	static int n = 27;
	JLabel b[][];
	static int health = 15;
	static int centrex = 7;
	static int centrey = 19;
	static int ammo = 15;
	static boolean alive = true;
	static int num = 0;
	static Color[] bc = new Color[25];
	static int[] bx = new int[25];
	static int[] by = new int[25];
	static int tmp[][] = new int[14][23];
	static int count = 0;
	public laser(){
		for (int x = 0;x<25;x++){
			bx[x] = -5;
		    by[x] = -5;
		}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		b = new JLabel [m][n];
        setLayout(new GridLayout(n,m));
        for (int y = 0;y<n;y++){
            for (int x = 0;x<m;x++){
                    b[x][y] = new JLabel( );
                    b[x][y].setBackground(Color.BLACK);
                    add(b[x][y]);
                    b[x][y].setEnabled(true);
                    b[x][y].setOpaque(true);
                    b[x][y].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    b[x][y].setPreferredSize(new Dimension(50,25));
            }
    }
        setFocusable(true);
        addKeyListener(this);
        pack();
        setVisible(true);
        for (int y = 0;y<23;y++){
            grid[0][y] = Color.gray;
            grid[13][y] = Color.gray;
    }
    for (int x = 0;x<14;x++){
            grid[x][0] = Color.gray;
            grid[x][22] = Color.gray;
    }
        go();
	}
	
	public void colours(){
		int random = (int) (Math.floor(Math.random()*8+1));
		colours[8] = colours[7];
		colours[7] = colours[6];
		colours[6] = colours[5];
		colours[5] = colours[4];
		colours[4] = colours[3];
		colours[3] = colours[2];
		colours[2] = colours[1];
		colours[1] = colours[0];
		colours[0] = colour[random];
		for (int y = 0;y<9;y++){
			b[0][(y)*3].setBackground(colours[y]);
			b[0][(y)*3+1].setBackground(colours[y]);
			b[0][(y)*3+2].setBackground(colours[y]);
		}
	}
	
	public void combo(){
		for (int x = 0;x<12;x++){
			for (int y = 0;y<21;y++){
				if (grid[x+1][y+1] != Color.BLACK){
					count = 0;
				combochk(x, y, grid[x+1][y+1]);
					for (int x2 = 0;x2<12;x2++){
						for (int y2 = 0;y2<21;y2++){
							if (count > 3){
							if (tmp[x2+1][y2+1] == 1){
								grid[x2+1][y2+1] = Color.BLACK;
							}
						  }
							tmp[x2+1][y2+1] = 0;
						}	
				}
					if (count > 3){
						score++;
					energy+=6;
					}
			}}
		}
	}
	
	public void combochk(int x, int y, Color c){
        for (int a = 0;a<4;a++){
        	if ((grid[x+1+deltax[a]][y+1+deltay[a]] == c) && (tmp[x+deltax[a]+1][y+deltay[a]+1] == 0)){
        		tmp[x+deltax[a]+1][y+deltay[a]+1] = 1;
        		count++;
             combochk(x+deltax[a], y+deltay[a], c);
        }}}
	
	public void power(){
			for (int y = 0;y<27;y++){
				if ((27-energy) <= y){
					b[15][y].setBackground(Color.green);
				} else {
				b[15][y].setBackground(Color.red);
				}
			}
		}
	
	public void gen(){
		int randi;
		int geni;
		for (int x = 0;x<12;x++){
			for (int y = 19;y>=0;y--){
				grid[x+1][y+1+1] = grid[x+1][y+1];
			}
		}
		for (int x = 0; x<12;x++){
			geni = (int) (Math.floor(Math.random()*100+1));
			if (geni<50){
			randi = (int) (Math.floor(Math.random()*8+1));
			} else {
				randi = 0;
			}
			grid [x+1][1] = colour[randi];
		}
	}
	
	public void match(){
		for (int x = 0;x<12;x++){
			for (int y = 0;y<21;y++){
				b[x+2][y].setBackground(grid[x+1][y+1]);
			}
		}
	}
	
	public void go(){	
		setup();
		int time = 4000;
		clock = System.currentTimeMillis();
		bullet = System.currentTimeMillis(); 
		pulse = System.currentTimeMillis(); 
		do{
			if (health < 0){
				Component temporaryLostComponent = null;
				JOptionPane.showMessageDialog(temporaryLostComponent, "Game Over! You scored: "+score+". Well done!");
	            System.exit(0);
			}
			ship();
			if (System.currentTimeMillis()-pulse > time){
				if (time>1000){
				time-=10;
				}
			gen();
			match();
			pulse = System.currentTimeMillis();
			}
			if (System.currentTimeMillis()-clock > 300){
				regen();
				clock = System.currentTimeMillis();
			}
			if (System.currentTimeMillis()-bullet > 30){
				health();
				power();
				combo();
			projectile();
				bullet = System.currentTimeMillis();
			}
			if (up == true){
				up();
				up = false;
			}
			if  (down == true){
				down();
				down = false;
			}
			if (left == true){
				left();
				left = false;
			}
			if  (right == true){
				right();
				right = false;
			}
			if (fire == true){
				if ((ammo>0) && (num<25)){
				fire();
				colours();
				projectile();
				}
			}
				if (fire2 == true){
					wmd();
					fire2 = false;
				}
				fire = false;
		}while (alive == true);
	}
	
	public void wmd(){
		energy = 0;
		for (int x = 0;x<12;x++){
			for (int y = 0;y<21;y++){
				grid[x+1][y+1] = Color.BLACK;
			}
		}
	}
	
	public void regen(){
		if (ammo<12){
		ammo+=1;
		ammo(Color.blue);
		} else {
			ammo = 15;
			ammo(Color.blue);
		}
	}
	
	public void setup(){
		for (int x = 1;x<13;x++){
			for(int y = 1;y<22;y++){
				grid[x][y] = Color.BLACK;
			}
		}
		for (int x = 0;x<9;x++){
			colours[x] = colour[rand[x]];
		}
		for (int y = 0;y<9;y++){
			b[0][(y)*3].setBackground(colours[y]);
			b[0][(y)*3+1].setBackground(colours[y]);
			b[0][(y)*3+2].setBackground(colours[y]);
		}
		power();
		ship();
		health();
		ammo(Color.blue);
		gen();
		match();
	}
	
	public void ammo(Color l){
		for (int x = 1;x<ammo;x++){
			 b[x][26].setBackground(l);
			 b[x][25].setBackground(l);
		}
	}
	public void health(){
		for (int x = 1;x<15;x++){
			b[x][24].setBackground(Color.BLACK);	
		}
		for (int x = 1;x<health;x++){
			if (x<3){
				b[x][24].setBackground(Color.red);	
			} else {
			 b[x][24].setBackground(Color.green);
		}
			}
	}
	
	public void ship(){
		b[centrex+1][centrey].setBackground(Color.WHITE);
		b[centrex-1][centrey].setBackground(Color.WHITE);
		b[centrex][centrey-1].setBackground(Color.WHITE);
		b[centrex][centrey-2].setBackground(Color.WHITE);
		b[centrex+1][centrey-1].setBackground(Color.WHITE);
		b[centrex-1][centrey-1].setBackground(Color.WHITE);
	}
	
	public void fire(){
		num++;
		bx[num-1] = centrex;
		by[num-1] = centrey-3;
		bc[num-1] = colours[8];
		ammo(Color.orange);
		if (ammo>-1){
		ammo-=6;
		}
		ammo(Color.BLUE);
	}
	
	public void projectile(){
		boolean hit = false;
		Color tmpbc[] = new Color[25];
		int tmpbx[] = new int[25];
		int tmpby[] = new int[25];
		for (int y = 0;y<25;y++){
			tmpbc[y] = bc[y];
			tmpbx[y] = bx[y];
			tmpby[y] = by[y];
		}
		for (int x = 0;x<num;x++){
		if ((by[x] > 0) && (checkhit(bx[x],by[x]) == false)){
			b[bx[x]][by[x]].setBackground(Color.BLACK);
		} else {
        hit = true;
		if (hit == true){
			grid[bx[x]-2+1][by[x]+1] = bc[x];
			if(x < 25){
				if (x != 24){
			if (tmpbx[x+1] == -5){
				tmpbc[x] = null;
				tmpbx[x] = -5;
				tmpby[x] = -5;
			} else {
				for (int c = x;c<num;c++){
					tmpbc[c] = tmpbc[c+1];
					tmpbx[c] = tmpbx[c+1];
					tmpby[c] = tmpby[c+1];
				}
			}
			} else {
				tmpbc[x] = null;
				tmpbx[x] = -5;
				tmpby[x] = -5;
			}
			num--;
		}
			x--;
			for (int y = 0;y<25;y++){
				bc[y] = tmpbc[y];
				bx[y] = tmpbx[y];
				by[y] = tmpby[y];
			}
		}
		}
		}
		try {
			Thread.sleep(30L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int x = 0;x<num;x++){
			if ((by[x] > 0) && (checkhit(bx[x],by[x]) == false)){
		by[x]--;
		b[bx[x]][by[x]].setBackground(bc[x]);
			} 
		}
	}
	
	public boolean checkhit(int bx, int by){
		if(b[bx][by-1].getBackground() == Color.BLACK){
			return false;
		} else{
			return true;
		}
	}
	
	
	public void right(){
		if ((b[centrex+1+1][centrey].getBackground() != Color.BLACK) ||
		(b[centrex+1+1][centrey-1].getBackground() != Color.BLACK) ||
		(b[centrex+1][centrey-1-1].getBackground() != Color.BLACK)){
			health--;
		}
		b[centrex+1][centrey].setBackground(Color.BLACK);
		b[centrex-1][centrey].setBackground(Color.BLACK);
		b[centrex][centrey-1].setBackground(Color.BLACK);
		b[centrex][centrey-2].setBackground(Color.BLACK);
		b[centrex+1][centrey-1].setBackground(Color.BLACK);
		b[centrex-1][centrey-1].setBackground(Color.BLACK);
		centrex++;
		b[centrex+1][centrey].setBackground(Color.WHITE);
		b[centrex-1][centrey].setBackground(Color.WHITE);
		b[centrex][centrey-1].setBackground(Color.WHITE);
		b[centrex][centrey-2].setBackground(Color.WHITE);
		b[centrex+1][centrey-1].setBackground(Color.WHITE);
		b[centrex-1][centrey-1].setBackground(Color.WHITE);
	}
	
	public void left(){
		if ((b[centrex-1-1][centrey].getBackground() != Color.BLACK) ||
		(b[centrex-1][centrey-2].getBackground() != Color.BLACK) ||
		(b[centrex-1-1][centrey-1].getBackground() != Color.BLACK)){
			health--;
		}
		b[centrex+1][centrey].setBackground(Color.BLACK);
		b[centrex-1][centrey].setBackground(Color.BLACK);
		b[centrex][centrey-1].setBackground(Color.BLACK);
		b[centrex][centrey-2].setBackground(Color.BLACK);
		b[centrex+1][centrey-1].setBackground(Color.BLACK);
		b[centrex-1][centrey-1].setBackground(Color.BLACK);
		centrex--;
		b[centrex+1][centrey].setBackground(Color.WHITE);
		b[centrex-1][centrey].setBackground(Color.WHITE);
		b[centrex][centrey-1].setBackground(Color.WHITE);
		b[centrex][centrey-2].setBackground(Color.WHITE);
		b[centrex+1][centrey-1].setBackground(Color.WHITE);
		b[centrex-1][centrey-1].setBackground(Color.WHITE);
	}
	
	public void up(){
		if ((b[centrex+1][centrey-1-1].getBackground() != Color.BLACK) ||
		(b[centrex-1][centrey-1-1].getBackground() != Color.BLACK) ||
		(b[centrex][centrey-2-1].getBackground() != Color.BLACK)){
			health--;
		}
		b[centrex+1][centrey].setBackground(Color.BLACK);
		b[centrex-1][centrey].setBackground(Color.BLACK);
		b[centrex][centrey-1].setBackground(Color.BLACK);
		b[centrex][centrey-2].setBackground(Color.BLACK);
		b[centrex+1][centrey-1].setBackground(Color.BLACK);
		b[centrex-1][centrey-1].setBackground(Color.BLACK);
		centrey--;
		b[centrex+1][centrey].setBackground(Color.WHITE);
		b[centrex-1][centrey].setBackground(Color.WHITE);
		b[centrex][centrey-1].setBackground(Color.WHITE);
		b[centrex][centrey-2].setBackground(Color.WHITE);
		b[centrex+1][centrey-1].setBackground(Color.WHITE);
		b[centrex-1][centrey-1].setBackground(Color.WHITE);
	}
	
	public void down(){
		if ((b[centrex][centrey].getBackground() != Color.BLACK) ||
		(b[centrex-1][centrey+1].getBackground() != Color.BLACK) ||
		(b[centrex+1][centrey+1].getBackground() != Color.BLACK)){
			health--;
		}
		b[centrex+1][centrey].setBackground(Color.BLACK);
		b[centrex-1][centrey].setBackground(Color.BLACK);
		b[centrex][centrey-1].setBackground(Color.BLACK);
		b[centrex][centrey-2].setBackground(Color.BLACK);
		b[centrex+1][centrey-1].setBackground(Color.BLACK);
		b[centrex-1][centrey-1].setBackground(Color.BLACK);
		centrey++;
		b[centrex+1][centrey].setBackground(Color.WHITE);
		b[centrex-1][centrey].setBackground(Color.WHITE);
		b[centrex][centrey-1].setBackground(Color.WHITE);
		b[centrex][centrey-2].setBackground(Color.WHITE);
		b[centrex+1][centrey-1].setBackground(Color.WHITE);
		b[centrex-1][centrey-1].setBackground(Color.WHITE);
	}
	
	public boolean checkmove(int x, int y, int dx, int dy){
		if (((x-1+dx) > 0) && ((x+1+dx) < 15) && ((y-2+dy) > -1) && ((y+dy) < 24)){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER){		
			if (energy > 25){
				fire2 = true;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP){
				if (checkmove(centrex, centrey, 0,-1) == true){
				up = true;
				}
				} else if (e.getKeyCode() == 

KeyEvent.VK_RIGHT){
					if (checkmove(centrex, centrey, 1,0) == true){
					right = true;
					}
				} else if (e.getKeyCode() == 

KeyEvent.VK_LEFT){
					if (checkmove(centrex, centrey, -1,0) == true){
					left = true;
					}
				} else if (e.getKeyCode() == 

KeyEvent.VK_DOWN){
					if (checkmove(centrex, centrey, 0,1) == true){
					down = true;
					}
				}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			fire = true;
			}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}