package com.ucardstore.model;

import com.ucardstore.enums.LanguageCode;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/4.
 */
@Data
public class RegisterUser implements Serializable {

    @Email
    private String email;

    private String telephone;


    private String userName;

    @NotBlank
    private String languageCode;

    @NotBlank
    private String nickName;

    @NotBlank
    private String password;

    private String appIdentifier;

}
