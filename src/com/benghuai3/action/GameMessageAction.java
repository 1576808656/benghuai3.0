package com.benghuai3.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.benghuai3.bean.GameMessage;
import com.benghuai3.service.GameMessageServiceDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

@Controller
public class GameMessageAction {
	
	static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	int start;
	int end;
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	//获取游戏资讯
	public String selectAllGameMessage() {
		GameMessageServiceDao gameMessage = context.getBean("gameMessageServiceImpl",GameMessageServiceDao.class);
		start = 1;
		end = 5;
		List<GameMessage>list = gameMessage.selectAllGameMessage(start,end);
		ValueStack vs = ActionContext.getContext().getValueStack();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("start", start);
		session.setAttribute("end", end);
		vs.set("gameMessage", list);
		return "success";
	}
	
	//显示更多游戏资讯
	public String moreMessage() {
		GameMessageServiceDao gameMessage = context.getBean("gameMessageServiceImpl",GameMessageServiceDao.class);
		ValueStack vs = ActionContext.getContext().getValueStack();
		HttpSession session = ServletActionContext.getRequest().getSession();
		start = (Integer) session.getAttribute("start")+5;
		end = (Integer) session.getAttribute("end")+5;
		if(end>gameMessage.selectTotal()) {
			end = gameMessage.selectTotal();
		}
		List<GameMessage>list = gameMessage.selectAllGameMessage(start, end);
		vs.set("gameMessage", list);
		session.setAttribute("start", start);
		session.setAttribute("end", end);
		return "success";
	}
}
