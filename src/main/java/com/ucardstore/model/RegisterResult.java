package com.ucardstore.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/4.
 */
@Data
public class RegisterResult implements Serializable {

    private String tokenStr;
    private String userID;
    private String userName;

}
