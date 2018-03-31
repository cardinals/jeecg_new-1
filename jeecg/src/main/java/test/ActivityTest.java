package test;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ActivityTest {
	
	@Autowired
	protected RepositoryService repositoryService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private ProcessEngine processEngine;
	
	
	@Test
	public void createTable() {
		
		System.out.println(processEngine);
		processEngine.getRepositoryService().createDeployment()
		                                    .addClasspathResource("deployments/leave_1.bpmn")
		                                    .name("请假流程")
		                                    .deploy();
	}

}
