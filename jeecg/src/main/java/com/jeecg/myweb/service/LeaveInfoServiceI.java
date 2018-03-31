package com.jeecg.myweb.service;
import com.jeecg.myweb.entity.LeaveInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface LeaveInfoServiceI extends CommonService{
	
 	public void delete(LeaveInfoEntity entity) throws Exception;
 	
 	public Serializable save(LeaveInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(LeaveInfoEntity entity) throws Exception;
 	
}
