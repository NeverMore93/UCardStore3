package com.ucardstore.api;

import com.ucardstore.dao.UniversityDao;
import com.ucardstore.entity.UniversityQRScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by YUAN on 2016/9/7.
 */
@Controller
@RequestMapping(value = "/university")
public class QRScanController {

    @Resource
    private UniversityDao universityDao;
    private UniversityQRScan universityQRScan = new UniversityQRScan();

    @RequestMapping(value = "/apple",method = RequestMethod.GET)
    public String apple(String universityName,  HttpServletRequest request ){

        String scanTime = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.of("Asia/Shanghai")).format(Instant.now());universityQRScan.setUser(request.getRemoteUser());
        universityQRScan.setAddr(request.getRemoteAddr());
        universityQRScan.setHost(request.getRemoteHost());
        universityQRScan.setUser(request.getRemoteUser());
        universityQRScan.setScanTime(scanTime);
        universityQRScan.setUniversityName(universityName);
        universityDao.add(universityQRScan);


        return "redirect:http://www.ucardstore.com:8888/resources/index2.html";

    }

    @RequestMapping(value = "/android",method = RequestMethod.GET)
    public String android(String universityName,  HttpServletRequest request ){

        String scanTime = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.of("Asia/Shanghai")).format(Instant.now());universityQRScan.setUser(request.getRemoteUser());
        universityQRScan.setAddr(request.getRemoteAddr());
        universityQRScan.setHost(request.getRemoteHost());
        universityQRScan.setUser(request.getRemoteUser());
        universityQRScan.setScanTime(scanTime);
        universityQRScan.setUniversityName(universityName);
        universityDao.add(universityQRScan);
        return "redirect:http://www.ucardstore.com:8888/resources/index.html";

    }

}
