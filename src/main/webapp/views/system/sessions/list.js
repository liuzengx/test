$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
    
});

function kitout(sessionId){
	alert('id为: '+sessionId);
}

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_departments').bootstrapTable({
            url: 'system/sessions/getList.do',
            //toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 10, // 每页的记录行数（*）
			pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
			strictSearch : true,
			showColumns : true, // 是否显示所有的列
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			height : $('#system_abc2').height() - 2, // 表格高度，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "ID", // 每一行的唯一标识，一般为主键列
			showToggle : true, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
            columns: [
                      /*{checkbox: true},*/
					  {
						title: '序号',
		                align: "center",
						formatter: function (value, row, index) {
							//获取每页显示的数量
		                    var pageSize=$('#tb_departments').bootstrapTable('getOptions').pageSize;
		                    //获取当前是第几页
		                    var pageNumber=$('#tb_departments').bootstrapTable('getOptions').pageNumber;
		                    //返回序号，注意index是从0开始的，所以要加上1
		                    return pageSize * (pageNumber - 1) + index + 1;
						}
					  }, 
                      {field: 'sessionId',title: 'sessionId'}, 
                      {field: 'loginName',title: '登录账号'},
                      {field: 'userName',title: '登录名称'},
                      {field: 'hostIp',title: 'ip地址'}, 
                      {field: 'startTime',title: '开始登录时间'}, 
                      {field: 'lastTime',title: '最后登陆时间'},
                      {field: 'sessionId',title: '操作',
                    	  formatter:function(value,row,index){
                    		  return "<a href='#' class='sid' onclick='kitout(\""+value+"\")'>强制退出</a>";
                    	  }
                      }
                     ]
        });
    };
    
    //得到查询的参数
    oTableInit.queryParams = function (params) {
    	debugger
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            departmentname: $("#txt_search_departmentname").val(),
            statu: $("#txt_search_statu").val()
        };
        return temp;
    };
    return oTableInit;
};

var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};