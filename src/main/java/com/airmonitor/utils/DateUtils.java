package com.airmonitor.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String getOrderNo() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
		 String str = format.format(new Date()); 
		 return str;
	}
	public static String getCurrent() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 String str = format.format(new Date()); 
		 return str;
	}
	public static String getCurrentDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		String str = format.format(new Date()); 
		return str;
	}
}
