package com.ucardstore.TestCase;

import com.ucardstore.Constants;
import org.imgscalr.Scalr;

import javax.imageio.*;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static com.ucardstore.Constants.DPI;
import static com.ucardstore.Constants.INCH_2_CM;

/**
 * Created by YUAN on 2016/9/22.
 */
public class TestCase4 {
    public static void main(String[] args) throws IOException {

        File file1 = new File("test1.jpg");
        File file2 = new File("test2.jpg");

        BufferedImage bufferedImage1 = ImageIO.read(file1);
        BufferedImage bufferedImage2 = ImageIO.read(file2);

        BufferedImage scaledImage1 = Scalr.resize(bufferedImage1, Constants.POSTCARD_WIDTH, Constants.POSTCARD_HEIGHT);
        BufferedImage scaledImage2 = Scalr.resize(bufferedImage2, Constants.POSTCARD_WIDTH, Constants.POSTCARD_HEIGHT);

        File file3 = new File("test0001.png");
        File file4 = new File("test0002.png");


        for (Iterator<ImageWriter> iterator = ImageIO.getImageWritersByFormatName("png"); iterator.hasNext();) {
            ImageWriter imageWriter = iterator.next();
            ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();
            ImageTypeSpecifier imageTypeSpecifier = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_RGB);
            IIOMetadata iioMetadata = imageWriter.getDefaultImageMetadata(imageTypeSpecifier, imageWriteParam);
            if (iioMetadata.isReadOnly() || !iioMetadata.isStandardMetadataFormatSupported()) {
                continue;
            }
            setMetadata(iioMetadata);


            try (
                    ImageOutputStream stream1 = ImageIO.createImageOutputStream(file3);
                    ImageOutputStream stream2 = ImageIO.createImageOutputStream(file4);
            ) {
                imageWriter.setOutput(stream1);
                imageWriter.write(iioMetadata, new IIOImage(scaledImage1, null, iioMetadata), null);
                imageWriter.setOutput(stream2);
                imageWriter.write(iioMetadata, new IIOImage(scaledImage2, null, iioMetadata), null);

            }
            break;
        }



    }

    private static void setMetadata(IIOMetadata metadata) throws IIOInvalidTreeException {
        double dotsPerInch = 1.0 * DPI / 10 / INCH_2_CM;

        IIOMetadataNode horiz = new IIOMetadataNode("HorizontalPixelSize");
        horiz.setAttribute("value", Double.toString(dotsPerInch));

        IIOMetadataNode vert = new IIOMetadataNode("VerticalPixelSize");
        vert.setAttribute("value", Double.toString(dotsPerInch));

        IIOMetadataNode dim = new IIOMetadataNode("Dimension");
        dim.appendChild(horiz);
        dim.appendChild(vert);

        IIOMetadataNode root = new IIOMetadataNode("javax_imageio_1.0");
        root.appendChild(dim);

        metadata.mergeTree("javax_imageio_1.0", root);

    }
}
