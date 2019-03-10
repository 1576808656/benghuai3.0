package com.benghuai3.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benghuai3.bean.GameMessage;
import com.benghuai3.dao.GameMessageDao;
import com.benghuai3.service.GameMessageServiceDao;

@Service
@Transactional
public class GameMessageServiceImpl implements GameMessageServiceDao {
	
	static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Override
	public List<GameMessage> selectAllGameMessage(int start,int end) {
		context = new ClassPathXmlApplicationContext("beans.xml");
		GameMessageDao gameMessage = context.getBean("gameMessageDaoImpl",GameMessageDao.class);
		List<GameMessage>list = gameMessage.selectAllGameMessage(start,end);
		return list;
	}

	@Override
	public int selectTotal() {
		GameMessageDao gameMessage = context.getBean("gameMessageDaoImpl",GameMessageDao.class);
		return gameMessage.selectTotal();
	}



}
