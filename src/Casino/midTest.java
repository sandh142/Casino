package Casino;
import java.awt.FileDialog;
import javax.swing.JFrame;
public class midTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    JFrame jf = new JFrame();
    
    FileDialog fd = new FileDialog(jf,"Pick an Audio File",FileDialog.LOAD);
    fd.setVisible(true);

	
		AudioClass mf = new AudioClass(fd.getDirectory()+fd.getFile());
        mf.setVisible(true);
     mf.iterate();
  
     QLab4 fram = new QLab4();
     fram.setVisible(true);
}
}
