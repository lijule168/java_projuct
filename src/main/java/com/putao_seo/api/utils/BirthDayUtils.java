package com.putao_seo.api.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class BirthDayUtils {
	
	
	/**
	 * 计算年龄
	 * @param birthday
	 * @return 异常数据返回0岁
	 */
	public static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) 
                		<birth.get(Calendar.DAY_OF_YEAR)) {
                    age -= 1;
                }
            }
            return age;
        } catch (Exception e) {
           return 0;
        }
    }
	
	/**
	 * 使用java 8的ChronoUnit，ChronoUnit可以以多种单位（基本涵盖了所有的，看源码发现竟然还有“FOREVER”这种单位。。）表示两个时间的时间差
	 */
	public static long calculateTimeDifferenceByChronoUnit(Date startDate,Date endDate) {
	    LocalDate Date1 = UDateToLocalDate(startDate);
	    System.out.println("开始时间：" + startDate);

	    LocalDate Date2 = UDateToLocalDate(endDate);
	    System.out.println("结束时间：" + endDate);

	    long daysDiff = ChronoUnit.DAYS.between(Date1, Date2);
	    System.out.println("两个时间之间的天数差为：" + daysDiff);
	    return daysDiff;
	}
	
	public static LocalDate UDateToLocalDate(Date date) {
	    Instant instant = date.toInstant();
	    ZoneId zone = ZoneId.systemDefault();
	    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
	    return localDateTime.toLocalDate();
	}
	
}
