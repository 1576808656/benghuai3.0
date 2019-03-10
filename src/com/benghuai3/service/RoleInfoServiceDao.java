package com.benghuai3.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.benghuai3.bean.GameMessage;
import com.benghuai3.bean.RoleHeadPic;
import com.benghuai3.bean.RoleInfo;
import com.benghuai3.bean.RoleMenu;
import com.benghuai3.bean.RoleMessage;

public interface RoleInfoServiceDao {
	
	//����·�����ҽ�ɫ
	public RoleInfo selectRole(String path);
	
	//����id���ҽ�ɫ
	public RoleInfo selectRole(int id);
	
	//����id���ҽ�ɫ��Ϣ
	public RoleMessage selectMessageById(int id);
	
	//���ҽ�ɫͷ��
	public List<RoleHeadPic>selectHead();
	
	//�������н�ɫ
	public List<RoleMenu>selectAllRole();
	
	//�л���ɫ��ʾ
	public RoleInfo change(String c,int id,ApplicationContext context);
	
	//�ر�session
	public void close(ApplicationContext context);
}
