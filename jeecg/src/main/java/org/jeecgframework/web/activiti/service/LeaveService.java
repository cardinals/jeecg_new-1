package org.jeecgframework.web.activiti.service;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.jeecgframework.web.activiti.dao.LeaveDao;
import org.jeecgframework.web.activiti.entity.Leave;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LeaveService {
	
	@Autowired
	private LeaveDao leaveDao;
	
	@Autowired
    private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	
}
