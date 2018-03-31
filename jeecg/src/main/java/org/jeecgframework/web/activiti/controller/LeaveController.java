package org.jeecgframework.web.activiti.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.web.activiti.entity.Leave;
import org.jeecgframework.web.activiti.service.LeaveService;
import org.jeecgframework.web.activiti.util.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Description: TODO(请假流程控制类)
 * @author liujinghua
 */
@Controller
@RequestMapping("/leaveController")
public class LeaveController extends BaseController{
	
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;

	private static final Logger logger = Logger.getLogger(LeaveController.class);
	
	
}
