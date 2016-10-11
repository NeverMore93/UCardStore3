package com.ucardstore.tool;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.sun.prism.*;
import com.sun.prism.Image;
import com.ucardstore.Constants;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import org.apache.sanselan.ImageInfo;
import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.Sanselan;
import org.apache.sanselan.common.IImageMetadata;
import org.apache.sanselan.common.ImageMetadata;
import org.asynchttpclient.*;

import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutionException;

import org.apache.commons.io.IOUtils;

import javax.imageio.*;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;

import com.sun.imageio.plugins.png.PNGImageWriter;
import com.sun.imageio.plugins.jpeg.JPEGImageWriter;
import org.imgscalr.Scalr;

import static com.ucardstore.Constants.DPI;
import static com.ucardstore.Constants.INCH_2_CM;

/**
 * Created by YUAN on 2016/9/3.
 */
public class UCSTool {
    private Random random = new Random();
    private AsyncHttpClient client = new DefaultAsyncHttpClient();


    public  String generateToken(){

        String token =DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC).format(Instant.now());
        for(int i=0;i<8;i++)
        {
            token+=Integer.toHexString(random.nextInt());
        }
        return token;
    }

    public  String generateUserID(){
        String userID =DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC).format(Instant.now());
        for(int i=0;i<4;i++)
        {
            userID+=Integer.toHexString(random.nextInt());
        }
        return userID;
    }

    public  String generatePostcardID(){
        String userID =DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC).format(Instant.now());
        for(int i=0;i<8;i++)
        {
            userID+=Integer.toHexString(random.nextInt());
        }
        return userID;
    }

    public String generateorderSerialNumber(){
        String serialNumber =  DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC).format(Instant.now());
        for(int i=0;i<8;i++)
        {
            serialNumber+=Integer.toHexString(random.nextInt());
        }

        return serialNumber;
    }




}
