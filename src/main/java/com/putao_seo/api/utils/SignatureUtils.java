package com.putao_seo.api.utils;

import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@SuppressWarnings("restriction")
public class SignatureUtils {

	public static void main(String[] args) {
		System.out.println(getSafeUrl("f99d250bce46d0782476969674184f0a", "26114_441b468fc7", 1530547199L));

//		String  url = "http://192.168.50.193:8080/course/live/apply_live_url?putaoid=&sign=Optional222af0fcda0401c56bc1a65898f6014ab94229&ts=978307200&uuid=E566EA11-272C-4E8A-9066-416ED7E40506";
		// http://192.168.50.193:8080/course/live/apply_live_url?putaoid=E566EA11-272C-4E8A-9066-416ED7E40506&sign=af0fcda0401c56bc1a65898f6014ab94&ts=978307200&uuid=E566EA11-272C-4E8A-9066-416ED7E40506
		String uid = "E566EA11-272C-4E8A-9066-416ED7E40506";
		String uuid = "E566EA11-272C-4E8A-9066-416ED7E40506";
		String ts = "978307200";
		String key = "47f93270e2a920c2757a697d0637ce22";
		System.out.println(checkCourseLiveMD5(uid, uuid, ts, key, null));

		String str = sha1Encode(
				"jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg&noncestr=Wm3WZYTPz0wzccnW&timestamp=1414587457&url=http://mp.weixin.qq.com?params=value");
		System.out.println(str);
	}

	private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };

	/*
	 * KEY+ stream_id + txTime
	 */
	public static String getSafeUrl(String key, String streamId, long txTime) {
		String input = new StringBuilder().append(key).append(streamId).append(Long.toHexString(txTime).toUpperCase())
				.toString();

		String txSecret = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			txSecret = byteArrayToHexString(messageDigest.digest(input.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return txSecret == null ? ""
				: new StringBuilder().append("txSecret=").append(txSecret).append("&").append("txTime=")
						.append(Long.toHexString(txTime).toUpperCase()).toString();
	}

	private static String byteArrayToHexString(byte[] data) {
		char[] out = new char[data.length << 1];

		for (int i = 0, j = 0; i < data.length; i++) {
			out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS_LOWER[0x0F & data[i]];
		}
		return new String(out);
	}

	public static String SALT = "64a6dc4e6f23c45d0547985e38c7001a";
	public static String SALT_PC = "11c117616770fb8833e5692d58bb0059";

	public static boolean checkCourseLiveMD5(String uid, String uuid, String ts, String key, String from) {
		if (uid == null) {
			uid = "";
		}
		String salt = SALT;
		if ("pc".equals(from) || "weixin".equals(from)) {
			salt = SALT_PC;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			String input = new StringBuilder().append(uuid).append(uid).append(ts).append(salt).toString();
			String myMD5 = byteArrayToHexString(messageDigest.digest(input.getBytes("UTF-8")));
			if (key != null && key.equals(myMD5)) {
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean checkMD5(HttpServletRequest request, String sign, String from) {
		if (request == null || sign == null)
			return false;

		StringBuilder sb = new StringBuilder();
		List<String> keyList = new LinkedList<String>(request.getParameterMap().keySet());
		Collections.sort(keyList);
		for (String key : keyList) {
			if (key.equals("sign")) {
				continue;
			}
			sb.append(key).append("=").append(request.getParameter(key)).append(";");
		}
		String salt = SALT;
		if ("pc".equals(from)) {
			salt = SALT_PC;
		}
		String input = sb.append(salt).toString();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			String myMD5 = byteArrayToHexString(messageDigest.digest(input.getBytes("UTF-8")));
			System.out.println(myMD5);
			if (sign != null && sign.equals(myMD5)) {
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return false;
	}

	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuilder buf = new StringBuilder(len * 2);
		// 把密文转换成十六进制的字符串形式
		for (int j = 0; j < len; j++) {
			buf.append(DIGITS_LOWER[(bytes[j] >> 4) & 0x0f]);
			buf.append(DIGITS_LOWER[bytes[j] & 0x0f]);
		}
		return buf.toString();
	}

	public static String sha1Encode(String str) {
		if (str == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
			messageDigest.update(str.getBytes());
			return getFormattedText(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * md5签名 data 为需要验签的数据 salt为盐值 encode为编码
	 * @param data
	 * @param salt
	 * @param encode
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String genSign(Map<String, String> data, String salt) throws UnsupportedEncodingException {

		Set<String> keySet = data.keySet();
		String[] keyArray = keySet.toArray(new String[keySet.size()]);
		Arrays.sort(keyArray);
		StringBuilder sb = new StringBuilder();
		for (String k : keyArray) {
			if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
				sb.append(k).append("=").append(data.get(k).trim()).append("&");
		}
		sb.append("salt=").append(salt);
		return genMD5(sb.toString());

	}

	/**
	 * md5签名 data 为需要验签的数据 默认盐值为putao0409 编码规则为utf-8
	 * @param map
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String genSign(Map<String, String> map) throws UnsupportedEncodingException {
		return genSign(map, "putao0409");
	}
	
	public static String genMD5(String string) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(string.getBytes());
			System.out.println(new String(md5));
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String genToken() {
		String token = UUID.randomUUID().toString().replaceAll("-", "") + "";
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(token.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
