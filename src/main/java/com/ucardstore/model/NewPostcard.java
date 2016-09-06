package com.ucardstore.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/6.
 */
@Data
public class NewPostcard implements Serializable {

    @NotBlank
    private String token;
    private String content;
    private String frontPic;
    private String backPic;
    private String createTime;
    private String sendTime;
    private String receiveTime;
    private String sendAddress;
    private String receiveAddress;
    private String originalCountryCode;
    private String goalCountryCode;
    private String sendCountryCode;
    private String caption;
    private String imageID;
    private String videoID;
    private boolean isAR;
    private boolean isHorizon;
}
