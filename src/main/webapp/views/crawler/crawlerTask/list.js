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
		header:'任务列表',
		columns:[
		         [       
		          {field:'FAREANAME',title:'序号',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'任务url',width:400,align:'left',halign:'center'},
		          
		          {field:'FAREANAME',title:'是否定时',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'任务状态',width:100,align:'left',halign:'center'},
		          
		          {field:'FAREANAME',title:'请求方式',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'页数',width:100,align:'left',halign:'center'},
		          
		          {field:'FAREANAME',title:'添加时间',width:100,align:'left',halign:'center'},
		          {field:'FAREANAME',title:'修改时间',width:100,align:'left',halign:'center'}
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

