import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
//import sun.audio.*;


public class GamePanel extends JPanel implements Runnable, ActionListener{
    
    static GamePanel gpanel = new GamePanel(); 
    private int space;
    private int space2;
    private int speed;
    private int speed2;
    private int width=100;
    private int height = 100;
    private int WIDTH = 1200;
    private int HEIGHT = 800;
    private int move = 20, move2 = 20, count = 0, count2 = 0;
    public int score1 = 0, score2 = 0;
    
    boolean pup=false;
    
    private int bg1x=0,dx=10,bg2y=0,fx,fy;
    
    boolean isdead = false;
    boolean isdead2 = false;
    
    int z = 0;
    int z2 = 0;
    int FPS = 60;
    
    JLabel water2;
    private BufferedImage front,back1,back2,player,behula1,behula2,behula3,behula4,stone,water,velab,vela1,vela2,tile,credit,guide,intro,stage1,stage2,endf,dead;
    public static Rectangle playerd;
    public static Rectangle vela; 
    
    public static Rectangle flag;
    
    private static ArrayList<Rectangle> stones;
    private static ArrayList<Rectangle> stones2;
    private Random rand;
    Timer t;
    public static String State = "Menu";
    Thread gameThread;
    
    NewMenu nmenu = new NewMenu();
    KeyInput keyh = new KeyInput();
    Player playerr = new Player(this,keyh);
    Player2 playerr2 = new Player2(this,keyh);
    
    public GamePanel() {
        init();
    }
    
    /*public static void music()
    {
        try{
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\b_music.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(0);
        } catch(UnsupportedAudioFileException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch(LineUnavailableException e){
            e.printStackTrace();
        }
        
    }*/
    
    public static void restart(){
                stones.clear();
                stones2.clear();
                gpanel.init();
                
    }
    public void init() {
        
        try {
            
            back1 = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\lev1_backf.png"));
            //back1 = ImageIO.read(new File("chobigula\\lev1_backf.png"));4
            //back1 = ImageIO.read(new File("JavaApp2D\\src\\chobigula\\lev1_backf.png"));
            front = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\backfinall.png"));
            
            back2 = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\river2.png"));
            behula1 = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\b1.png"));
            behula2 = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\b2.png"));
            behula3 = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\b3.png"));
            behula4 = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\b4.png"));
            stone = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\stone.png"));
            //velab = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\velaimg2.gif"));
            
            stage1 = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\stage1o.png"));
            stage2 = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\stage2o.png"));
            endf = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\end_final.png"));
            dead = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\deadf.png"));
            
            credit = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\creditf.png"));
            guide = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\guidefinal2.png"));
            intro = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\introfinal2.png"));
            
            vela1 = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\velaim01.png"));
            vela2 = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\velaim02.png"));
            stone = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\stoneimg.png"));
            tile = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\stoneimg.png"));
            //water = ImageIO.read(new File("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\watergif.gif"));
            water2 = new JLabel("", new ImageIcon("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\watergif.gif"),JLabel.CENTER);
            
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyh);
        this.setFocusable(true);
        this.addMouseListener(new MouseInput(this));
        
        t = new Timer(20,this);
        
        bg1x = 0;
        bg2y = 0;
        
        fx = 1220;
        fy = -30;
        space = 1200;
        space2 =700;
        speed = 2;
        speed2 =2;
        rand = new Random();
        
        stones = new ArrayList<Rectangle>();
        playerd = new Rectangle(playerr.x,playerr.y,130,200);
        
        stones2 = new ArrayList<Rectangle>();
        vela = new Rectangle(WIDTH/2-50, HEIGHT-210, 150, 200);
        
        
        //System.out.println("State is " + State);
        
        //if(State=="level1"){
        
        //}
        
        t.start();
     
        startGameThread();
    }
    
    public void addFlag(Graphics gp){
        
        stones.clear();
        flag = new Rectangle(fx, 450, 50, 200);
        fx = fx-5;
        //flag.x = flag.x-5;
        gp.setColor(Color.white);
        gp.fillRect(flag.x, flag.y, 50, 200);
    }
    
    public void addFlag2(Graphics gp){
        
        stones2.clear();
        flag = new Rectangle(0, fy, 1200, 60);
        fy = fy+7;
        //flag.x = flag.x-5;
        gp.setColor(Color.white);
        gp.fillRect(flag.x, flag.y, 1200, 60);
    }

