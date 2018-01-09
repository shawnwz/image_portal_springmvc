/* This file ImageSetService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gaopin.entity.FlowImageset;
import com.gaopin.entity.FlowImagesetSub;
import com.gaopin.entity.ImageGroup;
import com.gaopin.entity.ImageGroupImage;
import com.gaopin.entity.ImageInfo;
import com.gaopin.entity.ImagePartialSets;
import com.gaopin.entity.ImageSets;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.service.BaseService;

public interface ImageSetService extends BaseService {
	public int getTopCount();
	public List<FlowImageset> getTopList(int p,int n);
    public List<FlowImagesetSub> getSubList(Integer topid);
    public Map<Integer,List<FlowImagesetSub> > getTopMap(int p,int n);
    public FlowImagesetSub getItem(Integer id);
    public FlowImageset getTopItem(Integer id) ;
    public List<PreviewImageInfo> getImages(Integer subid);
    public boolean checkImages(Integer subid,String corbisId);
    public void cleanCache();
	
}
