package com.ucardstore.TestCase;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.DeviceType;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.*;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import java.util.Set;

import static cn.jpush.api.push.model.notification.PlatformNotification.ALERT;

/**
 * Created by YUAN on 2016/10/10.
 */
public class JPushClientDemo {
	public static void main(String[] args){
		JPushClient jpushClient = new JPushClient("beb4fb2bc4d43bcf93017d5c", "77f2c9b5371012ea52ef5e2d");
		PushPayload pushPayload =PushPayload.newBuilder()
				.setPlatform(Platform.all())
				.setAudience(Audience.registrationId("191e35f7e04ce79c00a"))
				.setNotification(Notification.newBuilder()
						.addPlatformNotification(IosNotification.newBuilder()
								.setAlert("test")
								.autoBadge()
								.setSound("happy.caf")
								.addExtra("from", "JPush")
								.build())
						.build())
				.setMessage(Message.content("test"))
				.build();

		PushResult pushResult = new PushResult();
		try {
			pushResult=jpushClient.sendPush(pushPayload);
		} catch (APIConnectionException | APIRequestException e) {
			e.printStackTrace();
		}

		System.out.println(pushResult);
	}
}
