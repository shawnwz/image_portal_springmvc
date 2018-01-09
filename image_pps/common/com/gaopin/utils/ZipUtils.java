/* This file ZipUtils.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Deflater;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class ZipUtils {
	
	public static final int BUFFER = 8192;
	
	public static void compress(List<String> sourcePaths, String zipPath, String encoding, String comment)  
            throws FileNotFoundException, IOException {  
        // 设置压缩文件路径，默认为将要压缩的路径的父目录为压缩文件的父目录  
        if (zipPath == null || "".equals(zipPath) || !zipPath.endsWith(".zip")) {  
            throw new FileNotFoundException("必须指定一个压缩路径，而且该路径必须以'.zip'为结尾");  
        }  
        // 设置解压编码  
        if (encoding == null || "".equals(encoding)) {  
            encoding = "GBK";  
        }  
        // 要创建的压缩文件的父目录不存在，则创建  
        File zipFile = new File(zipPath);  
        if (!zipFile.getParentFile().exists()) {  
            zipFile.getParentFile().mkdirs();  
        }  
        // 创建压缩文件输出流  
        FileOutputStream fos = null;  
        try {  
            fos = new FileOutputStream(zipPath);  
        } catch (FileNotFoundException e) {  
        }  
        // 使用指定校验和创建输出流  
        CheckedOutputStream csum = new CheckedOutputStream(fos, new CRC32());  
        // 创建压缩流  
        ZipOutputStream zos = new ZipOutputStream(csum);  
        // 设置编码，支持中文  
        zos.setEncoding(encoding);  
        // 设置压缩包注释  
        zos.setComment(comment);  
        // 启用压缩  
        zos.setMethod(ZipOutputStream.DEFLATED);  
        // 设置压缩级别为最强压缩  
        zos.setLevel(Deflater.NO_COMPRESSION);  
        // 压缩文件缓冲流  
        BufferedOutputStream bout = null;  
        try {  
            // 封装压缩流为缓冲流  
            bout = new BufferedOutputStream(zos);  
            // 迭代压缩每一个路径  
            for (int i=0,len=sourcePaths.size(); i<len; i++) {  
                // 获取每一个压缩路径  
                File sourceFile = new File(sourcePaths.get(i));
                if(!sourceFile.exists()){ // 文件不存在
                	continue;
                }
                // 对数据源进行压缩  
                compressRecursive(zos, bout, sourceFile, sourceFile.getParent());  
            }  
        } finally {  
            if (bout != null) {  
                try{ bout.close(); } catch (Exception e) {}  
            }  
        }  
    }
	
	/** 
     * @Description:  
     *     压缩文件时，所使用的迭代方法 
     * @param zos 压缩输出流 
     * @param bout 封装压缩输出流的缓冲流 
     * @param sourceFile 将要压缩的文件或目录的路径 
     * @param prefixDir 整个将要压缩的文件或目录的父目录，传入此值为了获取压缩条目的名称 
    */  
   private static void compressRecursive(ZipOutputStream zos, BufferedOutputStream bout,  
           File sourceFile, String prefixDir) throws IOException, FileNotFoundException {  
       // 获取压缩条目名，初始时将要压缩的文件或目录的相对路径  
       String entryName = sourceFile.getAbsolutePath().substring(prefixDir.length() + File.separator.length());  
       // 判断是文件还是目录，如果是目录，则继续迭代压缩  
       if (sourceFile.isDirectory()) {  
           // 如果是目录，则需要在目录后面加上分隔符('/')  
           //ZipEntry zipEntry = new ZipEntry(entryName + File.separator);  
           //zos.putNextEntry(zipEntry);  
           // 获取目录中的文件，然后迭代压缩  
           File[] srcFiles = sourceFile.listFiles();  
           for (int i = 0; i < srcFiles.length; i++) {  
               // 压缩  
               compressRecursive(zos, bout, srcFiles[i], prefixDir);  
           }  
       } else {  
           // 开始写入新的ZIP文件条目并将流定位到条目数据的开始处  
           ZipEntry zipEntry = new ZipEntry(entryName);  
           // 向压缩流中写入一个新的条目  
           zos.putNextEntry(zipEntry);  
           // 读取将要压缩的文件的输入流  
           BufferedInputStream bin = null;  
           try{  
               // 获取输入流读取文件  
               bin = new BufferedInputStream(new FileInputStream(sourceFile));  
               // 读取文件，并写入压缩流  
               byte[] buffer = new byte[16384];  
               int readCount = -1;  
               while ((readCount = bin.read(buffer)) != -1) {  
                   bout.write(buffer, 0, readCount);  
               }  
               // 注，在使用缓冲流写压缩文件时，一个条件完后一定要刷新，不然可能有的内容就会存入到后面条目中去了  
               bout.flush();  
               // 关闭当前ZIP条目并定位流以写入下一个条目  
               zos.closeEntry();  
           } finally {  
               if (bin != null) {  
                   try { bin.close(); } catch (IOException e) {}  
               }  
           }  
       }  
   }
	
	public static void main(String[] args) throws Exception{
		System.out.println("=======================================S");
		long t = System.currentTimeMillis();
		List<String> list = new ArrayList<String>();
		list.add("D:/temp/0709/5148_2013-10-13_001.txt");
		list.add("D:/temp/0709/5163_2013-10-13_001.txt");
		list.add("D:/temp/0709/5171_2013-10-14_001.txt");
		list.add("D:/temp/0709/y.txt");
		list.add("D:/temp/0709/ORDERDATA_CPBM001_2013-07-20 1200.txt");
		
		compress(list, "d:/temp/0709/s.zip", "GBK", "测试内容");
		System.out.println("时间：" + (System.currentTimeMillis()-t));
		System.out.println("=======================================E");
	}
	
	
}
