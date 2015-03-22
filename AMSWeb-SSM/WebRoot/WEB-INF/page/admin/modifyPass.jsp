<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码 </title>
    
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
				var oldPass=$("#oldPass").val();
				var newPass1=$("#newPass1").val();
				var newPass2=$("#newPass2").val();

				if(oldPass=="" || newPass1=="" || newPass2==""){
					alert("请输入完整信息！");
					return false;
				}else{
					if(newPass1!=newPass2){
						alert("两次密码驶入不一致！");
						return false;
					}else{
						return ture;
					}
				}
			}
			
			$("form").submit(checkForm);
		});
	</script>
  </head>
  
  <body>
  	<div class="whole">
  		<form action="admin_op_doModifyPass.action" method="post" >
  			<table>
  				<div class="title">修改密码</div>
				<tr>
					<td>原密码：</td>
					<td><input type="text" id="oldPass" name="oldPass" placeholder="请输入原密码" ></td>
				</tr>
				<tr>
					<td>新密码：</td>
					<td><input type="password" id="newPass1" name="newPass1" placeholder="请输入新密码" ></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" id="newPass2" name="newPass2" placeholder="请再次输入新密码" ></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="修改"/></td>
				</tr>
  			</table>
  		</form>
  	</div>
  </body>
</html>
