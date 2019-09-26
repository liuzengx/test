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
	<input type="hidden" id="md5"/>
	<div id="stockProfit_add_content">
	<form id="addUserForm" class="form-horizontal" style="padding: 15px">
		<div class="form-group">
			<label for="" class="col-xs-2 control-label">股票代码:</label>
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
				<input type="text" class="form-control" id="stockDeal"
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
</div>
</body>
<script type="text/javascript">
$(function () {
    
    
});
function callbackdata() {
	var md5 = $("#md5").val();
    var stockCode = $("#stockCode").val();
	var stockName = $("#stockName").val();
	var stockCost = $("#stockCost").val();
	var stockDeal = $("#stockDeal").val();
	var dealNumber = $("#dealNumber").val();
	var dealDate = $("#dealDate").val();
	var buyTotal = $("#buyTotal").val();
	var sellTotal = $("#sellTotal").val();
	
    /* , "Certificate": passengerCertificate, "CertificateNum": passengerCertificateNum, "Birthday": passengerBirthday, "Sex": passengerSex */
    var obj = { "md5": md5,"stockCode": stockCode, "stockName": stockName,"sellTotal": sellTotal,"stockCost": stockCost,"stockDeal": stockDeal,"dealNumber": dealNumber,"dealDate": dealDate,"buyTotal": buyTotal,"sellTotal": sellTotal};
    return JSON.stringify(obj);
}
</script>
</html>