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
    
    <title>归还资产</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="/${projectName }/css/style.css">

	<script type="text/javascript" src="/${projectName }/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			
			//是否可归还
			var flag=false;
			var assetArry = [];
			<c:forEach items="${assetList}" var="asset">
				assetArry.push(
					{
						id:	${asset.id},
						name: '${asset.name}',
						statue: '${asset.statue}',
					}
				);
			</c:forEach>
			
			function fillAssetInfo() {
				
				//获得资产编号
				var assetId=$("#assetId").val();
				//资产说明
				var info;
				for ( var i = 0; i < assetArry.length; i++) {
					
					if(assetId==assetArry[i].id){
						if(assetArry[i].statue=='待归还'){
							flag=true;
						}else {
							flag=false;
						}
						info=assetArry[i].name+"，"+assetArry[i].statue;
						break;
					}
				}
				$("#assetInfo").val(info);
			}
			
			$("#assetId").change(fillAssetInfo);
			fillAssetInfo();
			
			function checkForm() {
				
				var remark=$("#remark").val();

				if(remark==""){
					alert("请输入完整信息！");
					return false;
				}else{
					return ture && flag;
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
			
				<div class="title">借出与归还管理->->归还资产</div>
				<hr>
				<br/>
  				<br/>
  				<br/>
				<form action="admin_op_doBackAsset.action" method="post" >
		  			<table>
		  				<div class="title">归还资产</div>
		  				<tr>
		  					<td>资产编号：</td>
		  					<td>
		  						<select id="assetId" name="assetId">
									<c:forEach items="${assetList }" var="asset">
										<option value="${asset.id }">${asset.id }</option>
									</c:forEach>
		  						</select>
		  					</td>
		  					<td>资产说明：</td>
		  					<td><input type="text" id="assetInfo" name="assetInfo"></td>
		  				</tr>
		  				<tr>
		  					<td>备注：</td>
		  					<td colspan="3"><input type="text" id="remark" name="remark"/></td>
		  				</tr>
		  				<tr>
		  					<td></td>
		  					<td><input type="submit" value="确定归还"/></td>
		  					<td></td>
		  				</tr>
		  			</table>
  				</form>
			</div>
		</div>
	</div>
  </body>
</html>
