<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>	
<html>
<head>
	<base href="<%=basePath%>">
	<title>学生管理系统 首页</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="CSS/menu.css">
</head>
<body>
	<div id="index_head">
		<span id="head_title"><a href="index.html">计算机科学与技术学院 学生管理平台</a></span>
		<ul id="user">
			<li><img src="#" id="user_logo"></li>
			<li><span id="user_name">管理员</span></li>
		</ul>
	</div>
	<div id="left_bar">
		<div id="stu_manage">
			<div class="father_menu">
				<img src="images/StudentManage.png" class="father_icon">
				<span>学生管理</span>
				<img src="images/arrow.png" class="arrow">
			</div>
			<ul>
		  		<li><img src="images/StuMessageManage.png" class="son_icon"><a class="menuURL" href="admin/manageInfo/1" target="content">信息管理</a></li>
				<li><img src="images/GradeManage.png" class="son_icon"><a class="menuURL" href="#">电子假条</a></li>
				<!-- <li><img src="images/CourseManage.png" class="son_icon"><a class="menuURL" href="#">课程管理</a></li> -->
			</ul>
		</div>
		<div id="news_manage">
			<div class="father_menu">
				<img src="images/news.png" class="father_icon">
				<span>新闻中心</span>
				<img src="images/arrow.png" class="arrow">
			</div>
			<ul>
				<li><img src="images/StuMessageManage.png" class="son_icon"><a class="menuURL" href="#">活动报道</a></li>
				<li><img src="images/GradeManage.png" class="son_icon"><a class="menuURL" href="CompeteMessage.html">竞赛信息</a></li>
				<li><img src="images/CourseManage.png" class="son_icon"><a class="menuURL" href="#">学院风采</a></li>
			</ul>
		</div>
	</div>
	<div id="content">
		<iframe name="content" frameborder="0" width="100%" scrolling="no" height="100%"></iframe>
		
	</div>
<script type="text/javascript" src="JS/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="JS/StuMange.js"></script>
</body>
</html>