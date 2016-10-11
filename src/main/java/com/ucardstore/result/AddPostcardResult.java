package com.ucardstore.result;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/6.
 */
@Data
public class AddPostcardResult implements Serializable {
    private String orderSerialNumber;

    private String cardID;

    private String createTime;

    private String discountCode;

    private String userID;

    private double priceEUR;

    private double priceRMB;
}
