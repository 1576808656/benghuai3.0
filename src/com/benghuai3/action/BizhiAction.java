package com.benghuai3.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.benghuai3.service.BizhiServicesDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class BizhiAction {
	
	static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	public String selectBizhi() {
		BizhiServicesDao bizhiService = context.getBean("bizhiServicesDaoImpl",BizhiServicesDao.class);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("bizhi", bizhiService.selectAllBizhi());
		return "success";
	}
}
