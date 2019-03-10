package com.benghuai3.dao.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.benghuai3.bean.RoleHeadPic;
import com.benghuai3.bean.RoleInfo;
import com.benghuai3.dao.RoleInfoDao;

@Repository
public class RoleInfoDaoImpl implements RoleInfoDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public RoleInfo select(String path) {
		RoleInfo roleinfo = (RoleInfo)getHibernateTemplate().find("FROM RoleInfo as r WHERE r.pic=?",path).get(0);
		return roleinfo;
	}
	
	//puzzle

	@Override
	public RoleInfo select(int id) {
		RoleInfo roleinfo = (RoleInfo) getHibernateTemplate().find("FROM RoleInfo as r WHERE id=?",id).get(0);
		return roleinfo;
	}
	
	@Override
	public void close() {
		getHibernateTemplate().getSessionFactory().getCurrentSession().close();
	}

	@Override
	public List<RoleHeadPic> selectHead() {
		List<RoleHeadPic>list = (List<RoleHeadPic>) getHibernateTemplate().find("FROM RoleHeadPic");
		return list;
	}

}
