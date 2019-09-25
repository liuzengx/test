<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
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
</head>
<body>
	<div>
		<div class="panel-body" style="padding: 10px; height: 20%;">
			<div class="panel panel-default" style="margin-bottom: 10px;">
				<div class="panel-heading">查询条件</div>
				<div class="panel-body">
					<form id="formSearch" class="form-horizontal">
						<div class="form-group" style="margin-top: 5px">
							<label class="control-label col-sm-1"
								for="system_sessionslog_loginName">登录账号</label>
							<div class="col-sm-3">
								<input type="text" class="form-control"
									id="system_sessionslog_loginName">
							</div>
							<label class="control-label col-sm-1"
								for="system_sessionslog_onlineTime">在线时间</label>
							<div class="col-sm-3">
								<input type="text" class="form-control"
									id="system_sessionslog_onlineTime">
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
			<div id="system_sessionslog_toolbar" class="btn-group"
				style="margin-bottom: 6px;">
				<button id="stockProfit_btn_add" type="button"
					class="btn btn-default">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				<button id="stockProfit_btn_edit" type="button"
					class="btn btn-default">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				</button>
				<button id="stockProfit_btn_delete" type="button"
					class="btn btn-default">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button>
			</div>

			<div id="system_abc" style="height: 100%;">
				<table id="system_sessionslog_list"></table>
			</div>

		</div>
	</div>
</body>

<!-- <div id="stockProfit_add_content" style="display: none;">
	<form id="addUserForm" class="form-horizontal" style="padding: 15px">
		<div class="form-group">
			<label for="stockCode" class="col-xs-2 control-label">股票代码:</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="stockCode"
					name="stockCode" placeholder="股票代码">
			</div>
			<label for="stockName" class="col-xs-2 control-label">股票名称:</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="stockName"
					name="stockName" placeholder="股票名称">
			</div>
		</div>
		<div class="form-group">
			<label for="stockCost" class="col-xs-2 control-label">成本单价:</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="stockCost"
					name="stockCost" placeholder="成本单价">
			</div>
			<label for="stockDeal" class="col-xs-2 control-label">成交单价:</label>
			<div class="col-xs-4">
				<input type="password" class="form-control" id="stockDeal"
					name="stockDeal" placeholder="成交单价">
			</div>
		</div>
		<div class="form-group">
			<label for="dealNumber" class="col-xs-2 control-label">数量(股):</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="dealNumber"
					name="dealNumber" placeholder="数量(股)">
			</div>
			<label for="dealDate" class="col-xs-2 control-label">成交日期:</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="dealDate"
					name="dealDate" placeholder="成交日期">
			</div>
		</div>
		<div class="form-group">
			<label for="buyTotal" class="col-xs-2 control-label">买入金额:</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="buyTotal"
					name="buyTotal" placeholder="买入金额">
			</div>
			<label for="sellTotal" class="col-xs-2 control-label">卖出金额:</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="sellTotal"
					name="sellTotal" placeholder="卖出金额">
			</div>
		</div>
		<div class="form-group">
			<label for="stockProfit" class="col-xs-2 control-label">毛利润:</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="stockProfit"
					name="stockProfit" style="cursor: pointer" placeholder="毛利润"
					readonly>
			</div>
			<label for="stockNetProfit" class="col-xs-2 control-label">净利润:</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="stockNetProfit"
					name="stockNetProfit" style="cursor: pointer" placeholder="净利润"
					readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="taxAmount" class="col-xs-2 control-label">税额:</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="taxAmount"
					name="taxAmount" style="cursor: pointer" placeholder="税额" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="FDATARANGENAME" class="col-xs-2 control-label">查阅范围:</label>
			<div class="col-xs-9">
				<input type="text" class="form-control" id="FDATARANGENAME"
					name="FDATARANGENAME" style="cursor: pointer" placeholder="查阅范围"
					readonly>
			</div>
			<div class="col-xs-1">
				<i class="icon iconfont icon-binoculars" id="menuBtn2"
					onclick="showMenu2();return false;"
					style="font-size: 22px; color: #0a6999; margin-left: -0.5em"></i>
			</div>
			<label class="col-xs-2 control-label" id="menuBtn2"
				onclick="showMenu();return false;">选择</label>
		</div>
		<input type="hidden" id="FDEPTCODE" name="FDEPTCODE"> <input
			type="hidden" id="FORGCODE" name="FORGCODE"> <input
			type="hidden" id="FDATARANGE" name="FDATARANGE">
	</form>
	<div style="background: red; height: 38%;">
		<table id="stock_jiaoyi_list" style="height: 100%;"></table>
	</div>
</div> -->
<script
	src="<%=request.getContextPath()%>/views/stock/profit/list.js?v=${v}"></script>
<%-- <script src="<%=request.getContextPath()%>/views/stock/profit/list.js"></script> --%>
<script type="text/javascript">
	
</script>
</html>