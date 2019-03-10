package com.benghuai3.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.benghuai3.bean.GameMessage;
import com.benghuai3.dao.GameMessageDao;

@Repository
public class GameMessageDaoImpl implements GameMessageDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<GameMessage> selectAllGameMessage(int start,int end) {
		List<GameMessage>list = new ArrayList<GameMessage>();
		int j = 5;
		if(end-start<4) {
			j=end-start+1;
		}
		for(int i=0;i<j;i++) {
			list.add((GameMessage)getHibernateTemplate().find("FROM GameMessage WHERE id>=? AND id<=?",start,end).get(i));
		}
		return list;
	}
	
	@Override
	public List<GameMessage> selectAllGameMessage() {
		List<GameMessage>list = new ArrayList<GameMessage>();

		for(int i=0;i<getHibernateTemplate().find("FROM GameMessage").size();i++) {
			list.add((GameMessage)getHibernateTemplate().find("FROM GameMessage").get(i));
		}
		return list;
	}

	@Override
	public int selectTotal() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("FROM GameMessage").size();
	}

	@Override
	public int updateGameMessage(GameMessage gameMessage) {
		System.out.println("Ö´ÐÐdao²ã");
		System.out.println("dao:"+gameMessage.getHead());
		getHibernateTemplate().update(gameMessage);
		getHibernateTemplate().flush();
		return 0;
	}

}
