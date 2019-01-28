package com.company.ExtraImage;

import java.awt.image.BufferedImage;

public class Sheet {
    private BufferedImage image;

    public Sheet(BufferedImage image) {
        this.image = image;
    }
    public BufferedImage crop(int x, int y, int width, int height){return image.getSubimage(x,y,width,height); }
}
