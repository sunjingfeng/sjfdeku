package com.zs.pms.utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.crypto.Data;

/**
 * 时间工具类
 * 
 * @author Administrator
 *
 */
public class DateUtil {
	/**
	 * 获得当前时间的方法
	 * 
	 * @return
	 */
	public static String getStrDate(Date date) {
		// 获得日历对象
		Calendar cal = Calendar.getInstance();
		// 当前的年
		int y = cal.get(Calendar.YEAR);
		// 当前的月(月份从0开始)
		int m = cal.get(Calendar.MONTH) + 1;
		// 当前的日
		int d = cal.get(Calendar.DATE);
		// 当前的小时
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		// 通过获得的当前小时来判断是上午，中午还是下午
		String str = "";
		if (hh > 6 && hh <= 11) {
			str = "上午好！";
		} else if (hh > 11 & hh <= 14) {
			str = "中午好!";
		} else if (hh > 14 && hh < 18) {
			str = "下午好!";
		} else if (hh > 18 && hh < 24) {
			str = "晚上好!";
		} else {
			str = "玩什么玩，快去睡";
		}
		return y + "-" + m + "-" + d + "" + str;

	}

	//当前时间转成字符串
	public static String getdataToStr(Data date) {
		DateFormat aFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return aFormat.format(date);
	}
	//字符串转时间
	public static Date getStrToDate(String s, String format) throws ParseException {
		DateFormat aFormat =new SimpleDateFormat(format);
		return aFormat.parse(s);
	}

}
