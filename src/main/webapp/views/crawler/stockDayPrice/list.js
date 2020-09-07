$(function(){
	initTable();
	
function initTable(){
    $('#stock_dayprice_list').datagrid({
		//url: 'stock/profit/getList.do',
		queryParams: {
		},
		method: 'get',
		striped:true,
		pagination:true,
		pageNmber:1,
        pageSize: 50,
        //onDblClickRow : update,
        pageList: [20, 50,100,200],    // 表格行显示数量选择下拉框内容
		idField:"FID",
		defaultRowContextMenu:true,
		header:'历史资金',
		frozenColumns:[
		               [
							{field:'ROWNUM',title:'序号',width:40,align:'left',halign:'center'},  
							{field:'FSHOWCODE',title:'股票代码',width:100,align:'left',halign:'center'},    
							{field:'FENTCODE',title:'股票名称',width:100,align:'left',halign:'center',sortable:true},
							{field:'FENTCODE2',title:'日期',width:100,align:'left',halign:'center'},
							{field:'STOCKNAME',title:'收盘价',width:100,align:'left',halign:'center'}
		                ]
		               ],
		columns:[
		         [       
		          {field:'FAREANAME',title:'今日最高',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'今日最低',width:100,align:'left',halign:'center'},
		          
		          {field:'FAREANAME',title:'开盘价',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'成交量(手)',width:100,align:'left',halign:'center'},
		          
		          {field:'FAREANAME',title:'成交额(元)',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'量比',width:100,align:'left',halign:'center'},
		          
		          {field:'FAREANAME',title:'昨天收盘价',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'市盈率',width:100,align:'left',halign:'center'},
		          
		          {field:'FAREANAME',title:'换手率(%)',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'涨跌额',width:100,align:'left',halign:'center'},
		          
		          {field:'FAREANAME',title:'涨跌幅(%)',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'振幅(%)',width:100,align:'left',halign:'center'}
		      ]],  
		singleSelect:true,
		selectOnCheck:true,
		checkOnSelect:true,
		defaultHeaderContextMenu:true,
		defaultRowContextMenu:true,
		toolbar: '#stock_dayprice_toolbar'
	});
   
	}
    
    
});

