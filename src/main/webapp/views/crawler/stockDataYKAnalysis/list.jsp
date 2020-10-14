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
<script src="<s:url value="/vendors/echarts/echarts-all.js" />"></script>
<script src="<s:url value="/vendors/echarts/esl.js" />"></script>
    
<jsp:include page="/static/commonviews/header.jsp" />
</head>
<body>
<div id="stockDataYKAnalysis_bar_echarts" style="width: 50%; height: 50%; float: left;">sd</div>

<div id="stockDataYKAnalysis_line_echarts" style="width: 50%; height: 50%; float: left;">sd</div>

<div class="easyui-layout" data-options="fit:true">
	<table id="stock_view_list" style="width: 100%; height: 50%; float: left;"> 
	</table> 
	<%--=============== 页面样式 ===============--%>
</div>
<div id="stock_view_toolbar">
<div id="tb" style="padding:5px;height:auto">
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
    	<span style="font-size:12px;">日期起:</span>
        <input id="stock_view_list_fdate_q" class="easyui-datebox" style="width:100px">
        <span style="font-size:12px;">到:</span>
        <input id="stock_view_list_fdate_z" class="easyui-datebox" style="width:100px">
        <span style="font-size:12px;">股票代码:</span>
        <input id="stock_view_list_fcode" class="easyui-text" style="width:100px">
        <span style="font-size:12px;">股票名称:</span>
        <select id="stock_view_list_fname" class="easyui-combobox" panelHeight="auto" style="width:100px">
            <option value="美亚柏科">美亚柏科</option>
            <option value="索菲亚">索菲亚</option>
            <option value="青农商行">青农商行</option>
            <option value="中国软件">中国软件</option>
            <option value="五粮液">五粮液</option>
        </select>
        <a id="stock_view_list_search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        <a id="stock_view_list_reset" class="easyui-linkbutton" iconCls="icon-reset">重置</a>
    </div>
</div>
</div>

<%--=============== 页面脚本 ===============--%>
<script src="<s:url value="/views/crawler/stockDataYKAnalysis/list.js" />" type="text/javascript"></script>
<script src="<s:url value="/views/crawler/stockDataYKAnalysis/echartsList.js" />" type="text/javascript"></script>		
<script>
    
</script>
</body>
</html>