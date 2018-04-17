package com.jeecg.gpnu.entity;

import java.util.Date;

public class TaskEntity {
	
	private String id;
	
	private String userId;
	
	private String userName;
     
    private String processInstanceId;
    
    private Date createTime;
    

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date date) {
		this.createTime = date;
	}

	   
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	
	
	
}
