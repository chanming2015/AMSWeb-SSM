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
    
    <title>修改固定资产</title>
    
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
					<c:if test="${cate.name == asset.cate.supper}">
						opts.selected = true;
					</c:if>
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
						if(categoryArr[i].name=='${asset.cate.name }'){
							opts.selected = true;
						}
						small.add(opt);
					}
				} 		
			}
			
			bigCate.onchange = fillCate;
			fillCate();
			
			function checkForm() {
				var AssetName=$("#AssetName").val();
				var AssetPrice=$("#AssetPrice").val();
				var AssetRemark=$("#AssetRemark").val();

				if(AssetName=="" || AssetPrice=="" || AssetRemark==""){
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
			
				<div class="title">固定资产管理->->修改固定资产</div>
				<hr>
				<br/>
  				<br/>
  				<br/>
				<form action="admin_asset_doModifyAsset.action" method="post" >
		  			<input type="hidden" id="AssetName" name="a.id" value="${asset.id }" />
		  			<table>
		  				<div class="title">修改固定资产</div>
		  				<tr>
		  					<td>资产名称：</td>
		  					<td colspan="3"><input type="text" id="AssetName" name="a.name" value="${asset.name }" /></td>
		  				</tr>
		  				<tr>
		  					<td>大类：</td>
		  					<td><select id="bigCateSelect" name=""></select></td>
		  					<td>小类：</td>
		  					<td><select id="smallCateSelect" name="name"></select></td>
		  				</tr>
		  				<tr>
		  					<td>购入价格：</td>
		  					<td colspan="3"><input type="text" id="AssetPrice" name="a.price" value="${asset.price }"/></td>
		  				</tr>
		  				<tr>
		  					<td>资产借用状态：</td>
		  					<td colspan="3">
		  						<select id="statue" name="a.statue">
		  							<option value="可借出">可借出</option>
		  							<option value="待归还">待归还</option>
		  						</select>
		  					</td>
		  				</tr>
		  				<tr>
		  					<td>备注：</td>
		  					<td colspan="3"><input type="text" id="AssetRemark" name="a.remark" value="${asset.remark }"/></td>
		  				</tr>
		  				<tr>
		  					<td></td>
		  					<td><input type="submit" value="确定修改"/></td>
		  					<td></td>
		  				</tr>
		  			</table>
  				</form>
			</div>
		</div>
	</div>
  </body>
</html>
