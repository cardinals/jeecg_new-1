package com.jeecg.gpnu.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.jeecgframework.web.activiti.entity.Leave;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.gpnu.entity.LeaveInfoEntity;
import com.jeecg.gpnu.service.LeaveActivitService;


@Service
@Transactional
public class LeaveWorkflowService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    LeaveActivitService leaveService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;
  
    /**
     * 保存请假实体并启动流程
     */
    public ProcessInstance startWorkflow(LeaveInfoEntity entity,TSUser user, Map<String, Object> variables) {
        if (entity.getId() == null) {
            entity.setUserid(user.getId());
            //entity.setApplytime(new Date());
        }
        List<TSDepart> tsDeparts = leaveService.findDepartListByUserId(user.getId());
        entity.setName(user.getRealName());
        entity.setClassName(tsDeparts.get(0).getDepartname());
        entity.setCreateName(tsDeparts.get(1).getDepartname());
        entity.setProfessionName((tsDeparts.get(2).getDepartname()));
        entity.setInstitudeName(tsDeparts.get(3).getDepartname());
        
        leaveService.save(entity);//持久化请假实体
        String businessKey = entity.getId().toString();//实体保存后的ID，作为流程中的业务key
        
        // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        identityService.setAuthenticatedUserId(user.getId());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave_2", businessKey, variables);//将业务主ID设置为流程实例的key
        String processInstanceId = processInstance.getId();
        entity.setProcessInstanceId(processInstanceId);// 将流程实例的ID保存至业务表
        logger.debug("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"leave", businessKey, processInstanceId, variables});
        leaveService.save(entity);
        return processInstance;
    }


}