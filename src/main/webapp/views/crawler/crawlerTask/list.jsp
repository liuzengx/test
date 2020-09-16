<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta name="viewport" content="width=device-width" />
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
    
<jsp:include page="/static/commonviews/header.jsp" />
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
	<table id="crawler_task_list" style="width: 100%; height: 100%; float: left;"> 
	</table> 
	<%--=============== 页面样式 ===============--%>
</div>
<div id="crawler_task_toolbar">
<div id="tb1" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
    	<a title="新增" id="" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    	<a  title="修改" id=""
             class="easyui-linkbutton"
             data-options="iconCls:'icon-edit',plain:true">修改</a>
	     <a  title="查看" id=""
		     class="easyui-linkbutton"
		     data-options="iconCls:'icon-periord',plain:true">查看</a> 
	     <a  title="删除" id=""
             class="easyui-linkbutton"
             data-options="iconCls:'icon-remove',plain:true">删除</a>
		<a id="" title="导出" class="easyui-linkbutton" data-options="iconCls:'icon-export',plain:true">导出</a>
		<a id=""  title="打印" class="easyui-linkbutton"  data-options="iconCls:'icon-print',plain:true">打印</a>
        
        <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true">剪切</a>
    </div>
    <div>
    	<span style="font-size:12px;">添加时间起:</span>
        <input id="crawler_task_list_fdate_q" class="easyui-datebox" style="width:100px">
        <span style="font-size:12px;">到:</span>
        <input id="crawler_task_list_fdate_z" class="easyui-datebox" style="width:100px">
        <span style="font-size:12px;">定时任务:</span>
        <select id="crawler_task_list_isTimed" class="easyui-combobox" panelHeight="auto" style="width:100px">
            <option value="0">否</option>
            <option value="1">是</option>
        </select>
        <span style="font-size:12px;">任务状态:</span>
        <select id="crawler_task_list_state" class="easyui-combobox" panelHeight="auto" style="width:100px">
            <option value="-1">爬取失败</option>
            <option value="0">待爬取</option>
            <option value="1">爬取完成</option>
            <option value="2">爬取中</option>
        </select>
        <span style="font-size:12px;">解析源码类型:</span>
        <input id="crawler_task_list_jsoupXML" class="easyui-text" style="width:100px">
        <a id="crawler_task_list_search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        <a id="crawler_task_list_reset" class="easyui-linkbutton" iconCls="icon-reset">重置</a>
    </div>
</div>
</div>

<%--=============== 页面脚本 ===============--%>
<script src="<s:url value="/views/crawler/crawlerTask/list.js" />" type="text/javascript"></script>	

</body>
</html>