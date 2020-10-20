package com.spring.MyPortfolio.dto;

import java.util.Date;

public class MemberDto {
	private String userId;
	private String password;
	private String name;
	private String brthdy;
	private String sexDstn;
	private String email;
	private Date   regDate;
	private String mbTlNum;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrthdy() {
		return brthdy;
	}
	public void setBrthdy(String brthdy) {
		this.brthdy = brthdy;
	}
	public String getSexDstn() {
		return sexDstn;
	}
	public void setSexDstn(String sexDstn) {
		this.sexDstn = sexDstn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getMbTlNum() {
		return mbTlNum;
	}
	public void setMbTlNum(String mbTlNum) {
		this.mbTlNum = mbTlNum;
	}
	
	
}
