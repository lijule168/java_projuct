package com.putao_seo.api.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * 	获取今天起始时间和结束时间
 * @author xiaoct
 *
 */
public class DateUtils {

	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	
	public static Date getBeginTime() {
		LocalDateTime lo = LocalDateTime.now();
		LocalDateTime begin = LocalDateTime.of(lo.getYear(), lo.getMonth(), lo.getDayOfMonth(), 0, 0,0);
        ZonedDateTime beginTime = begin.atZone(ZoneId.systemDefault());//Combines this date-time with a time-zone to create a  ZonedDateTime.
        return Date.from(beginTime.toInstant());		 
	}
	
	public static Date getEndTime() {
		LocalDateTime lo = LocalDateTime.now();
		LocalDateTime end = LocalDateTime.of(lo.getYear(), lo.getMonth(), lo.getDayOfMonth(),23,59,59);
        ZonedDateTime endTime = end.atZone(ZoneId.systemDefault());//Combines this date-time with a time-zone to create a  ZonedDateTime.
        return Date.from(endTime.toInstant());		 
	}

	public static Date getNowTime() {
		LocalDateTime lo = LocalDateTime.now();
		LocalDateTime begin = LocalDateTime.of(lo.getYear(), lo.getMonth(), lo.getDayOfMonth(), lo.getHour(), lo.getMinute(),lo.getSecond());
		ZonedDateTime beginTime = begin.atZone(ZoneId.systemDefault());//Combines this date-time with a time-zone to create a  ZonedDateTime.
		return Date.from(beginTime.toInstant());
	}

	public static Date getThirtyMinBeforeTime() {
		LocalDateTime lo = LocalDateTime.now().minusMinutes(50);
		LocalDateTime begin = LocalDateTime.of(lo.getYear(), lo.getMonth(), lo.getDayOfMonth(), lo.getHour(), lo.getMinute(),lo.getSecond());
		ZonedDateTime beginTime = begin.atZone(ZoneId.systemDefault());//Combines this date-time with a time-zone to create a  ZonedDateTime.
		return Date.from(beginTime.toInstant());
	}

	public static Date getFiveMinBeforeTime() {
		LocalDateTime lo = LocalDateTime.now().minusMinutes(30);
		LocalDateTime begin = LocalDateTime.of(lo.getYear(), lo.getMonth(), lo.getDayOfMonth(), lo.getHour(), lo.getMinute(),lo.getSecond());
		ZonedDateTime beginTime = begin.atZone(ZoneId.systemDefault());//Combines this date-time with a time-zone to create a  ZonedDateTime.
		return Date.from(beginTime.toInstant());
	}

	/**
	 * String返回时间
	 * @param format
	 * @param date
	 * @return
	 */
	public static Date getStringDate(String format,String date) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(date);
	}


	/**
	 * 返回时间String
	 * @param format
	 * @param date
	 * @return
	 */
	public static String getDateString(String format,Date date) throws Exception{
		return new SimpleDateFormat(format).format(date);
	}
	
	
	public static Date getNumDayAfter(Integer num) throws Exception{
			Calendar now = Calendar.getInstance();
			System.out.println("NOW DATE:"+ new Date().getTime());
	        now.add(Calendar.DAY_OF_MONTH, +30);
	        return now.getTime();
	}

}
