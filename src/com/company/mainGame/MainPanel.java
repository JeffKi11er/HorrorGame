package com.company.mainGame;

import com.company.Character.Entity;
import com.company.managerGame.GameManager;
import com.company.managerGame.StateAttack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel implements Runnable, KeyListener {
    private GameManager gameManager = new GameManager();
    private BufferedImage bufferedImage;
    private StateAttack stateAttack;
    private Thread thread;
    private boolean flag [] = new boolean[256];
    public MainPanel() {
        setBackground(Color.GRAY);
        gameManager.initGame();
        thread = new Thread(this);
        thread.start();
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void run() {
        while(true){
            if(flag[KeyEvent.VK_LEFT]){
                gameManager.movePlayer(Entity.left);
            }
            if(flag[KeyEvent.VK_RIGHT]){
                gameManager.movePlayer(Entity.right);
            }
            if(flag[KeyEvent.VK_UP]){
                gameManager.movePlayer(Entity.up);
            }
            if(flag[KeyEvent.VK_DOWN]){
                gameManager.movePlayer(Entity.down);
            }
            repaint();
            try
            {
                Thread.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        super.paintComponent(graphics2D);
        gameManager.draw(graphics2D);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        flag[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        flag[e.getKeyCode()] = false;
    }

}
