package com.ucardstore.tool;

import cn.jpush.api.JPushClient;

/**
 * Created by YUAN on 2016/10/10.
 */
public class JPushTool {
	private static final String appKey="77f2c9b5371012ea52ef5e2d";
	private static final String masterSecret="beb4fb2bc4d43bcf93017d5c";
	JPushClient jpushClient = new JPushClient(appKey, masterSecret);

}
