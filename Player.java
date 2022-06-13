import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Player extends JPanel{

    public int PosX;
    public int PosY;
    int playerSpeed = 10;
    public boolean dirRight = false;
    public boolean dirLeft = false;
    String direction = "right";
    keyInput input = new keyInput();
    BufferedImage img1, img2;

    Player(){
       
        PosX = 100;
        PosY = 450;

        try {
            img1 = ImageIO.read(new File("Frog.gif"));
            img2 = ImageIO.read(new File("FrogLeft.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void playerUpdate(){
        
        if(dirRight == true && PosX <= 1050 - img1.getWidth())
        {
            PosX += playerSpeed;
            direction = "right";
        }
        if(dirLeft == true && PosX >= 0)
        {
            PosX -= playerSpeed;
            direction = "left";
        }
    }


    public void paint(Graphics g){

        BufferedImage currentImg = img1;
       
        Graphics2D g2d = (Graphics2D) g;

        switch (direction) {
            case "right":
                  currentImg = img1;
                break;
            case "left":
                  currentImg = img2;
                break;        
        
            default:
                break;
        }

        g2d.drawImage(currentImg, PosX, PosY, this);

        g2d.dispose();
    }
    


    /////////////////////////////////////////////////////  INPUT  ////////////////////////////////////////////////////////////////
    public class keyInput implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
           if(e.getKeyChar() == 'd'){
            dirRight = true;
          }
            if(e.getKeyChar() == 'a'){
             dirLeft = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyChar() == 'd'){
                dirRight = false;
              }
            if(e.getKeyChar() == 'a'){
                dirLeft = false;
              }
        }
    
    
        
    }



}
