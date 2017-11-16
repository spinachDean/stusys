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
	<title>信息管理</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="CSS/StuManage.css">
	<link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css">
</head>
<body>
<div id="frameWork">
	
</div>
<div id="content">
		<div id="top-title">
			<span>学生基本信息管理</span>
			<hr/>
			<input class="list_input" type="text" list="grade" name="" placeholder="年级">
			<datalist id="grade">
				<option value="2014级">
				<option value="2015级">
				<option value="2016级">
				<option value="2017级">
			</datalist>
			<input class="list_input" list="class" name="" placeholder="班级">
			<datalist id="class">
				<option value="1">
				<option value="2">
			</datalist>
			<input class="list_input" list="stuID" name="" placeholder="学号">
			<input class="list_input" list="stuName" name="" placeholder="姓名">
			<input type="button" value="查询" class="find_btn" name="">
		</div>
		<div id="result" class="table-responsive">
			<table class="table table-striped table-hover">
				<tr>
					<th>学号</th><th>姓名</th><th>年级</th><th>专业班级</th><th>联系电话</th><th>查看详情</th>
				</tr>
				<c:forEach items="${info}" var="j">
				<tr>
					<td>${j.id}</td><td>${j.name}</td><td>${j.year}</td><td>${j.clazz}</td><td>${j.phone}</td><td><a href="StuMessageDetails.html"><img src="images/details.png"></a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
</div>

<script type="text/javascript" src="JS/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="JS/load.js"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>