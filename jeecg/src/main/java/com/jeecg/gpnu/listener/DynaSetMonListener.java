package com.jeecg.gpnu.listener;


import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("dynaSetMonListener")
public class DynaSetMonListener implements  TaskListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 7960387497099642910L;
	
	
	@Autowired
	private  SystemService systemService;
	
	// 实现TaskListener中的方法
	public void notify(DelegateTask delegateTask) {
	
			
	}
}
