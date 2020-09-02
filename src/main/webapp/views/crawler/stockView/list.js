$(function(){
	initTable();
	
function initTable(){
    $('#stock_view_list').datagrid({
		url: 'stock/profit/getList.do',
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
							{field:'STOCKNAME',title:'收盘价',width:100,align:'left',halign:'center'}, 
					        {field:'FTYPENAME',title:'涨跌幅',width:100,align:'center',halign:'center'}
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
		          {field:'FAREANAME',title:'净额',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'净占比',width:100,align:'left',halign:'center'},
		          
		          {field:'FAREANAME',title:'净额',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'净占比',width:100,align:'left',halign:'center'},
		          
		          {field:'FAREANAME',title:'净额',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'净占比',width:100,align:'left',halign:'center'},
		          
		          {field:'FAREANAME',title:'净额',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'净占比',width:100,align:'left',halign:'center'},
		          
		          {field:'FAREANAME',title:'净额',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'净占比',width:100,align:'left',halign:'center'}
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

