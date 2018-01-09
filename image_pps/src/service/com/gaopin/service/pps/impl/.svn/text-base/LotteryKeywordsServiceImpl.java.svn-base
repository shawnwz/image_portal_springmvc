package com.gaopin.service.pps.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




import org.springframework.stereotype.Service;

import com.gaopin.entity.LtKeywords;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.LotteryKeywordsService;


@Service("lotteryKeywordsService")
public class LotteryKeywordsServiceImpl extends BaseServiceImpl implements LotteryKeywordsService {

	@Override
	public boolean isExist(String keyword) {
		if(null!=keyword&&keyword.length()>0){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("keyword", keyword, CompareType.Equal));
			coll.add(new CompareExpression("count", 1, CompareType.Ge));
			List<LtKeywords> list=controller.findBy(LtKeywords.class,coll);
			if(list.size()>0)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void consumeKeyword(LtKeywords keyword) {
		
		int count = keyword.getCount()-1;
		keyword.setCount(count);
		super.updateObject(keyword);
		
	}

	@Override
	public LtKeywords findLtKeyword(String keyword) {
		if(null!=keyword&&keyword.length()>0){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("keyword", keyword, CompareType.Equal));
			coll.add(new CompareExpression("count", 1, CompareType.Ge));
			List<LtKeywords> list=controller.findBy(LtKeywords.class,coll);
			if(list.size()>0)
			{
				return list.get(0);
			}
		}
		return null;
	}

	
}
