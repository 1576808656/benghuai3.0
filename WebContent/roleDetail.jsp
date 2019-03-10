<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="jquery/jquery-3.2.1.min.js"></script>
	<link rel="shortcut icon" href="benghuai3/images/favicon.ico">
	<link rel="stylesheet" href="benghuai3/CSS/yayi.css">
	<title><s:property value="roleinfo.type"/></title>
</head>
<body>
	<s:if test="rolemessage==null">
		<script>window.location.href=""</script>
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
		<div></div>
		<h3 id="english">Raiden</h3><h3 id="english2">Mei</h3>
		<h1 id="title-name"><s:property value="roleinfo.name"/></h1>
		<h2 id="xingxi">角色卡:&nbsp;&nbsp;&nbsp;<s:property value="roleinfo.type"/></h2>
		<div>
			<img src="<s:property value="roleinfo.pic"/>" id="c1">
		</div>
		<div id="catalog">
			<img src="benghuai3/images/jieshao/left_arrow.png" id="lefts">
			<div id="prevs">
				<a href="change?c=d&id=<s:property value="roleinfo.id"/>">
					<div>
						<img src="<s:property value="roleinfo.leftpic"/>">
					</div>
				</a>
			</div>
			<div class="bgi"></div>
			<div class="bgi2"></div>
			<div id="nexts">
				<a href="change?c=a&id=<s:property value="roleinfo.id"/>">
					<div>
						<img src="<s:property value="roleinfo.rightpic"/>">
					</div>
				</a>
			</div>
			<img src="benghuai3/images/jieshao/right_arrow.png" id="rights">
		</div>
		<div id="id-card">
			<div id="air">
				<img src="benghuai3/images/jieshao/in_the_air.jpg" alt="">
			</div>
			<ul id="name">
				<li>姓名: <s:property value="roleinfo.name"/></li>
				<li>年龄: <s:property value="roleinfo.age"/></li>
				<li>装甲: <s:property value="roleinfo.type"/></li>
				<li>作战方式: <s:property value="roleinfo.fightType"/></li>
			</ul>
		</div>
	</div>

<s:if test="rolemessage.message1==null">
	<script type="text/javascript">
		$(function(){
 			$(".juese").css({display:"none"});
		})
	</script>
</s:if>

<div class="juese">
	<h1 class="jsjs">角色介绍</h1>
	<h3>Role Introduction</h3>
	<div class="jsk"><s:property value="roleinfo.type"/></div>
	<p class="flyfromright">
		<s:property value="rolemessage.message1"/>
		<br><br><br>
		<s:property value="rolemessage.message2"/>
		<br><br><br>
		<s:property value="rolemessage.message3"/>
		<br><br><br>
		<s:property value="rolemessage.message4"/>
		<br><br><br>
		<s:property value="rolemessage.message5"/>
		<br><br><br>
		<s:property value="rolemessage.message6"/>
	</p>
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
							<a href="/help/privacy/index.jsp" target="_blank">
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
<script>
$(function(){
	$("#title-name,#english,#english2,#xingxi").animate({left: "+=400px",opacity: 10},600);
	$("#english2,#english").css({color: "rgba(255,255,255,0.5)"});
	$("#c1").animate({left: "-=240px",opacity: 10},600);
	$("#prevs").hover(function(){
		$("#prevs,#prevs img").animate({width: "+=8px",height: "+=8px"},300);
	},function(){
		$("#prevs,#prevs img").animate({width: "-=8px",height: "-=8px"},300);
	});
	$("#nexts").hover(function(){
		$("#nexts,#nexts img").animate({width: "+=8px",height: "+=8px"},300);
	},function(){
		$("#nexts,#nexts img").animate({width: "-=8px",height: "-=8px"},300);
	});
	$(".juese").css({width: $("body").width(),height: 1000});
	//导航栏边框颜色改变
	$("text").hover(function(){
		$(this).animate($(this).css({borderColor: "orange"}),"slow");
	},function(){
		$(this).animate($(this).css({borderColor: "#00c3ff"}),"slow");
	});
	$(window).scroll(function(){
		if($(window).scrollTop()>=563){
			$(".jsjs").animate({left: "532px",opacity: 10},600);
			$(".juese h3").animate({left: "550px",opacity: 10},600);
			$(".jsk,.flyfromright").animate({left: "90px",opacity: 10},600);
		}
	});
});
</script>
</html>