<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>时间管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/bootstrap.css" rel="stylesheet">
<style>
#nowRound{width:45px;}
.main1{font-size:25px;color:#000;margin:40px auto;padding-left:100px;width:600px;}
.main2{width:600px;margin:30px auto}
.main3{color:#FFF;font-size:24px;margin:0 200px}
.main4{width:420px;float:right;} 
#nowWeek{width:35px;height:30px;}
#input2{width:450px;font-size:18px;border:0px;background:none;height:40px;margin-top:10px;}
.table th{text-align:center;vertical-align:middle;font-size:18px}
</style>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function setNowRound() {
		$.post("admin/setNowRound.action", "nowRound=" + $("#nowRound").val(),
				function(data) {
					alert(data);
				});
	}
	function setNowWeek() {
		$.post("admin/setNowWeek.action", "nowWeek=" + $("#nowWeek").val(),
				function(data) {
					alert(data);
				});
	}
	function leave() {
		$.post("admin/leave.action",$("#leaveForm").serialize(),
				function(data) {
					alert(data);
				});
	}
</script>
<body>
<div class="main1">
<font color="#000000">更改轮次为</font>
&nbsp;
<select id="nowRound">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select>
<a class="btn btn-success" onclick="setNowRound()">提交</a>

&nbsp;<font color="#000000">更改当前周为</font>
<input type="text" id="nowWeek"/>
<a class="btn btn-success" onclick="setNowWeek()">提交</a>
</div>
<div class="main2">
<form id="leaveForm">
<table class="table table-bordered table-hover">
<thead>
<tr bgcolor="#0099FF">
<th colspan="2"><div class="main3">请假</div></th>
</tr>
</thead>
<tr>

<th width="100px">姓名:</th>
<td><input type="text" id="input2" name="memberName"/></td>
</tr>
<tbody>
<tr>
<th>周次：</th>
<td><input type="text" id="input2" name="leaveWeek"/></td>
</tr>
<tr>
<th>星期：</th>
<td><input type="text" id="input2" name="week"/></td>
</tr>
<tr>
<th>第几节：</th>
<td><input type="text" id="input2" name="time"/></td>
</tr>
<tr>
<th>请假理由：</th>
<td><input type="text" id="input2" name="info"/></td>
</tr>
</tbody>
</table>
</form>
</div>
<div class="main4">
<a class="btn btn-primary" onclick="leave()">请假</a>
</div>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
