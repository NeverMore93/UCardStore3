package com.ucardstore.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/5.
 */
@Data
public class LogOutUser implements Serializable {
    private String token;
    private String userID;
}
