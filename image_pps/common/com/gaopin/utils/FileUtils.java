/* This file FileUtils.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class FileUtils {
	protected static Logger logger = Logger.getLogger(FileUtils.class);

	private static Object deleteLock = new Object();
	
	public static String fileType = "UTF-8";

	/**
	 * 转移文件
	 * 
	 * @param sourcePath
	 *            源文件路径
	 * @param toPath
	 *            目的文件路径
	 * @param fileName
	 *            文件名
	 * @return
	 * @throws Exception
	 * @author fming 2009-1-14
	 */
	public static boolean moveFile(String sourcePath, String toPath,
			String sourceName) {
		return moveFile(sourcePath, toPath, sourceName, sourceName);
	}

	/**
	 * 删除目录下所有空目录
	 * 
	 * @param sourcePath
	 * @param deleteSelf
	 * @return
	 * @author fming 2009-1-16
	 */
	public static boolean deleteBlankDirectory(String sourcePath,
			boolean deleteSelf) {
		synchronized (deleteLock) {
			File file = new File(sourcePath);
			if (file.exists()) {
				File[] files = file.listFiles();
				for (File fileTemp : files) {
					if (fileTemp.isDirectory()) {
						deleteBlankDirectory(fileTemp.getPath(), true);
					}
				}
				files = file.listFiles();
				if (deleteSelf && files.length == 0) {
					return file.delete();
				}
			}
			return true;
		}
	}
	
	/**
	 * 删除文件夹,包含其下的所有子文件及子文件夹
	 * @param filepath
	 * 创建人：  fming    
	 * 创建时间：2012-5-14  下午2:26:38
	 */
	public static void deleteFolder(String filepath) {
		File file = new File(filepath);
		if (file.exists()) {
			if (file.isFile()) {
				file.delete();
			} else if (file.isDirectory()) {
				File files[] = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					deleteFolder(files[i].getAbsolutePath());
				}	
			}
			file.delete();
		} else {
			System.out.println("所删除的文件不存在！" + '\n');
		}
	}
	
	public static boolean moveFile(String sourceFullPath, String toFullPath) {
		File sourceFile = new File(sourceFullPath);
		File toFile = new File(toFullPath);
		if (!sourceFile.exists()) {
			return false;
		}
		if (!toFile.getParentFile().exists()) {
			if (!toFile.getParentFile().mkdirs()) {
				return false;
			}
		}
		return sourceFile.renameTo(toFile);
	}

	/**
	 * 转移文件
	 * 
	 * @param sourcePath
	 *            源文件路径
	 * @param toPath
	 *            目的文件路径
	 * @param sourceName
	 *            源文件名
	 * @param toName
	 *            目的文件名
	 * @return
	 * @author fming 2009-1-16
	 */
	public static boolean moveFile(String sourcePath, String toPath,
			String sourceName, String toName) {
		String sourceFilePaths = sourcePath + File.separatorChar + sourceName;
		String toFilePaths = toPath + File.separatorChar + toName;
		File sourceFile = new File(sourceFilePaths);
		File toFile = new File(toFilePaths);
		if (!sourceFile.exists()) {
			return false;
		}
		if (!toFile.getParentFile().exists()) {
			if (!toFile.getParentFile().mkdirs()) {
				return false;
			}
		}
		return sourceFile.renameTo(toFile);
	}

	/**
	 * 构建文件的绝对路径
	 * 
	 * @param path
	 * @param fileName
	 * @return
	 * @author fming 2008-11-19
	 */
	public static String buildFilePath(String path, String fileName)
			throws Exception {
		if (StringUtils.isBlank(path) || StringUtils.isBlank(fileName)) {
			logger.error("目录[" + path + "]下文件[" + fileName + "]不存在！");
			throw new Exception("目录[" + path + "]下文件[" + fileName + "]不存在！");
		}
		if (!path.endsWith("\\") && !path.endsWith("/")
				&& !fileName.startsWith("\\") && !fileName.startsWith("/")) {
			path = path + File.separatorChar;
		}
		return path + fileName;
	}

	/**
	 * 根据文件路径和文件名读取文件内容
	 * 
	 * @param path
	 * @param fileName
	 * @return
	 * @throws Exception
	 * @author fming 2008-11-19
	 */
	public static StringBuffer readFile(String path, String fileName)
			throws Exception {
		checkPath(path);
		return readFileToString(buildFilePath(path, fileName));
	}

	/**
	 * 检查文件存储目录,不存在创建目录
	 * 
	 * @param path
	 * @author fming 2008-11-19
	 */
	public static void checkPath(String path) {
		File toFile = new File(path);
		if (!toFile.exists()) {
			if(logger.isDebugEnabled()) logger.debug("创建文件夹");
			toFile.mkdirs();
		} else if (toFile.isFile()) {
			toFile.delete();
			toFile.mkdirs();
		}
	}

	/**
	 * 写文件
	 * 
	 * @param valueMap
	 *            文件内容
	 * @param path
	 *            文件路径
	 * @param fileName
	 *            文件名
	 * @param isReWrite
	 *            追加方法
	 * @throws Exception
	 * 
	 * @author fming 2008-11-19
	 */
	public static boolean writeFile(StringBuffer valueMap, String path,
			String fileName, boolean isReWrite) throws Exception {
		synchronized (deleteLock) {
			checkPath(path);
			return writeFile(valueMap, buildFilePath(path, fileName), isReWrite);
		}
	}

	/**
	 * 写文件
	 * 
	 * @param contextList
	 *            文件内容集合
	 * @param path
	 *            文件路径
	 * @param fileName
	 *            文件名
	 * @param isReWrite
	 *            追加方法
	 * @return
	 * @throws Exception
	 * @author fming 2009-2-12
	 */
	public static boolean writeFile(List<String> contextList, String path,
			String fileName, boolean isReWrite) throws Exception {
		StringBuffer writeContext = new StringBuffer();
		for (String context : contextList) {
			writeContext.append(context);
		}
		return writeFile(writeContext, path, fileName, isReWrite);
	}

	/**
	 * 写文件
	 * 
	 * @param valueMap
	 *            文件内容
	 * @param filePath
	 *            文件路径
	 * @param isReWrite
	 *            追加方法
	 * @throws Exception
	 * 
	 * @author fming 2008-11-19
	 */
	private static boolean writeFile(StringBuffer valueMap, String filePath,
			boolean isReWrite) throws Exception {
		if(logger.isDebugEnabled()) logger.debug("写文件的文件路径   writeFile  ： " + filePath);
		FileWriter fileWriter = null;
		BufferedWriter bufferWriter = null;
		PrintWriter printWriter = null;
		if (StringUtils.isBlank(filePath))
			throw new Exception("目标文件路径为空");
		try {

			File toFile = new File(filePath);
			if (!toFile.exists()) {
				if(logger.isDebugEnabled()) logger.debug("写文件的文件");
				toFile.createNewFile();
			}

			fileWriter = new FileWriter(filePath, isReWrite);
			bufferWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferWriter);
			printWriter.println(new String(valueMap.toString().getBytes(),
					fileType));
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("文件写错误");
		} finally {
			try {
				if (printWriter != null)
					printWriter.close();
				if (bufferWriter != null)
					bufferWriter.close();
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new Exception("文件关闭错误");
			}
		}
		return true;
	}

	/**
	 * 读取文件至Map<行号Integer,内容String>
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 *             创建人： 刘方明 创建时间：2011-8-10 下午05:26:03
	 */
	public static Map<Integer, String> readFileToMap(File fromFile) throws Exception {
		Map<Integer, String> result = new HashMap<Integer, String>();
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try {
			if (!fromFile.exists()) {
				return result;
			}
			fileReader = new FileReader(fromFile);
			bufferedReader = new BufferedReader(fileReader);
			String data = "";
			int i = 1;
			while ((data = bufferedReader.readLine()) != null) {
				result.put(i, data);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("文件读错误");
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
				if (fileReader != null)
					fileReader.close();
			} catch (IOException e) {
				throw new Exception("文件关闭错误");
			}
		}
		return result;
	}

	/**
	 * 读取文件
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 * @author fming 2009-2-12
	 */
	private static StringBuffer readFileToString(String filePath)
			throws Exception {
		if(logger.isDebugEnabled()) logger.debug("读文件的文件路径   readFileToString  ： " + filePath);
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		StringBuffer resultBuff = new StringBuffer();
		try {
			File fromFile = new File(filePath);
			if (!fromFile.exists()) {
				return resultBuff;
			}
			fileReader = new FileReader(fromFile);
			bufferedReader = new BufferedReader(fileReader);
			String data = "";
			while ((data = bufferedReader.readLine()) != null) {
				resultBuff.append(new String(data.getBytes(), fileType));
				resultBuff.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("文件读错误");
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
				if (fileReader != null)
					fileReader.close();
			} catch (IOException e) {
				throw new Exception("文件关闭错误");
			}
		}
		return resultBuff;
	}
	
	public static byte[] readFileToByteArray(String filePath)
			throws IOException {
			File f=new File(filePath);
			int length=(int)f.length();
			FileInputStream in=new FileInputStream(filePath);
			   	  byte[] buffer=new byte[length];
			   	  int ins=in.read(buffer);
			   	return buffer;
	}
	
	/**
	 * 将流写入指定位置
	 * 
	 * @param in
	 * @param saveFilePath
	 * @param fileName
	 * @throws IOException
	 */
	public static void writeFile(InputStream in, String saveFilePath,
			String fileName) throws IOException {
		File f = new File(saveFilePath);
		if (!f.exists()) {
			f.mkdirs();
		}
		f = new File(saveFilePath, fileName);
		FileOutputStream out = null;
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			out = new FileOutputStream(f);
			byte[] buffer = new byte[1024];
			int length = 0;
			do {
				length = in.read(buffer);
				if (length == -1) {
					break;
				}
				out.write(buffer, 0, length);
				out.flush();
			} while (true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				out.flush();
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}

	}
}
