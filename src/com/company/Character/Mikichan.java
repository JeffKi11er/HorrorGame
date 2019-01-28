package com.company.Character;



import com.company.mainGame.MainFrame;
import com.company.managerGame.MapManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static com.company.mainGame.MainFrame.Width;

public class Mikichan extends Entity {
    public int count =0;
    private Image[] imagesRight = {
            new ImageIcon(getClass().getResource("/map/tile008.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/tile009.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/tile010.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/tile011.png")).getImage()
    };
    private Image[] imagesLeft = {
            new ImageIcon(getClass().getResource("/map/tile004.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/tile005.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/tile006.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/tile007.png")).getImage(),
    };
    private Image[] imagesUp = {
            new ImageIcon(getClass().getResource("/map/tile012.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/tile013.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/tile014.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/tile015.png")).getImage(),
    };
    private Image[] imagesDown = {
            new ImageIcon(getClass().getResource("/map/tile000.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/tile001.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/tile002.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/tile003.png")).getImage(),
    };
    private Graphics2D graphics2D;
    private BufferedImage player;
    public Mikichan(int x, int y) {
        super(x, y);
        orient = down;


    }
    Image [] [] images = { imagesLeft,imagesRight, imagesUp, imagesDown};
    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(images[orient][index],x,y,null);
    }
    public void move(ArrayList<MapManager>arrayList) {
        count++;
        if(count >= 5){
            index++;
            if(index >= images[orient].length) {
                index = 0;
            }
            count = 0;
        }
    }

    public void changeOrient(int NewOrient){orient = NewOrient;}
    //public void changeOrient(int Neworient){ orient = Neworient;}
    public void movePosition(ArrayList<MapManager>arrayList){super.move(arrayList);}
    public boolean isCenter(){return x == MainFrame.Width/3;}
//    boolean checkMap(ArrayList<MapManager>mapManagers){
//        for (MapManager mapManager:mapManagers) {
//            if(mapManager.bit==3){
//                continue;
//            }
//            Rectangle rect = getRect().intersection(mapManager.getRect());
//            if (rect.isEmpty() == false) {
//                return false;
//            }
//        }return true;
//    }
    Rectangle getRect() {
        if (images == null){
            return new Rectangle();
        }
        int w = images[orient][index].getWidth(null);
        int h = images[orient][index].getHeight(null);
        Rectangle rect = new Rectangle(x + 10, y +40, w - 20, h - 60 );
        return rect;
    }

}
