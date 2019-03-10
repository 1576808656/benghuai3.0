package com.benghuai3.dao;

import java.util.List;

import com.benghuai3.bean.RoleHeadPic;
import com.benghuai3.bean.RoleInfo;

public interface RoleInfoDao {
	//ͨ��·�����Ҷ�Ӧ��ɫ��Ϣ
	public RoleInfo select(String path);
	
	//ͨ��id���ҽ�ɫ��Ӧ��Ϣ
	public RoleInfo select(int id);
	
	//��ȡ��ɫ��ͷ��
	public List<RoleHeadPic> selectHead();
	
	//�ر�session
	public void close();
}
