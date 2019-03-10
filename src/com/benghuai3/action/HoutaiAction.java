package com.benghuai3.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.benghuai3.bean.GameMessage;
import com.benghuai3.service.HoutaiServicesDao;

import net.sf.json.JSONObject;
@ParentPackage("json-default")
@Controller
public class HoutaiAction {
	
	String[] arr;
	
	private List<GameMessage>list;
	

	public List<GameMessage> getList() {
		return list;
	}
	public void setList(List<GameMessage> list) {
		this.list = list;
	}
	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	public String setData() {
		Map<String, List<GameMessage>> map = new HashMap<String, List<GameMessage>>();
		map.put("houtaidata", list);
		return "setdata";
	}
	
	//获取所有资讯信息并显示在后台网页
	public String getAllRoleMenu() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		//JSONObject json = new JSONObject();
		System.out.println("获取数据");
		HoutaiServicesDao houtai = context.getBean("houtaiServicesDaoImpl",HoutaiServicesDao.class);
		list = houtai.selectAllRoleMenu();
		String userStr =JSON.toJSONString(list);//使用fastjson将数据转换成json格式

		PrintWriter writer = ServletActionContext.getResponse().getWriter();

		writer.write(userStr);

		writer.flush();

		writer.close();
		return "success";
	}
	
	//接收后台网页更新的数据并存入数据库
	public String updateAction() {
		//左花括号索引
		int first = 0;
		//右花括号索引
		int last = 0;
		//数组索引
		int p = 0;
		List<GameMessage>list = new ArrayList<GameMessage>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String jsonStr = request.getParameter("update");
		System.out.println("获取成功:"+jsonStr);
		jsonStr = jsonStr.substring(1, jsonStr.length()-1);
		while(last != jsonStr.length()) {
			first = jsonStr.indexOf("{",first);
			last = jsonStr.indexOf("}",last);
			JSONObject jsonobject = JSONObject.fromObject(jsonStr.substring(first,last+1));
			System.out.println("处理后:"+jsonobject);
			GameMessage gameMessage = (GameMessage) JSONObject.toBean(jsonobject,GameMessage.class);
			list.add(gameMessage);
			System.out.println("bean:"+gameMessage.getHead());
			last+=1;
			first+=1;
		}
		HoutaiServicesDao houtaiService = context.getBean("houtaiServicesDaoImpl",HoutaiServicesDao.class);
		houtaiService.updateGameMessage(list);
		return "success";
	}
	
	//解析请求的Json数据
//    public String updateAction() throws IOException{
//    	System.out.println("进入方法");
//    	HttpServletRequest request = ServletActionContext.getRequest();
//        int contentLength = request.getContentLength();
//        if(contentLength<0){
//            return null;
//        }
//        byte buffer[] = new byte[contentLength];
//        for (int i = 0; i < contentLength;) {
//            int len = request.getInputStream().read(buffer, i, contentLength - i);
//            if (len == -1) {
//                break;
//            }
//            i += len;
//        }
//        String update = new String(buffer,"utf-8");
//		JSONObject jsonobject = new JSONObject();
//		JSONArray updates = jsonobject.getJSONArray(update);
//		System.out.println(updates.get(0));
//        return "success";
//    }
}
