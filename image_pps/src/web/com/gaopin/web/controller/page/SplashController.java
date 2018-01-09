/* This file SplashController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.constants.Constants;
import com.gaopin.entity.User;
import com.gaopin.entity.UserPrivilege;
import com.gaopin.service.pps.LightBoxService;
import com.gaopin.service.pps.SearchService;
import com.gaopin.service.pps.UserPrivilegeService;
import com.gaopin.service.pps.UserService;
import com.gaopin.utils.JsonFormat;
import com.gaopin.utils.MD5;
import com.gaopin.utils.StrUtils;
import com.gaopin.web.controller.BaseController;

@Controller
public class SplashController extends BaseController {

	@Resource
	private SearchService searchService;
	@Resource
	private LightBoxService lightBoxService;
	@Resource
	private UserService userService;
	@Resource
	private UserPrivilegeService userPrivilegeService;
	
	
	@RequestMapping(value="/splash")
	public String pageRegist(){
		return "splash/splash";
	}
}
