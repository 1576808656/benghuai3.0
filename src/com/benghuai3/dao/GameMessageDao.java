package com.benghuai3.dao;

import java.util.List;

import com.benghuai3.bean.GameMessage;

public interface GameMessageDao {
	//������Ϸ��Ѷ
	public List<GameMessage> selectAllGameMessage(int start,int end);
	
	public List<GameMessage> selectAllGameMessage();
	
	//������������
	public int selectTotal();
	
	//�޸���Ѷ��Ϣ
	public int updateGameMessage(GameMessage gameMessage);
}
