/* This file Constants.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.constants;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


public class Constants {
	
//	public static final String CACHE_SHORT = "cache_short";
//	public static final String CACHE_MEDIUM = "cache_medium";
//	public static final String CACHE_LONG = "cache_long";
	public static final String CACHE_VARIABLES = "cache_variables";
	public static final int CACHE_DEFAULT_TIMES = 3600;	// 默认缓存时间
	public static final int CACHE_DAY_TIMES = 24*3600;	// 默认缓存时间
	public static final int CACHE_HOUR_TIMES = 1*3600;	// 默认缓存时间
	public static final int CACHE_FOREVER_TIMES = 30*24*3600;	// 默认缓存时间
	public static final String IMAGE_DISK_PATH_ROOT_DEFAULT = "root.path.default"; // 图片默认根路径
	public static final String IMAGE_DISK_PATH_ROOT_PREFIX = "root.path.storage_"; // 图片根路径参数前缀
	public static final String IMAGE_DISK_PATH_WATERMARK = "img.water.path"; // 水印图片物理地址
	
	public static final String MOTION_DISK_PATH_ROOT_DEFAULT = "motionroot.path.default"; // 默认根路径
	public static final String MOTION_DISK_PATH_ROOT_PREFIX = "root.path.storage_"; // 根路径参数前缀
	
	//tube
	public static final int TUBE_ONLY_UPLOAD = 0;
	public static final int TUBE_TO_AUDIT = 1;
	public static final int TUBE_TO_META = 2;
	public static final int TUBE_REJECT = -2;
	public static final int TUBE_ONLINE = 4;
	public static final int TUBE_MOREINFO = 5;
	public static final String orgi_folder = "original";
	public static final String thumbnail_folder = "thumbnail";
	public static final String hover_folder = "hover";
	public static final String preview_folder = "preview";
	public static final String M2_folder = "M2";
	public static final String M14_folder = "M14";
	public static final String M32_folder = "M32";
	public static final String M50_folder = "M50";
	public static final String c2000_folder = "C2000";
	public static final String c900_folder = "C900";
	
	public static final String avatarsmall_folder = "s";
	public static final String avatarbig_folder = "l";
	
	public static final String avatar_default_url = "http://gaopinimages.com/a.jpg";
	
	public static final String cover_big_default_url = "http://gaopinimages.com/bigcover.jpg";
	public static final String cover_small_default_url = "http://gaopinimages.com/smallcover.jpg";
	
	public static final String tubemessage_user_not_login = "用户未登录";
	public static final String tubemessage_operation_success = "操作成功";
	public static final String tubemessage_operation_failed = "操作失败";
	public static final String tubemessage_update_success = "更新成功";
	public static final String tubemessage_update_failed = "更新失败";
	public static final String tubemessage_delete_success = "删除成功";
	public static final String tubemessage_delete_failed = "删除失败";
	public static final String tubemessage_privilege_error= "没有权限";
	public static final String tubemessage_para_error= "参数错误";
	
	public enum CommonStatus {
		ENABLE("启用"), DISABLE("禁用"), DELETE("逻辑删除");
		private static final Map<Integer, CommonStatus> map = new HashMap<Integer, CommonStatus>();
		static {
			for (CommonStatus e : EnumSet.allOf(CommonStatus.class)) {
				map.put(e.ordinal(), e);
			}
		}
		
		public static boolean isEnable(Integer ordinal) {
			if(ordinal == null) return false;
			return ENABLE.ordinal() == ordinal.intValue();
		}

		private String title;

		private CommonStatus(String title) {
			this.title = title;
		}

		public String getTitle() {
			return title;
		}

		public static String getTitle(Integer status) {
			CommonStatus statusEnum = get(status);
			return statusEnum == null ? "" : statusEnum.getTitle();
		}

		public static CommonStatus get(Integer status) {
			return map.get(status);
		}
	}
	
	public enum OnlineStatus {
		SUCCESS(0, "处理成功"), WAITING_APP(1, "待应用处理"), WAITING_SEARCH(2, "待应用处理"), FAILED_APP(-1,"应用处理失败"), FAILED_SEARCH(-2,"搜索处理失败");
		private static final Map<Integer, OnlineStatus> map = new HashMap<Integer, OnlineStatus>();
		static {
			for (OnlineStatus e : EnumSet.allOf(OnlineStatus.class)) {
				map.put(e.ordinal(), e);
			}
		}
		
		private int code;
		private String title;

		private OnlineStatus(int code, String title) {
			this.title = title;
			this.code = code;
		}

		public String getTitle() {
			return title;
		}
		
		public int getCode(){
			return code;
		}

		public static String getTitle(Integer status) {
			OnlineStatus statusEnum = get(status);
			return statusEnum == null ? "" : statusEnum.getTitle();
		}
		
		public static OnlineStatus get(Integer status) {
			if(status==null) return null;
			for (OnlineStatus e : EnumSet.allOf(OnlineStatus.class)) {
				if(e.code==status) return e;
			}
			return null;
		}
	}
	
	/**
	 * 性别
	 */
	public enum Sex {
		MALE("男"), FEMALE("女");
		private String desc;
		Sex(String desc) {
			this.desc = desc;
		}
		public static Sex getEnum(String desc) {
			if(StringUtils.isBlank(desc)) {
				return null;
			}
			for(Sex sex : Sex.values()) {
				if(StringUtils.equals(sex.getDesc(), desc)) {
					return sex;
				}
			}
			return null;
		}
		
		public static String getDescByOrdinal(Integer ordinal){
			if(ordinal == null){
				return "";
			}
			for(Sex s : Sex.values()){
				if(s.ordinal() == ordinal){
					return s.getDesc();
				}
			}
			return "";
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	public enum SizeType {
		M50("50M",558,3400,5100), M32("32M",559,2800,4200), M14("14M",561,1700,2550),
		M2("2M",64,1280,1024),PREVIEW("PREVIEW",67,640,480),WATERMARK("WATERMARK",67,640,480),SUPERMARK("SUPERMARK",68,640,480)
		,HOVER("HOVER",350,350,350),THUMBNAIL("THUMBNAIL",170,170,170),UNKNOWN("UNKNOWN",63,1,1),AVATAR("AVATAR",150,150,150)
		,BIGAVATAR("BIGAVATAR",300,300,300)
		,COVER400("COVER400",400,400,400)
		,COVER900("COVER900",900,900,900)
		,COVER2000("COVER2000",2000,2000,2000)
		;
		private int sizecode;
		private int width;
		private int height;
		private String title;
		private String path;
		
		SizeType(String title,int code,int width,int height) {
			this.title = title;
			this.path=title;
			this.sizecode=code;
			this.width=width;
			this.height=height;
		}
		
		public static SizeType getEnum(String title) {
			if(StringUtils.isBlank(title)) {
				return UNKNOWN;
			}
			for(SizeType r : SizeType.values()) {
				if(StringUtils.equals(r.getTitle(), title)) {
					return r;
				}
			}
			return UNKNOWN;
		}
		public static SizeType getEnum(int code) {
			for(SizeType r : SizeType.values()) {
				if(r.sizecode==code) {
					return r;
				}
			}
			return UNKNOWN;
		}
		public String getTitle(){
			return title;
		}
		public int getSizecode() {
			return sizecode;
		}
		public int getWidth() {
			return width;
		}
		public int getHeight() {
			return height;
		}public String getPath() {
			return path;
		}
		
		public  List<String> GetLowerPathList()
		{
			List<String> rst=new ArrayList<String>();
			SizeType[] list= getLessType();
			for (SizeType sizeType : list) {
					rst.add(sizeType.getPath());
			}
			return rst;
		}
		
		public SizeType[] getLessType(){
			switch (this) {
			case M50:
				return new SizeType[]{SizeType.M50,SizeType.M32,SizeType.M14,SizeType.M2,SizeType.PREVIEW};
			case M32:
				return new SizeType[]{SizeType.M32,SizeType.M14,SizeType.M2,SizeType.PREVIEW};
			case M14:
				return new SizeType[]{SizeType.M14,SizeType.M2,SizeType.PREVIEW};
			case M2:
				return new SizeType[]{SizeType.M2,SizeType.PREVIEW};
			case PREVIEW:
				return new SizeType[]{SizeType.PREVIEW};
			case SUPERMARK:
				return new SizeType[]{SizeType.SUPERMARK};
			default:
				break;
			}
			return new SizeType[]{};
		}
	}
	public enum LicenseType {
		DEFAULT("未知"), RF("RF"), RM("RM");
		private String title;
		private LicenseType(String title){
			this.title = title;
		}
		public String getTitle() {
			return title;
		}
	}
	
	public enum MailType{
		TEXT("文本邮件"),HTML("HTML邮件");
		private String title;
		private MailType(String title){
			this.title = title;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	}
	

	/**
	 * 是否
	 */
	public enum YesNo {
		YES("是"), NO("否");
		private static final Map<Integer, YesNo> map = new HashMap<Integer, YesNo>();
		static {
			for (YesNo e : EnumSet.allOf(YesNo.class)) {
				map.put(e.ordinal(), e);
			}
		}
		
		public static boolean isEnable(Integer ordinal) {
			if(ordinal == null) return false;
			return YES.ordinal() == ordinal.intValue();
		}

		private String title;

		private YesNo(String title) {
			this.title = title;
		}

		public String getTitle() {
			return title;
		}

		public static String getTitle(Integer status) {
			YesNo yes = get(status);
			return yes == null ? "" : yes.getTitle();
		}

		public static YesNo get(Integer status) {
			return map.get(status);
		}
	}
	

	public enum SelectionStatus {
		IN("上线"), OUT("下线"), PENDING("待处理");
		private static final Map<Integer, SelectionStatus> map = new HashMap<Integer, SelectionStatus>();
		static {
			for (SelectionStatus e : EnumSet.allOf(SelectionStatus.class)) {
				map.put(e.ordinal(), e);
			}
		}

		private String title;

		private SelectionStatus(String title) {
			this.title = title;
		}

		public String getTitle() {
			return title;
		}

		public static String getTitle(Integer status) {
			SelectionStatus yes = get(status);
			return yes == null ? "" : yes.getTitle();
		}

		public static SelectionStatus get(Integer status) {
			return map.get(status);
		}
	}
	

	public enum UserPrivilegeType {
		QP("QP"), BOBO("BOBO"), OUTLINE("OUTLINE"),OD("ON DEMAND"),BK("BackPaltfrom"),SM("SuperMark");
		 
		private String title;

		private UserPrivilegeType(String title) {
			this.title = title;
		}

		public String getTitle() {
			return title;
		}

		public static UserPrivilegeType get(Integer ordinal){
			if(ordinal == null){
				return null;
			}
			for(UserPrivilegeType s : UserPrivilegeType.values()){
				if(s.ordinal() == ordinal){
					return s;
				}
			}
			return null;
		}
		
		public static String getTitle(Integer ordinal) {
			if(ordinal == null){
				return "";
			}
			for(UserPrivilegeType s : UserPrivilegeType.values()){
				if(s.ordinal() == ordinal){
					return s.getTitle();
				}
			}
			return "";
		}
	}
	
	public enum TubeUploadType {
		DEFAULT("IMAGE"), AVATAR("AVATAR"), COVER("COVER"),ID("IDCARD");
		private String title;
		private TubeUploadType(String title){
			this.title = title;
		}
		public String getTitle() {
			return title;
		}
	}
	
	public static final int imageSet_PageSize=10;
}