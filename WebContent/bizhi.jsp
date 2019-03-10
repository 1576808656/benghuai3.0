<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="big">
		<span>
			<div id="yuantu">原图</div>
			<div id="close">关闭</div>
		</span>
		<div id="tupian"></div>
	</div>
	<div id="main">
		<div id="daohang">
			<a href="index.html"><text><span>首页</span></text></a>
			<a href="zixun.jsp"><text id="zixun"><span>作战资讯</span></text></a>
			<a href="juese.jsp"><text id="jieshao"><span>角色介绍</span></text></a>
			<a href="tese.html"><text id="tese"><span>游戏特色</span></text></a>
			<a href="gushi.html"><text id="bg"><span>故事背景</span></text></a>
			<a href="bizhi.html"><text id="download"><span>壁纸下载</span></text></a>
		</div>
	</div>
	<div id="bizhi">
		<ul>
			<s:iterator value="bizhi" var="b">
				<li>
					<div class="one">
						<img src="#b.smallpic" alt="">
						<div><s:property value="#b.picname"/></div>
					</div>
					<div class="two">
						<img src="benghuai3/images/bizhi/19.jpg" alt="">
						<div>银狼觉醒</div>
					</div>
				</li>
			</s:iterator>
	
		</ul>
	</div>
		<table width="100%" height="120">
			<tbody>
				<tr>
					<td>
						<img src="benghuai3/images/miHoYo_Games.png" width="180" height="auto" style="position: relative;left: 120px">
					</td>
					<td style="padding:12px 0" class="shengming">
						<span>
							▍健康游戏忠告：抵制不良游戏，拒绝盗版游戏。注意自我保护，谨防受骗上当。适度游戏益脑，沉迷游戏伤身。合理安排时间，享受健康生活。
						</span><br>
						<div style="height: 5px"></div>
						<span>
								▍用户协议： 
							<a href="/help/privacy/index.html" target="_blank">
							    米哈游游戏使用许可及服务协议</a>&nbsp;&nbsp;
							<a href="" target="_blank">米哈游用户个人信息及隐私保护政策</a>&nbsp;&nbsp;
							<a href="" target="_blank">交易纠纷处理</a>&nbsp;&nbsp;
							<a href="" target="_blank">家长监护工程</a>&nbsp;&nbsp;
							<a href="" target="_blank">防沉迷系统</a>&nbsp;&nbsp;
		    				<a href="" target="_blank">自律公约</a>
		    			</span><br>
		    			<div style="height: 5px"></div>
						<span>▍适龄提示： 本游戏适合17岁（含）以上玩家娱乐</span>
						<p>
							<span>
								沪ICP备14042301号-2 沪网文（2014）0592-182号 文网游备字〔2016〕Ｍ-CSG 1244 号
							</span>
						</p>
						<p>
							<span>
								<a href="" target="_blank"><img style="vertical-align: bottom;" src="benghuai3/images/gongan.png"></a> 沪公网安备31010402001116号
							</span>
						</p>
						<span width="100%" class="alls">
		 					2014-2018 All Rights Reserved 米哈游科技（上海） 有限公司版权所有 
			 				<span>
			 					<a href="" style="text-decoration: none;vertical-align: -webkit-baseline-middle;">
								<img src="benghuai3/images/youxidzbq.png" style="width:18px;"></a>
							</span>
							<span>
								<a href="" style="text-decoration: none;vertical-align: -webkit-baseline-middle;">
								<img src="benghuai3/images/wenhuajingying.png" style="width:24px;"></a>
							</span>
							<p style="float:left">地址：上海市徐汇区宜山路700号C4栋5层&nbsp;&nbsp; 电话：86-021-60331122</p>.
							<p style="clear:both"></p>
							<p style="float:left">投诉电话：021-34203135 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;投诉邮箱：tousu@mihoyo.com</p>
							<p style="float:right">
							<a href="" target="_blank" style="position: relative;left: -160px">联系方式</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="" target="_blank" style="position: relative;left: -160px">加入我们</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="" target="_blank" style="position: relative;left: -160px">免责条款</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="" target="_blank" style="position: relative;left: -160px">法律声明</a></p>
						</span>
					</td>
		  		</tr>
			</tbody>
		</table>
</body>
</html>