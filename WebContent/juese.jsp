<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
    <%@ page import="com.opensymphony.xwork2.ActionContext,com.opensymphony.xwork2.util.ValueStack" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="benghuai3/images/favicon.ico">
	<title>角色介绍 -《崩坏3》-为世界上所有的美好而战</title>
	<script src="jquery/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" href="benghuai3/CSS/benghuai-juese.css">
</head>
<body>

	<s:if test="allRolesInfo==null">
		<script>window.location.href="selectAllRoles"</script>
	</s:if>
	
	<!-- 导航栏 -->
	<div id="main">
		<div id="daohang">
			<a href="index.html"><text><span>首页</span></text></a>
			<a href="zixun.jsp"><text id="zixun"><span>作战资讯</span></text></a>
			<a href="juese.jsp"><text id="jieshao"><span>角色介绍</span></text></a>
			<a href="tese.html"><text id="tese"><span>游戏特色</span></text></a>
			<a href="gushi.html"><text id="bg"><span>故事背景</span></text></a>
			<a href="bizhi.html"><text id="download"><span>壁纸下载</span></text></a>
		</div>
		<!-- 滑动文字 -->
		<div style="height:300px" id="miaoshu">
			<h1 class="iflyfromleft">角色介绍</h1>
			<h2 class="iflyfromleft2">Role Introduction</h2>
			<p class="flyfromleft">
				您将指挥各具特色的少女们进行战斗<br>
				她们有的是擅长远距离战斗的枪手<br>
				有的是身手敏捷的刺客<br>
				也有操纵重型机甲的少女<br>
			</p>
        </div>
        <!-- 27个少女人物图片介绍 -->
        <div id="ziliao">
        <div class="bg"></div>
			<ul id="ziliaoBody">
				<s:iterator value="allRolesInfo" var="info">
					<s:if test="#info.id==26">
						<li class="ctn">
							<a href="selectById?id=<s:property value="#info.id"/>">
								<div>
									<img src="<s:property value="#info.url"/>" width="220px" height="272px">
								</div>
								<div class="name"><s:property value="#info.type"/></div>
							</a>
						</li>
					</s:if>
					<s:elseif test="#info.id==27">
						<li class="ctn2">
							<a href="selectById?id=<s:property value="#info.id"/>">
								<div>
									<img src="<s:property value="#info.url"/>" width="220px" height="272px">
								</div>
								<div class="name"><s:property value="#info.type"/></div>
							</a>
						</li>
					</s:elseif>
					<s:else>
						<li>
							<a href="selectById?id=<s:property value="#info.id"/>">
								<div>
									<img src="<s:property value="#info.url"/>" width="220px" height="272px">
								</div>
								<div class="name"><s:property value="#info.type"/></div>
							</a>
						</li>
					</s:else>
				</s:iterator>
			</ul>
        </div>
        <!-- 尾页 -->
		<table width="1024" height="120">
			<tbody>
				<tr>
					<td style="width: 300px">
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
							<a href="nvwushen/" target="_blank">米哈游用户个人信息及隐私保护政策</a>&nbsp;&nbsp;
							<a href="nvwushen/" target="_blank">交易纠纷处理</a>&nbsp;&nbsp;
							<a href="nvwushen/" target="_blank">家长监护工程</a>&nbsp;&nbsp;
							<a href="nvwushen/" target="_blank">防沉迷系统</a>&nbsp;&nbsp;
		    				<a href="nvwushen/" target="_blank">自律公约</a>
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
								<a href="nvwushen/" target="_blank"><img style="vertical-align: bottom;" src="benghuai3/images/gongan.png"></a> 沪公网安备31010402001116号
							</span>
						</p>
						<span width="100%" class="alls">
		 					2014-2018 All Rights Reserved 米哈游科技（上海） 有限公司版权所有 
			 				<span>
			 					<a href="nvwushen/" style="text-decoration: none;vertical-align: -webkit-baseline-middle;">
								<img src="benghuai3/images/youxidzbq.png" style="width:18px;"></a>
							</span>
							<span>
								<a href="nvwushen/" style="text-decoration: none;vertical-align: -webkit-baseline-middle;">
								<img src="benghuai3/images/wenhuajingying.png" style="width:24px;"></a>
							</span>
							<p style="float:left">地址：上海市徐汇区宜山路700号C4栋5层&nbsp;&nbsp; 电话：86-021-60331122</p>.
							<p style="clear:both"></p>
							<p style="float:left">投诉电话：021-34203135 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;投诉邮箱：tousu@mihoyo.com</p>
							<p style="float:right">
							<a href="nvwushen/" target="_blank" style="position: relative;left: -160px">联系方式</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="nvwushen/" target="_blank" style="position: relative;left: -160px">加入我们</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="nvwushen/" target="_blank" style="position: relative;left: -160px">免责条款</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="nvwushen/" target="_blank" style="position: relative;left: -160px">法律声明</a></p>
						</span>
					</td>
		  		</tr>
			</tbody>
		</table>
	</div>
</body>
<script>
$(function(){

	//文字右滑效果
	$(".iflyfromleft,.iflyfromleft2").animate({marginLeft: 500,opacity: 10},800);
	$(".flyfromleft").animate({marginLeft: 500,opacity: 10},1200);
	$(".bg,table").css({width: $("body").width()});
	//鼠标移上图片边框变色
	$("li").hover(function(){
		$(this).css({borderColor: "#008edf"});
		$("li").not($(this)).css({borderColor: "white"});
	},function(){
		$(this).css({borderColor: "white"});
	});
	//图片大框
	for(var i=0;i<27;i++){
		$("#ziliaoBody li:eq("+i+")").animate({opacity: 1},800,function(){
			$("#ziliaoBody li:eq("+(Number(i)+1)+")").animate({opacity: 1},600);
		})
	}
	//鼠标移上去导航栏变色
	$("text").hover(function(){
		$(this).animate($(this).css({borderColor: "orange"}),"slow");
	},function(){
		$(this).animate($(this).css({borderColor: "#00c3ff"}),"slow");
	});
	//点击播放视频
	$("#game-pv").click(function(){
		window.location.replace("images/index/pv2_2500 (2).mp4");
	});
	//下滑一定高度后标题栏隐藏
	$(window).scroll(function(){
		if($(window).scrollTop()>=280){
			$("#daohang").fadeOut();
		}else if($(window).scrollTop()<=280){
			$("#daohang").fadeIn();
		}
	})
})
</script>
</html>