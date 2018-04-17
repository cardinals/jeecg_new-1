package com.jeecg.gpnu.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

import javax.servlet.http.HttpSession;

import org.activiti.bpmn.converter.TaskXMLConverter;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.batik.util.io.StreamNormalizingReader;
import org.apache.fop.fo.properties.VoiceFamilyMaker;
import org.jeecgframework.core.common.dao.impl.CommonDao;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.activiti.entity.Leave;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSRole;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeecg.gpnu.entity.LeaveInfoEntity;
import com.jeecg.gpnu.entity.Message;
import com.jeecg.gpnu.entity.TaskEntity;
import com.jeecg.gpnu.service.FmsLdapService;
import com.jeecg.gpnu.service.LeaveActivitService;
import com.jeecg.gpnu.service.impl.LeaveWorkflowService;
import com.jeecg.gpnu.service.impl.RejectTaskService;


@Controller
@RequestMapping("leaveActivitController")
public class LeaveActivitController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LeaveActivitService leaveActivitService;

    @Autowired
    private LeaveWorkflowService leaveWorkflowService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;
    
    @Autowired
    private ProcessEngine processEngine;
        
    @Autowired
    private FmsLdapService fmsLdapService;
    
    @Autowired
    private IdentityService identityService;
   
    @Autowired
    private RejectTaskService rejectTaskService; 
    
    @Autowired
    private SystemService systemService;
    
    @Autowired
    private CommonDao commonDao;
    /**
     * 启动请假流程
     */

    
    
    @RequestMapping(params = "task")
    public String leaveManger() {
    
    	return "com/jeecg/gpnu/taskList";
    }
    
    @RequestMapping(params = "leave")
    public ModelAndView  leave() {
        TSUser tsUser =  ResourceUtil.getSessionUser();
        TSRoleUser roleUser = leaveActivitService.FindRoleByUserId(tsUser.getId()); 
        List<TSDepart> tsDeparts = leaveActivitService.findDepartListByUserId(tsUser.getId());
        ModelAndView andView = new ModelAndView();
		andView .addObject("roleName", roleUser.getTSRole().getRoleName());
		andView.addObject("tsUser",tsUser);
	    andView.addObject("tsDeparts",tsDeparts);
	
        andView.setViewName("com/jeecg/gpnu/leaveRequest");
    	return andView;
    }
    
    @RequestMapping(value = "start")
    public void startWorkflow(LeaveInfoEntity leave, RedirectAttributes redirectAttributes, HttpSession session) {
    	
        try {
        	TSUser user = ResourceUtil.getSessionUser();
        	
            Map<String, Object> variables = new HashMap<String, Object>();
            ProcessInstance processInstance = leaveWorkflowService.startWorkflow(leave, user, variables);
            redirectAttributes.addFlashAttribute("message", "流程已启动，流程ID：" + processInstance.getId());
        } catch (ActivitiException e) {
            if (e.getMessage().indexOf("no processes deployed with key") != -1) {
                logger.warn("没有部署流程!", e);
                redirectAttributes.addFlashAttribute("error", "没有部署请假流程");
            } else {
               logger.error("启动请假流程失败：", e);
                redirectAttributes.addFlashAttribute("error", "系统内部错误！");
            }
        } catch (Exception e) {
            logger.error("启动请假流程失败：", e);
            redirectAttributes.addFlashAttribute("error", "系统内部错误！");
        }
       
    } 
    
    public List<LeaveInfoEntity> findTodoTasks(String userId){
    	
    	TSUser user = ResourceUtil.getSessionUser();
    	List<LeaveInfoEntity> leaveInfoEntities = new ArrayList<LeaveInfoEntity>();
    	List<Task> waittingClaimTasks = taskService.createTaskQuery()
    			                                   .taskCandidateUser(user.getId())
   	                                           .list();
    	
    	for(Task task : waittingClaimTasks) {
    		String processInstanceId = task.getProcessInstanceId();
   	        ProcessInstance  processInstance =  runtimeService.createProcessInstanceQuery()
    	                                                      .processInstanceId(processInstanceId)
   	                                                      .singleResult();
    	    String businessKey = processInstance.getBusinessKey();
    	    String busnessKey = processInstance.getBusinessKey(); //获取启动流程时的业务key
    	    LeaveInfoEntity leaveInfoEntity = leaveActivitService.get(businessKey);
    	    leaveInfoEntity.setTask(task);
    	    leaveInfoEntities.add(leaveInfoEntity);
    	}
    	
    	return leaveInfoEntities;
    }
    
  
//    
//    @ResponseBody
//	@RequestMapping(value ="complete")
//	public Object complete(@RequestParam String taskId) {
//    	TSUser tsUser = ResourceUtil.getSessionUser();
//    	Map<String,Object> variables = new HashMap<String, Object>();
//    	variables.put("flag",3);
//    	taskService.complete(taskId, variables);
//    	Message message = new Message();
//    	message.setMsg("请等待进一步的审核");
//    	message.setFlag(true);
//    	return message;
//	}
	 
	@ResponseBody
	@RequestMapping(params = "myTaskList")
	public List<TaskEntity> findWaittingTask() {
		TSUser tsUser =  ResourceUtil.getSessionUser();
	    List<Task> tasks = taskService.createTaskQuery().taskAssignee(tsUser.getId()).list();
	    List<TaskEntity> taskEntities = new ArrayList<TaskEntity>();
	    if(tasks.size() > 0) {
	    	for(Task task : tasks) {
		    	LeaveInfoEntity infoEntity =  leaveActivitService.findUseridByProcessInstanceId(task.getProcessInstanceId());  
		        if(infoEntity == null) {
		        	continue;
		        }
		    	TaskEntity taskEntity = new TaskEntity();
		    	taskEntity.setId(task.getId());
		    	taskEntity.setUserName(infoEntity.getName());
		    	taskEntity.setProcessInstanceId(infoEntity.getProcessInstanceId());
		    	taskEntity.setCreateTime(task.getCreateTime());
		    	taskEntities.add(taskEntity);
		    }
	    }else {
	    	return null;
	    }
		return taskEntities;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "reject")
	public void reject(@RequestParam String processInstanceId) {
		
		rejectTaskService.rejectTask(processInstanceId, "usertask17", "不同意");
	}
	

  
 
	@RequestMapping(value ="complete")
	public Object complete() {

		return null;
    }
	
	@RequestMapping(params = "operation")
	public ModelAndView operation(@RequestParam String taskId,@RequestParam String processInstanceId) {
		ModelAndView andView = new ModelAndView();
		andView.addObject("taskId",taskId);
		andView.addObject("processInstanceId",processInstanceId);
		andView.setViewName("com/jeecg/gpnu/leave-operation");
		return andView;
	}
	

  
}