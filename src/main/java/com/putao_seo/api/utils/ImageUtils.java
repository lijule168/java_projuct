package com.putao_seo.api.utils;

import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtils {
	
	/**
	  * 图片转base64字符串
	  * @param imgFile 图片路径
	  * @return
	  */
	 public static String imageToBase64Str(InputStream inputStream) {
		 byte[] data = new byte[1024];
	   ByteArrayOutputStream outPut = new ByteArrayOutputStream();
	   try {
	     int len = -1;
        while ((len = inputStream.read(data)) != -1) {
       	 outPut.write(data, 0, len);
        }
	     inputStream.close();
	   } catch (IOException e) {
	     e.printStackTrace();
	   }
	   // 加密
	   BASE64Encoder encoder = new BASE64Encoder();
	   return encoder.encode(outPut.toByteArray());
	   
	 }

}
