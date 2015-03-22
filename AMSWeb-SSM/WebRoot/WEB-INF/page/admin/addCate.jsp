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
    
    <title>添加资产类别</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="/${projectName }/css/style.css">

	<script type="text/javascript" src="/${projectName }/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function(){

			var bigCate=$("#bigCateSelect")[0];
			<c:forEach items="${categoryList }" var="cate">
				<c:if test="${cate.supper == '根种类'}">
					var opts = new Option( '${cate.name}', '${cate.name}');
					bigCate.add(opts); 
				</c:if>
			</c:forEach>
			
			function checkForm1() {
				var bigCate=$("#bigCate").val();

				if(bigCate==""){
					alert("请输入完整信息！");
					return false;
				}else{
					return ture;
				}
			}
			
			$("#form1").submit(checkForm1);
			
			function checkForm2() {
				var smallCate=$("#smallCate").val();

				if(smallCate==""){
					alert("请输入完整信息！");
					return false;
				}else{
					return ture;
				}
			}
			
			$("#form2").submit(checkForm2);
		});
	</script>
  </head>
  
  <body>
    <div class="whole">
		<my:top/>
		<div class="main">
			<my:left/>
			<div class="right">
			
				<div class="title">资产类别管理->->添加资产类别</div>
				<hr>
				<br/>
  				<br/>
  				<br/>
				<form action="admin_cate_doAddCate.action" method="post" id="form1">
		  			<table>
		  				<div class="title">添加大类</div>
		  				<tr>
		  					<td>请输入大类名称：</td>
		  					<td><input type="text" id="bigCate" name="bigCate" placeholder="请输入大类名称" ></td>
		  					<td></td>
		  				</tr>
		  				<tr>
		  					<td></td>
		  					<td><input type="submit" value="添加大类"/></td>
		  					<td></td>
		  				</tr>
		  			</table>
  				</form>
  				<br/>
  				<br/>
  				<br/>
  				<hr/>
  				<br/>
  				<br/>
  				<br/>
  				<form action="admin_cate_doAddCate.action" method="post" id="form2">
		  			<table>
		  				<div class="title">添加小类</div>
		  				<tr>
		  					<td>请选择大类：</td>
		  					<td>
		  						<select id="bigCateSelect" name="bigCateSelect"></select>
		  					</td>
		  					<td></td>
		  				</tr>
		  				<tr>
		  					<td>请输入小类名称：</td>
		  					<td><input type="text" id="smallCate" name="smallCate" placeholder="请输入小类名称" ></td>
		  					<td></td>
		  				</tr>
		  				<tr>
		  					<td></td>
		  					<td><input type="submit" value="添加小类"/></td>
		  					<td></td>
		  				</tr>
		  			</table>
  				</form>
			</div>
		</div>
	</div>
  </body>
</html>
