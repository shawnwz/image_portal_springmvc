package com.gaopin.entity;

import java.util.Date;

public class TubeContestImagePreviewInfo implements java.io.Serializable {

	private String storageId;
	private String title;
	private String caption;
	private Date uploadDate;
	private String filename;
	private String orgifilename;
	private String uuid;
	private String userid;
	private String contestid;
	private String imageHost;
	private String md5path;
	private Date photoDate;
	private String creditLine;
	private int votes;
	private int views;
	private String comments;
	private String cameraused;
	private String lens;
	private String focallength;
	private String shutterspeed;
	private String iso;
	private String aperture;
	
	private String contesttitle;
	private String contestdesc;
	private Date contestdate;
	private String nickname;
	private String useravatar;
	private String username;
	public String getStorageId() {
		return storageId;
	}
	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOrgifilename() {
		return orgifilename;
	}
	public void setOrgifilename(String orgifilename) {
		this.orgifilename = orgifilename;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getImageHost() {
		return imageHost;
	}
	public void setImageHost(String imageHost) {
		this.imageHost = imageHost;
	}
	public String getMd5path() {
		return md5path;
	}
	public void setMd5path(String md5path) {
		this.md5path = md5path;
	}
	public Date getPhotoDate() {
		return photoDate;
	}
	public void setPhotoDate(Date photoDate) {
		this.photoDate = photoDate;
	}
	public String getCreditLine() {
		return creditLine;
	}
	public void setCreditLine(String creditLine) {
		this.creditLine = creditLine;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCameraused() {
		return cameraused;
	}
	public void setCameraused(String cameraused) {
		this.cameraused = cameraused;
	}
	public String getLens() {
		return lens;
	}
	public void setLens(String lens) {
		this.lens = lens;
	}
	public String getFocallength() {
		return focallength;
	}
	public void setFocallength(String focallength) {
		this.focallength = focallength;
	}
	public String getShutterspeed() {
		return shutterspeed;
	}
	public void setShutterspeed(String shutterspeed) {
		this.shutterspeed = shutterspeed;
	}
	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	public String getAperture() {
		return aperture;
	}
	public void setAperture(String aperture) {
		this.aperture = aperture;
	}
	public String getContestid() {
		return contestid;
	}
	public void setContestid(String contestid) {
		this.contestid = contestid;
	}
	public String getContesttitle() {
		return contesttitle;
	}
	public void setContesttitle(String contesttitle) {
		this.contesttitle = contesttitle;
	}
	public String getContestdesc() {
		return contestdesc;
	}
	public void setContestdesc(String contestdesc) {
		this.contestdesc = contestdesc;
	}

	public Date getContestdate() {
		return contestdate;
	}
	public void setContestdate(Date contestdate) {
		this.contestdate = contestdate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUseravatar() {
		return useravatar;
	}
	public void setUseravatar(String useravatar) {
		this.useravatar = useravatar;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	public TubeContestImagePreviewInfo(String storageId, String title,
			String caption, Date uploadDate, String filename,
			String orgifilename, String uuid, String userid, String contestid,
			String imageHost, String md5path, Date photoDate,
			String creditLine, int votes, int views, String comments,
			String cameraused, String lens, String focallength,
			String shutterspeed, String iso, String aperture,
			String contesttitle, String contestdesc, Date contestdate,
			String nickname, String useravatar, String username) {
		super();
		this.storageId = storageId;
		this.title = title;
		this.caption = caption;
		this.uploadDate = uploadDate;
		this.filename = filename;
		this.orgifilename = orgifilename;
		this.uuid = uuid;
		this.userid = userid;
		this.contestid = contestid;
		this.imageHost = imageHost;
		this.md5path = md5path;
		this.photoDate = photoDate;
		this.creditLine = creditLine;
		this.votes = votes;
		this.views = views;
		this.comments = comments;
		this.cameraused = cameraused;
		this.lens = lens;
		this.focallength = focallength;
		this.shutterspeed = shutterspeed;
		this.iso = iso;
		this.aperture = aperture;
		this.contesttitle = contesttitle;
		this.contestdesc = contestdesc;
		this.contestdate = contestdate;
		this.nickname = nickname;
		this.useravatar = useravatar;
		this.username = username;
	}
	public TubeContestImagePreviewInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
