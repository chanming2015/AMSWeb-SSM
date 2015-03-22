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
    
    <title>添加固定资产</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="/${projectName }/css/style.css">
	<script type="text/javascript" src="/${projectName }/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
		
			$("#AssetNo").val('${maxNo}');
			
			var bigCate=$("#bigCateSelect")[0];
			<c:forEach items="${categoryList }" var="cate">
				<c:if test="${cate.supper == '根种类'}">
					var opts = new Option( '${cate.name}', '${cate.name}');
					bigCate.add(opts); 
				</c:if>
			</c:forEach>
			
			//创建小类别数组
			var categoryArr = [];
			<c:forEach items="${categoryList}" var="cate">
				<c:if test="${cate.supper != '根' && cate.supper != '根种类' }">
					categoryArr.push(
						{
							name: '${cate.name}',
							supper: '${cate.supper}'
						}
					);
				</c:if>
			</c:forEach>
			
			//填充小类的函数
			function fillCate() {
				var big = $("#bigCateSelect").val();	//得到大类的名称
				var small = $("#smallCateSelect")[0];
				small.length = 0;
				for (var i=0; i<categoryArr.length; i++) {
					if (big==categoryArr[i].supper) {
						var opt = new Option( categoryArr[i].name, categoryArr[i].name );
						small.add(opt);
					}
				} 		
			}
			
			bigCate.onchange = fillCate;
			fillCate();
			
			function checkForm() {
				var AssetNo=$("#AssetNo").val();
				var AssetName=$("#AssetName").val();
				var AssetPrice=$("#AssetPrice").val();
				var AssetRemark=$("#AssetRemark").val();

				if(AssetNo=="" || AssetName=="" || AssetPrice=="" || AssetRemark==""){
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
			
				<div class="title">固定资产管理->->添加固定资产</div>
				<hr>
				<br/>
  				<br/>
  				<br/>
				<form action="admin_asset_doAddAsset.action" method="post" >
		  			<table>
		  				<div class="title">添加固定资产</div>
		  				<tr>
		  					<td>资产编号：</td>
		  					<td><input type="text" id="AssetNo" name="a.id"></td>
		  					<td>资产名称：</td>
		  					<td><input type="text" id="AssetName" name="a.name"></td>
		  				</tr>
		  				<tr>
		  					<td>大类：</td>
		  					<td><select id="bigCateSelect" name=""></select></td>
		  					<td>小类：</td>
		  					<td><select id="smallCateSelect" name="name"></select></td>
		  				</tr>
		  				<tr>
		  					<td>购入价格：</td>
		  					<td colspan="3"><input type="text" id="AssetPrice" name="a.price"/></td>
		  				</tr>
		  				<tr>
		  					<td>备注：</td>
		  					<td colspan="3"><input type="text" id="AssetRemark" name="a.remark"/></td>
		  				</tr>
		  				<tr>
		  					<td></td>
		  					<td><input type="submit" value="添加资产"/></td>
		  					<td></td>
		  				</tr>
		  			</table>
  				</form>
			</div>
		</div>
	</div>
  </body>
</html>
