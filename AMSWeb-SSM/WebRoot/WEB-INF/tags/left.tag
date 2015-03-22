<%@ tag pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="left">
	<input type="hidden" value="${projectName}" id="projectName">
	<link rel="StyleSheet" href="/${projectName}/js/dtree/dtree.css" type="text/css" />
    <script type="text/javascript" src="/${projectName}/js/dtree/dtree.js"></script>
  	<script type="text/javascript">
		d = new dTree('d');
		var index= 1;
		var indexArr = [];
		var urlArry = [];
		urlArry.push(
			{
				url: '',
				name: ''
			}
		);
		
		<c:forEach items="${roleMenuList }" var="roleMenu">
			<c:choose>
				<c:when test="${roleMenu.menu.supper == '根' }">
					d.add(0, -1,'${roleMenu.menu.name }');
				</c:when>
				<c:when test="${roleMenu.menu.supper == '固定资产管理系统' }">
					d.add(index, 0,'${roleMenu.menu.name }');
					//将一级目录和对应编号放入数组
					indexArr.push(
						{
							index: index,
							name: '${roleMenu.menu.name}'
						}
					);
					index++;
				</c:when>
				<c:otherwise>
					for (var i=0; i<indexArr.length; i++) {
						//查找一级目录与父目录相等
						if ('${roleMenu.menu.supper}' == indexArr[i].name ) {
							d.add(index, indexArr[i].index,'${roleMenu.menu.name }','/${projectName}/admin_${roleMenu.menu.url}.action','添加资产类别','');
							index++;
							break;
						}
					}
				</c:otherwise>
			</c:choose>
		</c:forEach>
        document.write(d); 
        d.openAll();        
	</script>
</div>