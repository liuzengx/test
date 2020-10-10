$(function(){
	initTable();
	
	function reloadMyGroupList(){
		var fdateq = $("#stock_dayprice_list_fdate_q").datebox('getValue');
		var fdatez = $("#stock_dayprice_list_fdate_z").datebox('getValue');
		var fcode = $("#stock_dayprice_list_fcode").val();
		var fname = $("#stock_dayprice_list_fname").combobox('getValue');
		console.info("fdateq:"+fdateq+" fdatez:"+fdatez+" fcode:"+fcode+" fname:"+fname);
		//if(fdateq==""||fcode=="")return;
		$('#stock_dayprice_list').datagrid('reload',{
			fdateq: fdateq,
			fdatez:fdatez,
			fcode: fcode,
			fname: fname
		}).datagrid('unselectAll');
	}
	
	function initTable(){
	    $('#stock_dayprice_list').datagrid({
			url: 'crawler/stockDayPrice/getList.do',
			queryParams: {
			},
			method: 'get',
			striped:true,
			pagination:true,
			rownumbers:true,//序号
			pageNmber:1,
	        pageSize: 50,
	        //onDblClickRow : update,
	        pageList: [20, 50,100,200],    // 表格行显示数量选择下拉框内容
			idField:"FID",
			defaultRowContextMenu:true,
			header:'历史资金',
			frozenColumns:[
			               [
								/*{field:'ROWNUM',title:'序号',width:40,align:'left',halign:'center'},*/  
								{field:'fcode',title:'股票代码',width:100,align:'center',halign:'center'},    
								{field:'fname',title:'股票名称',width:100,align:'center',halign:'center',sortable:true},
								{field:'fdate',title:'日期',width:100,align:'center',halign:'center'},
								{field:'spj',title:'收盘价',width:100,align:'center',halign:'center'}
			                ]
			               ],
			columns:[
			         [       
			          {field:'zgj',title:'今日最高',width:100,align:'center',halign:'center'},
			          {field:'zdj',title:'今日最低',width:100,align:'center',halign:'center'},
			          
			          {field:'kpj',title:'开盘价',width:100,align:'center',halign:'center'},
			          {field:'cjl',title:'成交量(手)',width:100,align:'center',halign:'center'},
			          
			          {field:'cje',title:'成交额(元)',width:100,align:'center',halign:'center'},
			          {field:'lb',title:'量比',width:100,align:'center',halign:'center'},
			          
			          {field:'zspj',title:'昨天收盘价',width:100,align:'center',halign:'center'},
			          {field:'syl',title:'市盈率',width:100,align:'center',halign:'center'},
			          
			          {field:'hsl',title:'换手率(%)',width:100,align:'center',halign:'center'},
			          {field:'zde',title:'涨跌额',width:100,align:'center',halign:'center'},
			          
			          {field:'zdf',title:'涨跌幅(%)',width:100,align:'center',halign:'center'},
			          {field:'zf',title:'振幅(%)',width:100,align:'center',halign:'center'}
			      ]],  
			singleSelect:true,
			selectOnCheck:true,
			checkOnSelect:true,
			defaultHeaderContextMenu:true,
			defaultRowContextMenu:true,
			toolbar: '#stock_dayprice_toolbar'
		});
	   
		}
	//查询事件
	$("#stock_dayprice_list_search").click(function(){
		reloadMyGroupList();
	});
	//重置查询条件事件
	$("#stock_dayprice_list_reset").click(function(){
		$("#stock_dayprice_list_fdate_q").datebox('setValue', '');
		$("#stock_dayprice_list_fdate_z").datebox('setValue', '');
		$("#stock_dayprice_list_fcode").val('');
		$("#stock_dayprice_list_fname").combobox('setValue', '');
		reloadMyGroupList();
	});
    
    
});

