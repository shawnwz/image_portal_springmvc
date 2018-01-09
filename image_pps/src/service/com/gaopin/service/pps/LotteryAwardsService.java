/* This file UserService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gaopin.entity.LtAwards;
import com.gaopin.service.BaseService;

/**
 * @author 高顺德
 *
 */
public interface LotteryAwardsService extends BaseService {
	
	public int totalAmount();
	public int classOneAmount();
	public int classTwoAmount();
	public int classThreeAmount();
	
	
	public void consumeAward(LtAwards awards);
	public String getAwardName(LtAwards awards);
	public String getAwardDes(LtAwards awards);
	
	public List<LtAwards> getAll();
}
