package com.jeecg.gpnu.dao;

import java.util.List;

import org.jeecgframework.web.activiti.entity.Leave;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;

import com.jeecg.gpnu.entity.LeaveInfoEntity;







public interface LeaveActivitDao {
    
	public void save(LeaveInfoEntity leave);

	public LeaveInfoEntity get(String businessKey);
	
	public List<String> findLeaderByUserid(String userId);

	public List<String> findLeaderByUserName(String userId);

	public LeaveInfoEntity findUseridByProcessInstanceId(String processInstanceId);
	
	public List<TSDepart> findDepartListByUserId(String userId);
	
	public TSRoleUser FindRoleByUserId(String userId);

}
