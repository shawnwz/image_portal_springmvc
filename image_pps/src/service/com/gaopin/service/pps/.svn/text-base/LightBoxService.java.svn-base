/* This file LightBoxService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.List;

import com.gaopin.entity.LightBox;
import com.gaopin.entity.LightBoxRel;
import com.gaopin.service.BaseService;

/**
 * @author 高顺德
 *
 */
public interface LightBoxService extends BaseService {
	public boolean checkInbox(Integer userId, String corbisid) ;
	public LightBoxRel getLightBoxItem(Integer id);
	public LightBox getLightBox(Integer id);
	public LightBox getLightBox(String code);
	public List<LightBox> getListByUser(Integer userId,int order);
	public List<LightBoxRel> getListByBox(Integer boxId);
	public LightBoxRel addBoxItem(Integer boxId,String corbisId);
	public LightBoxRel SetBoxItem(Integer id,String memo);
	public LightBox addBox(Integer userId,String userName, String name,Integer pid);
	public LightBox setBoxFather(Integer id,Integer pid);
	public LightBox addBoxDefault(Integer userId,String userName) ;
	public LightBoxRel delBoxItem(Integer id);
	public LightBox delBox(Integer id);
	public boolean delBoxImgByBoxIDAndCorbisId(int boxId,String corbisId);
	
	public LightBox UpdateLightBox(LightBox lb0);
	public boolean moveImg(int boxId, String[] imgids, int isDel) throws Exception;
	public LightBoxRel getLightBoxItem(String code,int lightBoxId);
	boolean deleteBoxImg(int boxId) throws Exception;
	boolean copyBoxImg(int boxId, String corbisId,int newBoxId);
}
