package com.benghuai3.dao;

import java.util.List;

import com.benghuai3.bean.RoleHeadPic;
import com.benghuai3.bean.RoleInfo;

public interface RoleInfoDao {
	//通过路径查找对应角色信息
	public RoleInfo select(String path);
	
	//通过id查找角色对应信息
	public RoleInfo select(int id);
	
	//获取角色的头像
	public List<RoleHeadPic> selectHead();
	
	//关闭session
	public void close();
}
