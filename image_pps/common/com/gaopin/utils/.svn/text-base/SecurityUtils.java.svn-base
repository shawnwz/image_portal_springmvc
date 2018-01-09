/* This file SecurityUtils.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SecurityUtils
{
	private final static String SCKEY = "Pi%~-Uo&^23)@Uj9O";
	private static SecurityUtils instance = new SecurityUtils();
	public static SecurityUtils getInstance(){
		return instance;
	}
	
	/**
	 * DES encrypt
	 * 
	 * @param byte[]
	 *            src the byte that is encrypted
	 * @param byte[]
	 *            enKey DES key
	 * @return byte[] byte after encrypt
	 */
	public byte[] Encrypt(byte[] src, byte[] enKey)
	{
		byte[] encryptedData = null;
		try
		{
			DESKeySpec dks = new DESKeySpec(enKey);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encryptedData = cipher.doFinal(src);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return encryptedData;
	}

	/**
	 * Base64 encode
	 * 
	 * @param byte[]
	 *            src the byte to be encoded
	 * 
	 * @return String the string after encoding
	 */

	public String getBase64Encode(byte[] src)
	{
		String requestValue = "";
		try
		{
			BASE64Encoder base64en = new BASE64Encoder();
			requestValue = base64en.encode(src);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return requestValue;
	}

	/**
	 * Delete the newline symbol of string When base64 encode DES string�� there
	 * are some newline symbols
	 * 
	 */
	private String filter(String str)
	{
		String output = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++)
		{
			int asc = str.charAt(i);
			if (asc != 10 && asc != 13)
				sb.append(str.subSequence(i, i + 1));
		}
		output = new String(sb);
		return output;
	}

	/**
	 * do URLDecoder.encode(strEncoding) to a string
	 * 
	 * @param String
	 *            src string that will be encoded
	 * 
	 * @return String Retrun string after encode
	 */

	public String getURLEncode(String src)
	{
		String requestValue = "";
		try
		{

			requestValue = URLEncoder.encode(src, "utf-8");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return requestValue;
	}

	/**
	 * DES encrypt
	 * 
	 * @param String
	 *            src Des encrypting stringing
	 * @param String
	 *            spkey DES Kry value
	 * @return String Return string after encrypting
	 */

	public String getDESEncrypt(String src, String spkey)
	{
		String requestValue = "";
		try
		{

			byte[] enKey = spkey.getBytes();

			byte[] src2 = src.getBytes();

			byte[] encryptedData = Encrypt(src2, enKey);

			String base64String = getBase64Encode(encryptedData);

			String base64Encrypt = filter(base64String);

			requestValue = getURLEncode(base64Encrypt);

		}
		catch (Exception e)
		{
			System.out.println("this is an error.");
			e.printStackTrace();
		}

		return requestValue;
	}

	/**
	 * Do URLDecoder.decode(strEncoding) to string
	 * 
	 * @param String
	 *            src The string that will be decoded
	 * 
	 * @return String Return string after decoding
	 */

	public String getURLDecoderdecode(String src)
	{
		String requestValue = "";
		try
		{
			requestValue = URLDecoder.decode(src, "utf-8");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return requestValue;
	}

	/**
	 * 
	 * Do des encrypt��
	 * 
	 * @param byte[]
	 *            src The byte that will be decrypted
	 * @param String
	 *            spkey Des key
	 * @return String Retrun string after decrypt
	 */
	public String deCrypt(byte[] debase64, String spKey)
	{
		String strDe = null;
		Cipher cipher = null;
		try
		{
			cipher = Cipher.getInstance("DES");
			byte[] key = spKey.getBytes();
			DESKeySpec dks = new DESKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey sKey = keyFactory.generateSecret(dks);
			cipher.init(Cipher.DECRYPT_MODE, sKey);
			byte ciphertext[] = cipher.doFinal(debase64);
			strDe = new String(ciphertext);
		}
		catch (Exception ex)
		{
			strDe = "";
			ex.printStackTrace();
		}
		return strDe;
	}

	/**
	 * DES decrypt
	 * 
	 * @param String
	 *            src The string that will be decrypted
	 * @param String
	 *            spkey des key
	 * @return String Return string after decrypt
	 */
	public String getDESDecrypt(String src, String spkey)
	{
		String requestValue = "";
		try
		{

			// URLDecoder.decodeTML The process that control code is decoded.
			String URLValue = getURLDecoderdecode(src);
			// Do BASE64 decode for des encrypted string

			BASE64Decoder base64Decode = new BASE64Decoder();
			byte[] base64DValue = base64Decode.decodeBuffer(URLValue);
			requestValue = deCrypt(base64DValue, spkey);
		}
		catch (Exception e)
		{
			System.out.println("this is an error too.");
			e.printStackTrace();
		}
		return requestValue;
	}
	
	public static String encrypt(String content){
		return instance.getDESEncrypt(content, SCKEY);
	}
	
	public static String decrypt(String content){
		return instance.getDESDecrypt(content, SCKEY);
	}

	public static void main(String[] args)
	{
		String oldString ="zhurenjie";
		
		System.out.println("2. des string: " + oldString);
		String reValue = encrypt(oldString);
		System.out.println("3. string after des encrypt: " + reValue);
		
		String reValue2 = decrypt(reValue);
		System.out.println("4. string after des decrypt: " + reValue2);

	}

}