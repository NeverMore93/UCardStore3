package com.ucardstore.TestCase;

import org.apache.commons.io.IOUtils;
import org.apache.commons.mail.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by YUAN on 2016/10/9.
 */
public class EmailTest {
    public static void main(String[] args) throws EmailException, IOException {
//        simpleEmailTest();
        HtmlEmailTest();
    }

//    static void simpleEmailTest() throws EmailException {
//        SimpleEmail simpleEmail = new SimpleEmail();
//        simpleEmail.setSmtpPort(587);
//        simpleEmail.setSSLOnConnect(true);
//        simpleEmail.setAuthenticator(new DefaultAuthenticator("y1305882275@gmail.com","q19938111949"));
//        simpleEmail.setHostName("smtp.gmail.com");
//
//        simpleEmail.setMsg("Test");
//        simpleEmail.setSubject("Test");
//        simpleEmail.setFrom("y1305882275@gmail.com");
//        simpleEmail.addTo("1305882275@qq.com");
//        simpleEmail.send();
//    }

    static void simpleEmailTest() throws EmailException {
        SimpleEmail simpleEmail = new SimpleEmail();
//        simpleEmail.setSmtpPort(465);
//        simpleEmail.setSSLOnConnect(false);
        simpleEmail.setAuthenticator(new DefaultAuthenticator("wentao.yuan@ucardstore.com","YWTywt19938111949"));
        simpleEmail.setHostName("smtp.exmail.qq.com");

        simpleEmail.setMsg("Test.....");
        simpleEmail.setSubject("Test......");
        simpleEmail.setFrom("wentao.yuan@ucardstore.com");
        simpleEmail.addTo("1305882275@qq.com");
        simpleEmail.send();
    }

    static void HtmlEmailTest() throws IOException, EmailException {
        HtmlEmail htmlEmail = new HtmlEmail();
        htmlEmail.setAuthenticator(new DefaultAuthenticator("wentao.yuan@ucardstore.com","YWTywt19938111949"));
        htmlEmail.setHostName("smtp.exmail.qq.com");
        URL url = new URL("https://www.baidu.com/");
        InputStream inputStream = url.openStream();
        String msgHtml = IOUtils.toString(inputStream,"UTF-8");

        System.out.println(msgHtml);
        htmlEmail.setHtmlMsg(msgHtml);
        htmlEmail.setFrom("wentao.yuan@ucardstore.com");
        htmlEmail.addTo("1305882275@qq.com");
        htmlEmail.setCharset("UTF-8");
        htmlEmail.send();
    }



}
