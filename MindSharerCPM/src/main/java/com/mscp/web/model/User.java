package com.mscp.web.model;

import java.sql.Timestamp;

public class User {

	private String uid;
	
	private String nickName;
	
	private String deviceId;
	
	private Timestamp regDttm;
	
	private Timestamp updDttm;
	
	private String cpId;
	
	private String cdPw;
	
	private String upw;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Timestamp getRegDttm() {
		return regDttm;
	}

	public void setRegDttm(Timestamp regDttm) {
		this.regDttm = regDttm;
	}

	public Timestamp getUpdDttm() {
		return updDttm;
	}

	public void setUpdDttm(Timestamp updDttm) {
		this.updDttm = updDttm;
	}

	public String getCpId() {
		return cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public String getCdPw() {
		return cdPw;
	}

	public void setCdPw(String cdPw) {
		this.cdPw = cdPw;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}
	
	
}
