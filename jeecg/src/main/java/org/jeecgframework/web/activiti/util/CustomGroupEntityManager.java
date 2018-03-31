package org.jeecgframework.web.activiti.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.AbstractManager;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.activiti.engine.impl.persistence.entity.GroupIdentityManager;
import org.springframework.stereotype.Service;

@Service
public class CustomGroupEntityManager  extends GroupEntityManager {
	
	

	public CustomGroupEntityManager() {
		// TODO Auto-generated constructor stub
		System.out.println("---------------------注入");
	}
	

    @Override
    public List<Group> findGroupsByUser(String userId) {
    	 List<Group> groups = new ArrayList<Group>();
         GroupEntity ge = new GroupEntity();
         ge.setId("admin");
         ge.setRevision(1);
         ge.setName("Administrators");
         ge.setType("security-role");
         groups.add(ge);
         return groups;
    }



}
