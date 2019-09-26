$(function() {
	// 1.初始化Table
	/*
	 * var oTable = new TableInit(); oTable.Init();
	 * 
	 * //2.初始化Button的点击事件 var oButtonInit = new ButtonInit();
	 * oButtonInit.Init();
	 */

	$('#system_sessionslog_list').bootstrapTable(
			{
				url : 'stock/profit/getList.do',
				method : 'get',
				toolbar : '#system_sessionslog_toolbar',
				striped : true, // 是否显示行间隔色
				cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination : true, // 是否显示分页（*）
				sortable : false, // 是否启用排序
				sortOrder : "asc", // 排序方式
				// queryParams: oTableInit.queryParams,//传递参数（*）
				queryParams : queryParams,
				sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
				pageNumber : 1, // 初始化加载第一页，默认第一页
				pageSize : 10, // 每页的记录行数（*）
				pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
				strictSearch : true,
				showColumns : true, // 是否显示所有的列
				showRefresh : true, // 是否显示刷新按钮
				minimumCountColumns : 2, // 最少允许的列数
				clickToSelect : true, // 是否启用点击选中行
				height : $('#system_abc').height() - 2, // 表格高度，如果没有设置height属性，表格自动根据记录条数觉得表格高度
				uniqueId : "ID", // 每一行的唯一标识，一般为主键列
				showToggle : true, // 是否显示详细视图和列表视图的切换按钮
				cardView : false, // 是否显示详细视图
				detailView : false, // 是否显示父子表
				columns : [
						{
							checkbox : true
						},
						{
							title : '序号',
							align : "center",
							formatter : function(value, row, index) {
								// 获取每页显示的数量
								var options = $('#system_sessionslog_list')
										.bootstrapTable('getOptions');
								var pageSize = options.pageSize;
								// 获取当前是第几页
								var pageNumber = options.pageNumber;
								// 返回序号，注意index是从0开始的，所以要加上1
								return pageSize * (pageNumber - 1) + index + 1;
							}
						}, {
							field : 'stockCode',
							title : '股票代码',
							halign : 'center',
							align : 'center'
						}, {
							field : 'stockName',
							title : '股票名称',
							halign : 'center',
							align : 'center'
						}, {
							field : 'buyTotal',
							title : '买入金额',
							halign : 'center',
							align : 'right',
							formatter : function(v, rows, index) {
								if (v != null)
									return v;
							}
						}, {
							field : 'sellTotal',
							title : '卖出金额',
							halign : 'center',
							align : 'right',
							formatter : function(v, rows, index) {
								if (v != null)
									return v;
							}
						}, {
							field : 'dealNumber',
							title : '数量(股)',
							halign : 'center',
							align : 'center'
						}, {
							field : 'dealDate',
							title : '成交日期',
							halign : 'center',
							align : 'center'
						}, {
							field : 'stockProfit',
							title : '毛利润',
							halign : 'center',
							align : 'right',
							formatter : function(v, rows, index) {
								if (v != null)
									return v;
							}
						}, {
							field : 'stockNetProfit',
							title : '净利润',
							halign : 'center',
							align : 'right',
							formatter : function(v, rows, index) {
								if (v != null)
									return v;
							}
						}, {
							field : 'taxAmount',
							title : '税额',
							halign : 'center',
							align : 'right',
							formatter : function(v, rows, index) {
								if (v != null)
									return v;
							}
						},
				/*
				 * {field: 'taxAmount',title: '税额',halign:
				 * 'center',align:'right',formatter:function(v,rows,index){if(v!=null)return
				 * v.toFixed(2);}},
				 */
				]
			});

	// 设置查询参数
	function queryParams(params) {
		var param = {

			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			departmentname : $("#system_sessionslog_loginName").val(),
			statu : $("#system_sessionslog_onlineTime").val()
		}
		return param;
	}

});
// 刷新
function refresh() {
	$('#system_sessionslog_list').bootstrapTable('refresh', {
		url : "stock/profit/getList.do",
		silent : true,
		query : {

		}
	});
}

