package com.benghuai3.service.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benghuai3.bean.GameMessage;
import com.benghuai3.bean.HibernateUtil;
import com.benghuai3.bean.RoleHeadPic;
import com.benghuai3.bean.RoleInfo;
import com.benghuai3.bean.RoleMenu;
import com.benghuai3.bean.RoleMessage;
import com.benghuai3.dao.RoleInfoDao;
import com.benghuai3.dao.RoleMenuDao;
import com.benghuai3.dao.RoleMessageDao;
import com.benghuai3.service.RoleInfoServiceDao;
@Service
@Transactional
public class RoleInfoServiceImpl implements RoleInfoServiceDao {
	
	static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Override
	public RoleInfo selectRole(String path) {
		RoleInfoDao roleinfo = context.getBean("roleInfoDaoImpl",RoleInfoDao.class);
		RoleInfo role = roleinfo.select(path);
		return role;
	}
	
	@Override
	public RoleInfo change(String c,int id,ApplicationContext context) {
		RoleInfoDao roleinfo = context.getBean("roleInfoDaoImpl",RoleInfoDao.class);
		if(id==1) {
			if(c.equals("d")) {
				id=roleMany();
			}else {
				id++;
			}
		}else {
			if(c.equals("d")) {
				id--;
			}else {
				id++;
			}
		}
		if(id>roleMany()) {
			id=1;
		}
		RoleInfo role = roleinfo.select(id);
		return role;
	}
	
	@Override
	public RoleMessage selectMessageById(int id) {
		RoleMessageDao roleMessageDao = context.getBean("roleMessageDaoImpl",RoleMessageDao.class);
		RoleMessage roleMessage = roleMessageDao.selectMessageById(id);
		return roleMessage;
	}

	@Override
	public void close(ApplicationContext context) {
		RoleInfoDao roleinfo = context.getBean("roleInfoDaoImpl",RoleInfoDao.class);
		roleinfo.close();
	}
	
	public int roleMany() {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT * FROM RoleInfo");
		int size = query.list().size();
		session.close();
		return size;
	}

	@Override
	public RoleInfo selectRole(int id) {
		RoleInfoDao roleinfo = context.getBean("roleInfoDaoImpl",RoleInfoDao.class);
		RoleInfo role = roleinfo.select(id);
		return role;
	}

	@Override
	public List<RoleHeadPic> selectHead() {
		RoleInfoDao roleinfo = context.getBean("roleInfoDaoImpl",RoleInfoDao.class);
		List<RoleHeadPic>list = roleinfo.selectHead();
		return list;
	}

	@Override
	public List<RoleMenu> selectAllRole() {
		RoleMenuDao rolemenu = context.getBean("roleMenuDaoImpl",RoleMenuDao.class);
		
		return rolemenu.selectRoles();
	}

}
