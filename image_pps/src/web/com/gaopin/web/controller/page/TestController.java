/* This file TestController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaopin.web.controller.BaseController;

@Controller
public class TestController extends BaseController {
		
	@RequestMapping(value="/test1")
	public String test1(){
		return "test/test1";
	}

	
	@RequestMapping(value="/test2")
	public String test2(){
		return "test/test2";
	}
	
	
	@RequestMapping(value="/test3")
	public String test3(){
		return "test/test3";
	}
	
	@RequestMapping(value="/testindex")
	public String test4(){
		return "test/testindex";
	}
}
