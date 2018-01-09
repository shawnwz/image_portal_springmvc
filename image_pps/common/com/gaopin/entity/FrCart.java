package com.gaopin.entity;

// Generated Sep 24, 2015 10:13:56 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FrCart generated by hbm2java
 */
@Entity
@Table(name = "fr_cart")
public class FrCart implements java.io.Serializable {

	private Integer id;
	private String gaopinId;
	private Integer userId;
	private Integer status;
	private Date createDate;
	private Date changeDate;

	public FrCart() {
	}

	public FrCart(String gaopinId, Integer userId, Integer status,
			Date createDate, Date changeDate) {
		this.gaopinId = gaopinId;
		this.userId = userId;
		this.status = status;
		this.createDate = createDate;
		this.changeDate = changeDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "gaopin_id", length = 30)
	public String getGaopinId() {
		return this.gaopinId;
	}

	public void setGaopinId(String gaopinId) {
		this.gaopinId = gaopinId;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "change_date", length = 19)
	public Date getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

}