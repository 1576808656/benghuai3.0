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
	
	//根据路径查找当前显示的角色
	private String path;
	
	//判断是切换到上一个人物还是下一个人物,若为d，则id减1
	private String c;
	
	//根据id查询目前有多少个人物,应该显示哪个人物
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
	
	//角色信息获取
	public void roleMessage(RoleInfoServiceDao roleinfo,int id,ValueStack vs) {
		RoleMessage roleMessage = roleinfo.selectMessageById(id);
		vs.set("rolemessage", roleMessage);
	}
	
	//切换角色显示
	public String change() {
		RoleInfoServiceDao roleinfo = context.getBean("roleInfoServiceImpl",RoleInfoServiceDao.class);
		RoleInfo role = roleinfo.change(c, id,context);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("roleinfo", role);
		roleMessage(roleinfo,role.getId(),vs);
		return "success";
	}
	
	//点击主页角色头像执行的查找
	public String selectById() {
		RoleInfoServiceDao roleinfo = context.getBean("roleInfoServiceImpl",RoleInfoServiceDao.class);
		RoleInfo role = roleinfo.selectRole(id);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("roleinfo", role);
		roleMessage(roleinfo,role.getId(),vs);
		return "success";
	}
	
	//获取角色头像
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
	
	//查找角色网页所有的角色
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
