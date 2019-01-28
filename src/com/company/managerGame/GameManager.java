package com.company.managerGame;

import com.company.Character.Entity;
import com.company.Character.Mikichan;
import com.company.mainGame.MainFrame;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private final int SIZE = 60;
    private ArrayList<MapManager>mapManagers;
    private StateAttack attack;
    private StateManager stateManager;
    public Mikichan mikichan;
    int[][] arr = {
            {4, 4, 4, 5, 4, 4, 5, 5, 5, 4, 5, 5, 5, 4, 5, 4, 5, 4, 5, 5, 5, 5, 5},
            {0, 0, 0, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3},
            {0, 0, 0, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3},
            {0, 0, 0, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3},
            {0, 0, 0, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3},
            {0, 0, 0, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3},
            {0, 0, 0, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3},
            {0, 0, 0, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3},
            {0, 0, 0, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
            {1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3},
            {1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3},
            {1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3},
            {1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3},
            {1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3},
    };

    public void initGame(){
        mikichan = new Mikichan(MainFrame.Width/3,200);
        readMap();
       // readState();
       // stateManager = new StateManager(0,0,3);
    }

//    private void readState() {
//        stateManagers = new ArrayList<StateManager>();
//        stateManagers.add(new StateManager(1));
//    }

    public void readMap() {
         mapManagers = new ArrayList<MapManager>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                int x = SIZE*j;
                int y = SIZE*i;
                int bit = arr[i][j];
                mapManagers.add(new MapManager(x,y,bit));
            }
        }
    }

    public void movePlayer(int NewOrient){
        mikichan.changeOrient(NewOrient);
        ArrayList<MapManager> managers = mapManagers;
        mikichan.move(managers);
        if(mikichan.isCenter()==false){
            mikichan.movePosition(managers);
            return;
        }
        boolean check = false;
        if(NewOrient == Entity.left){
            check = managers.get(0).boundStart();
        }else if(NewOrient == Entity.right){
            check = managers.get(managers.size()-1).boundEnd();
        }
        if(check){
            mikichan.movePosition(managers);
            return;
        }
        for (int i = 0; i < managers.size() ; i++) {
            managers.get(i).move(NewOrient);
        }

    }
    public void draw(Graphics2D graphics2D){
        for (MapManager manager: mapManagers) {
            manager.draw(graphics2D);
        }
        mikichan.draw(graphics2D);
    }
}
