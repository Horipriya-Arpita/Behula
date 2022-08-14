
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{

    public boolean uppressed, downpressed, leftpressed, rightpressed, escpressed, spacepressed;
    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void keyPressed(KeyEvent ke) {
        
        int code = ke.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            uppressed = true;
            //System.out.println("preesseed");
        }
        else if(code == KeyEvent.VK_S){
            downpressed = true;
            //System.out.println("preesseed");
        }
        else if(code == KeyEvent.VK_A){
            leftpressed = true;
            //System.out.println("preesseed");
        }
        else if(code == KeyEvent.VK_D){
            rightpressed = true;
            //System.out.println("preesseed");
        }
        
        else if(code == KeyEvent.VK_SPACE){
            spacepressed = true;
            //System.out.println("preesseed");
        } 
        else if(code == KeyEvent.VK_ESCAPE){
            escpressed = true;
            //System.out.println("preesseed");
        }
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int code = ke.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            uppressed = false;
        }
        else if(code == KeyEvent.VK_S){
            downpressed = false;
        }
        else if(code == KeyEvent.VK_A){
            leftpressed = false;
        }
        else if(code == KeyEvent.VK_D){
            rightpressed = false;
        }
        else if(code == KeyEvent.VK_SPACE){
            spacepressed = false;
        } 
        else if(code == KeyEvent.VK_ESCAPE){
            escpressed = false;
        }
    }
    
}
