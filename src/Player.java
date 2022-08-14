
import java.awt.Color;
import java.awt.Graphics2D;


public class Player {
    GamePanel gp;
    KeyInput kih;
    int x = 100;
    int y = 400;
    int speed = 4;
  
    
    private int fallingspeed = 0;
    private int gravity = 1;
    private int jumpPower = -25;
    
    public Player(GamePanel gp, KeyInput kih) {
        this.gp = gp;
        this.kih = kih;
    }
    
    public void update() {
        
        
        if(kih.uppressed==true){
            y -= speed;
            gp.playerd.y -= speed;
        }
        else if(kih.downpressed==true){
            y += speed;
            gp.playerd.y += speed;
        }
        else if(kih.leftpressed==true){
            x -= speed;
            gp.playerd.x -= speed;
        }
        else if(kih.rightpressed==true){
            x += speed;
            gp.playerd.x += speed;
        }

        else if(kih.escpressed == true){
            gp.State = "Menu";
        }

   
        if(isOnground()) {
            if(kih.spacepressed == true){
                jump();
                gp.score1++;
            }
        }
        else if(kih.spacepressed == false){

            fall();
        }

        else {
            fall();
        }
            
    }
    
    public void draw(Graphics2D g2) {
        
    }
    
    public boolean isOnground()
    {
        if(y+200 >= 590){
           return true; 
        }
        
        return false;
    }
    
    public void jump() {
        fallingspeed = jumpPower;
        fall();
    }
    
    public void fall()
    {
        y += fallingspeed;
        gp.playerd.y += fallingspeed;
        
        fallingspeed = fallingspeed + gravity;
    }
    
    
}
