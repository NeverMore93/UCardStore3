package com.ucardstore.model;

import com.ucardstore.enums.LanguageCode;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/4.
 */
@Data
public class RegisterUser implements Serializable {
    @NotBlank
    private String email;

    private String userName;


    private String languageCode;

    private String nickName;

    @NotBlank
    private String password;

}
