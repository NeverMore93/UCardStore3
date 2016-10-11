package com.ucardstore.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/5.
 */
@Data
public class LogInUser{

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
