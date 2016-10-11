package com.ucardstore.entity;

import lombok.Data;

/**
 * Created by YUAN on 2016/9/7.
 */
@Data
public class UniversityQRScan {
    private String scanTime;
    private String universityName;
    private String user;
    private String host;
    private String addr;
}
