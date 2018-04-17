package com.jeecg.gpnu.service;

import java.util.List;

public interface FmsLdapService {  
	
	  /**
     * 根據用戶的Id找到上一级的任务的执行者
     * @param applyUserId
     * @return
     */
    public String findMonitorById(String applyUserId);

    /**
     * 根据用户ID查找辅导员
     * @param employee
     * @return
     */
    public String findInstructByUserId(String applyUserId);

    /**
     * 根据用户Id查找二级学院领导
     * @param applyUserId
     * @return
     */
    public String findInstitudeById(String applyUserId);



}
