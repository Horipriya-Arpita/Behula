
public class Player2 {
    GamePanel gp;
    KeyInput kih;
    int x = 100;
    int y = 400;
    int speed = 7;
  
    
    
    public Player2(GamePanel gp, KeyInput kih) {
        this.gp = gp;
        this.kih = kih;
    }
    
    public void update() {
        
        
        if(kih.uppressed==true){
            //y -= speed;
            gp.vela.y -= speed;
        }
        else if(kih.downpressed==true){
            //y += speed;
            gp.vela.y += speed;
        }
        else if(kih.leftpressed==true){
            //x -= speed;
            gp.vela.x -= speed;
        }
        else if(kih.rightpressed==true){
            //x += speed;
            gp.vela.x += speed;
        }

        else if(kih.escpressed == true){
            gp.State = "Menu";
        }

    }
}
