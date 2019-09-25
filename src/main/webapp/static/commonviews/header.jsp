<%--
  Created by IntelliJ IDEA.
  User: xhc
  Date: 2017/3/29
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>

<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	/*版本号*/
	double version = Math.random();
	request.setAttribute("v",version);
%>

<!--[if lt IE 9]>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/ie/html5shiv.js"></script>
<![endif]-->

<link type="text/css" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
<link type="text/css" href="<%=request.getContextPath()%>/static/bootstrap-table/bootstrap-table.css" rel="stylesheet"/>
<link type="text/css" href="<%=request.getContextPath()%>/static/bootstrap-validator/bootstrapValidator.min.css" rel="stylesheet"/>
<link type="text/css" href="<%=request.getContextPath()%>/static/datepicker/datepicker3.css" rel="stylesheet"/>
<link type="text/css" href="<%=request.getContextPath()%>/static/sidebar/css/sidebar.css" rel="stylesheet"/>
<link type="text/css" href="<%=request.getContextPath()%>/static/ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet"/>
<link type="text/css" href="<%=request.getContextPath()%>/static/font/iconfont.css" rel="stylesheet"/>
<link type="text/css" href="<%=request.getContextPath()%>/static/layer/skin/layer.css" rel="stylesheet"/>
<%-- <link type="text/css" href="<%=request.getContextPath()%>/static/css/index.css" rel="stylesheet"/> --%>
<link type="text/css" href="<%=request.getContextPath()%>/static/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet"/>
<!--[if lt IE 9]>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/ie/respond.min.js"></script>
<![endif]-->
<script src="<%=request.getContextPath()%>/static/utils/sysForm.js"></script>
<script src="<%=request.getContextPath()%>/static/utils/tsUtils.js"></script>

<input id="path" value="<%=request.getContextPath()%>" type="hidden">
<input id="scheme" value="<%=request.getScheme()%>" type="hidden">
<input id="serverName" value="<%=request.getServerName()%>" type="hidden">
<input id="serverPort" value="<%=request.getServerPort()%>" type="hidden">
