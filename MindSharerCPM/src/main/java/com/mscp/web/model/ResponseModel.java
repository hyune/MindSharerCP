package com.mscp.web.model;

public class ResponseModel<T> {

	private int status;
	
	private T result;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
	
}
