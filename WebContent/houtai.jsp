<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>崩坏三后台管理</title>
	<script src="easyui/jquery.min.js"></script>
	<script src="easyui/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<style>
		.shipin{
			width: 400px;
			height: 300px;
			border: 1px solid black;
		}
		#zong{
			position: fixed;
			top: 240px;
			left: 400px;
			display: inline-flex;
			opacity: 0;
		}
		#beijing{
			position: fixed;
			top: 240px;
			left: 400px;
			display: inline-flex;
			opacity: 0;
		}
		.ctrb{
			font-size: 24px;
		}
		#xinwen{
			opacity: 0;
		}
		#juese{
			opacity: 0;
		}
	</style>
</head>
<body class="easyui-layout">
	<div data-options="region: 'north',split:true" style="height: 25%;background-image:url(benghuai3/images/index/bg_1.jpg);
	background-position: 0px -270px">
		<img src="benghuai3/images/index/logo.png" width="270px" height="170px">
		<center style="font-size:30px;margin-top: -90px">崩坏3后台管理系统</center>
	</div>
	<div data-options="region: 'west',title: '网页管理',split:true" style="width: 20%">
		<div class="easyui-accordion">
			<div data-options="title: '首页'">
				<ul class="easyui-tree">
					<li>视频</li>
					<li>背景</li>
				</ul>
			</div>
			<div data-options="title: '资讯'">
				<ul class="easyui-tree">
					<li>资讯信息</li>
				</ul>
			</div>
			<div data-options="title: '介绍'">
				<ul class="easyui-tree">
					<li>角色信息1</li>
					<li>角色信息2</li>
				</ul>
			</div>
			<div data-options="title: '下载'">
				<ul class="easyui-tree">
					<li>图片</li>
					<li>信息</li>
				</ul>
			</div>
		</div>
	</div>
	<div data-options="region: 'center',split:true,fit:true" id="ctr">
		<div id="zong">
			<div>
				<div class='shipin'></div>
				<center class='ctrb'>
					游戏视频
					<br><a href='#' class='easyui-linkbutton' data-options="iconCls: 'icon-reload'">上传</a>
				</center>
			</div>
			<div style='width: 30px;height: 300px'></div>
			<div>
				<div class='shipin'></div>
				<center class='ctrb'>
					动画视频
					<br><a href='#' class='easyui-linkbutton' data-options="iconCls: 'icon-reload'">上传</a>
				</center>
			</div>
		</div>
		<div id="beijing">
			<div>
				<div class='shipin'></div>
				<center class='ctrb'>
					人物
					<br><a href='#' class='easyui-linkbutton' data-options="iconCls: 'icon-reload'">上传</a>
				</center>
			</div>
			<div style='width: 30px;height: 300px'></div>
			<div>
				<div class='shipin'></div>
				<center class='ctrb'>
					背景
					<br><a href='#' class='easyui-linkbutton' data-options="iconCls: 'icon-reload'">上传</a>
				</center>
			</div>
		</div>
		<div class="easyui-panel" data-options="title: '新闻管理'" id="xinwen">
			<table id="zixun"></table>
		</div>
	</div>
	<div id="tt">
		<a href="#" class="easyui-linkbutton" data-options="iconCls: 'icon-save'" onclick="beginEdit()">修改</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls: 'icon-edit'" onclick="endEdit()">保存</a>
	</div>
