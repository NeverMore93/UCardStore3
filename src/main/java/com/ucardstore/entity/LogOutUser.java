package com.ucardstore.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/5.
 */
@Data
public class LogOutUser implements Serializable {
    private static final long serialVersionUID = -7497403213769313364L;
    private String token;
    private String userID;
}
