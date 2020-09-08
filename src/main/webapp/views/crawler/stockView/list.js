$(function(){
	initTable();
	
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
});

