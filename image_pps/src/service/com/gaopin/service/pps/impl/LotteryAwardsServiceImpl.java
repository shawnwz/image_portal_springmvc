package com.gaopin.service.pps.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gaopin.entity.LtAwards;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.LotteryAwardsService;

@Service("lotteryAwardsService")
public class LotteryAwardsServiceImpl extends BaseServiceImpl implements LotteryAwardsService  {

	@Override
	public int totalAmount() {
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("status", 1, CompareType.Equal));
		List<LtAwards> list=controller.findBy(LtAwards.class,coll);
		
		if(list.size()>0){
			return list.size();
		}else{
			return 0;
		}
	}

	@Override
	public int classOneAmount() {
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("status", 1, CompareType.Equal));
		coll.add(new CompareExpression("awardclass", 1, CompareType.Equal));
		List<LtAwards> list=controller.findBy(LtAwards.class,coll);
		
		if(list.size()>0){
			return list.size();
		}else{
			return 0;
		}
	}

	@Override
	public int classTwoAmount() {
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("status", 1, CompareType.Equal));
		coll.add(new CompareExpression("awardclass", 2, CompareType.Equal));
		List<LtAwards> list=controller.findBy(LtAwards.class,coll);
		
		if(list.size()>0){
			return list.size();
		}else{
			return 0;
		}
	}

	@Override
	public int classThreeAmount() {
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("status", 1, CompareType.Equal));
		coll.add(new CompareExpression("awardclass", 3, CompareType.Equal));
		List<LtAwards> list=controller.findBy(LtAwards.class,coll);
		
		if(list.size()>0){
			return list.size();
		}else{
			return 0;
		}
	}

	@Override
	public void consumeAward(LtAwards awards) {
		
		awards.setStatus(0);
		super.updateObject(awards);
	}

	@Override
	public String getAwardName(LtAwards awards) {
		
		return awards.getName();
	}

	@Override
	public String getAwardDes(LtAwards awards) {
		
		return awards.getDescription();
	}

	@Override
	public List<LtAwards> getAll() {
		
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("status", 1, CompareType.Ge));
		List<LtAwards> list=controller.findBy(LtAwards.class,coll);
		
		if(list.size()>0){
			return list;
		}else{
			return null;
		}	
	}
	

}
