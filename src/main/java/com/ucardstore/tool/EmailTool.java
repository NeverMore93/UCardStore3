package com.ucardstore.tool;

import com.ucardstore.Constants;
import org.apache.commons.io.IOUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static com.ucardstore.Constants.*;

/**
 * Created by YUAN on 2016/10/9.
 */
@Configuration
public class EmailTool {

    public static void main(String[] args){
        sendEmail("1305882275@qq.com");
    }

    public static void sendEmail(String recEmail) {
        HtmlEmail htmlEmail = new HtmlEmail();
        htmlEmail.setAuthenticator(new DefaultAuthenticator(EMAIL,PASSWORD));
        htmlEmail.setHostName(EMAIL_HOST_NAME);
        URL url;
        InputStream inputStream;

        try {
            url = new URL(WELCOME_PAGE);
            inputStream = url.openStream();
            String msgHtml = IOUtils.toString(inputStream, "UTF-8");
            htmlEmail.setHtmlMsg(msgHtml);
            htmlEmail.setFrom(EMAIL);
            htmlEmail.addTo(recEmail);
            htmlEmail.setCharset("UTF-8");
            htmlEmail.send();

        } catch (IOException | EmailException e) {
            e.printStackTrace();
        }
    }

}
