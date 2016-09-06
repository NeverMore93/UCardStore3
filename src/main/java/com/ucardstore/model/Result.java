package com.ucardstore.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YUAN on 2016/9/4.
 */
@Data
public class Result implements Serializable {
    @NotBlank
    private Integer code;
    @NotBlank
    private String msg;
    @NotBlank
    private Object data;

}
