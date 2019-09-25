<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/layer/layer.js"></script>
</head>
<body>
	
<h2>创建模态框（Modal）</h2>
<!-- 按钮触发模态框 -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
	开始演示模态框
</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					模态框（Modal）标题
				</h4>
			</div>
			<div class="modal-body">
				在这里添加一些文本
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<div>
	<input type="button" class="btn btn-primary" value="新增频道" 
	       data-toggle="modal" 
	       data-target="#addChannelInfoModal"  href="${pageContext.request.contextPath}/views/stock/profit/add.jsp"/>  
		<!-- 频道信息新增 Modal start -->
	<div class="modal hide fade" id="addChannelInfoModal"  tabindex="-1" role="dialog">
	<div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
	<h3>新增频道信息</h3>
	</div>
	<div class="modal-body"></div>
	</div>
	<!-- 频道信息新增 Modal end -->
</div>

<div id="add-content" style="display: none">
		<form id="addUserForm" class="form-horizontal" style="padding: 15px">
			<div class="form-group">
				<label for="FCODE" class="col-xs-2 control-label">用户代码:</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="FCODE" name="FCODE" placeholder="用户代码">
				</div>
				<label for="FNAME" class="col-xs-2 control-label">用户名称:</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="FNAME" name="FNAME" placeholder="用户名称">
				</div>
			</div>
			<div class="form-group">
				<label for="FLOGINCODE" class="col-xs-2 control-label">登陆名:</label>
				<div class="col-xs-8">
					<input type="text" class="form-control" id="FLOGINCODE" name="FLOGINCODE" placeholder="登录名">
				</div>
				<div class="col-xs-2">
					<div class="checkbox">
						<label>
							<input type="checkbox" id="FISSTOP" name="FISSTOP"> 停用
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="FPASSWORD" class="col-xs-2 control-label">用户密码:</label>
				<div class="col-xs-4">
					<input type="password" class="form-control" id="FPASSWORD" name="FPASSWORD" placeholder="用户密码">
				</div>
				<label for="FCONFIRMPASSWORD" class="col-xs-2 control-label">确认密码:</label>
				<div class="col-xs-4">
					<input type="password" class="form-control" id="FCONFIRMPASSWORD" name="FCONFIRMPASSWORD" placeholder="确认密码">
				</div>
			</div>
			<div class="form-group">
				<label for="FDEPTNAME" class="col-xs-2 control-label">所属机构:</label>
				<div class="col-xs-9">
					<input type="text" class="form-control" id="FDEPTNAME" name="FDEPTNAME" style="cursor: pointer" placeholder="所属机构" readonly>
				</div>
				<div class="col-xs-1">
					<i class="icon iconfont icon-binoculars"  id = "menuBtn"  onclick="showMenu();return false;" style="font-size: 22px;color: #0a6999;margin-left:-0.5em"></i>
				</div>
				<%--<label class="col-xs-2 control-label" id = "menuBtn"  onclick="showMenu();return false;">选择</label>--%>
			</div>
			<div class="form-group">
				<label for="FDATARANGENAME" class="col-xs-2 control-label">查阅范围:</label>
				<div class="col-xs-9">
					<input type="text" class="form-control" id="FDATARANGENAME" name="FDATARANGENAME" style="cursor: pointer" placeholder="查阅范围" readonly>
				</div>
				<div class="col-xs-1">
					<i class="icon iconfont icon-binoculars" id = "menuBtn2"  onclick="showMenu2();return false;" style="font-size: 22px;color: #0a6999;margin-left:-0.5em"></i>
				</div>
				<%--<label class="col-xs-2 control-label" id = "menuBtn2"  onclick="showMenu();return false;">选择</label>--%>
			</div>
			<input type="hidden" id="FDEPTCODE" name="FDEPTCODE">
			<input type="hidden" id="FORGCODE" name="FORGCODE">
			<input type="hidden" id="FDATARANGE" name="FDATARANGE">
		</form>
	</div>
	
	<h2>Layer</h2>
	<table>
		<tr>
			<td>
				<button id="test1" class="btn btn-primary"><i class="iconfont icon-xinzeng-copy"></i>弹出一个提示层</button>
			</td>		
		</tr>
		<tr>
			<td>
				<button id="test2" class="btn btn-default"><i class="iconfont icon-xinzeng-copy"></i>弹出一个页面层</button>
			<td>
		</tr>
		<tr>
			<td>
				<button id="test21" class="btn btn-default"><i class="iconfont icon-xinzeng-copy"></i>弹出一个可关闭页面层</button>
			<td>
		</tr>
		<tr>
			<td>
			<button id="parentIframe" class="btn btn-primary"><i class="iconfont icon-xinzeng-copy"></i>弹出一个iframe层</button>
			</td>
		</tr>
		<tr>
			<td>
			<button id="test4" class="btn btn-default"><i class="iconfont icon-xinzeng-copy"></i>弹出一个loading层</button>
			</td>
		</tr>
		<tr>
			<td>
			<button id="test5" class="btn btn-primary"><i class="iconfont icon-xinzeng-copy"></i>弹出一个tips层</button>
			</td>
		</tr>
	</table>
	

<script>
  
  //弹出一个提示层
  $('#test1').on('click', function(){
    layer.msg('hello');
  });
  
  //弹出一个页面层
  $('#test2').on('click', function(){
    layer.open({
      type: 1,
      area: ['600px', '360px'],
      shadeClose: true, //点击遮罩关闭
      content: '\<\div style="padding:20px;">自定义内容\<\/div>'
    });
  });
  
//弹出一个页面层
  $('#test21').on('click', function(){
    layer.open({
      type: 1,
      title:'用户-添加',
  	  skin:'layer-window',
      area: ['600px', '360px'],
      shadeClose: true, //点击遮罩关闭
      content:$('#add-content'),
      //content: '\<\div style="padding:20px;">自定义内容\<\/div>',
  	  btn:['添加','取消'],
 		/* yes:function () {
 			postData('add');
 		} */
    });
  });
  
  //弹出一个iframe层
  $('#parentIframe').on('click', function(){
    layer.open({
      type: 2,
      title: 'iframe父子操作',
      maxmin: true,
      shadeClose: true, //点击遮罩关闭层
      area : ['800px' , '520px'],
      content: 'test/iframe.html'
    });
  });
  
  //弹出一个loading层
  $('#test4').on('click', function(){
    var ii = layer.load();
    //此处用setTimeout演示ajax的回调
    setTimeout(function(){
      layer.close(ii);
    }, 1000);
  });
  
  //弹出一个tips层
  $('#test5').on('click', function(){
    layer.tips('Hello tips!', '#test5');
  });
  
  </script>
</body>
</html>