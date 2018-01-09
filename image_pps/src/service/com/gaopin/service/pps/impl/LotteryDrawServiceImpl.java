package com.gaopin.service.pps.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gaopin.constants.Constants;
import com.gaopin.entity.LtAwards;
import com.gaopin.entity.LtKeywords;
import com.gaopin.entity.User;
import com.gaopin.entity.LtWinner;
import com.gaopin.entity.LtNonloginUserWin;
import com.gaopin.entity.LtIpExclusive;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.LotteryDrawService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.service.pps.LotteryKeywordsService;
import com.gaopin.service.pps.LotteryAwardsService;
import com.gaopin.utils.CacheKeyUtils;
import com.gaopin.utils.PropertyReader;

@Service("lotteryDrawService")
public class LotteryDrawServiceImpl extends BaseServiceImpl implements LotteryDrawService{

	@Resource
	VariablesService variablesService;
	@Resource
	LotteryKeywordsService lotteryKeywordsService;
	@Resource
	LotteryAwardsService lotteryAwardsService;
	
	
	private static Map<String, LtIpExclusive> _map = new HashMap<String, LtIpExclusive>();
	
	
	@PostConstruct
	public void init(){
		long t = System.currentTimeMillis();
		if(PropertyReader.getInt("local.debug", -1)<=0){
			loadExclusiveIpList();
		}
		System.out.println("IP exclusive List load time ：" + (System.currentTimeMillis()-t));
	}
	
	
	@Override
	public LtAwards doLuckyDraw(User user, String keyword, String sessionid, String userip) {
		
		final int NUM = 1000;
		
		String prob_notlogin = variablesService.getVariablesValue("unregistered_user_probability", "");
		String prob_logined = variablesService.getVariablesValue("registered_user_probability", "");	
		float prob_nonuser = Float.parseFloat(prob_notlogin);
		float prob_user = Float.parseFloat(prob_logined);
		int time = Integer.parseInt(variablesService.getVariablesValue("lottery_win_times","1"));

		
/*		if(!lotteryKeywordsService.isExist(keyword)){
			return null;
		}*/

		if(keyword==null || keyword.isEmpty() || keyword.equals("") || keyword.equals(" ")){
			return null;
		}
		if(lotteryAwardsService.totalAmount()<=0){
			return null;
		}
		if(isInExclusiveList(userip)){
			return null;
		}


		List<LtAwards> awardslist = lotteryAwardsService.getAll();
		if(user == null){
			if(getWinCountBySessionId(sessionid)>=time){
				return null;
			}
/*			LtNonloginUserWin winner = getWinnerBySessionId(sessionid);
			if(winner!=null){
				if(System.currentTimeMillis() - winner.getCreateTime().getTime() < 3600*1000L){
					return null;
				}
			}*/
			int random = new Random().nextInt(NUM);
			if(random>0 && random<NUM*prob_nonuser){
				
				int rand = new Random().nextInt(awardslist.size());
				LtAwards award = awardslist.get(rand);
				LtKeywords ltkeyword = lotteryKeywordsService.findLtKeyword(keyword);
				//lotteryKeywordsService.consumeKeyword(ltkeyword);
				lotteryAwardsService.consumeAward(awardslist.get(rand));
				
				LtNonloginUserWin ltNonloginUserWin = new LtNonloginUserWin();
				ltNonloginUserWin.setSessionId(sessionid);
				ltNonloginUserWin.setAwardId(award.getId());
				ltNonloginUserWin.setCreateTime(new Date());
				ltNonloginUserWin.setAccept(0);
				ltNonloginUserWin.setKeyword(keyword);
				ltNonloginUserWin.setUserIp(userip);
				super.saveObject(ltNonloginUserWin);
				String key=CacheKeyUtils.getEntityListKey(LtNonloginUserWin.class, "sessionId", sessionid);
				cacheService.putRemote(key, ltNonloginUserWin, Constants.CACHE_HOUR_TIMES);
				return award;
				
			}else{
				return null;
			}
		}else{
			if(getWinCountByUser(user)>=time){
				return null;
			}
/*			LtWinner winner = getWinnerByUser(user); 
			if(winner!=null){
				if(System.currentTimeMillis() - winner.getCreateTime().getTime() < 3600*1000L){
					return null;
				}
			}*/
			int random = new Random().nextInt(NUM);
			if(random>0 && random<NUM*prob_user){
				
				int rand = new Random().nextInt(awardslist.size());
				LtAwards award = awardslist.get(rand);
				LtKeywords ltkeyword = lotteryKeywordsService.findLtKeyword(keyword);
				//lotteryKeywordsService.consumeKeyword(ltkeyword);
				lotteryAwardsService.consumeAward(awardslist.get(rand));
				
				LtWinner ltWinner = new LtWinner();
				ltWinner.setUserId(user.getId());
				ltWinner.setUserEmail(user.getEmail());
				ltWinner.setAwardId(award.getId());
				ltWinner.setUserName(user.getUserName());
				ltWinner.setContactInfo(user.getContactsInfo());
				ltWinner.setCreateTime(new Date());
				ltWinner.setGivingOut(0);
				ltWinner.setKeyword(keyword);
				ltWinner.setUserIp(userip);
				super.saveObject(ltWinner);
				String key=CacheKeyUtils.getEntityListKey(LtWinner.class, "userId", user.getId());
				cacheService.putRemote(key, ltWinner, Constants.CACHE_HOUR_TIMES);
				
				return award;
				
			}else{
				return null;
			}
			
		}
		
	}
	@Override
	public boolean isNonLoginUserWon(String sessionid) {

		if(null!=sessionid&&sessionid.length()>0){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("sessionId", sessionid, CompareType.Equal));
			coll.add(new CompareExpression("accept", 0, CompareType.Equal));
			List<LtNonloginUserWin> list=controller.findBy(LtNonloginUserWin.class,coll);
			if(list.size()>0)
				return true;
		}
		return false;
	}
	@Override
	public List<LtNonloginUserWin> getAwardForNonLoginUser(String sessionid) {
		if(null!=sessionid&&sessionid.length()>0){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("sessionId", sessionid, CompareType.Equal));
			coll.add(new CompareExpression("accept", 0, CompareType.Equal));
			List<LtNonloginUserWin> list=controller.findBy(LtNonloginUserWin.class,coll);
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					if(System.currentTimeMillis()-list.get(i).getCreateTime().getTime()>2*3600*1000L){
						list.remove(i);
						list.get(i).setAccept(-1);
						super.updateObject(list.get(i));
					}
				}
			}
			
			if(list.size()>0){
				return list;
			}
				
		}
		return null;
	}
	@Override
	public void consumeAwardForNonLoginUser(List<LtNonloginUserWin> list) {
		if(null!=list && list.size()>0){
			for(int n=0; n<list.size(); n++){
				list.get(n).setAccept(1);
				list.get(n).setAcceptTime(new Date());
				super.updateObject(list.get(n));
				
			}
		}
	}
	@Override
	public void recordAwardForNonLoginUser(User user, List<LtNonloginUserWin> list) {
		if(null!=list && list.size()>0){
			for(int n=0; n<list.size(); n++){
				LtWinner winner = new LtWinner();
				winner.setCreateTime(new Date());
				winner.setUserId(user.getId());
				winner.setUserEmail(user.getEmail());
				winner.setUserName(user.getUserName());
				winner.setContactInfo(user.getContactsInfo());
				winner.setAwardId(list.get(n).getAwardId());
				winner.setKeyword(list.get(n).getKeyword());
				winner.setUserIp(list.get(n).getUserIp());
				super.saveObject(winner);
			}
		}
		
	}
	@Override
	public void checkAndAcceptAwardForNonLoginUser(User user, String sessionid) {

		if(isNonLoginUserWon(sessionid)){
			List<LtNonloginUserWin> list = getAwardForNonLoginUser(sessionid);
			consumeAwardForNonLoginUser(list);
			recordAwardForNonLoginUser(user, list);
		}else{
			return;
		}
		
	}
	@Override
	public boolean isInExclusiveList(String userip) {
		
		if( null==_map.get(userip) ){
			return false;
		}else{
			return true;
		}
		
	}
	@Override
	public void loadExclusiveIpList() {
		_map.clear();
		
		List<LtIpExclusive> list = controller.getAll(LtIpExclusive.class);
		for(LtIpExclusive ip : list){
			_map.put(ip.getIpaddress(), ip);
			
		}
		
	}


	@Override
	public int getWinCountBySessionId(String sessionid) {
		String cacheKey = CacheKeyUtils.getEntityListKey(LtNonloginUserWin.class, "sessionId", sessionid);
		try {
			List<LtNonloginUserWin> list = (List<LtNonloginUserWin>) cacheService.getRemote(cacheKey);
			if(list.size()>0){
				return list.size();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("sessionId",sessionid, CompareType.Equal));
		Long count = controller.getResultCount(LtNonloginUserWin.class, coll);
		return (int)(count==null ? 0L : count.longValue());
	}
	
	public int getWinCountBySessionIdForToday(String sessionid) {
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("sessionId",sessionid, CompareType.Equal));
		coll.add(new CompareExpression("createTime",new Date(), CompareType.Equal));
		Long count = controller.getResultCount(LtNonloginUserWin.class, coll);
		return (int)(count==null ? 0L : count.longValue());
	}


	@Override
	public int getWinCountByUser(User user) {
		String cacheKey = CacheKeyUtils.getEntityListKey(LtWinner.class, "userId", user.getId());
		try {
			List<LtWinner> list = (List<LtWinner>) cacheService.getRemote(cacheKey);
			if(list.size()>0){
				return list.size();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("userId",user.getId(), CompareType.Equal));
		Long count = controller.getResultCount(LtWinner.class, coll);
		return (int)(count==null ? 0L : count.longValue());
	}
	
	public int getWinCountByUserForToday(User user) {
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("userId",user.getId(), CompareType.Equal));
		coll.add(new CompareExpression("createTime",new Date(), CompareType.Equal));
		Long count = controller.getResultCount(LtWinner.class, coll);
		return (int)(count==null ? 0L : count.longValue());
	}


	@Override
	public LtNonloginUserWin getWinnerBySessionId(String sessionid) {
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("sessionId",sessionid, CompareType.Equal));
		List<LtNonloginUserWin> list=controller.findBy(LtNonloginUserWin.class,coll);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}


	@Override
	public LtWinner getWinnerByUser(User user) {
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("userId",user.getId(), CompareType.Equal));
		List<LtWinner> list=controller.findBy(LtWinner.class, coll);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}


}
