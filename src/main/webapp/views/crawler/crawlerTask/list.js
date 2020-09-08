$(function(){
	initTable();
	
function initTable(){
    $('#stock_dayprice_list').datagrid({
		url: 'crawler/crawlerTask/getList.do',
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
		header:'任务列表',
		columns:[
		         [       
		          /*{field:'FAREANAME',title:'序号',width:100,align:'left',halign:'center'},*/
		          {field:'url',title:'任务url',width:500,align:'left',halign:'center'},
		          
		          {field:'isTimed',title:'是否定时',width:60,align:'center',halign:'center'},
		          {field:'state',title:'任务状态',width:60,align:'center',halign:'center'},
		          
		          {field:'isget',title:'请求方式',width:60,align:'center',halign:'center'},
		          {field:'pageNum',title:'页数',width:60,align:'right',halign:'center'},
		          {field:'jsoupXML',title:'解析源码类型',width:150,align:'center',halign:'center'},
		          {field:'addTime',title:'添加时间',width:130,align:'center',halign:'center'
		        	  /*formatter: function (date) {
                          //var pa = /.*\((.*)\)/;   //获取    /Date(时间戳) 括号中的字符串时间戳 的正则表达式
                          //var unixtime = date.match(pa)[1];  //通过正则表达式来获取到时间戳的字符串
		        		  return getTime(date);
                      }*/
		          },
		          {field:'updateTime',title:'修改时间',width:130,align:'center',halign:'center'}
		      ]],  
		singleSelect:true,
		selectOnCheck:true,
		checkOnSelect:true,
		defaultHeaderContextMenu:true,
		defaultRowContextMenu:true,
		toolbar: '#stock_dayprice_toolbar'
	});
   
	}
    //传入的字符串（Unix时间戳）转成我们想要的时间格式
	function getTime(/** timestamp=0 **/) {
	    var ts = arguments[0] || 0;
	    var t, y, m, d, h, i, s;
	    t = ts ? new Date(ts * 1000) : new Date();
	    y = t.getFullYear();
	    m = t.getMonth() + 1;
	    d = t.getDate();
	    h = t.getHours();
	    i = t.getMinutes();
	    s = t.getSeconds();
	    // 可根据需要在这里定义时间格式  
	    return y + '-' + (m < 10 ? '0' + m : m) + '-' + (d < 10 ? '0' + d : d) + ' ' + (h < 10 ? '0' + h : h) + ':' + (i < 10 ? '0' + i : i) + ':' + (s < 10 ? '0' + s : s);
	}
    
});

