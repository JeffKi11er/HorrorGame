package com.company.managerGame;

import com.company.mainGame.MainFrame;

import javax.swing.*;
import java.awt.*;

public class StateManager {
    int x;
    int y;
    int bit;
    Image [] img = {
            new ImageIcon(getClass().getResource("/map/fonHospitalOperate.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/fonHospitalReanim.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/fonHospitalVanna.png")).getImage(),
            new ImageIcon(getClass().getResource("/map/2.png")).getImage(),
    };

    public StateManager(int x, int y, int bit) {
        this.x = x;
        this.y = y;
        this.bit = bit;
    }

    public StateManager(int bit) {
        this.bit = bit;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public void draw(Graphics2D graphics2D){
     graphics2D.drawImage(img[bit],x,y,null);
    }
}
