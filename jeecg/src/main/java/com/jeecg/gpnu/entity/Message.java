package com.jeecg.gpnu.entity;

public class Message {
	
	private Boolean flag;
	private String msg;
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Message [flag=" + flag + ", msg=" + msg + "]";
	}
	
}
