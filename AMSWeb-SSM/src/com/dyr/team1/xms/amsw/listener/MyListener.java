/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Project:AMSWeb
 * Package:com.dyr.team1.xms.amsw.listener
 * FileName:MyListener.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015-2-12 下午3:10:11
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public class MyListener implements ServletContextListener{
	
	private ServletContext application;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		//得到公共区域
		application=sce.getServletContext();
		//得到工程路径
		String webRootPath=application.getRealPath("");
		//得到工程名称
		String projectName=webRootPath.substring(webRootPath.lastIndexOf("\\") + 1);
		application.setAttribute("projectName", projectName);
	}

}
