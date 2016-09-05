package com.ucardstore.entity;

import com.ucardstore.enums.LanguageCode;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/4.
 */
@Data
public class RegisterUser implements Serializable {
    private static final long serialVersionUID = -7497493213769319364L;
    @NotBlank
    private String email;

    private String userName;


    private String languageCode;

    private String nickName;

    @NotBlank
    private String password;

}
