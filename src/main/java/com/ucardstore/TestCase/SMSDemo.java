package com.ucardstore.TestCase;


import org.asynchttpclient.*;

/**
 * Created by YUAN on 2016/10/11.
 */
public class SMSDemo {
	String url = "http://sapi.253.com/msg/";// 应用地址
	String account = "询问对接人";// 账号
	String pswd = "询问对接人";// 密码
	String mobile = "13800210021,13800138000";// 手机号码，多个号码使用","分割
	String msg = "您好，您的验证码是123456";// 短信内容
	boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
	String extno = null;// 扩展码

	public static void main(String[] args){
		AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();


	}
}
