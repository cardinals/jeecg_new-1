package org.jeecgframework.web.activiti.util;

import javax.annotation.Resource;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserEntityManagerFactory implements SessionFactory {
    
	private CustomUserEntityManager customUserEntityManager;

    public void setCustomUserEntityManager(CustomUserEntityManager customUserEntityManager) {
        this.customUserEntityManager = customUserEntityManager;
    }

    @Override
    public Class<?> getSessionType() {
        // 返回原始的UserManager类型
        return UserIdentityManager.class;

    }

    @Override
    public Session openSession() {
        // 返回自定义的UserManager实例
        return customUserEntityManager;
    }
}