package com.company.State;

import com.company.mainGame.MainPanel;

import java.awt.*;

public abstract class State {
    private static State currentState = null;
    public static void setState(State state){currentState = state; }
    public static State getState(){return currentState;}
    public abstract void draw(Graphics2D graphics2D);
    protected MainPanel mainPanel;

    public State(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
