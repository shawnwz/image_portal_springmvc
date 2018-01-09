/* This file LightBoxService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.List;

import com.gaopin.entity.FrCart;
import com.gaopin.service.BaseService;

/**
 * 
 *
 */
public interface CartService extends BaseService {
	
	//public LightBoxRel getLightBoxItem(Integer id);
	public FrCart getCart(Integer userid, String gaopinId);
	public boolean deleteCart(Integer userid, String gaopinId);
	public List<FrCart> getListByUser(Integer userId,int order);
	//public List<LightBoxRel> getListByBox(Integer boxId);
	public FrCart addCart(Integer userid,String gaopinId);
	public int getCartItemCount(Integer userid);
	//public LightBoxRel SetBoxItem(Integer id,String memo);
	//public LightBox addBox(Integer userId,String userName, String name,Integer pid);
	//public LightBox setBoxFather(Integer id,Integer pid);
	//public LightBox addBoxDefault(Integer userId,String userName) ;
	//public LightBoxRel delBoxItem(Integer id);
	//public LightBox delBox(Integer id);
	//public boolean delBoxImgByBoxIDAndCorbisId(int boxId,String corbisId);
	public FrCart getCart(Integer id);
	public FrCart delCart(Integer id);
	
	//public LightBox UpdateLightBox(LightBox lb0);
	//public boolean moveImg(int boxId, String[] imgids, int isDel) throws Exception;
	//public LightBoxRel getLightBoxItem(String code,int lightBoxId);
	
	//boolean copyBoxImg(int boxId, String corbisId,int newBoxId);
}
