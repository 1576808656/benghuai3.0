package com.benghuai3.service;

import java.util.List;

import com.benghuai3.bean.GameMessage;

public interface GameMessageServiceDao {
	
	//查找游戏相关资讯
	public List<GameMessage> selectAllGameMessage(int start,int end);
	
	//查找资讯总数
	public int selectTotal();
	

}
