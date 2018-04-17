package com.jeecg.gpnu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.TransitionImpl;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RejectTaskService {
	
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private RepositoryService repositoryService;
    
    
	public void rejectTask(String procInstId, String destTaskKey,String rejectMessage) {
		
		//获取当前任取实例id
		Task taskEntity = taskService.createTaskQuery().processInstanceId(procInstId).singleResult();
		
		//当前任务的key
		String taskDefKey = taskEntity.getTaskDefinitionKey();
		System.out.println("taskDefKey:" + taskDefKey);
		//获得当前定义的模型
		ProcessDefinitionEntity processDefinition =(ProcessDefinitionEntity) ((RepositoryServiceImpl)repositoryService)
				.getDeployedProcessDefinition(taskEntity.getProcessDefinitionId());
		
		//获得当前流程定义的模型的所有任务节点
		List<ActivityImpl> activitylist = processDefinition.getActivities();
		
		//获得当前活动节点和驳回目标节点
		ActivityImpl currActivit = null;  //当前活动节点
		
		//驳回目标节点
		ActivityImpl destActivit = null; 
		
		int sign = 0;
		
		for(ActivityImpl activityImpl : activitylist) {
			//确定当前目标节点
			if(taskDefKey.equals(activityImpl.getId())) {
				currActivit = activityImpl;
				sign++;
			}else if(destTaskKey.equals(activityImpl.getId())){
				destActivit = activityImpl;
				sign++;
			}
			 
			if(sign == 2) {
				break;
			}
		}
		
		System.out.println("//-->currActiviti activityImpl.getId():"+currActivit.getId());
		System.out.println("//-->destActiviti activityImpl.getId():"+destActivit.getId());
		
		//保存流程节点的流程参数
		List<PvmTransition> hisPvmTransitionList = new ArrayList<PvmTransition>(0);
		
		for(PvmTransition pvmTransition : currActivit.getOutgoingTransitions()) {
			hisPvmTransitionList.add(pvmTransition);
		}
		
		//清空当前所有流出项
		currActivit.getOutgoingTransitions().clear();
		
		System.out.println("//-->currActiviti.getOutgoingTransitions().clear():"+currActivit.getOutgoingTransitions().size());
		
		//为当前节点动态创建新的流出项
		TransitionImpl newTransitionImpl   = currActivit.createOutgoingTransition();
		
		//为当前活动节点新的流出目标指定流程目标
		
		newTransitionImpl.setDestination(destActivit);
		
	    //保存驳回的意见
		taskEntity.setDescription(rejectMessage);  //设置驳回意见
		
		taskService.saveTask(taskEntity);
		
		//设定驳回标志 
		Map<String, Object> variables = new HashMap<String, Object>(0);
		variables.put("reject","reject");
		
		//执行当前任务驳回到目标任务draft
		taskService.complete(taskEntity.getId(), variables);
		
		//清除目标节点的新流入项
		destActivit.getIncomingTransitions().remove(newTransitionImpl);
		
		//清除原活动节点的临时流程项
		currActivit.getOutgoingTransitions().clear();
		
		//还原原活动节点流出项参数
		currActivit.getOutgoingTransitions().addAll(hisPvmTransitionList);
		
		
	}

}
