package com.company.camera;

public class GameCamera {
    private int xOffset, yOffset;

    public int getxOffset() {
        return xOffset;
    }

    public void setxOffset(int xOffset) {
        this.xOffset = xOffset;
    }

    public int getyOffset() {
        return yOffset;
    }

    public void setyOffset(int yOffset) {
        this.yOffset = yOffset;
    }

    public GameCamera(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    public void move(int xAmt, int yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
    }
}
