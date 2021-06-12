package com.putao_seo.api.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientUtils {
	
	public static String HttpGet(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();  //FIXME 先这么搞吧。
		try {
			HttpGet httpGet = new HttpGet(url);
			
//	        RequestConfig defaultRequestConfig = RequestConfig.custom().setConnectionRequestTimeout(5000).setConnectTimeout(1000)
//	            .build();
//			httpGet.setConfig(defaultRequestConfig);

			CloseableHttpResponse response = httpclient.execute(httpGet);
			
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String data = EntityUtils.toString(entity);
				return data;
			}
			response.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static InputStream HttpPost(String url, String body) {
		CloseableHttpClient httpclient = HttpClients.createDefault();  //FIXME 先这么搞吧。
		try {
			HttpPost httpPost = new HttpPost(url);
			if (body != null) {
				httpPost.setEntity(new StringEntity(body));
			}
			CloseableHttpResponse response = httpclient.execute(httpPost);
			
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream data = entity.getContent();
				return data;
			}
			response.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String HttpPost(String url, String body, Map<String, String> headers) {
		CloseableHttpClient httpclient = HttpClients.createDefault();  //FIXME 先这么搞吧。
		RequestConfig requestConfig = RequestConfig.custom()
		        .setSocketTimeout(4000) //read timeout
		        .setConnectTimeout(4000) // connect timeout
		        .build();
		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			if (headers != null) {
				for (Entry<String, String> entry : headers.entrySet()) {
					httpPost.setHeader(entry.getKey(), entry.getValue());
				}
			}
			if (body != null) {
				StringEntity entity = new StringEntity(body, Charset.forName("UTF-8"));
				httpPost.setEntity(entity);
			}
			CloseableHttpResponse response = httpclient.execute(httpPost);
			
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String data = EntityUtils.toString(entity);
				return data;
			}
			response.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
