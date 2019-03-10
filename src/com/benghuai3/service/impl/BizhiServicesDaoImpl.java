package com.benghuai3.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benghuai3.bean.Bizhi;
import com.benghuai3.dao.BizhiDao;
import com.benghuai3.service.BizhiServicesDao;

@Service
@Transactional
public class BizhiServicesDaoImpl implements BizhiServicesDao {

	static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	@Override
	public List<Bizhi> selectAllBizhi() {
		BizhiDao bizhi = context.getBean("bizhiDaoImpl",BizhiDao.class);
		List<Bizhi>list = bizhi.selectAllBizhi();
		return list;
	}
	
}
