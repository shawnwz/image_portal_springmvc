package com.gaopin.entity;

public class TubeUserInfoBrief implements java.io.Serializable {
	
	private String uuid;
	private String isActive;
	private String username;
	private String mobilenumber;
	private Integer isMobileVerified;
	private String email;
	private Integer isEmailVerified;
	private String avatarSmallUrl;
	private String avatarBigUrl;
	private String coverImageSmallUrl;
	private String coverImageBigUrl;
	private Integer gender;
	private Integer allCount;
	private Integer rejectCount;
	private Integer onlineCount;
	private String nickname;
	private String birthday;
	
	private String city;
	private String region;
	private String alipayaccount;
	private String signature;
	private String selfintro;
	private String registerby;
	
	//======================================
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public Integer getIsMobileVerified() {
		return isMobileVerified;
	}
	public void setIsMobileVerified(Integer isMobileVerified) {
		this.isMobileVerified = isMobileVerified;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIsEmailVerified() {
		return isEmailVerified;
	}
	public void setIsEmailVerified(Integer isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}
	public String getAvatarSmallUrl() {
		return avatarSmallUrl;
	}
	public void setAvatarSmallUrl(String avatarSmallUrl) {
		this.avatarSmallUrl = avatarSmallUrl;
	}
	public String getAvatarBigUrl() {
		return avatarBigUrl;
	}
	public void setAvatarBigUrl(String avatarBigUrl) {
		this.avatarBigUrl = avatarBigUrl;
	}
	public String getCoverImageSmallUrl() {
		return coverImageSmallUrl;
	}
	public void setCoverImageSmallUrl(String coverImageSmallUrl) {
		this.coverImageSmallUrl = coverImageSmallUrl;
	}
	public String getCoverImageBigUrl() {
		return coverImageBigUrl;
	}
	public void setCoverImageBigUrl(String coverImageBigUrl) {
		this.coverImageBigUrl = coverImageBigUrl;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getAllCount() {
		return allCount;
	}
	public void setAllCount(Integer allCount) {
		this.allCount = allCount;
	}
	public Integer getRejectCount() {
		return rejectCount;
	}
	public void setRejectCount(Integer rejectCount) {
		this.rejectCount = rejectCount;
	}
	public Integer getOnlineCount() {
		return onlineCount;
	}
	public void setOnlineCount(Integer onlineCount) {
		this.onlineCount = onlineCount;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAlipayaccount() {
		return alipayaccount;
	}
	public void setAlipayaccount(String alipayaccount) {
		this.alipayaccount = alipayaccount;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getSelfintro() {
		return selfintro;
	}
	public void setSelfintro(String selfintro) {
		this.selfintro = selfintro;
	}

	
	
	public String getRegisterby() {
		return registerby;
	}
	public void setRegisterby(String registerby) {
		this.registerby = registerby;
	}

	public TubeUserInfoBrief(String uuid, String isActive, String username,
			String mobilenumber, Integer isMobileVerified, String email,
			Integer isEmailVerified, String avatarSmallUrl,
			String avatarBigUrl, String coverImageSmallUrl,
			String coverImageBigUrl, Integer gender, Integer allCount,
			Integer rejectCount, Integer onlineCount, String nickname,
			String birthday, String city, String region, String alipayaccount,
			String signature, String selfintro, String registerby) {
		super();
		this.uuid = uuid;
		this.isActive = isActive;
		this.username = username;
		this.mobilenumber = mobilenumber;
		this.isMobileVerified = isMobileVerified;
		this.email = email;
		this.isEmailVerified = isEmailVerified;
		this.avatarSmallUrl = avatarSmallUrl;
		this.avatarBigUrl = avatarBigUrl;
		this.coverImageSmallUrl = coverImageSmallUrl;
		this.coverImageBigUrl = coverImageBigUrl;
		this.gender = gender;
		this.allCount = allCount;
		this.rejectCount = rejectCount;
		this.onlineCount = onlineCount;
		this.nickname = nickname;
		this.birthday = birthday;
		this.city = city;
		this.region = region;
		this.alipayaccount = alipayaccount;
		this.signature = signature;
		this.selfintro = selfintro;
		this.registerby = registerby;
	}
	public TubeUserInfoBrief() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	

	
	
	
	

}
