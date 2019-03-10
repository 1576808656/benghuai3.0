package com.benghuai3.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.benghuai3.bean.Bizhi;
import com.benghuai3.dao.BizhiDao;

@Repository
public class BizhiDaoImpl implements BizhiDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Bizhi> selectAllBizhi() {
		List<Bizhi>list = new ArrayList<Bizhi>();
		int n = getHibernateTemplate().find("FROM Bizhi").size();
		for(int i=0;i<n;i++) {
			list.add((Bizhi) getHibernateTemplate().find("FROM Bizhi").get(i));
		}
		
		return list;
	}

}
