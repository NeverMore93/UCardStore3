package com.ucardstore.TestCase;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by YUAN on 2016/9/20.
 */
public class TestCase2 {
    public static void main(String[] args) throws IOException {
        File file1  = new File("test02.png");
        File file2  = new File("img.png");
        File file3  = new File("result5.png");

        BufferedImage bufferedImage2 = ImageIO.read(file2);


        Thumbnails.of(file1).size(1748,1240).watermark((i, i1, i2, i3, i4, i5, i6, i7) -> new Point(1470,965), bufferedImage2, 1.0f).outputQuality(1.0f).toFile(file3);
    }
}
