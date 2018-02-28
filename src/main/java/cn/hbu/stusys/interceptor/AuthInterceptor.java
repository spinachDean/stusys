package cn.hbu.stusys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







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
 *权限拦截器，权限拦截
 */
public class AuthInterceptor implements HandlerInterceptor {

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
			//如果是学生 不能访问教师有关页面
			return false;
		}
		//如果是老师 只能访问自己权限有关的页面
		Teacher t=(Teacher)o;
		String servlet=request.getServletPath();
		for(Menu m:t.getMenulist())
		{
			//重写了equal方法，添加了自己的标识符
			if(m.equal(servlet))
			{
				return true;//如果相等则返回true
			}
		}
		return false;
	}

}
