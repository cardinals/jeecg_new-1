package org.jeecgframework.web.activiti.util;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.db.PersistentObject;
import org.activiti.engine.impl.persistence.AbstractManager;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.apache.commons.lang.xwork.StringUtils;
import org.jeecgframework.core.common.dao.impl.CommonDao;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomUserEntityManager extends UserEntityManager {
    
	
    @Autowired
    private CommonDao commonDao;
    
	private CustomUserManger customUserManager;

    public void setCustomUserManager(CustomUserManger customUserManager) {
        this.customUserManager = customUserManager;
    }
	
    @Override  
    public UserEntity findUserById(String userId) {  
    	  
    	
    	System.out.println("-------------------------------findUserById");
    
          return null;//返回的是activiti的实体类  
    }  
  
    @Override  
    public List<Group> findGroupsByUser(final String userCode) {  
    	 List<Group> groups = new ArrayList<Group>();
         GroupEntity ge = new GroupEntity();
         ge.setId("admin");
         ge.setRevision(1);
         ge.setName("Administrators");
         ge.setType("security-role");
         groups.add(ge);
         return groups;
  
    }
    
    @Override
    public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId, String key) {
    	// TODO Auto-generated method stub
    	System.out.println("dddddddddddddddddddd");
    	return super.findUserInfoByUserIdAndKey(userId, key);
    }

}