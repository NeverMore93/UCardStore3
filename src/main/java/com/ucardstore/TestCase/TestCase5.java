package com.ucardstore.TestCase;

import com.ucardstore.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by YUAN on 2016/9/22.
 */
public class TestCase5 {
    public static void main(String[] args) throws IOException {
        File edge = new File("01.png");
        BufferedImage edgeBuffer = ImageIO.read(edge);
        File backFile = new File("test.png");
        BufferedImage backFileBuffer = ImageIO.read(backFile);
        BufferedImage bufferedImage =new BufferedImage(2693,1240,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dRow = bufferedImage.createGraphics();
        Stroke stroke = new BasicStroke(3,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL,10, Constants.dash,10);
        g2dRow.setStroke(stroke);
        g2dRow.drawImage(edgeBuffer,0,0,null);
        g2dRow.drawImage(backFileBuffer,945,0,null);
        g2dRow.setColor(new Color(216,216,216,100));
        g2dRow.drawLine(945,0,945,1240);
//        g2dRow.drawLine(45,30,900,240);
        g2dRow.dispose();

        ImageIO.write(bufferedImage, "png", new File("result3.png"));
    }
}
