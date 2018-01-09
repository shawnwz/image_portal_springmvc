/* This file ProcessHelper.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;


public class ProcessHelper {

	
	public static String searchTest(String cmd) throws InterruptedException {
        try {

            // 使用Runtime来执行command，生成Process对象

            Process process = Runtime.getRuntime().exec(new String[] {"/bin/sh","-c",cmd,"&"});

            process.waitFor();

            // 取得命令结果的输出流

            InputStream is = process.getInputStream();

            // 用一个读输出流类去读

            InputStreamReader isr = new InputStreamReader(is);

            // 用缓冲器读行

            BufferedReader br = new BufferedReader(isr);

            String line = null;

            while ((line = br.readLine()) != null) {

                System.out.println(line);

            }

            is.close();

            isr.close();

            br.close();
            process.destroy();

        } catch (java.io.IOException e) {

            System.err.println("IOException " + e.getMessage());

        }
        return "";

    }


	public static String SpecCmd(String cmd) throws InterruptedException
	{
        StringBuilder sb=new StringBuilder();
		try {

            // 使用Runtime来执行command，生成Process对象

            Process process = Runtime.getRuntime().exec(cmd);
            Thread.sleep(130);
            process.waitFor();
            // 取得命令结果的输出流
            InputStream is = process.getInputStream();
            // 用一个读输出流类去读
            InputStreamReader isr = new InputStreamReader(is);
            // 用缓冲器读行
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
            process.destroy();
            is.close();

            isr.close();

            br.close();
        } catch (java.io.IOException e) {

            System.err.println("IOException " + e.getMessage());

        }
		return sb.toString().trim();
		
	}
	public static String SpecCmdGetIPTCMin(String path) throws InterruptedException
	{
		String cmd = "/usr/local/bin/identify " + path + "";
		String out=SpecCmd(cmd);
		///home/data2/ftp/launcher/RightsManaged011_Ultra/BLM001601.jpg JPEG 5085x3429 5085x3429+0+0 8-bit sRGB 12.39MB 0.010u 0:00.020
		String[] outs=out.split(" ");
		StringBuffer sb=new StringBuffer();
		/*
		 Image: /home/data3/ftp/launcher/Hi-res-images-KM11-14/25801011864.jpg
Geometry: 5616x3744+0+0
Colorspace: sRGB
		 */
		System.out.println("oooooooooooo"+out);
		sb.append("Image:");
		sb.append(path);
		sb.append("\r\n");
		sb.append("Geometry:");
		sb.append(outs[3]);
		sb.append("\r\n");
		sb.append("Colorspace:");
		sb.append(outs[5]);
		sb.append("\r\n");
		//System.out.println(sb.toString());
		return sb.toString();
	}

	public static String SpecCmdGetIPTC(String path) throws InterruptedException
	{
		String cmd = "/usr/local/bin/identify -verbose " + path + "";
		System.out.println(cmd);
        StringBuilder sb=new StringBuilder();
        Process process=null;
        StreamGobbler errorGobbler =null;
        
		try {
            // 使用Runtime来执行command，生成Process对象
             process = Runtime.getRuntime().exec(cmd);
             errorGobbler = new StreamGobbler(process.getErrorStream(), "ERROR");              
//            // kick off stderr  
            errorGobbler.start();  
//            StreamGobbler outGobbler = new StreamGobbler(process.getInputStream(), "STDOUT");  
//            // kick off stdout  
//            outGobbler.start();  
            process.waitFor();
            // 取得命令结果的输出流
            InputStream is = process.getInputStream();
            // 用一个读输出流类去读
            InputStreamReader isr = new InputStreamReader(is);
            // 用缓冲器读行
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            int linecount=0;
            while ((line = br.readLine()) != null) {
            	////////////////////////////////////
            	linecount++;
            	if(linecount>1000)
            		break;
				if(line.indexOf(":")<=0)
					continue;
//                System.out.println(line);
                sb.append(line+"\n");
            }
            process.destroy();
            is.close();

            isr.close();

            br.close();
        } catch (java.io.IOException e) {

            System.err.println("IOException " + e.getMessage());
        }finally{
        	if(errorGobbler!=null)
        	{
        		try {
        			if(errorGobbler.isAlive())
        			{
        			errorGobbler.stop();
					errorGobbler.destroy();
        			}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
        	}
        }
		return sb.toString().trim();
		
	}
	public static class StreamGobbler extends Thread {
		InputStream is;
		String type;
		OutputStream os;
		    
		StreamGobbler(InputStream is, String type) {
			this(is, type, null);
		}

	    StreamGobbler(InputStream is, String type, OutputStream redirect) {
	        this.is = is;
	        this.type = type;
	        this.os = redirect;
	    }
	    
	    public void run() {
	        InputStreamReader isr = null;
	        BufferedReader br = null;
	        PrintWriter pw = null;
	        try {
	            if (os != null)
	                pw = new PrintWriter(os);
	                
	            isr = new InputStreamReader(is);
	            br = new BufferedReader(isr);
	            String line=null;
	            while ( (line = br.readLine()) != null) {
	                if (pw != null)
	                    pw.println(line);
	                System.out.println(type + ">" + line);    
	            }
	            
	            if (pw != null)
	                pw.flush();
	        } catch (IOException ioe) {
	            ioe.printStackTrace();  
	        } finally{
	        	try {
	        	pw.close();
	        	br.close();
	        	isr.close();
				} catch (Exception e) {
					//e.printStackTrace();
				}
	        	
	        }
	    }
	} 

    /** 
     * 读取控制命令的输出结果 
     * 
     * @param cmd                命令 
     * @param isPrettify 返回的结果是否进行美化（换行），美化意味着换行，默认不进行美化,当此参数为null时也不美化， 
     * @return 控制命令的输出结果 
     * @throws IOException 
     */ 
    public static String readConsole(String cmd, Boolean isPrettify) throws IOException { 
            StringBuffer cmdout = new StringBuffer(); 
            System.out.println("执行命令：" + cmd); 
            Process process = Runtime.getRuntime().exec(cmd);     //执行一个系统命令 
            InputStream fis = process.getInputStream(); 
            BufferedReader br = new BufferedReader(new InputStreamReader(fis)); 
            String line = null; 
            if (isPrettify == null || isPrettify) { 
                    while ((line = br.readLine()) != null) { 
                            cmdout.append(line); 
                    } 
            } else { 
                    while ((line = br.readLine()) != null) { 
                            cmdout.append(line).append(System.getProperty("line.separator")); 
                    } 
            } 
            System.out.println("执行系统命令后的结果为：\n" + cmdout.toString()); 
            return cmdout.toString().trim(); 
    } 



}