/*
 * var TableInit = function () { var oTableInit = new Object(); //初始化Table
 * oTableInit.Init = function () {
 * $('#system_sessionslog_list').bootstrapTable({ url:
 * 'stock/profit/getList.do', method: 'get', toolbar:
 * '#system_sessionslog_toolbar', striped: true, //是否显示行间隔色 cache: false,
 * //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） pagination: true, //是否显示分页（*） sortable:
 * false, //是否启用排序 sortOrder: "asc", //排序方式 queryParams:
 * oTableInit.queryParams,//传递参数（*） sidePagination: "server",
 * //分页方式：client客户端分页，server服务端分页（*） pageNumber:1, //初始化加载第一页，默认第一页 pageSize:
 * 10, //每页的记录行数（*） pageList: [10, 25, 50, 100], //可供选择的每页的行数（*） strictSearch:
 * true, showColumns: true, //是否显示所有的列 showRefresh: true, //是否显示刷新按钮
 * minimumCountColumns: 2, //最少允许的列数 clickToSelect: true, //是否启用点击选中行
 * height:$('#system_abc').height()-2, //表格高度，如果没有设置height属性，表格自动根据记录条数觉得表格高度
 * uniqueId: "ID", //每一行的唯一标识，一般为主键列 showToggle:true, //是否显示详细视图和列表视图的切换按钮
 * cardView: false, //是否显示详细视图 detailView: false, //是否显示父子表 columns: [
 * {checkbox: true}, { title: '序号', align: "center", formatter: function (value,
 * row, index) { //获取每页显示的数量 var
 * options=$('#system_sessionslog_list').bootstrapTable('getOptions'); var
 * pageSize=options.pageSize; //获取当前是第几页 var pageNumber=options.pageNumber;
 * //返回序号，注意index是从0开始的，所以要加上1 return pageSize * (pageNumber - 1) + index + 1; } },
 * {field: 'stockCode',title: '股票代码',halign: 'center',align:'center'}, {field:
 * 'stockName',title: '股票名称',halign: 'center',align:'center'}, {field:
 * 'buyTotal',title: '买入金额',halign:
 * 'center',align:'right',formatter:function(v,rows,index){if(v!=null)return
 * v;}}, {field: 'sellTotal',title: '卖出金额',halign:
 * 'center',align:'right',formatter:function(v,rows,index){if(v!=null)return
 * v;}}, {field: 'dealNumber',title: '数量(股)',halign: 'center',align:'center'},
 * {field: 'dealDate',title: '成交日期',halign: 'center',align:'center'}, {field:
 * 'stockProfit',title: '毛利润',halign:
 * 'center',align:'right',formatter:function(v,rows,index){if(v!=null)return
 * v;}}, {field: 'stockNetProfit',title: '净利润',halign:
 * 'center',align:'right',formatter:function(v,rows,index){if(v!=null)return
 * v;}}, {field: 'taxAmount',title: '税额',halign:
 * 'center',align:'right',formatter:function(v,rows,index){if(v!=null)return
 * v;}}, {field: 'taxAmount',title: '税额',halign:
 * 'center',align:'right',formatter:function(v,rows,index){if(v!=null)return
 * v.toFixed(2);}}, ] }); };
 * 
 * //得到查询的参数 oTableInit.queryParams = function (params) {
 * 
 * var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 limit: params.limit,
 * //页面大小 offset: params.offset, //页码 departmentname:
 * $("#system_sessionslog_loginName").val(), statu:
 * $("#system_sessionslog_onlineTime").val() }; return temp; }; return
 * oTableInit; };
 * 
 * var ButtonInit = function () { var oInit = new Object(); var postdata = {};
 * 
 * oInit.Init = function () { //初始化页面上面的按钮事件 };
 * 
 * return oInit; };
 */
// 新增弹出一个页面层
$('#stockProfit_btn_add').on('click', function() {
	layer.open({
		type : 2,// 打开当前页面id用1，content:$('#stockProfit_add_content')，打开另一个页面用2，content:“XXX.jsp”
		title : '记录-添加',
		skin : 'layer-window',
		area : [ '800px', '650px' ],
		shadeClose : true, // 点击遮罩关闭
		content : "views/stock/profit/add.jsp",
		btn : [ '添加', '取消' ],
		yes : function(index) {
			var res = window["layui-layer-iframe" + index].callbackdata();
			var obj = JSON.parse(res);
			var stockCode = obj.stockCode;
			/*
			 * var passengerCertificate = obj.Certificate; var
			 * passengerCertificateNum = obj.CertificateNum; var
			 * passengerBirthday = obj.Birthday; var passengerSex = obj.Sex;
			 */
			// yes:function () {
			postData('add', res);
		}
	});

});

