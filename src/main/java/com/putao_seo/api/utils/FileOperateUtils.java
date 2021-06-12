package com.putao_seo.api.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileOperateUtils {

	public static String separator = "  ";

	public static String readTxt(String filePathAndName, String encoding) throws IOException {
		encoding = encoding.trim();
		StringBuffer str = new StringBuffer("");
		String st = "";
		
		try {
			FileInputStream fs = new FileInputStream(filePathAndName);
			InputStreamReader isr;
			if (encoding.equals("")) {
				isr = new InputStreamReader(fs);
			} else {
				isr = new InputStreamReader(fs, encoding);
			}
			BufferedReader br = new BufferedReader(isr);
			String data = "";
			while ((data = br.readLine()) != null) {
				str.append(data + separator);
			}
			st = str.toString().substring(0, str.length()-1);
			fs.close();
			isr.close();
			br.close();
		} catch (Exception es) {
			st = "";
		}
		return st;
	}
}
