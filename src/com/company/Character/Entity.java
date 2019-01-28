package com.company.Character;

import com.company.managerGame.MapManager;

import java.awt.*;
import java.util.ArrayList;

public abstract class Entity {
    public static final int left = 0;
    public static final int right = 1;
    public static final int up = 2;
    public static final int down = 3;

    protected int x, y;
    protected int speed = 1;
    protected int orient;
    protected Image [] [] image ;
    int index = 0;
    private Image images;
    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(ArrayList<MapManager> arrayList) {
        int xR = x;
        int yR = y;
        switch (orient) {
            case left: {
                x -= speed;
                break;
            }
            case right: {
                x += speed;
                break;
            }
            case up:
                y -= speed;
                break;
            case down:
                y += speed;
                break;
        }
        if(checkMap(arrayList)== false){
            x = xR;
            y = yR;
        }
    }
//    abstract boolean checkMap(ArrayList<MapManager>arrayList);
public boolean checkMap(ArrayList<MapManager> arrayList){
    for (MapManager map:arrayList) {
        if (map.getBit() == 0){
            continue;
        }
        Rectangle rect = getRect().intersection(map.getRect());
        if (rect.isEmpty() == false){
            return false;
        }
    }
    return true;
}
    Rectangle getRect() {
        if (images == null){
            return new Rectangle();
        }
        int w = images.getWidth(null);
        int h = images.getHeight(null);
        Rectangle rect = new Rectangle(x + 10, y +40, w - 20, h - 60 );
        return rect;
    }
    public void draw(Graphics2D g2d) {
        g2d.drawImage(images,x,y,null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}