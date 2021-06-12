package com.putao_seo.api.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加解密
 * 
 * Created by yyh on 2015/10/9.
 */
public class AESUtils {

	/**
	 * 密钥算法
	 */
	private static final String ALGORITHM = "AES";
	/**
	 * 加解密算法/工作模式/填充方式
	 */
	private static final String ALGORITHM_STR = "AES/ECB/PKCS5Padding";

	/**
	 * SecretKeySpec类是KeySpec接口的实现类,用于构建秘密密钥规范
	 */
	private SecretKeySpec key;

	public AESUtils(String hexKey) {
		key = new SecretKeySpec(hexKey.getBytes(), ALGORITHM);
	}

	/**
	 * AES加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String encryptData(String data) {
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM_STR); // 创建密码器
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			return byte2String(cipher.doFinal(data.getBytes()));
//			return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String byte2String(byte[] bytes) {
		String cipherText = "";
			for (int i = 0; i < bytes.length; i++) {
			int num = bytes[i];
			if (num < 0) {
				num += 800;
			}
			cipherText += String.format("%03d", num);
		}
		return cipherText;
	}
		
	
	private byte[] String2byte(String cipher) {
		if (cipher == null || cipher.length() == 0 ||
				cipher.length() % 3 != 0) {
			return null;
		}
		byte[] byteArray = new byte[cipher.length() / 3];
		for (int i = 0; i < cipher.length() / 3; i++) {
			String subString = cipher.substring(i*3, i*3+3);
			int num = Integer.parseInt(subString);
			if (num > 200) {
				num -= 800;
			}
			System.out.println(num);
			byteArray[i] = Byte.decode(num + "");
		}
		
		return byteArray;
	}
	

	/**
	 * AES解密
	 * 
	 * @param base64Data
	 * @return
	 * @throws Exception
	 */
	public String decryptData(String base64Data) {
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
			cipher.init(Cipher.DECRYPT_MODE, key);
			return new String(cipher.doFinal(String2byte(base64Data)));
//			return new String(cipher.doFinal(Base64.getDecoder().decode(base64Data)));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		AESUtils util = new AESUtils("bn1.putaoabc.com"); // 密钥
		System.out.println("cardNo:" + util.encryptData("13764591564")); // 加密
//		System.out.println("exp:" + util.decryptData("0DZeKzJMdCNJQeSR3K8EVw==")); // 解密
		System.out.println("exp:" + util.decryptData("118793013745029774099697046729677789699121084015"));
	}
}
