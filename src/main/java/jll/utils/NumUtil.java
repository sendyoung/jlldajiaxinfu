package jll.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class NumUtil {
	public static String Num() {

		try {
			Properties prop = new Properties();
			// 程序第一次运行时，配置文件不存在，需要先创建文件
			// 操作文件时，最好将文件封装成File对象，这是个好习惯
			File file = new File("count.properties");
			if (!file.exists())
				file.createNewFile();
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);

			// 获取属性，即程序运行次数
			int count = 0;
			String value = prop.getProperty("time");
			if (value != null) {
				count = Integer.parseInt(value);
			}
			count++;
			prop.setProperty("time", count + "");

			FileOutputStream fos = new FileOutputStream(file);
			prop.store(fos, "");


			String str = new SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
			long m = Long.parseLong((str)) * 10000;
			long ret = m + count;
			//count = count + 1;
			fos.close();
			fis.close();
			return "JLL" + ret;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
