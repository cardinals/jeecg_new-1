package org.jeecgframework.web.activiti.dao.imple;

import org.hibernate.SessionFactory;
import org.jeecgframework.web.activiti.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDaoImple implements HelloDao {
    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.print(sessionFactory);
	}

}
