package org.jeecgframework.web.activiti.util;

import java.util.List;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.jeecgframework.core.common.dao.impl.CommonDao;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserManger  {
   
	@Autowired
	private CommonDao commonDao;
	
	
	public UserEntity findUserById(String userId) {
		System.out.println("-----------------------findGroupsByUser");
		// TODO Auto-generated method stub
		TSUser tsUser = (TSUser) commonDao.getEntity(TSUser.class,userId);
		UserEntity userEntity = new UserEntity();
		userEntity.setId(tsUser.getId());
		userEntity.setLastName(tsUser.getRealName());
		return userEntity;
	}

	public List<Group> findGroupsByUser(String userId) {
		// TODO Auto-generated method stub
		System.out.println("-----------------------findGroupsByUser");
		return null;
	}

	public Boolean checkPassword(String userId, String password) {
		// TODO Auto-generated method stub
		TSUser tsUser = (TSUser) commonDao.getEntity(TSUser.class, userId);
		String pwd = tsUser.getPassword();
		
		if(pwd.equals(password)){
			return true;
		}
		return false;
	}

}
