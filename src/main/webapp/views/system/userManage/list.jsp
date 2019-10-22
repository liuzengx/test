<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<!-- 项目连接地址 ${pageContext.request.contextPath} -->
<!-- 页面参考 https://www.cnblogs.com/landeanfen/p/4976838.html -->
<head>
<%-- <jsp:include page="/static/commonviews/header.jsp"/> --%>
<meta name="viewport" content="width=device-width" />
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap/bootstrap-table.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap/bootstrap.js"></script>
<link href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/css/bootstrap/bootstrap-table.css"
	rel="stylesheet" />
<script
	src="<%=request.getContextPath()%>/js/bootstrap/bootstrap-table-zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/js/layer/layer.js"></script>
<jsp:include page="/static/commonviews/header.jsp" />
<script src="views/system/userManage/list.js"></script>
</head>
<body>
	<div>
		<div class="panel-body" style="padding: 10px; height: 20%;">
			<div class="panel panel-default" style="margin-bottom: 10px;">
				<div class="panel-heading">查询条件</div>
				<div class="panel-body">
					<form id="formSearch" class="form-horizontal">
						<div class="form-group" style="margin-top: 5px">
							<label class="control-label col-sm-1" for="system_user_loginName">登录账号</label>
							<div class="col-sm-3">
								<input type="text" class="form-control"
									id="system_user_loginName">
							</div>
							<label class="control-label col-sm-1"
								for="system_user_onlineTime">在线时间</label>
							<div class="col-sm-3">
								<input type="text" class="form-control"
									id="system_user_onlineTime">
							</div>
							<div class="col-sm-4" style="text-align: left;">
								<button type="button" style="margin-left: 50px" id=""
									class="btn btn-primary">查询</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div style="height: 80%;">
			<div id="system_user_toolbar" class="btn-group"
				style="margin-bottom: 6px;">
				<button id="user_btn_add" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				<button id="user_btn_edit" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				</button>
				<button id="user_btn_delete" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button>
			</div>

			<div id="system_user_div" style="height: 100%;">
				<table id="system_user_list"></table>
			</div>

		</div>
	</div>
</body>

</html>