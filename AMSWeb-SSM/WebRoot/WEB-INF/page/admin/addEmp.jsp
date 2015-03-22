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
    
    <title>添加职员</title>
    
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
				var EmpName=$("#EmpName").val();
				var Post=$("#Post").val();
				var EmpRemark=$("#EmpRemark").val();

				if(EmpName=="" || Post=="" || EmpRemark==""){
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
			
				<div class="title">职员管理->->添加职员</div>
				<hr>
				<br/>
  				<br/>
  				<br/>
				<form action="admin_emp_doAddEmp.action" method="post" >
					<input type="hidden" id="EmpNo" name="e.id" value="${maxNo }" />
		  			<table>
		  				<div class="title">添加职员</div>
		  				<tr>
		  					<td>职员姓名：</td>
		  					<td colspan="2"><input type="text" id="EmpName" name="e.name" /></td>
		  				</tr>
		  				<tr>
		  					<td>职位：</td>
		  					<td colspan="2"><input type="text" id="Post" name="e.post"/></td>
		  				</tr>
		  				<tr>
		  					<td>备注：</td>
		  					<td colspan="2"><input type="text" id="EmpRemark" name="e.remark"/></td>
		  				</tr>
		  				<tr>
		  					<td></td>
		  					<td><input type="submit" value="添加职员"/></td>
		  					<td></td>
		  				</tr>
		  			</table>
  				</form>
			</div>
		</div>
	</div>
  </body>
</html>
