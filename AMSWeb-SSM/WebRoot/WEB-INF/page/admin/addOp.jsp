<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加操作员</title>
    
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
		<my:top/>
		<div class="main">
			<my:left/>
			<div class="right">
			
				<div class="title">操作员管理->->添加操作员</div>
				<hr>
				<br/>
  				<br/>
  				<br/>
				<form action="admin_op_doAddOp.action" method="post" >
		  			<table>
		  				<div class="title">添加职员</div>
		  				<tr>
		  					<td>用户名：</td>
		  					<td colspan="2"><input type="text" id="username" name="op.userName" /></td>
		  				</tr>
		  				<tr>
		  					<td>密码：</td>
		  					<td colspan="2"><input type="text" id="password" name="op.password" /></td>
		  				</tr>
		  				<tr>
		  					<td>是否使用：</td>
		  					<td colspan="2">
		  						<select id="used" name="op.used">
		  							<option value="是">是</option>
		  							<option value="否">否</option>
		  						</select>
		  					</td>
		  				</tr>
		  				<tr>
		  					<td>角色：</td>
		  					<td colspan="2">
								<select id="role" name="op.role">
									<c:forEach items="${roleList }" var="role">
										<option value="${role }">${role }</option>
									</c:forEach>
		  						</select>
							</td>
		  				</tr>
		  				<tr>
		  					<td></td>
		  					<td><input type="submit" value="添加管理员"/></td>
		  					<td></td>
		  				</tr>
		  			</table>
  				</form>
			</div>
		</div>
	</div>
  </body>
</html>
