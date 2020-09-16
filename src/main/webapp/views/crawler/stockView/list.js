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
			url: 'crawler/stockView/getList.do',
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
			header:'历史资金',
			frozenColumns:[
			               [
								/*{field:'ROWNUM',title:'序号',width:40,align:'left',halign:'center'},*/  
								{field:'fcode',title:'股票代码',width:100,align:'center',halign:'center'},    
								{field:'fname',title:'股票名称',width:100,align:'center',halign:'center',sortable:true},
								{field:'fdate',title:'日期',width:100,align:'center',halign:'center'},
								{field:'spj',title:'收盘价',width:100,align:'center',halign:'center'}, 
						        {field:'zdf',title:'涨跌幅',width:100,align:'center',halign:'center'}
			                ]
			               ],
			columns:[
			         [{title:'主力净流入',colspan:2,align:'center',halign:'center'},
			          {title:'超大单净流入',colspan:2,align:'center',halign:'center'},
			          {title:'大单净流入',colspan:2,align:'center',halign:'center'},
			          {title:'中单净流入',colspan:2,align:'center',halign:'center'},
			          {title:'小单净流入',colspan:2,align:'center',halign:'center'}
			         ],
			         [       
			          {field:'zljlrje',title:'净额',width:100,align:'center',halign:'center'},
			          {field:'zljzb',title:'净占比',width:100,align:'center',halign:'center'},
			          
			          {field:'cddjlrje',title:'净额',width:100,align:'center',halign:'center'},
			          {field:'cddjzb',title:'净占比',width:100,align:'center',halign:'center'},
			          
			          {field:'ddjlrje',title:'净额',width:100,align:'center',halign:'center'},
			          {field:'ddjzb',title:'净占比',width:100,align:'center',halign:'center'},
			          
			          {field:'zdjlrje',title:'净额',width:100,align:'center',halign:'center'},
			          {field:'zdjzb',title:'净占比',width:100,align:'center',halign:'center'},
			          
			          {field:'xdjlrje',title:'净额',width:100,align:'center',halign:'center'},
			          {field:'xdjzb',title:'净占比',width:100,align:'center',halign:'center'}
			      ]],  
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

