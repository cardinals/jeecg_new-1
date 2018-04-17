package com.jeecg.gpnu.dao.imple;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.apache.fop.fo.properties.VoiceFamilyMaker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jeecgframework.web.activiti.entity.Leave;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeecg.gpnu.dao.LeaveActivitDao;
import com.jeecg.gpnu.entity.DepartEntity;
import com.jeecg.gpnu.entity.LeaveInfoEntity;



@Repository
public class LeaveActivitDaoImple implements LeaveActivitDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(LeaveInfoEntity leave) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(leave);
	}

	@Override
	public LeaveInfoEntity get(String businessKey) {
		// TODO Auto-generated method stub

		return (LeaveInfoEntity) sessionFactory.getCurrentSession().get(LeaveInfoEntity.class, businessKey);
	}

	@Override
	public List<String> findLeaderByUserName(String name) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public List<String> findLeaderByUserid(String partId) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public LeaveInfoEntity findUseridByProcessInstanceId(String processInstanceId) {
		// TODO Auto-generated method stub
		String hql = "FROM LeaveInfoEntity WHERE processInstanceId=:processInstanceId";
		List<LeaveInfoEntity> leaveInfoEntities = sessionFactory.getCurrentSession().createQuery(hql)
				.setString("processInstanceId", processInstanceId).list();
		
		if(leaveInfoEntities.size() != 0) {
			return leaveInfoEntities.get(0);
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<TSDepart> findDepartListByUserId(String userId) {
		String hql = "FROM TSUser WHERE id=:userId";
		String departName = "";
		List<TSUser> tsUsers = sessionFactory.getCurrentSession().createQuery(hql).setString("userId", userId).list();
		List<TSDepart> tsDeparts = new ArrayList<TSDepart>(4);
		String hql_de = "FROM   TSDepart WHERE id=:departId";
		List<TSDepart> tsDeparts2 = (List<TSDepart>) sessionFactory.getCurrentSession().createQuery(hql_de)
				.setString("departId", tsUsers.get(0).getDepartid()).list();
		TSDepart depart = tsDeparts2.get(0);
		tsDeparts.add(depart);
		while(true) {
			depart = depart.getTSPDepart();
			if(depart == null) {
				break;
			}else {
				tsDeparts.add(depart);
			}						
		}
		return tsDeparts;
	}
	
	@SuppressWarnings("unchecked")
	public TSRoleUser FindRoleByUserId(String userId) {
		String hql = "from TSRoleUser where userid=:userId";
		
		List<TSRoleUser> tsRoleUsers = sessionFactory.getCurrentSession().createQuery(hql)
		                                  .setString("userId", userId)
		                                  .list();
		
		return tsRoleUsers.get(0);
		
	}

}
