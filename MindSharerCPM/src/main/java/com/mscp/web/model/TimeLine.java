package com.mscp.web.model;

import java.sql.Timestamp;

public class TimeLine {
	
	/**
	 * 게시물 고유번호 
	 */
	private long tlSeq;
		
	/**
	 * 게시물 작성자 
	 */
	private String makerUid;
	
	/**
	 * 게시물 등록시간 
	 */
	private Timestamp regDttm;
	
	/**
	 * 게시물 수정시간 
	 */
	private Timestamp updDttm;
	
	/**
	 * 게시물 내용 
	 */
	private String text;
	
	/**
	 * 게시물 이미지 경로 
	 */
	private String imgPath;
	
	/**
	 * 공유 타입 <p>
	 * 0: ALL, 1:Follow, -1: Private
	 */
	private int shareType;

	public long getTlSeq() {
		return tlSeq;
	}

	public void setTlSeq(long tlSeq) {
		this.tlSeq = tlSeq;
	}

	public String getMakerUid() {
		return makerUid;
	}

	public void setTlMakerUid(String makerUid) {
		this.makerUid = makerUid;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getShareType() {
		return shareType;
	}

	public void setShareType(int shareType) {
		this.shareType = shareType;
	}

	
}
