package com.jeecg.gpnu.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("dynaSetInstrListener")
public class DynaSetInstrListener implements TaskListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7632569291476198537L;
	
	@Autowired
	private  SystemService systemService;


	@Override
	public void notify(DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		
	}

}
