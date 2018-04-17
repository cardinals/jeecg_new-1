package com.jeecg.gpnu.dao.imple;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSRole;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Repository;


import com.jeecg.gpnu.dao.FmsLdapDao;

@Repository
public class FmsLdapDaoImple implements FmsLdapDao {
    
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public String findMonitorById(String applyUserId) {
		// TODO Auto-generated method stub
		String hql = "from TSUser where id=:id"; 
		
		TSUser tsUser = (TSUser) sessionFactory.getCurrentSession().createQuery(hql)
		                                  .setString("id",applyUserId)
		                                  .uniqueResult();
		String roleId =  findRoleIdByRoleName("副班");
		String string = findUserIdByDapartIdAndRoleId(tsUser.getDepartid(), roleId,"副班");
		
		
		return string;
	}
	
	@SuppressWarnings("unchecked")
	private String findRoleIdByRoleName(String string) {
		// TODO Auto-generated method stub
		
		String hql = "From TSRole WHERE roleName=:roleName";
		List<TSRole> tsRoles = sessionFactory.getCurrentSession().createQuery(hql)
				                                                  .setString("roleName", string)
	                                                              .list();
		return tsRoles.get(0).getId();
	}
	

	@SuppressWarnings("unchecked")
	private String findUserIdByDapartIdAndRoleId(String departId, String roleId,String departName) {
		// TODO Auto-generated method stub
		String hql= "From TSRoleUser tu where tu.TSDepart.id =:departId and tu.TSRole.id=:roleId";
		List<TSRoleUser> tsRoles = sessionFactory.getCurrentSession().createQuery(hql)
				                                                 .setString("departId",departId)
				                                                 .setString("roleId",roleId)
				                                                 .list();
		return tsRoles.get(0).getTSUser().getId();
	}

	@Override
	public String findInstructByUserId(String applyUserId) {
		// TODO Auto-generated method stub
		return findLeaderByUserIdAndRoleName(applyUserId,"辅导员","辅导员");
	}
	
	
	private String findLeaderByUserIdAndRoleName(String applyUserId,String roleName,String departName) {
		 String hql = "from TSUser where id=:id"; 
			TSUser tsUser = (TSUser) sessionFactory.getCurrentSession().createQuery(hql)
			                                  .setString("id",applyUserId)
			                                  .uniqueResult();
			System.out.println("tsUser: " + tsUser.getId());
			TSDepart userDepart = getTopParentDeparts(tsUser.getDepartid());
			String hql_depart = "from TSDepart";
			TSDepart temp = null;
			List<TSDepart> tsDeparts = sessionFactory.getCurrentSession().createQuery(hql_depart).list();
			for (TSDepart depart : tsDeparts) {
				if (depart.getTSPDepart() != null) {
					if (depart.getTSPDepart().getId() == userDepart.getId()) {
						if(depart.getDepartname().equals(departName)) {
							temp = depart;
							break;
						}
					}
				}
			}
			
			String roleId = findRoleIdByRoleName(roleName);
			String userId = findUserIdByDapartIdAndRoleId(temp.getId(),roleId,departName);
			return userId;
	}
	
	
	private TSDepart getTopParentDeparts(String partId) {
		// TODO Auto-generated method stub
		List<TSDepart> tsDeparts = new ArrayList<TSDepart>();
		Session session = (Session) sessionFactory.getCurrentSession();
		TSDepart depart = (TSDepart) session.get(TSDepart.class, partId);
		tsDeparts.add(depart);
		while (depart.getTSPDepart() != null) {
			depart = depart.getTSPDepart();
			tsDeparts.add(depart);
		}
		return tsDeparts.get(tsDeparts.size() - 1);
	}

	@Override
	public String findInstitudeById(String applyUserId) {
		// TODO Auto-generated method stub
		
		return findLeaderByUserIdAndRoleName(applyUserId,"领导","学院领导");
	}
	
}
