<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="benghuai3/images/favicon.ico">
	<title>作战资讯</title>
	<script src="jquery/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" href="benghuai3/CSS/benghuai-zixun.css">
</head>
<body>
	<s:if test="gameMessage==null">
		<script>window.location.href="allGameMessage"</script>
	</s:if>
	<div id="main">
		<div id="daohang">
			<a href="index.html"><text><span>首页</span></text></a>
			<a href="zixun.jsp"><text id="zixun"><span>作战资讯</span></text></a>
			<a href="juese.jsp"><text id="jieshao"><span>角色介绍</span></text></a>
			<a href="tese.html"><text id="tese"><span>游戏特色</span></text></a>
			<a href="gushi.html"><text id="bg"><span>故事背景</span></text></a>
			<a href="bizhi.html"><text id="download"><span>壁纸下载</span></text></a>
		</div>
		<div id="news">
			<ul id="daohang-news">
				<li class="btm">全部</li>
				<li>新闻</li>
				<li>公告</li>
				<li>活动</li>
				<li>攻略</li>
			</ul>
			<hr class="one">
			<div id="message">
				<ul id="newsBody">
					<s:iterator value="gameMessage" var="message">
						<li>
							<img src="<s:property value="#message.url"/>">
							<h3><s:property value="#message.head"/></h3>
							<div class="time"><br>发布日期：<s:property value="#message.time"/></div>
							<div class="summary"><s:property value="#message.title"/></div>
						</li>
					</s:iterator>
				</ul>
				<img src="benghuai3/images/zixun/top.png" id="returnTop">
				<div id="more-back">
					<s:if test="#session['end']==12">
						<div id="nomore">
							<span id="more-text">没有更多</span>
							<span id="more-text-en">NO MORE INFORMATION</span>
						</div>
					</s:if>
					<s:else>
						<div id="more">
							<span id="more-text">更多新闻</span>
							<span id="more-text-en">GET MORE INFORMATION</span>
						</div>
					</s:else>
				</div>
				<div>
				
				</div>
			</div>
		</div>
		<s:debug/>
		<table width="1024" height="120">
			<tbody>
				<tr>
					<td>
						<img src="benghuai3/images/miHoYo_Games.png" width="180" height="auto" style="padding:0 20px 0 0">
					</td>
						<td style="padding:12px 0">
							<span>
								▍健康游戏忠告：抵制不良游戏，拒绝盗版游戏。注意自我保护，谨防受骗上当。适度游戏益脑，沉迷游戏	伤身。合理安排时间，享受健康生活。
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
							<span>
								沪ICP备14042301号-2 沪网文（2014）0592-182号 文网游备字〔2016〕Ｍ-CSG 1244 号
							</span>
							<div style="height: 5px"></div>
							<span>
								<a href="" target="_blank"><img style="vertical-align: bottom;" src="benghuai3/images/gongan.png"></a> 	沪公网安备31010402001116号
							</span>
							<span width="100%">
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
								<a href="" target="_blank">联系方式</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="" target="_blank">加入我们</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="" target="_blank">免责条款</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="" target="_blank">法律声明</a></p>
							</span>
						</td>
		  			</tr>
				</tbody>
		</table>
	</div>
</body>
<script>
$(function(){
	//导航栏淡入淡出
	$(window).scroll(function(){
		if($(window).scrollTop()>=280){
			$("#daohang").fadeOut();
		}else if($(window).scrollTop()<=280){
			$("#daohang").fadeIn();
		}
	})
	$("#main").css({width: $("body").width()});
	$("#daohang-news li").not($("li:eq(0)")).css({paddingLeft: 24});
	$("#daohang-news li:eq(0)").css({color: "#74dcff"});
	$("#daohang-news li").click(function(){
		$(this).addClass("btm");
		$("#daohang-news li").not($(this)).removeClass("btm");
		$(this).css({color: "#74dcff"});
		$("#daohang-news li").not($(this)).css({color: "white"});
	})
	//导航栏边框颜色改变
	$("text").hover(function(){
		$(this).animate($(this).css({borderColor: "orange"}),"slow");
	},function(){
		$(this).animate($(this).css({borderColor: "#00c3ff"}),"slow");
	});
	//新闻导航栏文字背景改变
	$("#daohang-news li").hover(function(){
		$(this).css({color: "#74dcff"});
		$("#daohang-news li").not($(this+",.btm")).css({color: "white"});
	},function(){
		$("#daohang-news li").not($(".btm")).css({color: "white"});
	});
	$("#newsBody li").hover(function(){
		$(this).find($("img,div,h3")).css({borderColor: "#74dcff",color: "#74dcff"});
		$("#newsBody li").not($(this)).css({color: "white"});
		$("#newsBody li img").not($(this).find($("img"))).css({borderColor: "white"});
	},function(){
		$(this).find($("img,div,h3")).css({borderColor: "white",color: "white"});

	});
	//返回顶部
	$("#returnTop").click(function(){
		$("body").animate({"scrollTop":"0"},1000);
	});
	
// 	//显示更多资讯
	$("#more").click(function(){
		window.location.href="moreMessage";
	});
});
</script>
</html>