package com.ucardstore.result;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/5.
 */
@Data
public class LogInResult implements Serializable {
    private String token;
    private String userID;
    private String userName;
}
