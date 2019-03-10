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
	
	//��ȡ������Ѷ��Ϣ����ʾ�ں�̨��ҳ
	public String getAllRoleMenu() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		//JSONObject json = new JSONObject();
		System.out.println("��ȡ����");
		HoutaiServicesDao houtai = context.getBean("houtaiServicesDaoImpl",HoutaiServicesDao.class);
		list = houtai.selectAllRoleMenu();
		String userStr =JSON.toJSONString(list);//ʹ��fastjson������ת����json��ʽ

		PrintWriter writer = ServletActionContext.getResponse().getWriter();

		writer.write(userStr);

		writer.flush();

		writer.close();
		return "success";
	}
	
	//���պ�̨��ҳ���µ����ݲ��������ݿ�
	public String updateAction() {
		//����������
		int first = 0;
		//�һ���������
		int last = 0;
		//��������
		int p = 0;
		List<GameMessage>list = new ArrayList<GameMessage>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String jsonStr = request.getParameter("update");
		System.out.println("��ȡ�ɹ�:"+jsonStr);
		jsonStr = jsonStr.substring(1, jsonStr.length()-1);
		while(last != jsonStr.length()) {
			first = jsonStr.indexOf("{",first);
			last = jsonStr.indexOf("}",last);
			JSONObject jsonobject = JSONObject.fromObject(jsonStr.substring(first,last+1));
			System.out.println("�����:"+jsonobject);
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
	
	//���������Json����
//    public String updateAction() throws IOException{
//    	System.out.println("���뷽��");
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