// 修改弹出一个页面层
$('#stockProfit_btn_edit').on('click', function() {
	// 获取行数据
	var rows = $("#system_sessionslog_list").bootstrapTable('getSelections');
	console.log(rows);
	console.log(rows.length);
	if (rows.length < 1 || rows.length > 1) {
		layer.alert('请选择一条数据', {
			icon : 0
		});
		return false;
	}
	// 打开弹框
	layer.open({
		type : 2,// 打开当前页面id用1，content:$('#stockProfit_add_content')，打开另一个页面用2，content:“XXX.jsp”
		title : '记录-修改',
		skin : 'layer-window',
		area : [ '800px', '650px' ],
		shadeClose : true, // 点击遮罩关闭
		content : "views/stock/profit/edit.jsp",
		// 父页面向子页面传值方法
		success : function(dom) {
			let
			$iframeDom = $(dom[0]).find("iframe").eq(0).contents();
			// test为子页面id
			$iframeDom.find("#md5").val(rows[0].md5);
			$iframeDom.find("#stockCode").val(rows[0].stockCode);
			$iframeDom.find("#stockName").val(rows[0].stockName);
			$iframeDom.find("#buyTotal").val(rows[0].buyTotal);
		},
		btn : [ '添加', '取消' ],
		yes : function(index) {
			var res = window["layui-layer-iframe" + index].callbackdata();
			var obj = JSON.parse(res);
			var stockCode = obj.stockCode;

			var passengerCertificate = obj.Certificate;
			var passengerCertificateNum = obj.CertificateNum;
			var passengerBirthday = obj.Birthday;
			var passengerSex = obj.Sex;

			postData('edit', res);
		}
	});
});

// 删除
$('#stockProfit_btn_delete').on('click', function() {
	// 获取行数据
	var rows = $("#system_sessionslog_list").bootstrapTable('getSelections');
	if (rows.length < 1) {
		layer.alert('请选择一条或多条数据进行删除', {
			icon : 0
		});
		return false;
	}
	layer.open({
		content : '您已选择了'+rows.length+'条数据',
		btn : [ '确定', '取消' ],
		yes : function(index, layero) {
			// 按钮【按钮一】的回调
			console.log(rows);
			layer.close(index);
			deldata(rows);
		},
		cancel : function(index, layero) {
			// 右上角关闭回调
			if (confirm('确定要刪除么')) { // 只有当点击confirm框的确定时，该层才会关闭
				layer.close(index);
			}
			return false;
		}
	});
});
/**
 * 提交记录参数
 * 
 * @param type
 */
function postData(type, jsonFormData) {
	var formData = sysForm.getFormData('addUserForm');
	// alert(JSON.stringify(formData));
	var url;
	if (type == 'add') {
		url = 'stock/profit/addRecord.do';
	} else if (type == 'edit') {
		url = 'stock/profit/editRecord.do';
	}

	$.ajax({
		type : 'post',
		url : url,
		data : jsonFormData,
		contentType : 'application/json;charset=utf-8',
		success : function(data) {
			// relist();
			layer.closeAll();
			refresh();
			if (type == 'add') {
				layer.msg('添加成功', {
					time : 1500
				});
			} else {
				layer.msg('修改成功', {
					time : 1500
				});
			}
		},
		error : function(data) {
			layer.closeAll();
			if (type == 'add') {
				layer.msg('添加失败', {
					time : 1500
				});
			} else {
				layer.msg('修改失败', {
					time : 1500
				});
			}
		}
	})
}

// 批量删除数据方法
function deldata(jsonFormData) {
	$.ajax({
		type : 'post',
		url : 'stock/profit/delRecord.do',
		data : jsonFormData,
		contentType : 'application/json;charset=utf-8',
		success : function(data) {
			refresh();
			layer.alert('刪除成功', {
				icon : 1
			});
		},
		error : function(data) {
			layer.alert('刪除失敗', {
				icon : 5
			});
		}
	})
}