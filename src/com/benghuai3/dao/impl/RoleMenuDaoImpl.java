package com.benghuai3.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.benghuai3.bean.RoleMenu;
import com.benghuai3.dao.RoleMenuDao;
@Repository
public class RoleMenuDaoImpl implements RoleMenuDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<RoleMenu> selectRoles() {
		List<RoleMenu>rolemenu = new ArrayList<RoleMenu>();
		int n = getHibernateTemplate().find("FROM RoleMenu").size();
		for(int i=0;i<n;i++) {
			rolemenu.add((RoleMenu)getHibernateTemplate().find("FROM RoleMenu").get(i));
		}
		return rolemenu;
	}

}
