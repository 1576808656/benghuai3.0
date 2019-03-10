package com.benghuai3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.benghuai3.bean.RoleMessage;
import com.benghuai3.dao.RoleMessageDao;

@Repository
public class RoleMessageDaoImpl implements RoleMessageDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public RoleMessage selectMessageById(int id) {
		System.out.println("id–≈œ¢:"+id);
		RoleMessage rolemessage = (RoleMessage)getHibernateTemplate().find("FROM RoleMessage as r WHERE r.roleid.id=?", id).get(0);
		System.out.println();
		return rolemessage;
	}

}
