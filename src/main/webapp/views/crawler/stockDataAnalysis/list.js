$(function(){
	initTable();
	
	function reloadMyGroupList(){
		var fdateq = $("#stock_view_list_fdate_q").datebox('getValue');
		var fdatez = $("#stock_view_list_fdate_z").datebox('getValue');
		var fcode = $("#stock_view_list_fcode").val();
		var fname = $("#stock_view_list_fname").combobox('getValue');
		console.info("fdateq:"+fdateq+" fdatez:"+fdatez+" fcode:"+fcode);
		//if(fdateq==""||fcode=="")return;
		$('#stock_view_list').datagrid('reload',{
			fdateq: fdateq,
			fdatez:fdatez,
			fcode: fcode,
			fname: fname
		}).datagrid('unselectAll');
	}
	
	function initTable(){
	    $('#stock_view_list').datagrid({
			url: 'crawler/stockDataAnalysis/getList.do',
			queryParams: {
			},
			method: 'get',
			striped:true,
			pagination:true,
			rownumbers:true,
			pageNmber:1,
	        pageSize: 50,
	        //onDblClickRow : update,
	        pageList: [20, 50,100,200],    // 表格行显示数量选择下拉框内容
			idField:"FID",
			defaultRowContextMenu:true,
			header:'数据分析',
			frozenColumns:[
			               [
								{field:'fcode',title:'股票代码',width:100,align:'center',halign:'center'},    
								{field:'fname',title:'股票名称',width:100,align:'center',halign:'center',sortable:true},
								{field:'fdate',title:'日期',width:100,align:'center',halign:'center'},
								{field:'kpj',title:'开盘价',width:80,align:'center',halign:'center'}, 
						        {field:'spj',title:'收盘价',width:80,align:'center',halign:'center'}
			                ]
			               ],
			columns:[
			         [
			          {field:'zdf',title:'涨跌幅',width:80,align:'center',halign:'center'},
			          {field:'spkpcj',title:'开盘收盘差价',width:80,align:'right',halign:'center'},
			          
			          {field:'zdj',title:'最低价',width:80,align:'center',halign:'center'},
			          {field:'zgj',title:'最高价',width:80,align:'center',halign:'center'},
			          
			          {field:'zgzjcj',title:'最高最低差价',width:80,align:'right',halign:'center'},
			          {field:'yqgztsy',title:'1千股做T收益',width:100,align:'right',halign:'center'},
			          
			          {field:'wqgztsy',title:'5千股做T收益',width:100,align:'right',halign:'center'},
			          {field:'zjrq',title:'资金日期',width:100,align:'center',halign:'center'},
			          
			          {field:'zljlrje',title:'主力资金净流入',width:100,align:'center',halign:'center'}
			         ]  
			      ],  
			singleSelect:true,
			selectOnCheck:true,
			checkOnSelect:true,
			defaultHeaderContextMenu:true,
			defaultRowContextMenu:true,
			toolbar: '#stock_view_toolbar'
		});
		}
	//查询事件
	$("#stock_view_list_search").click(function(){
		reloadMyGroupList();
	});
	//重置查询条件事件
	$("#stock_view_list_reset").click(function(){
		$("#stock_view_list_fdate_q").datebox('setValue', '');
		$("#stock_view_list_fdate_z").datebox('setValue', ''); 
		$("#stock_view_list_fcode").val('');
		$("#stock_view_list_fname").combobox('setValue', '');
		reloadMyGroupList();
	});
});

