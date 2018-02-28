package cn.hbu.stusys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.hbu.stusys.model.Menu;
import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.model.Teacher;
import cn.hbu.stusys.util.StringConst;

/**
 * @author chensiming
 *学生登录拦截，学生只有登录才能访问
 */
public class StudentLoginInterceptor implements HandlerInterceptor {
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO 自动生成的方法存根
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		Object o= request.getSession().getAttribute(StringConst.USER);
		if(o==null){
			response.sendRedirect(request.getContextPath());
			return false;//如果未登录，放回false
		}
		if(o instanceof Student)
		{
			Student stu=(Student)o;
			//如果是学生 不能访问教师有关页面
			if(((Student) o).getId()!=null)
			return true;
		}

		return false;
	}

}
