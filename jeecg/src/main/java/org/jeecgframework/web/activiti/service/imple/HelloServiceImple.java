package org.jeecgframework.web.activiti.service.imple;

import org.jeecgframework.web.activiti.dao.HelloDao;
import org.jeecgframework.web.activiti.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImple implements HelloService{
    
	@Autowired
	private HelloDao helloDao;
	
	@Override
	public void SayHello() {
		// TODO Auto-generated method stub
		helloDao.sayHello();
	}

}
