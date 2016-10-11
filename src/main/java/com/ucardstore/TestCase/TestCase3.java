package com.ucardstore.TestCase;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by YUAN on 2016/9/20.
 */
public class TestCase3 {
    public static void main(String[] args) throws IOException {
        File file= new File("01.png");
        File file2 = new File("03.png");

        BufferedImage bufferedImage = ImageIO.read(file);
        Graphics g = bufferedImage.getGraphics();
        Font font1 = new Font("Dialog",Font.PLAIN,66);
        Font font2 = new Font("Dialog",Font.PLAIN,56);

        g.setFont(font1);
        g.setColor(Color.black);
        g.drawString("周怡怡",126,480);
        g.drawString("200000",366,480);
        g.setFont(font2);
        g.drawString("中国上海市浦东新区",126,600);
        g.drawString("盛大新天地青春里X号XXX室",126,660);
        g.dispose();
        ImageIO.write(bufferedImage,"png",file2);

    }
}
