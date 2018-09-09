package com.zf.blog.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 创建文件夹
 * @author zf
 * 2017年12月5日
 */
@WebListener
public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 

    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	String basePath=sce.getServletContext().getRealPath("");
    	File fl=new File( new File(basePath).getParentFile() , "uploadfile");
    	if (!fl.exists()) {
			fl.mkdirs();
		}
    }
}
