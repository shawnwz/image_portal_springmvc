/* This file DateUtils.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils extends org.apache.commons.lang.time.DateUtils{
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat weekNameSdf = new SimpleDateFormat("E", Locale.CHINA);
	public static final SimpleDateFormat weekEnNameSdf = new SimpleDateFormat("E", Locale.US);
	public static final SimpleDateFormat ymdSdfSeries = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat ymdSdf = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat ymdSdfSlash = new SimpleDateFormat("yyyy/MM/dd");
	public static final SimpleDateFormat ymdhmSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat ymdhmsSdf = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final SimpleDateFormat ymSdf = new SimpleDateFormat("yyyy-MM");
	public static final SimpleDateFormat ySdf = new SimpleDateFormat("yyyy");
	
	public static Date getDateYmd(Date date){
		try{
			return DateUtils.parse(DateUtils.getDatestr(date, DateUtils.ymdSdf), DateUtils.ymdSdf);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public static String getWeekName(Date date){
		return weekNameSdf.format(date);
	}
	
	public static String getWeekEnName(Date date){
		return weekEnNameSdf.format(date);
	}
	
	public static String getYMD(Date date){
		return ymdSdf.format(date);
	}
	public static String getYYYYMMDD(Date date){
		return ymdSdfSeries.format(date);
	}
	public static String getDateStr(Date date){
		return sdf.format(date);
	}
	
	public static String getDatestr(Date date, SimpleDateFormat sdf){
		return sdf.format(date);
	}
	
	public static Date parse(String dateStr, SimpleDateFormat sdf) throws ParseException{
		return sdf.parse(dateStr);
	}
	
	public static Date parse(String dateStr, SimpleDateFormat sdf, SimpleDateFormat sdf1) throws ParseException{
		try{return sdf.parse(dateStr);}
		catch (Exception e) {
			return sdf1.parse(dateStr);
		}
	}
	
	/**
	 * 判断传入日期时间是否已经超过字符串时间
	 * @param date
	 * @param timeStr
	 * @return
	 */
	public static boolean afterTime(Date date, String timeStr){
		if(StrUtils.isBlank(timeStr)
				|| !timeStr.matches("(([0-1][0-9])|(2[0-3])):[0-5][0-9]")){
			return false;
		}
		String[] eles = timeStr.split(":");
		int hours = StrUtils.getIntValue(eles[0], 0);
		int minutes = StrUtils.getIntValue(eles[1], 0);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int dateHour = cal.get(Calendar.HOUR_OF_DAY);
		
		if(dateHour > hours){
			return true;
		}
		else if(dateHour==hours){
			return cal.get(Calendar.MINUTE)>=minutes;
		}
		return false;
		
	}
	
	public static boolean betweenTime(Date date, String timeStr){
		if(StrUtils.isBlank(timeStr)
				|| !timeStr.matches("(([0-1][0-9])|(2[0-3])|([0-9])):[0-5][0-9]-(([0-1][0-9])|(2[0-3])|([0-9])):[0-5][0-9]")){
			return false;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int code = hour*60+minute;
		
		String[] times = timeStr.split("-");
		int leftCode = 0;
		String[] lefts = times[0].split(":");
		leftCode = Integer.parseInt(lefts[0])*60 + Integer.parseInt(lefts[1]);
		if(code<leftCode) return false;
		
		int rightCode = 0;
		String[] rights = times[1].split(":");
		rightCode = Integer.parseInt(rights[0])*60 + Integer.parseInt(rights[1]);
		if(code>=rightCode) return false;
		
		return true;
	}
	
	public static boolean beforeTime(Date date, String timeStr){
		if(StrUtils.isBlank(timeStr)
				|| !timeStr.matches("(([0-1][0-9])|(2[0-3])):[0-5][0-9]")){
			return false;
		}
		String[] eles = timeStr.split(":");
		int hours = StrUtils.getIntValue(eles[0], 0);
		int minutes = StrUtils.getIntValue(eles[1], 0);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int dateHour = cal.get(Calendar.HOUR_OF_DAY);
		
		if(dateHour < hours){
			return true;
		}
		else if(dateHour==hours){
			return cal.get(Calendar.MINUTE)<=minutes;
		}
		return false;
		
	}
	
	public static int getPeriodDays(Date birthDate){
		if(birthDate==null) return 0;
		long space = birthDate.getTime() - System.currentTimeMillis();
		int days = (int)(space / (86400000));
		if(space%86400000!=0){
			days++;
		}
		days = days<=280 ? days:280;
		days = days>=0 ? days:0;
		return 280-days;
	}
	
	public static int getPeriodWeeks(Date birthDate){
		int week = getPeriodDays(birthDate) / 7;
		return week; 
	}
	
	public static int getAge(Date birthday){
//		if(birthday==null) return -1;
//		return (int)((System.currentTimeMillis()-birthday.getTime()) / (365*86400*1000L));
		if(birthday==null) return -1;
        Calendar cal = Calendar.getInstance(); 
        if (cal.before(birthday)) { 
            return 0;
        } 

        int yearNow = cal.get(Calendar.YEAR); 
        int monthNow = cal.get(Calendar.MONTH)+1; 
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); 
        
        cal.setTime(birthday); 
        int yearBirth = cal.get(Calendar.YEAR); 
        int monthBirth = cal.get(Calendar.MONTH)+1; 
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH); 

        int age = yearNow - yearBirth; 

        if (monthNow <= monthBirth) { 
            if (monthNow == monthBirth) { 
                if (dayOfMonthNow < dayOfMonthBirth) { 
                    age--; 
                } 
            } else { 
                age--; 
            } 
        } 
        return age; 
	}
	
	public static boolean betweenTimeRange(Date date, String startTime, String endTime){
		return beforeTime(date, endTime) && afterTime(date, startTime);
	}
	
	public static KeyValue<Long, Long> parseYmdDatePeriod(String str) throws Exception{
    	if(StrUtils.isBlank(str)){
    		return null;
    	}
    	str = str.replace("/", "-");
		str = str.replace("\\", "-");
		if(str.matches("\\d{4}-\\d{1,2}-\\d{1,2}")){
			long time = getSecondStamp(ymdSdf.parse(str));
			return new KeyValue<Long, Long>(time, time);
		}
		else if(str.matches("\\d{4}-\\d{1,2}")){
			Date dateLeft = ymSdf.parse(str);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateLeft);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			return new KeyValue<Long, Long>(getSecondStamp(dateLeft), getSecondStamp(calendar.getTime()));
		}
		else if(str.matches("\\d{4}")){
			Date dateLeft = ymdSdf.parse(str+"-01-01");
			Date dateRight = ymdSdf.parse(str+"-12-31");
			return new KeyValue<Long, Long>(getSecondStamp(dateLeft), getSecondStamp(dateRight));
		}
		return null;
    }
	
	public static Long getSecondStamp(Date date){
		if(date==null) return null;
		return date.getTime()/1000L;
	}

	public static void main(String[] args) throws Exception{
		
//		String str = "7/15/2008 12:00:00 AM";
//		SimpleDateFormat sdd = new SimpleDateFormat("M/d/yyyy h:mm:ss a", Locale.US);
		// 2011-05-25T20:23:54+00:00
		System.out.println(DateUtils.getDateStr(new Date(1408684756L*1000)));
	}
	
}