</body>
<script>
var index=new Array();
var arr=new Array();
var data="";
var updated="";
var updatedjson="";
$(function(){
	$("#zixun").datagrid({striped:true,fitColumns:true,checkOnSelect: false,columns:[
			[{
				field:"check",
				checkbox:true,
			},{
				field: "xuhao",
				title: "序号",
				width: "180px",
				align: "center",
			},{
				field: "tupian",
				title: "图片",
				width: "180px",
				align: "center",
				editor:{
					type: "filebox"
				}
			},{
				field: "biaoti",
				title: "标题",
				width: "180px",
				align: "center",
				editor:{
					type: "text"
				}
			},{
				field: "date",
				title: "发布日期",
				width: "180px",
				align: "center",
				editor:{
					type: "datebox"
				}
			},{
				field: "message",
				title: "信息",
				width: "180px",
				align: "center",
				editor:{
					type: "text"
				}
			},]
		],
		toolbar:"#tt",
	});
	$("#zixun").datagrid({
		onAfterEdit:function(){
		//	if ($('#zixun').datagrid('getChanges','updated').length!=0) {
				updated = $('#zixun').datagrid('getChanges', "updated");
				console.log(updated[0].head);
					
				//}
				$.post("updateaction",{"update":JSON.stringify(updated)});
			}
		
	});
	$(".easyui-tree").tree({
		onClick:function(node){
			if(node.text=="视频"){
				$("#zong").css({opacity: 1});
				$("#ctr div[id]").not($("#zong")).css({opacity: 0});
			}else if(node.text=="背景"){
				$("#beijing").css({opacity: 1});
				$("#ctr div[id]").not($("#beijing")).css({opacity: 0});
			}else if(node.text=="资讯信息"){
				$("#xinwen,#tt").css({opacity: 1});
				$("#zixun").datagrid({striped:true,fitColumns:true,url:"houtaiaction",checkOnSelect: false,columns:[
					[{
						field:"check",
						checkbox:true,
					},{
						field: "id",
						title: "序号",
						width: "180px",
						align: "center",
					},{
						field: "url",
						title: "图片",
						width: "180px",
						align: "center",
						editor:{
							type: "text"
						}
					},{
						field: "head",
						title: "标题",
						width: "180px",
						align: "center",
						editor:{
							type: "text"
						}
					},{
						field: "time",
						title: "发布日期",
						width: "180px",
						align: "center",
						editor:{
							type: "datebox"
						}
					},{
						field: "title",
						title: "信息",
						width: "180px",
						align: "center",
						editor:{
							type: "text"
						}
					},]
				],
				toolbar:"#tt",
			})
				$("#ctr div[id]").not($("#xinwen,#tt")).css({opacity: 0});
			}else if(node.text=="角色信息1"){
				$("#zixun").datagrid({columns:[
					[{
						field: "check",
						checkbox:true,
					},{
						field: "xuhao",
						title: "序号",
						width: "180px",
						align: "center",
					},{
						field: "tupian",
						title: "图片",
						width: "180px",
						align: "center",
						editor:{
							type: "filebox",
						}
					},{
						field: "juese",
						title: "角色名",
						width: "180px",
						align: "center",
						editor:{
							type: "text",
						}
					},]
				],
				data:[
						{xuhao:1,tupian:"images/zixun/gengxin.png",juese:"真炎幸魂"},
						{xuhao:2,tupian:"images/zixun/gengxin.png",juese:"芽衣"},
						{xuhao:3,tupian:"images/zixun/gengxin.png",juese:"真炎幸魂"},
					]
				});
			}else if(node.text=="角色信息2"){
				$("#zixun").datagrid({columns:[
					[{
						field: "check",
						checkbox:true,
					},{
						field: "xuhao",
						title: "序号",
						width: "180px",
						align: "center",
					},{
						field: "tupian",
						title: "图片",
						width: "180px",
						align: "center",
						editor:{
							type: "filebox",
						}
					},{
						field: "juese",
						title: "角色名",
						width: "180px",
						align: "center",
						editor:{
							type: "text",
						}
					},{
						field: "ziliao",
						title: "角色资料",
						width: "180px",
						align: "center",
						editor:{
							type: "text",
						}
					},]
				],
				data:[
						{xuhao:1,tupian:"images/zixun/gengxin.png",juese:"真炎幸魂",ziliao: "lksdjglih"},
						{xuhao:2,tupian:"images/zixun/gengxin.png",juese:"芽衣",ziliao: "lksdjglih"},
						{xuhao:3,tupian:"images/zixun/gengxin.png",juese:"真炎幸魂",ziliao: "lksdjglih"},
					]
				});
			}
		}
	})
});
function beginEdit(){
	arr=$("#zixun").datagrid("getSelections");
	for(var i=0;i<arr.length;i++){
		index[i]=$("#zixun").datagrid("getRowIndex",arr[i]);
		$("#zixun").datagrid("selectRow",index[i])
					.datagrid("beginEdit",index[i]);
	}
}
function endEdit(){
	for(var i=0;i<arr.length;i++){
		index[i]=$("#zixun").datagrid("getRowIndex",arr[i]);
		$("#zixun").datagrid("selectRow",index[i])
					.datagrid("endEdit",index[i]);
	}
	index=[];
	$("#zixun").datagrid("uncheckAll");
}
</script>
</html>