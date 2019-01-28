package com.company.managerGame;

import com.company.Character.Entity;
import com.company.mainGame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.company.Character.Entity.*;

public class MapManager {
    public int x;
    public int y;

    public int getBit() {
        return bit;
    }

    public int bit;
    Image[] img = {
            new ImageIcon(getClass()
                    .getResource("/map/Webp.net-resizeimage (1).png")).getImage(),
            new ImageIcon(getClass()
                    .getResource("/map/Webp.net-resizeimage (2).png")).getImage(),
            new ImageIcon(getClass()
                    .getResource("/map/divanHospital.png")).getImage(),
            new ImageIcon(getClass()
                    .getResource("/map/Webp.net-resizeimage (3).png")).getImage(),
            new ImageIcon(getClass()
                    .getResource("/map/Webp.net-resizeimage (4).png")).getImage(),
            new ImageIcon(getClass().getResource("/map/Webp.net-resizeimage (3) (1).png")).getImage()
    };

    public MapManager(int x, int y, int bit) {
        this.x = x;
        this.y = y;
        this.bit = bit;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(img[bit], x, y, null);
    }
//    public void checkOracle(){
//        if(bit == 3 ){
//            return;
//        }
//}
    public boolean boundStart(){return x>=0;}
    public boolean boundEnd(){return x<= MainFrame.Width; }
    public void move(int NewOrient){switch (NewOrient) {
        case Entity.left: {
            x ++;
            break;
        }
        case Entity.right: {
            x --;
            break;
        }
        case Entity.up:
            y ++;
            break;
        case Entity.down:
            y --;
            break;
        }
    }
    public Rectangle getRect() {
        if (img == null){
            return new Rectangle();
        }
            int w = img[bit].getWidth(null);
            int h = img[bit].getHeight(null);
            Rectangle rect = new Rectangle(x, y, w, h);
            return rect;
    }
}
