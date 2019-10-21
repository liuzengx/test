<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<%-- <jsp:include page="/static/commonviews/header.jsp"/> --%>
<meta name="viewport" content="width=device-width" />
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap/bootstrap.js"></script>
<link href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.css"
	rel="stylesheet" />
<script
	src="<%=request.getContextPath()%>/js/bootstrap/bootstrap-table.js"></script>
<link
	href="<%=request.getContextPath()%>/css/bootstrap/bootstrap-table.css"
	rel="stylesheet" />
<script
	src="<%=request.getContextPath()%>/js/bootstrap/bootstrap-table-zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/js/layer/layer.js"></script>
<jsp:include page="/static/commonviews/header.jsp" />
</head>
<body>

	<div id="system_user_add_content">
		<form id="addUserForm" class="form-horizontal" style="padding: 15px">
			<div class="form-group">
				<label for="FCODE" class="col-xs-2 control-label">用户代码:</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="FCODE" name="FCODE" placeholder="用户代码">
				</div>
				<label for="FNAME" class="col-xs-2 control-label">用户名称:</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="USERNAME" name="USERNAME" placeholder="用户名称">
				</div>
			</div>
			<div class="form-group">
				<label for="FLOGINCODE" class="col-xs-2 control-label">登陆名:</label>
				<div class="col-xs-8">
					<input type="text" class="form-control" id="ACCOUNT" name="ACCOUNT" placeholder="登录名">
				</div>
				<div class="col-xs-2">
					<div class="checkbox">
						<label>
							<input type="checkbox" id="ISSTOP" name="ISSTOP"> 停用
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="FPASSWORD" class="col-xs-2 control-label">用户密码:</label>
				<div class="col-xs-4">
					<input type="password" class="form-control" id="PASSWORD" name="PASSWORD" placeholder="用户密码">
				</div>
				<label for="FCONFIRMPASSWORD" class="col-xs-2 control-label">确认密码:</label>
				<div class="col-xs-4">
					<input type="password" class="form-control" id="FCONFIRMPASSWORD" name="FCONFIRMPASSWORD" placeholder="确认密码">
				</div>
			</div>
			<div class="form-group">
				<label for="FDEPTNAME" class="col-xs-2 control-label">所属机构:</label>
				<div class="col-xs-9">
					<input type="text" class="form-control" id="FDEPTNAME" name="FDEPTNAME" style="cursor: pointer" placeholder="所属机构" readonly>
				</div>
				<div class="col-xs-1">
					<i class="icon iconfont icon-binoculars"  id = "menuBtn"  onclick="showMenu();return false;" style="font-size: 22px;color: #0a6999;margin-left:-0.5em"></i>
				</div>
				<%--<label class="col-xs-2 control-label" id = "menuBtn"  onclick="showMenu();return false;">选择</label>--%>
			</div>
			<div class="form-group">
				<label for="FDATARANGENAME" class="col-xs-2 control-label">查阅范围:</label>
				<div class="col-xs-9">
					<input type="text" class="form-control" id="FDATARANGENAME" name="FDATARANGENAME" style="cursor: pointer" placeholder="查阅范围" readonly>
				</div>
				<div class="col-xs-1">
					<i class="icon iconfont icon-binoculars" id = "menuBtn2"  onclick="showMenu2();return false;" style="font-size: 22px;color: #0a6999;margin-left:-0.5em"></i>
				</div>
			</div>
			<input type="hidden" id="FDEPTCODE" name="FDEPTCODE">
			<input type="hidden" id="FORGCODE" name="FORGCODE">
			<input type="hidden" id="FDATARANGE" name="FDATARANGE">
		</form>
	</div>
	
</body>
<script type="text/javascript">
$(function () {
    
    
});
function callbackdata() {
    var fcode = $("#FCODE").val();
	var username = $("#USERNAME").val();
	var account = $("#ACCOUNT").val();
	var password = $("#PASSWORD").val();
	var fconfirmpassword = $("#FCONFIRMPASSWORD").val();
	var fdeptname = $("#FDEPTNAME").val();
	var fdatarangename = $("#FDATARANGENAME").val();
	var isstop = $("#ISSTOP").val();
	
    var obj = { "fcode": fcode, "username": username,"account": account,"password": password,"fconfirmpassword": fconfirmpassword,"fdeptname": fdeptname,"fdatarangename": fdatarangename,"isstop": isstop};
    return JSON.stringify(obj);
}
</script>
</html>