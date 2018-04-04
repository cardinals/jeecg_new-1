package test;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.task.Task;
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
	
	
	//@Test
	public void createTable() {
		
		System.out.println(processEngine);
		processEngine.getRepositoryService().createDeployment()
		                                    .addClasspathResource("deployments/leave_1.bpmn")
		                                    .name("请假流程")
		                                    .deploy();
	}
	
	@Test
	public void findTask() {
		List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskAssignee("蓝伟雄").list();
		for(Task task : tasks) {
			System.out.println("id        "+ task.getId());
			System.out.println("name      "+ task.getName());
			System.out.println("------------------------------------------");
		}
		return ;
	}

}
