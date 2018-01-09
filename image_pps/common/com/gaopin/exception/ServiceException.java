/* This file ServiceException.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.exception;

/**
 * 业务处理对象的异常
 * 
 * @author fming
 */
public class ServiceException extends BaseRuntimeException {
			
	private static final long serialVersionUID = 1L;
	
	private String status;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(String status,String message) {
		super(message);
		this.status = status;
	}
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	public ServiceException(String status,String message, Throwable cause) {
		super(message, cause);
		this.status = status;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
}
