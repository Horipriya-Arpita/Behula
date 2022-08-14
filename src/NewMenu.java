
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class NewMenu {

    
    public Rectangle playButton = new Rectangle(480,350,250,50);
    public Rectangle introButton = new Rectangle(450,90,300,150);
    //public Rectangle guideButton = new Rectangle(50,610,250,80);//guide back
    //public Rectangle guideButton = new Rectangle(50,650,250,60);//menu guide
    public Rectangle guideButton = new Rectangle(50,550,250,60);
    public Rectangle creditButton = new Rectangle(640,650,220,60);
    public Rectangle exitButton = new Rectangle(920,650,220,60);
    
    public void render(Graphics g){
        
        Graphics2D g2 = (Graphics2D)g;
        //g2.drawImage(front,0,0, (ImageObserver) this);
        
        Font fnt0 = new Font("arial",Font.BOLD,50);
        g2.setFont(fnt0);
        g2.setColor(Color.red);
        g2.drawString("O Behula", 600, 100);
        
        Font fnt1 = new Font("arial",Font.BOLD,30);
        g2.setFont(fnt1);
        g2.setColor(Color.white);
        g2.drawString("Play", playButton.x + 19, playButton.y + 30);
        g2.draw(playButton);
        
        g2.drawString("Intro", introButton.x + 19, introButton.y + 30);
        g2.draw(introButton);
        
        g2.drawString("Guide", guideButton.x + 19, guideButton.y + 30);
        g2.draw(guideButton);
        
        g2.drawString("Credit", creditButton.x + 19, creditButton.y + 30);
        g2.draw(creditButton);
        
        g2.drawString("Exit", exitButton.x + 19, exitButton.y + 30);
        g2.draw(exitButton);
    }
}
