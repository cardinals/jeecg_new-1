package com.jeecg.gpnu.service.impl;

import java.io.Serializable;
import java.util.List;

import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecg.gpnu.dao.FmsLdapDao;
import com.jeecg.gpnu.service.FmsLdapService;

@Service("fmsLdapServiceImple")
public class FmsLdapServiceImple  implements FmsLdapService ,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1533015751447735749L;

	@Autowired
	private SystemService systemService;
	
	@Autowired
	private FmsLdapDao fmsLdapDao;
	@Override
	public String findMonitorById(String applyUserId) {
		// TODO Auto-generated method stub
		return fmsLdapDao.findMonitorById(applyUserId);
	}
	@Override
	public String findInstructByUserId(String applyUserId) {
		
		System.out.println(applyUserId);
		// TODO Auto-generated method stub
		return fmsLdapDao.findInstructByUserId(applyUserId);
	}
	@Override
	public String findInstitudeById(String applyUserId) {
		// TODO Auto-generated method stub
		return fmsLdapDao.findInstitudeById(applyUserId);
	}


}
