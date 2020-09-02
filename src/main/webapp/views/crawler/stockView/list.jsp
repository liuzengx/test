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
	<table id="stock_view_list" style="width: 100%; height: 100%; float: left;"> 
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
        Date From: <input class="easyui-datebox" style="width:100px">
        To: <input class="easyui-datebox" style="width:100px">
        Language:
        <select class="easyui-combobox" panelHeight="auto" style="width:100px">
            <option value="java">Java</option>
            <option value="c">C</option>
            <option value="basic">Basic</option>
            <option value="perl">Perl</option>
            <option value="python">Python</option>
        </select>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
    </div>
</div>
</div>
<!-- <div style="margin:10px 0;"></div> -->


<div style="height: 100%;">
	<!-- <table id="dg" title="历史资金" style="width:100%;height:70%" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10"> -->
    <!-- <thead>
    <tr>
        <th field="inv" width="80">Inv No</th>
        <th field="date" width="100">Date</th>
        <th field="name" width="80">Name</th>
        <th field="amount" width="80" align="right">Amount</th>
        <th field="price" width="80" align="right">Price</th>
        <th field="cost" width="100" align="right">Cost</th>
        <th field="note" width="110">Note</th>
    </tr>
    </thead>
</table> -->
</div>


<%--=============== 页面脚本 ===============--%>
<script src="<s:url value="/views/crawler/stockView/list.js" />" type="text/javascript"></script>	
<script>
    /*function getData() {
        var rows = [];
        for (var i = 1; i <= 800; i++) {
            var amount = Math.floor(Math.random() * 1000);
            var price = Math.floor(Math.random() * 1000);
            rows.push({
                inv: 'Inv No ' + i,
                date: $.fn.datebox.defaults.formatter(new Date()),
                name: 'Name ' + i,
                amount: amount,
                price: price,
                cost: amount * price,
                note: 'Note ' + i
            });
        }
        return rows;
    }

    function pagerFilter(data) {
        if (typeof data.length == 'number' && typeof data.splice == 'function') {	// is array
            data = {
                total: data.length,
                rows: data
            }
        }
        var dg = $(this);
        var opts = dg.datagrid('options');
        var pager = dg.datagrid('getPager');
        pager.pagination({
            onSelectPage: function (pageNum, pageSize) {
                opts.pageNumber = pageNum;
                opts.pageSize = pageSize;
                pager.pagination('refresh', {
                    pageNumber: pageNum,
                    pageSize: pageSize
                });
                dg.datagrid('loadData', data);
            }
        });
        if (!data.originalRows) {
            data.originalRows = (data.rows);
        }
        var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
        var end = start + parseInt(opts.pageSize);
        data.rows = (data.originalRows.slice(start, end));
        return data;
    }

    $(function () {
        $('#dg').datagrid({loadFilter: pagerFilter}).datagrid('loadData', getData());
    }); */
</script>
</body>
</html>