package com.ucardstore.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/5.
 */
@Data
public class Postcard{

    private Integer id;
    //userID
    @NotBlank
    private String userID;
    //userID
    @NotBlank
    private String cardID;
    //是否AR
    private boolean ar;
    //横竖
    private boolean horizon;
    //是否支付
    private boolean paid;
    //明信片创建时间
    private String createTime;
    //发送时间
    private String sendTime;
    //接受的时间
    private String receiveTime;
    //支付时间
    private String payTime;
    //折扣优惠码
    private String discountCode;
    //支付类型
    private String payType;
    //明信片在支付后生成订单序列化
    private String orderSerialNumber;
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
    //发货国家缩写
    private String originalCountryCode;
    //收货国家缩写
    private String goalCountryCode;
    //用户所在国家缩写
    private String sendCountryCode;
    //明信片内容
    private String content;

    private double  priceEUR;

    private double  priceRMB;

    private String recName;

    private String outTradeNo;

    private String tradeStatus;

    private String tradeNo;

    private String buyerId;




}
