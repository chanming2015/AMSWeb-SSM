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
    
    <title>固定资产</title>
    
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
				<div class="title">固定资产管理->->固定资产</div>
				<hr>
				<form action="">
					<div class="show">
						<table>
							<tr>
								<td>资产编号</td>
								<td>资产名称</td>
								<td>资产类别</td>
								<td>购买价格</td>
								<td>购买时间</td>
								<td>资产状态</td>
								<td>资产备注</td>
								<td>操作</td>
							</tr>
							
							<c:forEach items="${assetList }" var="asset">
								<tr>
									<td>${asset.id }</td>
									<td>${asset.name }</td>
									<td>${asset.cate.name }</td>
									<td>${asset.price }</td>
									<td>${asset.buyTime }</td>
									<td>${asset.statue }</td>
									<td>${asset.remark }</td>
									<td>
										<a href="admin_asset_toModifyAsset.action?id=${asset.id }">修改</a>
										<a href="admin_asset_doRemoveAsset.action?id=${asset.id }">删除</a>
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
