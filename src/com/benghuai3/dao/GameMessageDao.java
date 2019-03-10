package com.benghuai3.dao;

import java.util.List;

import com.benghuai3.bean.GameMessage;

public interface GameMessageDao {
	//查找游戏资讯
	public List<GameMessage> selectAllGameMessage(int start,int end);
	
	public List<GameMessage> selectAllGameMessage();
	
	//查找新闻总数
	public int selectTotal();
	
	//修改资讯信息
	public int updateGameMessage(GameMessage gameMessage);
}
