package com.jeecg.gpnu.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.jeecgframework.web.activiti.entity.Leave;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;

import com.jeecg.gpnu.entity.LeaveInfoEntity;

public interface LeaveActivitService {
	
     public void save(LeaveInfoEntity entity);

	 public LeaveInfoEntity get(String businessKey);
	 
	 public LeaveInfoEntity findLeaveInfoEntityByProId(String processInstanceId);
		
	 public List<TSDepart> findDepartListByUserId(String userId);

	 public TSRoleUser FindRoleByUserId(String userId);
	 
	 public void UpdateBpmStatus(String statu,String processInstanceId);

	 public void UpdateComment(String comment, String processInstanceId);

	public void UpdateConcleLeave(Date date, String processInstanceId);
}
