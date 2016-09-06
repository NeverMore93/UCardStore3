package com.ucardstore.tool;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Random;

/**
 * Created by YUAN on 2016/9/3.
 */
public class UCSTool {

    public  String generateToken(){
        Random random = new Random();
        String token =Integer.toHexString(random.nextInt());
        for(int i=0;i<7;i++)
        {
            token+=Integer.toHexString(random.nextInt());
        }
        return token;
    }

    public  String generateUserID(){
        Random random = new Random();
        String userID =Integer.toHexString(random.nextInt());
        for(int i=0;i<3;i++)
        {
            userID+=Integer.toHexString(random.nextInt());
        }
        return userID;
    }

    public String Str2Pic(String pic,String name,String type) throws IOException {

        String folderpath  = System.getProperty("user.dir") +"//resources//image//"+ type;
        Path path = Paths.get(folderpath , name+".jpg");
        Files.write(path, Base64.getDecoder().decode(pic));
        String pathStr= folderpath+"//"+name+".jpg";
         return pathStr;
    }

    public String Pic2Str(String name,String type) throws IOException {
        String str  = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(System.getProperty("user.dir") +"//resources//image//"+ type +"//"+ name +".jpg")));
        return str;
    }


}
