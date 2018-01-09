/* This file ImageMeta.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.mongo.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="imageMeta")
public class ImageMeta {
	@Id
	@Field("id")
	private String id;
	private Integer ratioType;
	private String colorSpace;
	private String exifMake;
	private String originalFilename;
	private Integer height;
	private Long maxSize;
	@Field("640K")
	private ImageDetail image640;
	@Field("180")
	private ImageDetail image180;
	@Field("240")
	private ImageDetail image240;
	@Field("650")
	private ImageDetail image650;
	@Field("14M")
	private ImageDetail image14M;
	@Field("305")
	private ImageDetail image305;
	@Field("32M")
	private ImageDetail image32M;
	@Field("2M")
	private ImageDetail image2M;
	private String exifFocalLength;
	private Float ratio;
	private String exifModel;
	private String exifFormat;
	private Integer width;
	private String printSize;
	private Integer channel;
	private String corbisId;
	private String exifFNumber;
	private String exifExposureTime;
	private Long fileSize;
	private String extName;
	private String maxSizeName;
	private String maxSizeFileName;
	private Integer imgDensity;
	private Integer storageId;
	private String filePathName;
	private String resolution;
	
	
	public Integer getRatioType() {
		return ratioType;
	}
	public void setRatioType(Integer ratioType) {
		this.ratioType = ratioType;
	}
	public String getColorSpace() {
		return colorSpace;
	}
	public void setColorSpace(String colorSpace) {
		this.colorSpace = colorSpace;
	}
	public String getExifMake() {
		return exifMake;
	}
	public void setExifMake(String exifMake) {
		this.exifMake = exifMake;
	}
	public String getOriginalFilename() {
		return originalFilename;
	}
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Long getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(Long maxSize) {
		this.maxSize = maxSize;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ImageDetail getImage640() {
		return image640;
	}
	public void setImage640(ImageDetail image640) {
		this.image640 = image640;
	}
	public ImageDetail getImage180() {
		return image180;
	}
	public void setImage180(ImageDetail image180) {
		this.image180 = image180;
	}
	public ImageDetail getImage650() {
		return image650;
	}
	public void setImage650(ImageDetail image650) {
		this.image650 = image650;
	}
	public ImageDetail getImage240() {
		return image240;
	}
	public void setImage240(ImageDetail image240) {
		this.image240 = image240;
	}
	public ImageDetail getImage14M() {
		return image14M;
	}
	public void setImage14M(ImageDetail image14m) {
		image14M = image14m;
	}
	public ImageDetail getImage305() {
		return image305;
	}
	public void setImage305(ImageDetail image305) {
		this.image305 = image305;
	}
	public ImageDetail getImage32M() {
		return image32M;
	}
	public void setImage32M(ImageDetail image32m) {
		image32M = image32m;
	}
	public ImageDetail getImage2M() {
		return image2M;
	}
	public void setImage2M(ImageDetail image2m) {
		image2M = image2m;
	}
	public String getExifFocalLength() {
		return exifFocalLength;
	}
	public void setExifFocalLength(String exifFocalLength) {
		this.exifFocalLength = exifFocalLength;
	}
	public Float getRatio() {
		return ratio;
	}
	public void setRatio(Float ratio) {
		this.ratio = ratio;
	}
	public String getExifModel() {
		return exifModel;
	}
	public void setExifModel(String exifModel) {
		this.exifModel = exifModel;
	}
	public String getExifFormat() {
		return exifFormat;
	}
	public void setExifFormat(String exifFormat) {
		this.exifFormat = exifFormat;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public String getPrintSize() {
		return printSize;
	}
	public void setPrintSize(String printSize) {
		this.printSize = printSize;
	}
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public String getCorbisId() {
		return corbisId;
	}
	public void setCorbisId(String corbisId) {
		this.corbisId = corbisId;
	}
	public String getExifFNumber() {
		return exifFNumber;
	}
	public void setExifFNumber(String exifFNumber) {
		this.exifFNumber = exifFNumber;
	}
	public String getExifExposureTime() {
		return exifExposureTime;
	}
	public void setExifExposureTime(String exifExposureTime) {
		this.exifExposureTime = exifExposureTime;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public String getExtName() {
		return extName;
	}
	public void setExtName(String extName) {
		this.extName = extName;
	}
	public String getMaxSizeName() {
		return maxSizeName;
	}
	public void setMaxSizeName(String maxSizeName) {
		this.maxSizeName = maxSizeName;
	}
	public String getMaxSizeFileName() {
		return maxSizeFileName;
	}
	public void setMaxSizeFileName(String maxSizeFileName) {
		this.maxSizeFileName = maxSizeFileName;
	}
	public Integer getImgDensity() {
		return imgDensity;
	}
	public void setImgDensity(Integer imgDensity) {
		this.imgDensity = imgDensity;
	}
	public Integer getStorageId() {
		return storageId;
	}
	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}
	public String getFilePathName() {
		return filePathName;
	}
	public void setFilePathName(String filePathName) {
		this.filePathName = filePathName;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	@Override
	public String toString() {
		return "ImageMeta [id=" + id + ", ratioType=" + ratioType
				+ ", colorSpace=" + colorSpace + ", exifMake=" + exifMake
				+ ", originalFilename=" + originalFilename + ", height="
				+ height + ", maxSize=" + maxSize + ", image640=" + image640
				+ ", image180=" + image180 + ", image240=" + image240
				+ ", image650=" + image650 + ", image14M=" + image14M
				+ ", image305=" + image305 + ", image32M=" + image32M
				+ ", image2M=" + image2M + ", exifFocalLength="
				+ exifFocalLength + ", ratio=" + ratio + ", exifModel="
				+ exifModel + ", exifFormat=" + exifFormat + ", width=" + width
				+ ", printSize=" + printSize + ", channel=" + channel
				+ ", corbisId=" + corbisId + ", exifFNumber=" + exifFNumber
				+ ", exifExposureTime=" + exifExposureTime + ", fileSize="
				+ fileSize + ", extName=" + extName + ", maxSizeName="
				+ maxSizeName + ", maxSizeFileName=" + maxSizeFileName
				+ ", imgDensity=" + imgDensity + ", storageId=" + storageId
				+ ", filePathName=" + filePathName + ", resolution="
				+ resolution + "]";
	}
}
