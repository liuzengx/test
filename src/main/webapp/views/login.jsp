<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>java后台管理</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="login_box">
      <div class="login_l_img"><img src="images/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
          <div class="login_name">
               <p>OA管理系统</p>
          </div>
          <form method="post" action="login">
          	<span style="background: red" id="msg"></span>
              <input  name="mid" id="mid" type="text"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
              <!-- <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
			  <input type="password" name="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/> -->
              <input type="password" name="password" id="password" />
              <input class="login_submit" value="登录" style="width:100%;" type="submit">
              <!-- <button class="login" type="submit" value="submit" style="width:100%;">Submit</button> -->
          </form>
      </div>
      <!-- <div class="copyright">某某有限公司 版权所有©2016-2018 技术支持电话：000-00000000</div> -->
</div>
<div style="text-align:center;">
<!-- <p>更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p> -->
</div>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	
	if (window.parent.window != window) {
		var href = window.location.href+"";
		if(href && href.indexOf('?kickout')!=-1){
			alert('您已经被踢出，请重新登录！');
		}
        window.top.location = "index.do";

    } 
   
    <%-- $(".login_submit").click(function () {
        var userName = $("#username").val();
        if (userName == '' || userName == null) {
            alert("用户名输入不能为空");
            return;
        }

        var password = $("#password").val();
        if (password == '' || password == null) {
            alert("密码输入不能为空");
            return;
        }
    });
    <% String msg = (String)request.getAttribute("msg"); %>
    if ('<%=msg%>' != 'null') {
        $("#msg").html('<%=msg%>');
    } --%>
</script>
</body>
</html>