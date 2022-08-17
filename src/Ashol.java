
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Ashol extends JFrame{

    
    
    public static void main(String[] args) {
        JFrame win = new JFrame();
        
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        win.setTitle("Behula - Lokhindar");
        
        GamePanel gamePanel = new GamePanel();
        
        win.add(gamePanel);
        win.pack();
        win.setLocationRelativeTo(null);
        win.setVisible(true);
        
       
    }
    
}
