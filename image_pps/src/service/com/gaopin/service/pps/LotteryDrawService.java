package com.gaopin.service.pps;

import java.util.List;

import com.gaopin.service.BaseService;
import com.gaopin.entity.LtWinner;
import com.gaopin.entity.User;
import com.gaopin.entity.LtAwards;
import com.gaopin.entity.LtKeywords;
import com.gaopin.entity.LtNonloginUserWin;


public interface LotteryDrawService extends BaseService {

	public LtAwards doLuckyDraw(User user, String keyword, String sessionid, String userip);
	
	
	
	public boolean isNonLoginUserWon(String sessionid);
	public List<LtNonloginUserWin> getAwardForNonLoginUser(String sessionid);
	public void consumeAwardForNonLoginUser(List<LtNonloginUserWin> list);
	public void recordAwardForNonLoginUser(User user, List<LtNonloginUserWin> list);
	public void checkAndAcceptAwardForNonLoginUser(User user, String sessionid);
	
	
	public boolean isInExclusiveList(String userip);
	
	public void loadExclusiveIpList();
	
	public int getWinCountBySessionId(String sessionid);
	
	public int getWinCountByUser(User user);
	
	public LtNonloginUserWin getWinnerBySessionId(String sessionid);
	
	public LtWinner getWinnerByUser(User user);
}
