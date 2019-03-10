package com.benghuai3.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.benghuai3.bean.GameMessage;
import com.benghuai3.bean.RoleHeadPic;
import com.benghuai3.bean.RoleInfo;
import com.benghuai3.bean.RoleMenu;
import com.benghuai3.bean.RoleMessage;

public interface RoleInfoServiceDao {
	
	//根据路径查找角色
	public RoleInfo selectRole(String path);
	
	//根据id查找角色
	public RoleInfo selectRole(int id);
	
	//根据id查找角色信息
	public RoleMessage selectMessageById(int id);
	
	//查找角色头像
	public List<RoleHeadPic>selectHead();
	
	//查找所有角色
	public List<RoleMenu>selectAllRole();
	
	//切换角色显示
	public RoleInfo change(String c,int id,ApplicationContext context);
	
	//关闭session
	public void close(ApplicationContext context);
}
