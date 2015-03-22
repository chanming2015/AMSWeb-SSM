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
    
    <title>操作员管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/${projectName }/css/style.css">

  </head>
  
  <body>
	<div class="whole">
		
		<my:top/>
		<div class="main">
			
			<my:left/>
			<div class="right">
				<div class="title">操作员管理->->所有操作员</div>
				<hr>
				<form action="">
					<div class="show">
						<table>
							<tr>
								<td>操作员账号</td>
								<td>是否可以使用</td>
								<td>操作员角色</td>
								<td>操作</td>
							</tr>
							
							<c:forEach items="${operatorList }" var="op">
								<tr>
									<td>${op.userName }</td>
									<td>${op.used }</td>
									<td>${op.role }</td>
									<td>
										<a>修改</a>
										<a>删除</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</form>
			</div>
		</div>
	</div>
  </body>
</html>
