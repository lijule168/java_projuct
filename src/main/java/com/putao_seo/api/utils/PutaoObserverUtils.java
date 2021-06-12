package com.putao_seo.api.utils;

import java.util.HashMap;
import java.util.Map;

public class PutaoObserverUtils {
	
	public static String genLog(Map<String, Object> params) {
		//[Putao-Observer,cost=4,processedPackCount=1,requestID=63twlww4htma1gpro6v8,userID=putao_iPad,sessionID=6ne3jhzsh6z2vdwg0m5j,innerSessionID=3df3eee7,seqID=0]
		StringBuffer sb = new StringBuffer();
		if (params != null) {
			
			sb.append("[Putao-Observer,");
			for (Map.Entry<String, Object> param : params.entrySet()) {
				sb.append(param.getKey()).append("=").append(param.getValue()).append(",");
			}
			
			if (sb.length() > 1 && sb.charAt(sb.length() - 1) == ',') {
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.append("]");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("cost", 100);
		params.put("url", "https");
		System.out.println(genLog(params));
	}

}
