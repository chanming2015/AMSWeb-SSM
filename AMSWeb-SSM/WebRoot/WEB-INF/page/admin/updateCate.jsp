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
    
    <title>修改资产类别</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="/${projectName }/css/style.css">

	<script type="text/javascript" src="/${projectName }/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var old = $("#oldName")[0];
			old.value = '${name}';
			
			function checkForm() {
				var oldName=$("#oldName").val();
				var newName=$("#newName").val();

				if(oldName=="" || newName==""){
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
			
				<div class="title">资产类别管理->->修改资产类别</div>
				<hr>
				<br/>
  				<br/>
  				<br/>
				<form action="admin_cate_doModifyCate" method="post" >
		  			<table>
		  				<tr>
		  					<td>原名称：</td>
		  					<td><input type="text" id="oldName" name="oldName" /></td>
		  					<td></td>
		  				</tr>
		  				<tr>
		  					<td>新名称：</td>
		  					<td><input type="text" id="newName" name="newName" placeholder="请输入新名称" /></td>
		  					<td></td>
		  				</tr>
		  				<tr>
		  					<td></td>
		  					<td><input type="submit" value="修改"/></td>
		  					<td></td>
		  				</tr>
		  			</table>
  				</form>
			</div>
		</div>
	</div>
  </body>
</html>
