/* This file PinYinUtils.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

import org.apache.commons.lang.StringUtils;
public class PinYinUtils{

	/**
	 * 获取简拼
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String getPy(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		}
		str = StringUtils.replace(str.trim(), " ", "");
		str = castSBCcase(str);
		String py = "";
		try {
			for (int i = 0; i < str.length(); i++) {
				String temp = str.substring(i, i + 1);
				temp = castSBCcaseSingle(temp);
				if (isParticular(temp)){// 特殊字符
					py += temp;
					continue;
				} 
				if (isNumOrChar(temp)){// 数字或字母
					py += temp;
				} else {
					py += getCharPY(temp);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return py;
	}

	/**
	 * 判断是否为特殊字符
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isParticular(String str) {
		char[] ch = { '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')',
				'_', '+', '{', '}', '|', ':', '"', '<', '>', '?', '`', '-',
				'=', '[', ']', '\\', ';', '\'', ',', '.', '/', '、', '。', '‘',
				'’' };
		boolean flag = false;
		if(StringUtils.isBlank(str)){
			return false;
		}
		str = str.trim();
		try{
			for (int i = 0; i < ch.length; i++) {
				if (str.charAt(0) == ch[i]) {
					flag = true;
					break;
				}
			}
		}catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 判断字符是否是全角
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isSBCcase(String str) {
		return str.getBytes().length > 1;
	}

	/**
	 * 全角转半角 单个字符
	 * 
	 * @param str
	 * @return
	 */
	private static String castSBCcaseSingle(String str)
			throws UnsupportedEncodingException {
		String strReturn = "";
		if (StringUtils.isBlank(str)) {
			return strReturn;
		}
		byte[] b = null;
		b = str.getBytes("unicode");
		if (b[3] == -1) {
			b[2] = (byte) (b[2] + 32);
			b[3] = 0;
			try {
				strReturn = new String(b, "unicode");
			} catch (java.io.UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return strReturn;
		}
		return str;
	}

	/**
	 * 全角转半角
	 * 
	 * @param QJstr
	 * @return
	 */
	private static final String castSBCcase(String QJstr) {
		String outStr = "";
		if (StringUtils.isBlank(QJstr)) {
			return outStr;
		}
		String Tstr = "";
		byte[] b = null;

		for (int i = 0; i < QJstr.length(); i++) {
			try {
				Tstr = QJstr.substring(i, i + 1);
				b = Tstr.getBytes("unicode");
			} catch (java.io.UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (b[3] == -1) {
				b[2] = (byte) (b[2] + 32);
				b[3] = 0;
				try {
					outStr = outStr + new String(b, "unicode");
				} catch (java.io.UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				continue;
			} 
			outStr = outStr + Tstr;
		}
		return outStr;
	}

	/**
	 * 判断是否为字母或数字
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isNumOrChar(String str) {
		Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");// 数字或者字母
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 获取简拼
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String getEachFirstLetter(String str) {
		String py = "";
		if (StringUtils.isBlank(str)) {
			return py;
		}
		for (int i = 0; i < str.length(); i++) {
			py += getCharPY(str.substring(i, i + 1));
		}
		return py;
	}

	/**
	 * 获取单个字符的拼音简写
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private static String getCharPY(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		}
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		try {
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(str.toCharArray()[0], format);
			if (pinyinArray == null) {
				return "";
			}
			String pinyinArrayA = pinyinArray[0];
			String substringA = pinyinArrayA.substring(0, 1);
			String substringB = substringA.toUpperCase();
			return substringB;
		} catch (Exception e) {
			e.printStackTrace();
			return str;
		}
	}
	private static String getFullPY(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		}
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		try {
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(str.toCharArray()[0], format);
			if (pinyinArray == null) {
				return "";
			}
			String pinyinArrayA = pinyinArray[0];
			return pinyinArrayA;
		} catch (Exception e) {
			e.printStackTrace();
			return str;
		}
	}
	
	public static String getFullPy(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		}
		str = StringUtils.replace(str.trim(), " ", "");
		str = castSBCcase(str);
		String py = "";
		try {
			for (int i = 0; i < str.length(); i++) {
				String temp = str.substring(i, i + 1);
				temp = castSBCcaseSingle(temp);
				if (isParticular(temp)){// 特殊字符
					py += temp;
					continue;
				} 
				if (isNumOrChar(temp)){// 数字或字母
					py += temp;
				} else {
					py += getFullPY(temp);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return py;
	}
	
	public static void main(String[] args) {
		System.out.println(getFullPy("的飞洒"));
		System.out.println(getEachFirstLetter("的飞洒"));
	}
}


