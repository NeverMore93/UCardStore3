package com.ucardstore.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/5.
 */
@Data
public class LogInUser implements Serializable {
    private static final long serialVersionUID = -7497403213769319364L;

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
