package com.ucardstore.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/5.
 */
@Data
public class LogInResult implements Serializable {
    private static final long serialVersionUID = -7497693213759319364L;
    private String token;
    private String userID;
    private String userName;
}
