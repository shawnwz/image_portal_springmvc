/* This file AnonymousController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaopin.entity.LightBox;
import com.gaopin.entity.LightBoxRel;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.service.pps.BatchDownloadService;
import com.gaopin.service.pps.ImageGroupService;
import com.gaopin.service.pps.LightBoxService;
import com.gaopin.service.pps.SearchService;
import com.gaopin.service.pps.UserPrivilegeService;
import com.gaopin.service.pps.UserService;
import com.gaopin.utils.StrUtils;
import com.gaopin.web.controller.BaseController;
@Controller
public class AnonymousController extends BaseController {
		
	@RequestMapping(value = {"/anonymous/lightbox2d"})
	public String lightbox(HttpServletRequest request){
		
		return "page/lightbox";
	}
	
	@RequestMapping(value = {"/anonymous/lightboxdownload"})
	public String lightboxdownload(){
		
		return "page/lightbox";
	}
	
}
