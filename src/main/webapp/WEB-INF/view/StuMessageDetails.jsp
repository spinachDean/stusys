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
	<title>信息详情</title>
	<meta charset="utf-8">
	<meta name="description" content="StuMessageDetails">
	<meta name="author" content="yangxinnian">
	<link rel="stylesheet" type="text/css" href="CSS/StuMessageDetails.css">
	<link rel="stylesheet" type="text/css" href="CSS/StuManage.css">
</head>
<body>
<div id="frameWork">
	
</div>
<div id="content">
	<div id="top">
		<span>学生信息详情</span>
		<hr>
	</div>
	<div id="details">
		<table id="details_table">
			<tr>
				<th>姓名</th><td>${detail.name}</td>
				<th>性别</th><td>${detail.sex}</td>
			</tr>
			<tr>
				<th>学号</th><td>${detail.id}</td>
				<th>班级</th><td>${detail.clazz}</td>
			</tr>
			<tr>
				<th>联系方式</th><td>${detail.phone}</td>
				<th>家庭电话</th><td>${detail.homeNumber}</td>
			</tr>
			<tr>
				<th>家庭住址</th><td colspan="3">${detail.address}</td>
			</tr>
			<tr class="table_box">
				<th class="edit_th">所获荣誉
					<div class="edit"><img src="images/edit.png" alt="修改"><span>修改</span></div>
				</th>
				<td colspan="3">${detail.hornor}</td>
			</tr>
			<tr class="table_box">
				<th class="edit_th">活动经历
					<div class="edit"><img src="images/edit.png" alt="修改"><span>修改</span></div>
				</th>
				<td colspan="3">${detail.activity}</td>
			</tr>
		</table>
	</div>
</div>
<div id="edit_modal">
	<div id="modal_content">
		<h1>修改</h1>
		<textarea>
			
		</textarea>
		<input type="button" value="提交修改" name="">
		<img src="images/shutUp_light.png">
	</div>
</div>
<script type="text/javascript" src="JS/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="JS/load.js"></script>
<script type="text/javascript" src="JS/StuMessageDetails.js"></script>
</script>
</body>
</html>