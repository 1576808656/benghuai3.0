package com.benghuai3.service;

import java.util.List;

import com.benghuai3.bean.GameMessage;

public interface HoutaiServicesDao {
	public List<GameMessage> selectAllRoleMenu();
	
	//�޸�gameMessage
	public int updateGameMessage(List<GameMessage>list);
}
