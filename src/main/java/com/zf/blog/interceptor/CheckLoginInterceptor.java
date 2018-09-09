package com.zf.blog.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 拦截器
 * @author zf
 * 2017年12月6日
 */
public class CheckLoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception ex)
			throws Exception {
		System.out.println("来了...");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}

	/**
	 * 在访问Controller之前调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2)
			throws Exception {
		if (arg0.getSession().getAttribute("currentLoginLeaguer")==null) {
			String path=arg0.getScheme()+"://"+arg0.getServerName()+":"+arg0.getServerPort()+arg0.getContextPath()+"/";
			arg1.setContentType("text/html;charset=utf-8");
			PrintWriter out=arg1.getWriter();
			out.println("<script>alert('请先登录...');location.href='"+path+"index.jsp'</script>");
			out.flush();
			out.close();
			return false;
		}
		return true;             //如果flase则不再往后传
	}

}
