package com.putao_seo.api.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class SMSUtils {

	// 短信应用SDK AppID
	static int appid = 1400097249; // 1400开头

	// 短信应用SDK AppKey
	static String appkey = "cfcfbac1f3216037ce079573b84bf771";
	
	// 短信模板ID，需要在短信应用中申请
	static int templateId = 128224; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
	static int forignTemplateId = 269193;
	
	public static final String MINI_SIGN = "葡萄少儿英语";
	public static final String APP_SIGN = "葡萄英语";
	
	public static boolean SendSMS(String phoneNum, String vcode, String sign, String countryCode) {

		// 签名
		String smsSign = sign; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
		
		try {
			int tid = templateId;
			ArrayList<String> params = new ArrayList<String>();
			params.add(vcode);
			if (countryCode != null && !"86".equals(countryCode) && !"".equals(countryCode)) { //外国的
				params.add(vcode);
				tid = forignTemplateId;
			}
		    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		    SmsSingleSenderResult result = ssender.sendWithParam(countryCode, phoneNum,
		    		tid, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
		    System.out.print(result);
		} catch (HTTPException e) {
		    // HTTP响应码错误
		    e.printStackTrace();
		    return false;
		} catch (JSONException e) {
		    // json解析错误
		    e.printStackTrace();
		    return false;
		} catch (IOException e) {
		    // 网络IO错误
		    e.printStackTrace();
		    return false;
		}
		
		return true;
	}
	public static String genRandomCode() {
		// return UUID.randomUUID().toString().substring(0, 4);
		return String.format("%04d", Math.abs(UUID.randomUUID().hashCode() % 10000));
	}
	
	
}
