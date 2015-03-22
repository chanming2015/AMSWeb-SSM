<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>固定资产管理系统登录 </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/${projectName }/css/style.css">
	<script type="text/javascript" src="/${projectName }/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			function checkForm() {
				var username=$("#username").val();
				var password=$("#password").val();
				if(username=="" || password==""){
					alert("请输入完整信息！");
					return false;
				}else{
					return ture;
				}
			}
			
			$("form").submit(checkForm);
		});
	</script>
	
  </head>
  
  <body>
  	<div class="whole">
  		<form action="admin_op_doLogin.action" method="post" >
  			<table>
  				<div class="title">固定资产管理系统登录 </div>
				<tr>
					<td>用户名：</td>
					<td><input type="text" id="username" name="username" placeholder="请输入用户名" ></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" id="password" name="password" placeholder="请输入密码" ></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="登录"/></td>
				</tr>
  			</table>
  		</form>
  	</div>
  </body>
</html>