    public void addstones(boolean first){
        //score1++;
        int x=0;
        int y=0;
        int Width = 50;
        int Height = 50;
        int positiony = rand.nextInt()%2;
        int sp = 500+rand.nextInt()%300; 
        
        
        if(positiony==0){
            y = 550;
        }
        else {
            y = 550;
        }
        
        if(first){
            stones.add(new Rectangle(x+1000+stones.size()*space+ sp,y,Width,Height));
        }
        else {
            stones.add(new Rectangle(stones.get(stones.size()-1).x+sp,y,Width,Height));
        }
    }
    
    public void addstones2(boolean second)
    {
        int positionx = rand.nextInt()%6  ;
        int x = 0;
        int y = 0;
        int Width = 50;
        int Height = 50;
        int sp = 100+rand.nextInt()%100;
        
        if(positionx == 0){
            x = 200;
        }
        else if(positionx == 1){
            x = 350;
        }
        
        else if(positionx == 2){
            x = 500;
        }
        else if(positionx == 3){
            x = 650;
        }
        else if(positionx == 4){
            x = 800;
        }
        else {
            x = 950;
        }
        if(second){
            stones2.add(new Rectangle(x, y-100-(stones2.size()*space2), Width, Height));
        }
        else {
            stones2.add(new Rectangle(x,stones2.get(stones2.size()-1).y-sp,Width,Height));
        }
    }
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while(gameThread != null)
        {
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            
            if(timer >= 1000000000) {
                drawCount = 0;
                timer = 0;
            }
        }
    }
    
    public void update() {

        if(State == "level1"){
            playerr.update();
            //music();
        }
        
        if(State == "level2"){
            playerr2.update();
            
        }
        
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        
        switch(State){
            
            case "stage1":
                g.drawImage(stage1,0,0,this);
                //nmenu.render(g);
                break;
               
            case "stage2":
                g.drawImage(stage2,0,0,this);
                //nmenu.render(g);
                break;
                
            case "dead":
                g.drawImage(dead,0,0,this);
                //nmenu.render(g);
                break;
                
            case "end":
                g.drawImage(endf,0,0,this);
                //nmenu.render(g);
                break;
                
                
            case "level1":
                this.add(water2);
                gameUpdate1(g);
                break;
             
            case "level2":
                this.add(water2);
                gameUpdate2(g);
                break;
                
            case "Menu":
                //JLabel label = new JLabel("");
                //ImageIcon im = new ImageIcon("F:\\New Folder (2)\\JavaApp2D\\src\\chobigula\\watergif.gif");
                //label.setBounds(100,45,350,200);
                //label.setIcon(im);
                //this.add(label);
                score1=0;
                score2=0;
                //super.paintComponent(g);
                g.drawImage(front,0,0,this);
                //nmenu.render(g);
                break;
                
            case "credit":
                score1=0;
                score2=0;
                g.drawImage(credit,0,0,this);
                //nmenu.render(g);
                break;
               
            case "guide":
                score1=0;
                score2=0;
                g.drawImage(guide,0,0,this);
                //nmenu.render(g);
                break;
               
            case "intro":
                score1=0;
                score2=0;
                g.drawImage(intro,0,0,this);
                //nmenu.render(g);
                break;
               
                
        }
        
        
    }
    
    public void gameUpdate1(Graphics g){
        
        super.paintComponent(g);
        Graphics2D gp = (Graphics2D)g;   

        
        gp.drawImage(back1,bg1x,0,this);
        gp.drawImage(back1,bg1x+back1.getWidth(),0,this);
        bg1x = bg1x-7;
        
        if(bg1x < - back1.getWidth()){
            bg1x=0;
        }
        
        Font fnt0 = new Font("arial",Font.BOLD,20);
        gp.setFont(fnt0);
        gp.setColor(Color.red);
        gp.drawString("Score : ", 50, 20);
        String s = Integer.toString(score1);
        gp.drawString(s,150,20);
        
        
        //gp.setColor(Color.white);
        //gp.fillRect(0, 650, WIDTH, 200);
        
        //gp.setColor(Color.orange);
        //gp.fillRect(0, 600, WIDTH, 250);

        gp.drawImage(player,playerr.x,playerr.y,this);
        
        if(score1>5){
            addFlag(gp);
        }
        
        
        
        addstones(true);
        addstones(true);
        addstones(true);
        addstones(true);
        addstones(true);
        addstones(true);
        addstones(true);

        for(Rectangle rect: stones){
            //gp.setColor(Color.green.darker());
            //gp.fillRect(rect.x, rect.y, rect.width, rect.height);
            gp.drawImage(stone,rect.x,rect.y,this);
        }
        gp.dispose();
        
       
    }
    
    public void gameUpdate2(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D gp2 = (Graphics2D)g;   
        
        
        gp2.drawImage(back2,0,bg2y,this);
        gp2.drawImage(back2,0,bg2y-back2.getHeight(),this);
        //gp2.drawImage(back2,0,bg2y+1600,this);
        bg2y = bg2y + 7;
        
        if(bg2y > back2.getHeight()){
            bg2y = 0;
        }
        
        //gp2.setColor(Color.red);
        //gp2.fillRect(vela.x,vela.y,vela.width,vela.height);
        //System.out.println("score2 g : " + score2);
        Font fnt0 = new Font("arial",Font.BOLD,30);
        gp2.setFont(fnt0);
        gp2.setColor(Color.red);
        gp2.drawString("Score : ", 140, 30);
        String s = Integer.toString(score2);
        gp2.drawString(s,250,30);
        
        gp2.drawImage(velab,vela.x,vela.y,this);
        //gp2.setColor(Color.red);
        //gp2.fillRect(vela.x,vela.y,150,vela.height);
        
        if(score2>5){
            addFlag2(gp2);
        }
        
        addstones2(true);
        addstones2(true);
        addstones2(true);
        addstones2(true);
        addstones2(true);
        addstones2(true);
        addstones2(true);
        
        //gp2.setColor(Color.MAGENTA);
        for(Rectangle rect2:stones2) {
            //gp2.fillRect(rect2.x, rect2.y, rect2.width, rect2.height);
            gp2.drawImage(stone,rect2.x,rect2.y,this);
        }

        
    }

    
    public void stoneUpdate1()
    {
    
        if(fx<playerr.x){
            restart();
            repaint();
            fx=1200;
            GamePanel.State = "stage2";
        }
        
        Rectangle rect;
        count++;
        for(int i = 0; i < stones.size(); i++)
        {
            rect=stones.get(i);
            if(count % 1000== 0)
            {
                speed++;
                if(move < 50) move+=1;
            }
            
            rect.x-=speed;
           
        }
        
        for(Rectangle r:stones)
        {
            if(r.intersects(playerd)){
                GamePanel.State = "dead";
            }
        }
        for(int i = 0; i <stones.size(); i++)
        {
            rect=stones.get(i);
            if(rect.x + 50 < 0 )
            {
                stones.remove(rect);
                addstones(false);
                
            }
            
        }
    }
    
    public void stoneUpdate2()
    {
        if(fy>vela.y){
            restart();
            repaint();
            fy=-30;
            GamePanel.State = "end";
        }
        
        Rectangle rect2;
        count2++;
        for(int i = 0; i < stones2.size(); i++)
        {
            rect2=stones2.get(i);
            if(count2 % 1000 == 0)
            {
                speed2++;
                if(move2 < 50) move2+=10;
            }
            rect2.y+=speed2;
        }
        
        for(Rectangle r:stones2)
        {
            if(r.y > 800){
                score2++;
                //System.out.println("score2 stu : " + score2);
            }
            if(r.intersects(vela)){
                GamePanel.State = "dead";
                isdead2 = true;
            }
        }
        for(int i = 0; i <stones2.size(); i++)
        {
            rect2=stones2.get(i);
            if(rect2.y+rect2.height>HEIGHT )
            {
                score2++;
                //System.out.println("score2 stu : " + score2);
                stones2.remove(rect2);
                addstones2(false);
            }
        }
        
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        
        z++;
        switch(z)
        {
            case 1:
            {
                player = behula1;
                break;
            }
            
            case 5:
            {
                player = behula2;
                break;
            }
            
            case 10:
            {
                player = behula3;
                break;
            }
            
            case 15:
            {
                player = behula4;
                break;
            }
               
        }
        if(z==20)
        {
            z=0;
        }
        
        z2++;
        switch(z2)
        {
            case 1:
            {
                velab = vela1;
                break;
            }
            
            case 5:
            {
                velab = vela2;
                break;
            }
            
               
        }
        if(z2==10)
        {
            z2=0;
        }
        
        
        speed = 7;
        speed2 = 7;
        

        
        stoneUpdate1();
        stoneUpdate2();

        
        repaint();
    }
}