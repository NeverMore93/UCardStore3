package com.ucardstore.TestCase;



import org.asynchttpclient.*;
import org.hsqldb.types.Charset;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by YUAN on 2016/10/11.
 */
public class SMSDemo {
	static String url = "http://sapi.253.com/msg/HttpBatchSendSM";// 应用地址
	static String account = "Youkac8";// 账号
	static String pswd = "eDo6aJyxB";// 密码
	static String mobile = "18521004228";// 手机号码，多个号码使用","分割
	static String msg = "您的验证码是8888。如非本人操作，请忽略本短信";// 短信内容
	boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
	String extno = null;// 扩展码

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
		StringBuffer requestBody = new StringBuffer();
		List<Param> params = new ArrayList<Param>();
		params.add(new Param("account",account));
		params.add(new Param("pswd",pswd));



		String result = asyncHttpClient.preparePost(url).setBody(params.toString()).execute(new AsyncCompletionHandler<String>() {
			@Override
			public String onCompleted(Response response) throws Exception {
				return response.getResponseBody();
			}
		}).get();

		System.out.print(result);








	}
}
