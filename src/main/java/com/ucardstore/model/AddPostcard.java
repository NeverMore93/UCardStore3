package com.ucardstore.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/6.
 */
@Data
public class AddPostcard implements Serializable {

    //发件人地址
    private String sendAddress;
    //收件人地址 国家 省 市 县
    private String receiveAddress;
    //边框上写的小字
    private String caption;
    //视佳的图片ID
    private String imageID;
    //VR视频的ID
    private String videoID;
    //是否AR
    private boolean ar;
    //横竖
    private boolean horizon;
    //发货国家缩写
    private String originalCountryCode;
    //收货国家缩写
    private String goalCountryCode;
    //用户所在国家缩写
    private String sendCountryCode;
    //用户token
    @NotBlank
    private String token;
    //明信片内容
    private String content;
    //正面照片的base64编码
    private String frontPic;
    //背面照片的base64编码
    private String backPic;

    private String edgeBackPic;

    private String recName;
}
