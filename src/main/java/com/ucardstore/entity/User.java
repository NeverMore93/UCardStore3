package com.ucardstore.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/3.
 */
@Data
public class User implements Serializable {
    @NotBlank
    private String userID;
    @NotBlank
    private String token;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @NotBlank

    private String email;

    private String nickName;

    @NotBlank
    private String appIdentifier;

    private String jpushID;

}
