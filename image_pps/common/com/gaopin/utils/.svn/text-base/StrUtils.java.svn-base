/* This file StrUtils.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class StrUtils extends StringUtils {

	public static boolean isEnglish(String str){
		if(isBlank(str)) return false;
		return str.length()==str.getBytes().length;
	}
	
	/**
	 * 过滤掉相邻多余的空格
	 * @param str
	 * @return
	 */
	public static String filterMultiSpace(String str){
		char lastChar = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(ch==' ' && lastChar==' '){
				continue;
			}
			sb.append(ch);
			lastChar = ch;
		}
		return sb.toString();
	}
	
	public static String getLimitLenAmg(String content, int len){
		if(isBlank(content)) return content;
		// 取出中括号内容
		boolean append = true;
		StringBuilder sb = new StringBuilder();
		char[] chars = content.toCharArray();
		for(char ch : chars){
			if(ch=='['){
				append = false;
				continue;
			}
			if(ch==']'){
				append = true;
				continue;
			}
			if(append){
				sb.append(ch);
			}
		}
		
		len = sb.length()>len ? len : sb.length();
		String str = sb.substring(0, len);
		return str;
	}
	
	public static String trim(String str, String reg){
		if(str==null) return str;
		str = str.trim();
		while(str.endsWith(reg)){
			str = str.substring(0, str.length()-reg.length());
		}
		return str;
	}
	
	public static String getSqlInArray(String[] args){
		StringBuilder sb = new StringBuilder();
		for(String s : args){
			if(sb.length()>0){
				sb.append(",");
			}
			sb.append("'").append(s).append("'");
		}
		return sb.toString();
	}
	
	public static String array2Str(Object[] objs){
		if(objs==null) return null;
		StringBuilder sb = new StringBuilder();
		for(Object obj : objs){
			sb.append(obj.toString());
		}
		return sb.toString();
	}
	
	public static Boolean getBoolean(String s, Boolean def){
		try{
			if(s.equalsIgnoreCase("true")) return true;
			if(s.equalsIgnoreCase("false")) return false;
			return def;
		}
		catch (Exception e) {
			return def;
		}
	}
	
	public static Integer getIntValue(String s, Integer def) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return def;
		}
	}
	
	public static int getIntValue(String s, int def) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return def;
		}
	}

	public static short getShortValue(String s, short def) {
		try {
			return Short.parseShort(s);
		} catch (Exception e) {
			return def;
		}
	}

	public static Long getLongValue(String s, Long def) {
		try {
			return Long.parseLong(s);
		} catch (Exception e) {
			return def;
		}
	}
	
	public static long getLongValue(String s, long def) {
		try {
			return Long.parseLong(s);
		} catch (Exception e) {
			return def;
		}
	}

	public static String getNullStr(String s, String def) {
		if (s == null)
			return def;
		return s;
	}

	public static String getNullStr(Object s) {
		if(s==null) return "";
		return s.toString();
	}
	public static String getNullStr(String s) {
		return getNullStr(s, "");
	}

	public static String getHtmlSpace(String s) {
		return getNullStr(s, "&nbsp;");
	}

	/**
	 * 大于1M转成MB，小于转成KB
	 * 
	 * @param size
	 * @return
	 */
	public static String smartToSize(Integer size, int limit) {
		if (size > 1024 * 1024) {
			return toMbSize(size, limit) + "M";
		}
		return toKbSize(size) + "K";
	}

	public static String toKbSize(Integer size) {
		Integer kb = size / 1024;
		return kb.toString();
	}

	/**
	 * 
	 * @param size
	 * @param limit
	 *            保留小数点后几位
	 * @return
	 */
	public static String toMbSize(Integer size, int limit) {
		Double mb = size.doubleValue() / (1024 * 1024);
		String str = mb.toString();
		int index = str.indexOf(".");
		String result = str;
		if (index > 0) {
			String prefix = str.substring(0, index);
			String suffix = str.substring(index + 1);
			if (suffix.length() > limit) {
				suffix = suffix.substring(0, limit);
			}
			result = prefix + "." + suffix;
		}
		result = StringUtils.removeEnd(result, "0");
		result = StringUtils.removeEnd(result, ".");
		return result;
	}

	public static String urlEncode(String content, String encode) {
		try {
			return URLEncoder.encode(content, encode);
		} catch (Exception e) {
			e.printStackTrace();
			return content;
		}
	}

	/**
	 * @param str
	 *            需要显示的字符串
	 * @param len
	 *            需要显示的长度(注意：长度是以byte为单位的，一个汉字是2个byte)
	 * @param symbol
	 *            用于表示省略的信息的字符，如“...”,“>>>”等。 只需要提供一个符号即可 表示占位符
	 * @return 返回处理后的字符串
	 */

	public static String getLimitStr(String str, int bytes, String symbol)
			throws Exception {
		// 1.过滤全角字符
		// str = QBchange(str);
		// System.out.println("2."+str);
		// 2.先判断原始字符串总长度
		if (StringUtils.isEmpty(str)) {
			return "";
		}
		byte def_b[] = str.getBytes("GBK");
		if (def_b.length <= bytes) {
			return str;
		}
		// 3.中英文匹配
		Pattern a = Pattern.compile("[\u4e00-\u9fa5]+$");
		String[] split = str.split("");
		int len = 0;
		StringBuilder sb = new StringBuilder();
		for (String s : split) {
			Matcher b = a.matcher(s);
			if (!"".equals(s)) {
				if (b.matches()) {
					// System.out.println(s + " is chinese");
					len += 2;
					if (len <= bytes) {
						if (len <= bytes - 2)
							sb.append(s);
						else {
							for (int i = 0; i < bytes - len; i++)
								sb.append(symbol);
						}
						continue;
					}
				} else {
					// System.out.println(s + " is NOT chinese");
					len += 1;
					if (len <= bytes) {
						if (len <= bytes - 3)
							sb.append(s);
						else {
							for (int i = 0; i < bytes - len; i++)
								sb.append(symbol);
						}
						continue;
					}
				}
			}
			if (len >= bytes) {
				break;
			}
		}
		// System.out.println("len="+len);
		try {
			if (len > bytes) {
				byte b[] = sb.toString().getBytes("GBK");
				// System.out.println("b.lenght="+b.length);
				if (b.length < bytes) {
					for (int i = 0; i < bytes - b.length; i++)
						sb.append(symbol);
				}
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	// 全角转半角
	public static final String QBchange(String QJstr) {
		String outStr = "";
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
			} else
				outStr = outStr + Tstr;
		}
		return outStr;
	}

	public static final String full2HalfChange(String QJstr) {
		StringBuffer outStrBuf = new StringBuffer("");
		String Tstr = "";
		byte[] b = null;
		for (int i = 0; i < QJstr.length(); i++) {
			Tstr = QJstr.substring(i, i + 1);
			// 全角空格转换成半角空格
			if (Tstr.equals("　")) {
				outStrBuf.append(" ");
				continue;
			}
			try {
				b = Tstr.getBytes("unicode");
				// 得到 unicode 字节数据
				if (b[2] == -1) {
					// 表示全角
					b[3] = (byte) (b[3] + 32);
					b[2] = 0;
					outStrBuf.append(new String(b, "unicode"));
				} else {
					outStrBuf.append(Tstr);
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // end for.
		return outStrBuf.toString();

	}
	
	public static String toUnicode(String s) {
		StringBuffer sb = new StringBuffer();
		if (s == null || s.equals(""))
			return "";
		for (int i = 0; i < s.length(); i++) {
			char cChar = s.charAt(i);
			// if(isChinese(cChar))
			if (((int) cChar) > 256) {
				if (isChinese2(cChar)) {
					sb.append("&#x");
					sb.append(Integer.toHexString(cChar));
					sb.append(";");
				}
				continue;
			} else if (((int) cChar) > 127) {
				sb.append("&#x");
				sb.append(Integer.toHexString(cChar));
				sb.append(";");
				continue;
			} else if (((int) cChar) < 32) { //
				continue;
			}
			switch (cChar) {
			case 32: // ' '
				sb.append("&nbsp;");
				break;

			case '$': // '$' 36
				sb.append("＄");
				break;

			case '\'': // '\'' 39
				sb.append("&apos;");
				break;

			case 34: // '"'
				sb.append("&quot;");
				break;

			case 38: // '&'
				sb.append("&amp;");
				break;

			case 60: // '<'
				sb.append("&lt;");
				break;

			case 62: // '>'
				sb.append("&gt;");
				break;
			case 0:
				break;
			case 20: // '\14'
				// sb.append("&gt;");
				break;
			default:
				sb.append(cChar);
				break;
			}
		}

		return sb.toString();
	}

	public static boolean isChinese_bak(char c) {
		Character ch = Character.valueOf(c);
		String sCh = ch.toString();
		try {
			byte bb[] = sCh.getBytes("gb2312");
			if (bb.length > 1) {
				boolean flag = true;
				return flag;
			}
		} catch (UnsupportedEncodingException ue) {
			ue.printStackTrace();
			boolean flag1 = false;
			return flag1;
		}
		return false;
	}

	static sun.io.CharToByteGBK tool = new sun.io.CharToByteGBK();

	public static boolean isChinese2(char ch) {
		return tool.canConvert(ch);
	}

	/**
	 * 十六进制转字符串。
	 * 
	 * @param str
	 *            源字符串
	 * @return 转换后的字符串
	 */
	public static String hex2Str(String hex) {
		return hex2Str(hex, "UTF-8");

	}

	public static String hex2Str(String hex, String charset) {
		if (null == hex)
			return "";

		String res = "";
		byte[] bts = new byte[hex.length() / 2];
		for (int i = 0; i < bts.length; i++) {
			bts[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2),
					16);
		}

		try {
			if ("unicode".equalsIgnoreCase(charset))
				res = new String(bts);
			else
				res = new String(bts, charset);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * 字符串转十六进制。
	 * 
	 * @param str
	 *            源字符串
	 * @return 转换后的字符串
	 */
	public static String str2Hex(String source) {
		return str2Hex(source, "UTF-8");
	}

	public static String str2Hex(String source, String charset) {
		StringBuffer strBuff = new StringBuffer(100);
		String stmp = null;
		if (source == null) {
			return null;
		}

		try {
			byte[] strByte = source.getBytes(charset);
			for (int i = 0; i < strByte.length; i++) {
				stmp = Integer.toHexString(strByte[i] & 0xFF);
				if (stmp.length() == 1) {
					strBuff.append("0");
				}
				strBuff.append(stmp);
			}
		} catch (Throwable ex) {
			ex.printStackTrace();
		}

		return strBuff.toString().trim().toUpperCase();
	}

	/**
	 * 为Velocity使用，Velocity本身不支持数组方法
	 * 
	 * @param objs
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List getArraySize(Object[] objs) {
		List list = new ArrayList();
		if (objs != null) {
			for (Object obj : objs) {
				list.add(obj);
			}
		}
		return list;
	}

	/**
	 * 根据资源ID获取资源类型
	 * 
	 * @param resourceId
	 * @return
	 */
	public static String getResourceType(String resourceId) {
		return "";
	}

	/**
	 */
	public static String splitName(String name, int flag) {
		if (StringUtils.isEmpty(name))
			return name;
		int splitIndex = name.lastIndexOf("(");
		int splitEnd = name.lastIndexOf(")");
		if (splitIndex < 0 || splitEnd < 0 || splitEnd < splitIndex)
			return name;
		String issn = name.substring(splitIndex + 1, splitEnd);// 期刊数
		String rName = name.substring(0, splitIndex);
		if (flag == 1)
			return StringUtils.trim(issn);
		else if (flag == 0)
			return StringUtils.trim(rName);
		return name;
	}

	private static Random randGen = null;
	private static char[] numbersAndLetters = null;
	private static Object initLock = new Object();

	public static final String randomString(int length) {

		if (length < 1) {
			return null;
		}
		if (randGen == null) {
			synchronized (initLock) {
				if (randGen == null) {
					randGen = new Random();
					numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"
							+ "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ")
							.toCharArray();
					// numbersAndLetters =
					// ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
				}
			}
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
			// randBuffer[i] = numbersAndLetters[randGen.nextInt(35)];
		}
		return new String(randBuffer);
	}

	public static final String format(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat(
				"EEE, d MMM yyyy HH:mm:ss z", Locale.US);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(d);
	}

	/**
	 * 将字符串形式的键值对分割为map存储形式，比如：用逗号分割每一个键值对，=号分割key和value
	 * 
	 * @param line
	 * @param delim
	 * @param delimkv
	 * @return 创建人： songlekan 创建时间：2012-7-9 上午09:57:34
	 */
	public static Map<String, String> str2HashMap(String line, String delim,
			String delimkv) {
		if (line != null && !line.equals("")) {
			String[] keyValues = line.split(delim);
			Map<String, String> map = new HashMap<String, String>();
			for (String keyValue : keyValues) {
				String[] kv = keyValue.split(delimkv);
				map.put(StringUtils.trim(kv[0]), StringUtils.trim(kv[1]));
			}
			return map;
		}
		return null;
	}

	/**
	 * 替换网页抓取的文本内容
	 * 
	 * @param str
	 * @return 创建人： zhugzh 创建时间：2013-6-17 下午03:13:20
	 */
	public static final String charChangeForHtml(String str) {
		if (str == null || str == "") {
			return str;
		}
		String result = str.replace("&ldquo;", "\\\"").replace("&rdquo;",
				"\\\"");// 替换"""号
		result = result.replace("&mdash;", "—");// 替换中文横杠
		result = result.replace("&hellip;", "…");
		result = result.replace("&#12539;", "・");
		result = result.replace("&middot;", "·");
		result = result.replace("&nbsp;", " ");
		result = result.replace("&rsquo;", "’");
		result = result.replace("&lsquo;", "‘");
		return result;
	}

	public static String byte2HexStr(byte[] b) {
		String stmp = "";
		StringBuilder sb = new StringBuilder("");
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0xFF);
			sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
			sb.append(" ");
		}
		return sb.toString().toUpperCase().trim();
	}

	public static byte[] hex2byte(String str) {
		if (str == null) {
			return null;
		}
		str = str.trim();
		int len = str.length();
		if ((len == 0) || (len % 2 == 1))
			return null;
		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[(i / 2)] = (byte) Integer.decode(
						"0x" + str.substring(i, i + 2)).intValue();
			}
			return b;
		} catch (Exception e) {
		}
		return null;
	}

	private static sun.io.ByteToCharUnicode byte2Unicode = new sun.io.ByteToCharUnicode();
	private static sun.io.CharToByteUnicode char2Byte = new sun.io.CharToByteUnicode();
	
	@SuppressWarnings("deprecation")
	public static String toUnicodeHex(String s) {
		try{
		String hex = byte2HexStr(char2Byte.convertAll(s.toCharArray()));
		hex = hex.replace(" ", "");
		return hex.substring(4);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@SuppressWarnings("deprecation")
	public static String unicodeHex2Str(String hex) {
		hex = "FFFE" + hex;
		try{
			return new String(byte2Unicode.convertAll(hex2byte(hex)));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	/**
	 * 隐藏手机号后四位
	 * @param mobile
	 * @return
	 * 创建人：  songlekan   
	 * 创建时间：2013-10-7  下午2:44:24
	 */
	public static String getMobileTitle(Long mobile){
		if(mobile == null){
			return "";
		}
		String mobileStr = mobile.toString();
		String prifix = mobileStr.substring(0, 3);
		String suffix = mobileStr.substring(7);
		String mobileTitle = prifix + "****" + suffix;
		return mobileTitle;
	}
	
	/**
	 * 判断手机号码是否合法
	 * @param mobileNo
	 * @return
	 * 创建人：  songlekan   
	 * 创建时间：2013-10-14  下午1:34:20
	 */
	public static  boolean isMobileNo(String mobileNo){
		if(isBlank(mobileNo)){
			return false;
		}
		Long mobile = getLongValue(mobileNo, 0);
		if(mobile == 0){
			return false;
		}
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobileNo);
		return m.matches();
	} 
	
	public static boolean isChinese(char c) {  
		  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
  
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
  
            return true;  
  
        }  
  
        return false;  
  
    }
	
	public static boolean isEnglish(char ch){
		if(ch<128) return true;
		if (ch == 0x40) return true;  
        if (ch == 0x2D || ch == 0x2F) return true;  
        if (0x23 <= ch && ch <= 0x26) return true;  
        if (0x28 <= ch && ch <= 0x2B) return true;          
        if (0x3C <= ch && ch <= 0x3E) return true;          
        if (0x5B <= ch && ch <= 0x60) return true;  
        if (0x7B <= ch && ch <= 0x7E) return true;  
        if (0x21 <= ch && ch <= 0x22) return true;  
        if (ch == 0x27 || ch == 0x2C) return true;  
        if (ch == 0x2E || ch == 0x3A) return true;  
        if (ch == 0x3B || ch == 0x3F) return true;  
        return false;
	}
	
	public static void main(String[] args) throws Exception{
			
			String s = "马尔士戴维斯";
			for(char c : s.toCharArray()){
				
				System.out.println(c+":"+(isChinese(c)||isEnglish(c)));
			}
		}
	
	public static String getMediaType(String gaopinid){
		
		if(gaopinid.startsWith("13")){
			return "image";
		}else if(gaopinid.startsWith("15")){
			return "motion";
		}else{
			return null;
		}
		
	}
	
}
