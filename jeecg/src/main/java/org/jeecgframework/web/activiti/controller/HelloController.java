package org.jeecgframework.web.activiti.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.jeecgframework.core.common.dao.impl.CommonDao;
import org.jeecgframework.web.activiti.service.HelloService;

import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/helloController")
public class HelloController {
	

	@Autowired 
	private HelloService helloService;
	
	@Autowired
	private ProcessEngine processEngine;
	
    @Autowired
    private TaskService taskService;
	
	@Autowired 
	private CommonDao commonDao;
    
	
	@RequestMapping("/hello")
	public void SayHello() {
		
	     helloService.SayHello();
	}
	
	
	@RequestMapping("queryProcessDefin")
	public void testQueryProcessDefin() {
       List<ProcessDefinition>	processList	= processEngine.getRepositoryService()
    		                                               .createProcessDefinitionQuery()
    		                                               .list();
       
       for(ProcessDefinition definition : processList) {
    	   System.out.println(definition.getName());
       }
	}
	
	@RequestMapping("queryTask")
	public void testQueryTask() {
		
		List<Task> taskServices =  processEngine.getTaskService().createTaskQuery().taskAssignee("lan").list();
		
		for(Task task : taskServices) {
			System.out.println("任务Id:"+task.getId());
			System.out.println("任务名称:" +task.getName());
			System.out.println("执行人 "+ task.getAssignee());
			System.out.println("-----------------------------------------------------");
		}
		
	}
	
	@RequestMapping("startProcess")
	public void startProcess() {
	  ProcessInstance pi =	processEngine.getRuntimeService().startProcessInstanceByKey("leave_1");
	  System.out.println("启动流程实例"+pi.getActivityId() + "    "+ pi.getName());
	  
	}
	
    
	@RequestMapping("completeTask")
	public void completeTask() {
		String taskId = "10004";
	    processEngine.getTaskService().complete(taskId);
	    System.out.println("完成任务");
		
	}
	
	
	@RequestMapping("indentService")
	public void testIndentService() {
	    
	 
	  IdentityService identityService =	processEngine.getIdentityService();
	  List<User> users=  identityService.createUserQuery().list();

    	  for(User user : users) {
    		  System.out.println(user.getId());
        	  System.out.println(user.getFirstName());
        	  System.out.println(user.getEmail());
        	  System.out.println("----------------------------------------------------");
    	  }
       
	}	
}
