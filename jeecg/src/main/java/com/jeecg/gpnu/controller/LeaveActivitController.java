package com.jeecg.gpnu.controller;

import static org.hamcrest.CoreMatchers.nullValue;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.jeecgframework.core.common.dao.impl.CommonDao;
import org.jeecgframework.core.util.FileUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jeecg.gpnu.entity.LeaveInfoEntity;
import com.jeecg.gpnu.entity.Message;
import com.jeecg.gpnu.entity.Msg;
import com.jeecg.gpnu.entity.OpertionEntity;
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

	@Autowired
	private HistoryService historyService;

	@Autowired
	private RepositoryService repositoryService;

	/**
	 * 启动请假流程
	 */

	@RequestMapping(params = "task")
	public String leaveManger() {

		return "com/jeecg/gpnu/taskList";
	}

	@RequestMapping(params = "leaveApply")
	public ModelAndView leaveApply() {
		TSUser tsUser = ResourceUtil.getSessionUser();
		List<TSDepart> tsDeparts = leaveActivitService.findDepartListByUserId(tsUser.getId());
		ModelAndView andView = new ModelAndView();
		andView.addObject("tsUser", tsUser);
		andView.addObject("tsDeparts", tsDeparts);
		andView.setViewName("com/jeecg/gpnu/leave-apply");
		return andView;
	}

	@RequestMapping(value = "start")
	@ResponseBody
	public Object startWorkflow(LeaveInfoEntity leave, RedirectAttributes redirectAttributes, HttpSession session) {
		Msg msg = new Msg();
		System.out.println(leave.toString());
		try {
			TSUser user = ResourceUtil.getSessionUser();
			Map<String, Object> variables = new HashMap<String, Object>();
			ProcessInstance processInstance = leaveWorkflowService.startWorkflow(leave, user, variables);
			msg.setSuccess(true);
			msg.setMsg("添加成功");
			redirectAttributes.addFlashAttribute("message", "流程已启动，流程ID：" + processInstance.getId());
		} catch (ActivitiException e) {
			if (e.getMessage().indexOf("no processes deployed with key") != -1) {
				logger.warn("没有部署流程!", e);
				redirectAttributes.addFlashAttribute("error", "没有部署请假流程");
			} else {
				logger.error("启动请假流程失败：", e);
				redirectAttributes.addFlashAttribute("error", "系统内部错误！");
			}

			msg.setSuccess(false);
			msg.setMsg("错误提示:服务器异常，请联系管理员");
		} catch (Exception e) {
			logger.error("启动请假流程失败：", e);
			redirectAttributes.addFlashAttribute("error", "系统内部错误！");
			msg.setSuccess(false);
			msg.setMsg("错误提示:服务器异常，请联系管理员");
		}
		return msg;

	}

	public List<LeaveInfoEntity> findTodoTasks(String userId) {

		TSUser user = ResourceUtil.getSessionUser();
		List<LeaveInfoEntity> leaveInfoEntities = new ArrayList<LeaveInfoEntity>();
		List<Task> waittingClaimTasks = taskService.createTaskQuery().taskCandidateUser(user.getId()).list();

		for (Task task : waittingClaimTasks) {
			String processInstanceId = task.getProcessInstanceId();
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
					.processInstanceId(processInstanceId).singleResult();
			String businessKey = processInstance.getBusinessKey();
			String busnessKey = processInstance.getBusinessKey(); // 获取启动流程时的业务key
			LeaveInfoEntity leaveInfoEntity = leaveActivitService.get(businessKey);
			leaveInfoEntity.setTask(task);
			leaveInfoEntities.add(leaveInfoEntity);
		}

		return leaveInfoEntities;
	}

	@ResponseBody
	@RequestMapping(value = "completeByStudent")
	public Object completeByStudent(@RequestParam String taskId, @RequestParam String processInstanceId) {
		TSUser tsUser = ResourceUtil.getSessionUser();
		LeaveInfoEntity leaveInfoEntity = leaveActivitService.findLeaveInfoEntityByProId(processInstanceId);
		if (leaveInfoEntity.getBpmStatus() == "4") {
			leaveActivitService.UpdateComment("", processInstanceId);
			leaveActivitService.UpdateBpmStatus("2", processInstanceId);
		}
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("flag", 3);
		taskService.complete(taskId, variables);
		leaveActivitService.UpdateBpmStatus("2", processInstanceId);
		Message message = new Message();
		message.setMsg("请等待进一步的审核");
		message.setFlag(true);
		return message;
	}

	@ResponseBody
	@RequestMapping(params = "myTaskList")
	public List<TaskEntity> findWaittingTask() {
		TSUser tsUser = ResourceUtil.getSessionUser();
		List<Task> tasks = taskService.createTaskQuery().taskAssignee(tsUser.getId()).list();
		List<TaskEntity> taskEntities = new ArrayList<TaskEntity>();
		if (tasks.size() > 0) {
			for (Task task : tasks) {
				LeaveInfoEntity infoEntity = leaveActivitService
						.findLeaveInfoEntityByProId(task.getProcessInstanceId());
				if (infoEntity == null) {
					continue;
				}
				TaskEntity taskEntity = new TaskEntity();
				taskEntity.setId(infoEntity.getId());
				taskEntity.setTaskId(task.getId());
				taskEntity.setUserid(infoEntity.getUserid());
				taskEntity.setUserName(infoEntity.getName());
				taskEntity.setProcessInstanceId(infoEntity.getProcessInstanceId());
				taskEntity.setCreateTime(task.getCreateTime());
				taskEntity.setBpmStatus(infoEntity.getBpmStatus());
				taskEntity.setComment(infoEntity.getInstructorComment());
				taskEntities.add(taskEntity);
			}
		}
		System.out.println(taskEntities.size());
		return taskEntities;

	}

	@ResponseBody
	@RequestMapping(value = "reject")
	public void reject(@RequestParam String processInstanceId) {

		rejectTaskService.rejectTask(processInstanceId, "usertask17", "不同意");
	}

	@RequestMapping(value = "complete")
	@ResponseBody
	public Object complete(OpertionEntity opertionEntity) {
		TSUser tsUser = ResourceUtil.getSessionUser();
		Msg msg = new Msg();
		switch (opertionEntity.getOperation()) {
		case "agree":
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("flag", 3);
			LeaveInfoEntity leaveInfoEntity = leaveActivitService
					.findLeaveInfoEntityByProId(opertionEntity.getProcessInstanceId());
			if (leaveInfoEntity.getBpmStatus() == "5") {
				leaveActivitService.UpdateBpmStatus("3", opertionEntity.getProcessInstanceId());
			}
			taskService.complete(opertionEntity.getTaskId(), variables);
			leaveActivitService.UpdateComment(opertionEntity.getComment(), opertionEntity.getProcessInstanceId());
			leaveActivitService.UpdateConcleLeave(opertionEntity.getCancelLeave(),
					opertionEntity.getProcessInstanceId());
			leaveActivitService.UpdateBpmStatus("5", opertionEntity.getProcessInstanceId());
			msg.setMsg("审核成功");
			msg.setSuccess(true);
			break;
		case "reject":
			rejectTaskService.rejectTask(opertionEntity.getProcessInstanceId(), "usertask17",
					opertionEntity.getComment());
			leaveActivitService.UpdateBpmStatus("4", opertionEntity.getProcessInstanceId());
			leaveActivitService.UpdateComment(opertionEntity.getComment(), opertionEntity.getProcessInstanceId());
			msg.setMsg("审核成功");
			msg.setSuccess(true);
			break;
		case "submit":
			Map<String, Object> var_flag = new HashMap<String, Object>();
			var_flag.put("flag", 4);
			taskService.complete(opertionEntity.getTaskId(), var_flag);
			msg.setMsg("提交成功");
			msg.setSuccess(true);
			break;
		}

		return msg;

	}

	@RequestMapping(params = "operation")
	public ModelAndView operation(@RequestParam String taskId, @RequestParam String processInstanceId) {
		ModelAndView andView = new ModelAndView();
		andView.addObject("taskId", taskId);
		andView.addObject("processInstanceId", processInstanceId);
		andView.setViewName("com/jeecg/gpnu/leave-operation");
		return andView;
	}

	@RequestMapping(params = "readProcessImg")
	public void readProcessImg() throws IOException {

		// 创建仓库服务对对象
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 从仓库中找需要展示的文件
		String deploymentId = "745001";
		List<String> names = repositoryService.getDeploymentResourceNames(deploymentId);
		String imageName = null;
		for (String name : names) {
			if (name.indexOf(".png") >= 0) {
				imageName = name;
			}
			
		}
		if (imageName != null) {
			System.out.println(imageName);
			File f = new File(imageName);
			// 通过部署ID和文件名称得到文件的输入流
			InputStream in = repositoryService.getResourceAsStream(deploymentId, imageName);
			FileUtils.copyInputStreamToFile(in, f);
		}
	}

}