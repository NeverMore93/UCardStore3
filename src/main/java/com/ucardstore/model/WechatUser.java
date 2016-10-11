package com.ucardstore.model;

import lombok.Data;

/**
 * Created by YUAN on 2016/10/4.
 */
@Data
public class WechatUser {
    private String access_token;
    private String openid;
    private String email;
    private String phone;
    private String provider;
    private String userID;
}
