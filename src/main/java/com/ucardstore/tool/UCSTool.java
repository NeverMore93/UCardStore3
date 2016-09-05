package com.ucardstore.tool;

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


}
