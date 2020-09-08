$(function(){
	initTable();
	
function initTable(){
    $('#stock_dayprice_list').datagrid({
		url: 'crawler/crawlerCronJob/getList.do',
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
		header:'定时任务',
		frozenColumns:[
		               [
							/*{field:'ROWNUM',title:'序号',width:40,align:'left',halign:'center'},*/  
							{field:'url',title:'任务url',width:400,align:'left',halign:'center'}
		                ]
		               ],
		columns:[
		         [       
		          {field:'isTimed',title:'是否定时',width:60,align:'center',halign:'center'},
		          {field:'state',title:'任务状态',width:60,align:'center',halign:'center'},
		          
		          {field:'isget',title:'请求方式',width:60,align:'center',halign:'center'},
		          {field:'jsoupXML',title:'解析源码类型',width:150,align:'center',halign:'center'},
		          
		          {field:'addTime',title:'添加时间',width:130,align:'center',halign:'center'},
		          {field:'updateTime',title:'修改时间',width:130,align:'center',halign:'center'},
		          
		          {field:'intervalTime',title:'间隔时间(分钟)',width:100,align:'center',halign:'center'},
		          {field:'executeTime',title:'定时执行时间',width:130,align:'center',halign:'center'},
		          
		          {field:'tname',title:'任务名称',width:200,align:'center',halign:'center'},
		          {field:'pid',title:'来源任务id',width:100,align:'left',halign:'center'}
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

