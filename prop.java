import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;



public class prop extends JFrame implements Runnable{
          
        Thread thread;
        Player player = new Player();   
        int Fps = 30; 
        BufferedImage img;  

    prop(){

        thread = new Thread(this);
      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1050, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        
        this.add(player);
        this.addKeyListener(player.input);
        
        thread.start();
        this.setVisible(true); 
    
    }

    void drawImage(){

    }

    
    
    public void update(){

        player.playerUpdate();
        
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/Fps;  // 0.1666 s
        double nextDrwaTime = System.nanoTime() + drawInterval;

       
       while (thread != null){
         update();
         repaint();

        ////////////////////////////   FPS   /////////////   UPDATE   ////////////////   FPS   //////////////   UPDATE   ///////////////////////
        try{
            double remainingTime = nextDrwaTime - System.nanoTime();
            remainingTime = remainingTime/1000000;
            if(remainingTime < 0){
               remainingTime = 0;
            }

            Thread.sleep((long) remainingTime);

            nextDrwaTime += drawInterval;
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     }
        
    }

    
}