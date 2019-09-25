<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/views/system/sessionsLog/list.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-table.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-table.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-table-zh-CN.js"></script>
</head>
<body>
    <div class="panel-body" style="padding-bottom:0px;height: 100px">
        <div class="panel panel-default">
            <div class="panel-heading">查询条件</div>
            <div class="panel-body">
                <form id="formSearch" class="form-horizontal">
                    <div class="form-group" style="margin-top:15px">
                        <label class="control-label col-sm-1" for="system_sessionslog_loginName">登录账号</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="system_sessionslog_loginName">
                        </div>
                        <label class="control-label col-sm-1" for="system_sessionslog_onlineTime">在线时间</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="system_sessionslog_onlineTime">
                        </div>
                        <div class="col-sm-4" style="text-align:left;">
                            <button type="button" style="margin-left:50px" id="" class="btn btn-primary">查询</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>       
	
     <div id="system_sessionslog_toolbar" class="btn-group">
       <!--  <a href='#' >强制退出</a>
            <button id="btn_add" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="btn_edit" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button> -->
      </div>
        <table id="system_sessionslog_list"></table>
    </div>
</body>

</html>