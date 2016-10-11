package com.ucardstore.tool;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.sanselan.ImageReadException;
import org.imgscalr.Scalr;

import javax.imageio.*;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;

import static com.ucardstore.Constants.*;

/**
 * Created by YUAN on 2016/9/22.
 */
public class ImageTool {
    private void generateQRcode(String cardID) throws WriterException, IOException {

        HashMap hints=new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");		//设置支持中文编码
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);		//纠错等级。
        hints.put(EncodeHintType.MARGIN, 1);					//边框

        BitMatrix bitmatrix=new MultiFormatWriter().encode(cardID, BarcodeFormat.QR_CODE, QRcode_width, QRcode_height);
        File files=new File(File.separator+"opt"+File.separator+"images"+File.separator+"QRcode"+File.separator+ cardID +".png");						//文件
        Path path=files.toPath();								//文件路径
        MatrixToImageWriter.writeToPath(bitmatrix,"png", path);
    }

    public void processPostcardImg(String frontPic,String backPic,String edgeBackPic,String cardID) throws Exception{
        //保存从前端传来的照片
        savePic(frontPic, backPic,edgeBackPic,cardID);
        //拼接图片
        Imgjoint(cardID);

        //生成二维码
        generateQRcode(cardID);
        //添加二维码
        addQRcode(cardID);
        //设置DPI为300
        setDPI(cardID);
        //添加收件人
//        addRec(recName,postcode,address1,address2,cardID);

    }

    public void savePic(String string,String name) throws IOException {
        String filePath = File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"preprocess"+File.separator+"frontPic"+File.separator+name+".png";
        File file = new File(filePath);

        Path path = file.toPath();
        Files.write(path , Base64.getDecoder().decode(string));
    }

    private void  savePic(String frontPic,String backPic,String edgeBackPic,String cardID) throws IOException {
        File frontImg = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"preprocess"+File.separator+"frontPic"+File.separator+cardID+".png");

        File backImg = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"preprocess"+File.separator+"backPic"+File.separator+cardID+".png");

        File edgeBackImg = new File(File.separator+"opt"+File.separator+"images"+File.separator+"edge"+File.separator+"back"+File.separator+cardID+".png");

        Path frontPath  = frontImg.toPath();
        Path backPath  = backImg.toPath();
        Path edgeBackPath = edgeBackImg.toPath();
        Files.write(frontPath , Base64.getDecoder().decode(frontPic));
        Files.write(backPath , Base64.getDecoder().decode(backPic));
        Files.write(edgeBackPath, Base64.getDecoder().decode(edgeBackPic));
    }

    private void addRec(String recName,String postcode,String address1,String address2,String cardID) throws IOException {
        File backFile = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"processed"+File.separator+"back3"+File.separator+cardID+".png");
        File outputFile = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"processed"+File.separator+"back4"+File.separator+cardID+".png");
        BufferedImage bufferedImage = ImageIO.read(backFile);
        Graphics g = bufferedImage.getGraphics();
        Font font1 = new Font("Dialog",Font.PLAIN,66);
        Font font2 = new Font("Dialog",Font.PLAIN,56);
        g.setFont(font1);
        g.setColor(Color.black);
        g.drawString(recName,126,480);
        g.drawString(postcode,366,480);
        g.setFont(font2);
        g.drawString(address1,126,600);
        g.drawString(address2,126,660);
        g.dispose();
        ImageIO.write(bufferedImage,"png",outputFile);
    }

    private void Imgjoint(String cardID) throws IOException{
        File edgeBack = new File(File.separator+"opt"+File.separator+"images"+File.separator+"edge"+File.separator+"back"+File.separator+cardID+".png");
        File edgeFront = new File(File.separator+"opt"+File.separator+"images"+File.separator+"edge"+File.separator+"front.png");
        File back = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"preprocess"+File.separator+"backPic"+File.separator+cardID+".png");
        File front = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"preprocess"+File.separator+"frontPic"+File.separator+cardID+".png");

        BufferedImage edgeBackBuffer = ImageIO.read(edgeBack);
        BufferedImage edgeFrontBuffer = ImageIO.read(edgeFront);
        BufferedImage backBuffer =  Scalr.resize(ImageIO.read(back), 1748, 1240);
        BufferedImage frontBuffer = Scalr.resize(ImageIO.read(front), 1748, 1240);


        File resultBack = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"processed"+File.separator+"back1"+File.separator+cardID+".png");
        File resultFront = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"processed"+File.separator+"front1"+File.separator+cardID+".png");


        BufferedImage bufferedBackImage =new BufferedImage(2693,1240,BufferedImage.TYPE_INT_RGB);
        BufferedImage bufferedFrontImage =new BufferedImage(2693,1240,BufferedImage.TYPE_INT_RGB);

        Graphics2D g2dBack = bufferedBackImage.createGraphics();
        Graphics2D g2dFront = bufferedFrontImage.createGraphics();

        Stroke stroke = new BasicStroke(6,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL,10,dash,10);
        Color color = new Color(216,216,216,100);


        g2dBack.setStroke(stroke);
        g2dBack.drawImage(edgeBackBuffer,0,0,null);
        g2dBack.drawImage(backBuffer,945,0,null);
        g2dBack.setColor(color);
        g2dBack.drawLine(942,0,942,1240);
        g2dBack.dispose();


        g2dFront.drawImage(frontBuffer,0,0,null);
        g2dFront.drawImage(edgeFrontBuffer,1748,0,null);
        g2dFront.setStroke(stroke);
        g2dFront.setColor(color);
        g2dFront.drawLine(1745,0,1745,1240);
        g2dFront.dispose();

        ImageIO.write(bufferedBackImage, "png", resultBack);
        ImageIO.write(bufferedFrontImage, "png", resultFront);
    }




    private void setDPI(String cardID) throws IOException, ImageReadException {
        File inputBackImg = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"processed"+File.separator+"back2"+File.separator+cardID+".png");
        File inputFrontImg = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"processed"+File.separator+"front1"+File.separator+cardID+".png");

        BufferedImage bufferedinputFrontImage = ImageIO.read(inputFrontImg);
        BufferedImage bufferedinputBackImage = ImageIO.read(inputBackImg);

        BufferedImage scaledinputFrontImage = Scalr.resize(bufferedinputFrontImage, POSTCARD_WIDTH, POSTCARD_HEIGHT);
        BufferedImage scaledinputBackImage = Scalr.resize(bufferedinputBackImage,  POSTCARD_WIDTH, POSTCARD_HEIGHT);

        File outputFrontImg = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"processed"+File.separator+"front2"+File.separator+cardID+".png");
        File outputBackImg = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"processed"+File.separator+"back3"+File.separator+cardID+".png");


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
                    ImageOutputStream backStream = ImageIO.createImageOutputStream(outputBackImg);
                    ImageOutputStream frontStream = ImageIO.createImageOutputStream(outputFrontImg)
            ) {
                imageWriter.setOutput(frontStream);
                imageWriter.write(iioMetadata, new IIOImage(scaledinputFrontImage, null, iioMetadata), imageWriteParam);
                imageWriter.setOutput(backStream);
                imageWriter.write(iioMetadata, new IIOImage(scaledinputBackImage, null,iioMetadata), imageWriteParam);
            }
            break;
        }

    }

    private void setMetadata(IIOMetadata iioMetadata) throws IIOInvalidTreeException {
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

        iioMetadata.mergeTree("javax_imageio_1.0", root);

    }




    private void addQRcode(String cardID) throws IOException {
        File file = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"processed"+File.separator+"back1"+File.separator+cardID+".png");
        File QRcodeFile = new File(File.separator+"opt"+File.separator+"images"+File.separator+"QRcode"+File.separator+cardID+".png");
        File outputFile = new File(File.separator+"opt"+File.separator+"images"+File.separator+"postcard"+File.separator+"processed"+File.separator+"back2"+File.separator+cardID+".png");
        BufferedImage bufferedImage = ImageIO.read(QRcodeFile);
        Thumbnails.of(file).size(2693,1240).watermark((i, i1, i2, i3, i4, i5, i6, i7) -> new Point(2415,965),bufferedImage,1.0f).outputQuality(1.0f).toFile(outputFile);
    }








//    private void getQRcode(String cardID) throws Exception {
//        StringBuffer QRcode = new StringBuffer("http://pan.baidu.com/share/qrcode?w=150&h=150&url=http://www.ucardstore.com:8102/tracking?cardID=");
//        QRcode.append(cardID);
//        String QRcodeURL = QRcode.toString();
//         File imageFile = new File("//opt//images//QRcode//"+cardID+".png");
//         FileOutputStream out = new FileOutputStream(imageFile);
//        InputStream result=  client.prepareGet(QRcodeURL).execute(new AsyncCompletionHandler<InputStream>() {
//            @Override
//            public InputStream onCompleted(Response response) throws Exception {
//                return response.getResponseBodyAsStream();
//
//            }}).get();
//        client.close();
//
//        IOUtils.copy(result, out);
//    }
}
