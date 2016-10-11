package com.ucardstore.TestCase;

import com.ucardstore.Constants;
import org.imgscalr.Scalr;

import javax.imageio.*;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static com.ucardstore.Constants.DPI;
import static com.ucardstore.Constants.INCH_2_CM;

/**
 * Created by YUAN on 2016/9/30.
 */
public class TestCase8 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("20160930073858674404dffae32644d9cd7bb16a90fec23d7d0c44de46646423e04ec6b9d8e893.png");


        BufferedImage bufferedImage1 = ImageIO.read(file1);

        BufferedImage scaledImage1 = Scalr.resize(bufferedImage1, Constants.POSTCARD_WIDTH, Constants.POSTCARD_HEIGHT);


        File file3 = new File("20160930073858674404dffae32644d9cd7bb16a90fec23d7d0c44de46646423e04ec6b9d8e893-2.png");



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

            ) {
                imageWriter.setOutput(stream1);
                imageWriter.write(iioMetadata, new IIOImage(scaledImage1, null, iioMetadata), null);



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
