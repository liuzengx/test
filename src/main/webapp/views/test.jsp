<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/9
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
ajax请求<input id="test"></input>
<script type="text/javascript" src="js/jquery.js"></script> 
<script type="text/javascript">
	
	$(function(){
		$.ajax({
			url:"${pageContext.request.contextPath }/loguo",
			type:"GET",
			data:{"id":1}, 
			contentType: 'application/json;charset=utf-8',
			success:function(data) {
				debugger
				$("#test").val(data);
			}
		});
	});
</script> 
</body>
</html>
