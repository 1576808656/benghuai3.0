package com.benghuai3.service;

import java.util.List;

import com.benghuai3.bean.GameMessage;

public interface GameMessageServiceDao {
	
	//������Ϸ�����Ѷ
	public List<GameMessage> selectAllGameMessage(int start,int end);
	
	//������Ѷ����
	public int selectTotal();
	

}
