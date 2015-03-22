/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Project:AMSWeb
 * Package:com.dyr.team1.xms.amsw.interceptor
 * FileName:MethodInterceptor.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015-2-12 下午3:37:12
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@SuppressWarnings("serial")
public class MethodInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		ActionContext ctx=invocation.getInvocationContext();
		if(ctx.getSession().get("admin")!=null){
			return invocation.invoke();
		}else {
			return "login";
		}
	}

}
