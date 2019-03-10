package com.benghuai3.dao;

import com.benghuai3.bean.RoleMessage;

public interface RoleMessageDao {
	//根据角色id查找对应角色信息
	public RoleMessage selectMessageById(int id);
}
