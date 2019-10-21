$(function() {
	$('#system_user_list').bootstrapTable(
			{
				url : 'system/userManage/getList.do',
				method : 'get',
				toolbar : '#system_user_toolbar',
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
				height : $('#system_user_div').height() - 2, // 表格高度，如果没有设置height属性，表格自动根据记录条数觉得表格高度
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
								var options = $('#system_user_list')
										.bootstrapTable('getOptions');
								var pageSize = options.pageSize;
								// 获取当前是第几页
								var pageNumber = options.pageNumber;
								// 返回序号，注意index是从0开始的，所以要加上1
								return pageSize * (pageNumber - 1) + index + 1;
							}
						},
	                      {field: 'userName',title: '用户姓名',halign : 'center',align : 'center'}, 
	                      {field: 'account',title: '登录账号'},
	                      {field: 'password',title: '登录密码'},
	                      {field: 'orgCode',title: '部门名称'}, 
	                      {field: 'postCode',title: '岗位名称'},
	                      {field: 'isStop',title: '账号状态'}, 
	                      {field: 'a',title: '创建时间'}
				]
			});

	// 设置查询参数
	function queryParams(params) {
		var param = {

			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			departmentname : $("#system_user_loginName").val(),
			statu : $("#system_user_onlineTime").val()
		}
		return param;
	}

	// 刷新
	function refresh() {
		$('#system_user_list').bootstrapTable('refresh', {
			url : "stock/profit/getList.do",
			silent : true,
			query : {

			}
		});
	}

	//新增弹出一个页面层
	$('#user_btn_add').on('click', function() {
		layer.open({
			type : 2,// 打开当前页面id用1，content:$('#stockProfit_add_content')，打开另一个页面用2，content:“XXX.jsp”
			title : '记录-添加',
			skin : 'layer-window',
			area : [ '800px', '400px' ],
			shadeClose : true, // 点击遮罩关闭
			content : "views/system/userManage/add.jsp",
			btn : [ '添加', '取消' ],
			yes : function(index) {
				var res = window["layui-layer-iframe" + index].callbackdata();
				var obj = JSON.parse(res);
				//var stockCode = obj.stockCode;
				
//				 * var passengerCertificate = obj.Certificate; var
//				 * passengerCertificateNum = obj.CertificateNum; var
//				 * passengerBirthday = obj.Birthday; var passengerSex = obj.Sex;
				 
				// yes:function () {
				postData('add', res);
			}
		});

	});

	// 修改弹出一个页面层
	$('#user_btn_edit').on('click', function() {
		// 获取行数据
		var rows = $("#system_user_list").bootstrapTable('getSelections');
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
	$('#user_btn_delete').on('click', function() {
		// 获取行数据
		var rows = $("#system_user_list").bootstrapTable('getSelections');
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
		url = 'system/userManage/addRecord.do';
	} else if (type == 'edit') {
		url = 'system/userManage/editRecord.do';
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
		dataType: 'json',
		url : 'stock/profit/delRecord.do',
		data : JSON.stringify(jsonFormData),
		//traditional: true,
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