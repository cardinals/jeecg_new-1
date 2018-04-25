package com.jeecg.gpnu.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.activiti.engine.runtime.ProcessInstance;
import org.jeecgframework.web.activiti.entity.Leave;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecg.gpnu.dao.LeaveActivitDao;
import com.jeecg.gpnu.entity.LeaveInfoEntity;
import com.jeecg.gpnu.service.LeaveActivitService;


@Service
public class LeaveActivitServiceImple implements LeaveActivitService{
    
	@Autowired
	private LeaveActivitDao leaveDao;
	
	@Override
	public void save(LeaveInfoEntity leave) {
		// TODO Auto-generated method stub
		
		leaveDao.save(leave);
	}

	@Override
	public LeaveInfoEntity get(String businessKey) {
		// TODO Auto-generated method stub
		
		return leaveDao.get(businessKey);
	}

	@Override
	public LeaveInfoEntity findLeaveInfoEntityByProId(String processInstanceId) {
		// TODO Auto-generated method stub
		return leaveDao.findLeaveInfoEntityByProId(processInstanceId);
	}

	@Override
	public List<TSDepart> findDepartListByUserId(String userId) {
		// TODO Auto-generated method stub	
		return leaveDao.findDepartListByUserId(userId);
	}

	@Override
	public TSRoleUser FindRoleByUserId(String userId) {
		// TODO Auto-generated method stub
		return leaveDao.FindRoleByUserId(userId);
	}

	@Override
	public void UpdateBpmStatus(String statu,String processInstanceId) {
		// TODO Auto-generated method stub
		leaveDao.UpdateBpmStatus(statu,processInstanceId);
	}

	@Override
	public void UpdateComment(String comment, String processInstanceId) {
		// TODO Auto-generated method stub
		leaveDao.UpdateComment(comment, processInstanceId);
	}


	@Override
	public void UpdateConcleLeave(Date concleLeave, String processInstanceId) {
		// TODO Auto-generated method stub
		leaveDao.UpdateConcleLeave(concleLeave, processInstanceId);
	}

	

}
