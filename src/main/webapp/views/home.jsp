<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<%--第三方样式--%>
<link href="<s:url value="/vendors/jquery-easyui/themes/metro-blue/easyui.css" />" rel="stylesheet">
<link href="<s:url value="/vendors/jquery-easyui/themes/icon.css" />" rel="stylesheet">
<link href="<s:url value="/vendors/jquery-easyui/themes/color.css" />" rel="stylesheet">
<link href="<s:url value="/vendors/zTree/css/zTreeStyle/zTreeStyle.css" />" rel="stylesheet">
<%--=============== 第三方脚本库 ===============--%>
<%--jquery--%>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="<s:url value="/vendors/jquery-easyui/jquery.easyui.min.js" />"></script>
<script src="<s:url value="/vendors/jquery-easyui/local/easyui-lang-zh_CN.js" />"></script>
<script src="<s:url value="/vendors/echarts/echarts-all.js" />"></script>

<body style="height: 800px;background-color: #A6F8AC">
	<div style="height:100%;width: 100%">
		<div style="height:50%;">
		  	<div id="map" style="float:left;background-color:#A6F9AC;height:100%;width:50%;">第一个DIV盒子</div> 
			<div style="float:left;background-color:#A6F5AC;height:100%;width:50%;">第二个DIV盒子</div>
		</div>
		<div style="background-color:green;height:50%;">
			<div style="float:left;background-color:#A6F9AC;height:100%;width:50%;">第一个DIV盒子</div> 
			<div style="float:left;background-color:#A6F5AC;height:100%;width:50%;">第二个DIV盒子</div>
		</div>
	</div>
	
	<%--=============== 页面脚本 ===============--%>
	<script src="<s:url value="/views/home.js" />" type="text/javascript"></script>
</body>
</html>