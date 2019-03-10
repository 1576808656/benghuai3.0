package com.benghuai3.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.benghuai3.bean.RoleHeadPic;
import com.benghuai3.bean.RoleInfo;
import com.benghuai3.bean.RoleMenu;
import com.benghuai3.bean.RoleMessage;
import com.benghuai3.service.RoleInfoServiceDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

@Controller
public class RoleInfoAction {
	
	//����·�����ҵ�ǰ��ʾ�Ľ�ɫ
	private String path;
	
	//�ж����л�����һ�����ﻹ����һ������,��Ϊd����id��1
	private String c;
	
	//����id��ѯĿǰ�ж��ٸ�����,Ӧ����ʾ�ĸ�����
	private int id;
	
	private static ApplicationContext context;

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	public String selectRole() {
		RoleInfoServiceDao roleinfo = context.getBean("roleInfoServiceImpl",RoleInfoServiceDao.class);
		RoleInfo role = roleinfo.selectRole(path);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("roleinfo", role);
		roleMessage(roleinfo,role.getId(),vs);
		return "success";
	}
	
	//��ɫ��Ϣ��ȡ
	public void roleMessage(RoleInfoServiceDao roleinfo,int id,ValueStack vs) {
		RoleMessage roleMessage = roleinfo.selectMessageById(id);
		vs.set("rolemessage", roleMessage);
	}
	
	//�л���ɫ��ʾ
	public String change() {
		RoleInfoServiceDao roleinfo = context.getBean("roleInfoServiceImpl",RoleInfoServiceDao.class);
		RoleInfo role = roleinfo.change(c, id,context);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("roleinfo", role);
		roleMessage(roleinfo,role.getId(),vs);
		return "success";
	}
	
	//�����ҳ��ɫͷ��ִ�еĲ���
	public String selectById() {
		RoleInfoServiceDao roleinfo = context.getBean("roleInfoServiceImpl",RoleInfoServiceDao.class);
		RoleInfo role = roleinfo.selectRole(id);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("roleinfo", role);
		roleMessage(roleinfo,role.getId(),vs);
		return "success";
	}
	
	//��ȡ��ɫͷ��
	public String selectRoleHead() {
		RoleInfoServiceDao roleinfo = context.getBean("roleInfoServiceImpl",RoleInfoServiceDao.class);
		List<RoleHeadPic>list = roleinfo.selectHead();
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("rolehead", list);
		System.out.println(list.size());
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("rolehead", list);
		return "success";
	}
	
	//���ҽ�ɫ��ҳ���еĽ�ɫ
	public String selectAllRoles() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		RoleInfoServiceDao roleinfo = context.getBean("roleInfoServiceImpl",RoleInfoServiceDao.class);
		List<RoleMenu>list = roleinfo.selectAllRole();
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("allRolesInfo", list);
		session.setAttribute("allRolesInfo", list);
		return "success";
	}
}
