package com.benghuai3.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benghuai3.bean.GameMessage;
import com.benghuai3.dao.GameMessageDao;
import com.benghuai3.service.HoutaiServicesDao;

@Service
@Transactional
public class HoutaiServicesDaoImpl implements HoutaiServicesDao {
	
	private static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	@Override
	public List<GameMessage> selectAllRoleMenu() {
		GameMessageDao gameMessage = context.getBean("gameMessageDaoImpl",GameMessageDao.class);
		List<GameMessage> gameinfo = gameMessage.selectAllGameMessage();
		return gameinfo;
	}

	@Override
	public int updateGameMessage(List<GameMessage> list) {
		System.out.println("Ö´ÐÐservice²ã");
		GameMessageDao gameDao = context.getBean("gameMessageDaoImpl",GameMessageDao.class);
		for(int i=0;i<list.size();i++) {
			gameDao.updateGameMessage(list.get(i));
		}
		return 0;
	}
}
