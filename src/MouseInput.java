
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInput implements MouseListener{

    GamePanel gp;
    public MouseInput(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void mousePressed(MouseEvent e) {
       /*
        public Rectangle playButton = new Rectangle(520,430,190,60);
        */
        int mx = e.getX();
        int my = e.getY();
        
        //480,350,250,50
        
        if(GamePanel.State=="Menu")
        {
            if(mx>=480 && mx<=730)
            {
                if(my>=350 && my<=400)
                {
                    //gp.restart();
                    gp.State = "stage1";
                    /*gp.restart();
                    gp.State = "level1";
                    //new GamePanel().isdead = false;
                    //new GamePanel().check1(GamePanel.State,new GamePanel().isdead);
                    System.out.println("restarted1");*/
                    
                }
            }
            
            if(my>=650 && my<=710)
            {
                if(mx>=340 && mx<=590)
                {
                    //System.out.println("intro");
                    gp.restart();
                    gp.State = "intro";
                    
                }
                
                if(mx>=50 && mx<=300)//(50,650,250,60);
                {
                    //System.out.println("guide");
                    gp.State = "guide";
                    
                }
                
                if(mx>=640 && mx<=860)
                {
                    //System.out.println("credit");
                    gp.State = "credit";
                    
                }
                
                if(mx>=920 && mx<=1140)
                {
                    System.exit(1);
                    
                }
            }
   
        }
        
        /*
        public Rectangle playButton = new Rectangle(520,430,190,60);
        */
        
        if(GamePanel.State == "credit")
        {
            if(mx>=520 && mx<=710)
            {
                if(my>=430 && my<=490)
                {
                    gp.State = "Menu";
                    
                }
            }
        }
        /*
        public Rectangle guideButton = new Rectangle(50,610,250,80);
        */
        if(GamePanel.State == "guide")
        {
            if(mx>=50 && mx<=300)
            {
                if(my>=610 && my<=690)
                {
                    gp.State = "Menu";
                    
                }
            }
        }
        
        /*
        (50,550,250,60);
        */
        
        if(GamePanel.State == "intro")
        {
            if(mx>=50 && mx<=300)
            {
                if(my>=550 && my<=610)
                {
                    gp.State = "Menu";
                    gp.restart();
                    
                }
            }
        }
        //0,330,1200,150);
        if(GamePanel.State == "stage1")
        {
            if(mx>=0 && mx<=1200)
            {
                if(my>=330 && my<=480)
                {
                    gp.restart();
                    gp.State = "level1";
                    //new GamePanel().isdead = false;
                    //new GamePanel().check1(GamePanel.State,new GamePanel().isdead);
                    //System.out.println("restarted1");                    
                }
            }
        }
        
        if(GamePanel.State == "stage2")
        {
            if(mx>=0 && mx<=1200)
            {
                if(my>=330 && my<=480)
                {
                    gp.restart();
                    gp.State = "level2";
                    //new GamePanel().isdead = false;
                    //new GamePanel().check1(GamePanel.State,new GamePanel().isdead);
                    //System.out.println("restarted1");  
                }
            }
        }
        //450,90,300,80);
        
        if(GamePanel.State == "dead")
        {
            if(mx>=450 && mx<=750)
            {
                if(my>=90 && my<=170)
                {
                    gp.restart();
                    gp.State = "Menu";
                    
                    
                    
                    // test
                    
                }
            }
        }
        //450,90,300,150
        if(GamePanel.State == "end")
        {
            if(mx>=450 && mx<=750)
            {
                if(my>=90 && my<=240)
                {
                    gp.restart();
                    gp.State = "Menu";
                    
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
