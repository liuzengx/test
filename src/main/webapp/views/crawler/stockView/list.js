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
								{field:'spj',title:'收盘价',width:100,align:'center',halign:'center',
									formatter:function(val,row,value){
										  var a=row.zdf+"";
						            		if (a.indexOf('-') == -1) {
						            			return '<span style="color:red" >'+row.spj+'</span>';
											}else{
												return '<span style="color:#17A046" >'+row.spj+'</span>';
											}
									  }
								}, 
						        {field:'zdf',title:'涨跌幅',width:100,align:'center',halign:'center',
									formatter:function(val,row,value){
										  var a=row.zdf+"";
						            		if (a.indexOf('-') == -1) {
						            			return '<span style="color:red" >'+row.zdf+'</span>';
											}else{
												return '<span style="color:#17A046" >'+row.zdf+'</span>';
											}
									  }
						        }
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
			          {field:'zljlrje',title:'净额',width:100,align:'center',halign:'center',
			        	  formatter:function(val,row,value){
							  var a=row.zljzb+"";
			            		if (a.indexOf('-') == -1) {
			            			return '<span style="color:red" >'+row.zljlrje+'</span>';
								}else{
									return '<span style="color:#17A046" >'+row.zljlrje+'</span>';
								}
						  }  
			          },
			          {field:'zljzb',title:'净占比',width:100,align:'center',halign:'center',
			        	  formatter:function(val,row,value){
							  var a=row.zljzb+"";
			            		if (a.indexOf('-') == -1) {
			            			return '<span style="color:red" >'+row.zljzb+'</span>';
								}else{
									return '<span style="color:#17A046" >'+row.zljzb+'</span>';
								}
						  }
			          },
			          
			          {field:'cddjlrje',title:'净额',width:100,align:'center',halign:'center',
			        	  formatter:function(val,row,value){
							  var a=row.cddjzb+"";
			            		if (a.indexOf('-') == -1) {
			            			return '<span style="color:red" >'+row.cddjlrje+'</span>';
								}else{
									return '<span style="color:#17A046" >'+row.cddjlrje+'</span>';
								}
						  }   
			          },
			          {field:'cddjzb',title:'净占比',width:100,align:'center',halign:'center',
			        	  formatter:function(val,row,value){
							  var a=row.cddjzb+"";
			            		if (a.indexOf('-') == -1) {
			            			return '<span style="color:red" >'+row.cddjzb+'</span>';
								}else{
									return '<span style="color:#17A046" >'+row.cddjzb+'</span>';
								}
						  }  
			          },
			          
			          {field:'ddjlrje',title:'净额',width:100,align:'center',halign:'center',
			        	  formatter:function(val,row,value){
							  var a=row.ddjzb+"";
			            		if (a.indexOf('-') == -1) {
			            			return '<span style="color:red" >'+row.ddjlrje+'</span>';
								}else{
									return '<span style="color:#17A046" >'+row.ddjlrje+'</span>';
								}
						  }   
			          },
			          {field:'ddjzb',title:'净占比',width:100,align:'center',halign:'center',
			        	  formatter:function(val,row,value){
							  var a=row.ddjzb+"";
			            		if (a.indexOf('-') == -1) {
			            			return '<span style="color:red" >'+row.ddjzb+'</span>';
								}else{
									return '<span style="color:#17A046" >'+row.ddjzb+'</span>';
								}
						  }   
			          },
			          
			          {field:'zdjlrje',title:'净额',width:100,align:'center',halign:'center',
			        	  formatter:function(val,row,value){
							  var a=row.zdjzb+"";
			            		if (a.indexOf('-') == -1) {
			            			return '<span style="color:red" >'+row.zdjlrje+'</span>';
								}else{
									return '<span style="color:#17A046" >'+row.zdjlrje+'</span>';
								}
						  }   
			          },
			          {field:'zdjzb',title:'净占比',width:100,align:'center',halign:'center',
			        	  formatter:function(val,row,value){
							  var a=row.zdjzb+"";
			            		if (a.indexOf('-') == -1) {
			            			return '<span style="color:red" >'+row.zdjzb+'</span>';
								}else{
									return '<span style="color:#17A046" >'+row.zdjzb+'</span>';
								}
						  }   
			          },
			          
			          {field:'xdjlrje',title:'净额',width:100,align:'center',halign:'center',
			        	  formatter:function(val,row,value){
							  var a=row.xdjzb+"";
			            		if (a.indexOf('-') == -1) {
			            			return '<span style="color:red" >'+row.xdjlrje+'</span>';
								}else{
									return '<span style="color:#17A046" >'+row.xdjlrje+'</span>';
								}
						  }  
			          },
			          {field:'xdjzb',title:'净占比',width:100,align:'center',halign:'center',
			        	  formatter:function(val,row,value){
							  var a=row.xdjzb+"";
			            		if (a.indexOf('-') == -1) {
			            			return '<span style="color:red" >'+row.xdjzb+'</span>';
								}else{
									return '<span style="color:#17A046" >'+row.xdjzb+'</span>';
								}
						  }   
			          }
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

