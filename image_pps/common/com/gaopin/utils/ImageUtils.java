/* This file ImageUtils.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.gif4j.GifDecoder;
import com.gif4j.GifEncoder;
import com.gif4j.GifFrame;
import com.gif4j.GifImage;
import com.gif4j.Watermark;
import com.gif4j.TextPainter;

import java.awt.*;
import java.util.Iterator;

public class ImageUtils {
	private static Logger logger = Logger.getLogger(ImageUtils.class);
    
    private static Image WATER_HORIZONTAL = null;
    private static Image WATER_VERTICAL = null;
    private static Image SUPER_MARK_TOPRIGHT = null;

    static{
    	try{
    		WATER_HORIZONTAL = ImageIO.read(ImageUtils.class.getResourceAsStream("/water_horizontal.png"));
    		WATER_VERTICAL = ImageIO.read(ImageUtils.class.getResourceAsStream("/water_vertical.png"));
    		SUPER_MARK_TOPRIGHT = ImageIO.read(ImageUtils.class.getResourceAsStream("/supermark_topright.png"));
    	}
    	catch (Exception e) {
			logger.error("载入水印图片异常[classes/water_horizontal.png, water_vertical.png]：", e);
		}
    }
    
	/**
     * 添加图片水印
     * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)
	 * @throws IOException 
*/
    public final static void pressImage(File sourceImg, File destImg) throws IOException {
            try {
                Image image = ImageIO.read(sourceImg);
                int width = image.getWidth(null);
                int height = image.getHeight(null);
                BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = bufferedImage.createGraphics();
                g.drawImage(image, 0, 0, width, height, null);
                
                Image waterImage = null;
                if(width>=height){
                	waterImage = WATER_HORIZONTAL;
                }
                else{
                	waterImage = WATER_VERTICAL;
                }
                
                int water_x = (width-waterImage.getWidth(null)) / 2;
                int water_y = (height-waterImage.getHeight(null)) / 2;
                
                int width_1 = waterImage.getWidth(null);
                int height_1 = waterImage.getHeight(null);
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.6f));
                
                g.drawImage(waterImage, water_x, water_y, width_1, height_1, null); // 水印文件结束
                
                g.dispose();
                
                //g.drawimage
                
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); // 取得内存输出流  
                JPEGEncodeParam param = JPEGCodec.getDefaultJPEGEncodeParam(bufferedImage);  
                param.setQuality(0.80f, true); 
                param.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);  
                param.setXDensity(300);  
                param.setYDensity(300);  
                
                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(  
                        byteArrayOutputStream, param);  
                encoder.encode(bufferedImage);  
                
                // 判断水印图片文件夹是否存在，不存在创建
                File waterFolder = destImg.getParentFile();
                if(!waterFolder.exists()){
                	waterFolder.mkdirs();
                }
                byteArrayOutputStream.writeTo(new FileOutputStream(destImg));
            } catch (IOException e) {
                logger.error("生成水印图片异常[srcFile="+sourceImg.getPath()+"][destFile="+destImg.getPath()+"]", e);
                throw e;
            }
    }

	/**
     * 添加图片超级水印   copied from pressImage(File sourceImg, File destImg) by Sean
     * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)
	 * @throws IOException 
*/
    public final static void pressImage_superMark(File sourceImg, File destImg) throws IOException {
            try {
                Image image = ImageIO.read(sourceImg);
                int width = image.getWidth(null);
                int height = image.getHeight(null);
                BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = bufferedImage.createGraphics();
                g.drawImage(image, 0, 0, width, height, null);
                
                Image waterImage = null;
                waterImage = SUPER_MARK_TOPRIGHT;
 
                
                int water_x = width-waterImage.getWidth(null);
               // int water_y = (height-waterImage.getHeight(null));
                //int water_y= waterImage.getHeight(null);
                int water_y = 0;
                
                int width_1 = waterImage.getWidth(null);
                int height_1 = waterImage.getHeight(null);
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.9f));
                
                g.drawImage(waterImage, water_x, water_y, width_1, height_1, null); // 水印文件结束
                
                g.dispose();
                
                //g.drawimage
                
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); // 取得内存输出流  
                JPEGEncodeParam param = JPEGCodec.getDefaultJPEGEncodeParam(bufferedImage);  
                param.setQuality(0.80f, true); 
                param.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);  
                param.setXDensity(300);  
                param.setYDensity(300);  
                
                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(  
                        byteArrayOutputStream, param);  
                encoder.encode(bufferedImage);  
                
                // 判断水印图片文件夹是否存在，不存在创建
                File waterFolder = destImg.getParentFile();
                if(!waterFolder.exists()){
                	waterFolder.mkdirs();
                }
                byteArrayOutputStream.writeTo(new FileOutputStream(destImg));
            } catch (IOException e) {
                logger.error("生成水印图片异常[srcFile="+sourceImg.getPath()+"][destFile="+destImg.getPath()+"]", e);
                throw e;
            }
    }
    
    
	/**
     Sean added  @ 20150706
*/
    public final static void pressImage_gif(File  sourceImg, File  destImg) throws IOException {
            try {
            	TextPainter textPainter = new TextPainter(new Font("arial" , Font.BOLD, 16));
            	 textPainter.setOutlinePaint(Color.WHITE);
            	 BufferedImage renderedWatermarkText = textPainter.renderString("gaopinimages.com ", true);
            	 Watermark watermark =  new Watermark(renderedWatermarkText, Watermark.LAYOUT_TOP_RIGHT);
            	 GifImage gifImage = GifDecoder.decode(sourceImg);
            	 System.out.println(" decode source" );
/*            	 System.out.println(" decoder  decode sourceImag" );
            	 BufferedImage[] tempImages =new BufferedImage[gifImage.getNumberOfFrames()];
            	 GifImage outputgifImage = new GifImage();
            	 outputgifImage.setDefaultDelay(100);
            	 gifImage.addComment("GaopinImages.com");
            	 System.out.println(" begain for loop" );
            	 for (int i = 0; i < gifImage.getNumberOfFrames(); i++) {
            		 
            		 System.out.println(i );
            		 GifFrame frame = gifImage.getFrame(i);
            		 Image frameImage = frame.getAsImage();
                     int width = frameImage.getWidth(null);
                     System.out.println("width ==" + width );
                     int height = frameImage.getHeight(null);
                     System.out.println("height ==" + height );
                     //BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                     tempImages[i] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                     System.out.println("new BufferedImage" );
                     Graphics2D g = tempImages[i].createGraphics();
                     System.out.println("above is Graphics2D " );
                     g.drawImage(frameImage, 0, 0, width, height, null);
                     System.out.println("above is g.drawImage " );
                     Image waterImage = null;
                     System.out.println("waterImage = null" );
                     if(width>=height){
                     	waterImage = WATER_HORIZONTAL;
                     }
                     else{
                     	waterImage = WATER_VERTICAL;
                     }
                     System.out.println("water image  ==" + waterImage.toString() );
                     
                     int water_x = (width-waterImage.getWidth(null)) / 2;
                     int water_y = (height-waterImage.getHeight(null)) / 2;
                     
                     int width_1 = waterImage.getWidth(null);
                     int height_1 = waterImage.getHeight(null);
                     
                     System.out.println("water image width  ==" + width_1 );
                     System.out.println("water image height  ==" + height_1 );
                     
                     g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.6f));
                     System.out.println("setComposite" );
                     g.drawImage(waterImage, water_x, water_y, width_1, height_1, null); // 水印文件结束
                     System.out.println("drawImage....." );
                     g.dispose();
                     System.out.println("dispose.....xxx" );
                     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); // 取得内存输出流  
                     System.out.println("取得内存输出流" );
                     BufferedImage t = tempImages[i];
                     JPEGEncodeParam param = JPEGCodec.getDefaultJPEGEncodeParam(t); 
        
                     System.out.println("JPEGEncodeParam param = JPEGCodec.getDefaultJPEGEncodeParam" );
                     param.setQuality(0.80f, true); 
                     System.out.println("setQuality" );
                     param.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);  
                     System.out.println("JPEGEncodeParam" );
                     param.setXDensity(300);  
                     System.out.println("setXDensity" );
                     param.setYDensity(300);  
                     System.out.println("setYDensity" );
                     
                     JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(  
                             byteArrayOutputStream, param);  
                     encoder.encode(tempImages[i]); 
                     System.out.println("encoder.encode...." );
                     
                     System.out.println("encode.encode....." + i );
            		 
            	 }
            	 System.out.println(" length of tempimages  = " + tempImages.length );
            	 for (int i = 0; i < tempImages.length; i++)
            		 outputgifImage.addGifFrame(new GifFrame(tempImages[i]));
                 // save animated gif image
            	 System.out.println("saving outputgifimage..." );
                 File waterFolder = destImg.getParentFile();
                 if(!waterFolder.exists()){
                   waterFolder.mkdirs();
                 }
                 GifEncoder.encode(outputgifImage, destImg);*/
            	 
            	 
            	 
            	 GifImage t = watermark.apply(gifImage, true);
            	 System.out.println(" apply watermark" );
                
                // 判断水印图片文件夹是否存在，不存在创建
                File waterFolder = destImg.getParentFile();
                if(!waterFolder.exists()){
                	System.out.println(" !exists" );
                	waterFolder.mkdirs();
                }
                GifEncoder.encode(t, destImg);
                System.out.println(" encode" );
               // byteArrayOutputStream.writeTo(new FileOutputStream(destImg));
            } catch (IOException e) {
            	System.out.println(" exception" );
                logger.error("生成水印图片异常[srcFile="+sourceImg.getPath()+"][destFile="+destImg.getPath()+"]", e);
                throw e;
            }
    }
    

    
	public static void main(String[] a) {
		try{
			System.out.println(ImageUtils.class.getResourceAsStream(""));
			
			String source = "d:/1.jpg";
			String dest = "d:/2.jpg";
			long t = System.currentTimeMillis();
			for(int i=0; i<1; i++){
				pressImage(new File("d:/1.jpg"), new File("d:/a1/b1/c1/11.jpg"));
				pressImage(new File("d:/3.jpg"), new File("d:/33.jpg"));
			}
			System.out.println("t=" + (System.currentTimeMillis()-t));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
