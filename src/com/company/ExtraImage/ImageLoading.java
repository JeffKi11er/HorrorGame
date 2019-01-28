package com.company.ExtraImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.sql.BatchUpdateException;

public class ImageLoading {
    public static BufferedImage loading(String path){
        try
        {
            return ImageIO.read(ImageLoading.class.getResource(path));
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
