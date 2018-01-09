/* This file FileNameEqualsFilter.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.lang.StringUtils;

public class FileNameEqualsFilter implements FilenameFilter {
	
	public enum CompareType {
		Contains, NotContains;
	}
	
	public FileNameEqualsFilter(String filter) {
		this.filter = filter;
		this.compareType = CompareType.Contains;
	}
	
	public FileNameEqualsFilter(String filter, CompareType compareType) {
		this.filter = filter;
		this.compareType = compareType;
	}
	
	private String filter;
	
	private CompareType compareType;

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public CompareType getCompareType() {
		return compareType;
	}

	public void setCompareType(CompareType compareType) {
		this.compareType = compareType;
	}

	@Override
	public boolean accept(File dir, String name) {
		if(StringUtils.isBlank(filter)) {
			return false;
		}
		String[] filterArr = filter.split(",");
		switch(compareType) {
		case Contains:
			for(String f : filterArr) {
				if(StringUtils.equals(name, f)) {
					return true;
				}
			}
			break;
		case NotContains:
			for(String f : filterArr) {
				if(name.startsWith(f + ".")) {
					return true;
				}
			}
			break;
		}
		
		return false;
	}

}
