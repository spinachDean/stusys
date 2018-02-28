package cn.hbu.stusys.controller;

import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.service.IAdminService;
import cn.hbu.stusys.service.IStudentService;
import cn.hbu.stusys.util.StringConst;

/**
 * 管理员控制层，所需要权限最高,教学秘书和团委书记使用
 * @author chensiming
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	IStudentService studentService;
	@Autowired
	IAdminService adminService;
	/**
	 * 临时方法 跳转到管理页面 暂时不做检查
	 * @return
	 */
	@GetMapping
	public String admin(HttpServletRequest request)
	{
		return "/WEB-INF/view/admin.jsp";
	}
	
	/**
	 * 跳转到管理员管理学生页面
	 * 使用异步方法减少主线程的占用
	 * @param request
	 * @param page
	 * @return
	 */
	@GetMapping("/manageInfo/{page}")
	public Callable<String> ge1tAllStudentInfo(final HttpServletRequest request,@PathVariable("page") Integer page,final Student student)
	{
		final int p;//临时的page
		if(page==null) p=1;
		else p=page;

		return new Callable<String>() {
			
			public String call() throws Exception {
				request.setAttribute(StringConst.INFO,adminService.getStudentInfoByPage(p,20,student));
				return "/WEB-INF/view/StuMessageManage.jsp";
			}
		};
		
	}
	/**
	 * 根据ID查询学生详细信息 管理员才能进行的操作
	 * @param request
	 * @param id
	 * @return
	 */
	@GetMapping("/getDetails/{id}")
	public String getStudentDetails(HttpServletRequest request,@PathVariable(value="id",required=true)String id)
	{
		request.setAttribute(StringConst.DETAIL,studentService.getStudentDetailInfo(id));
		return "/WEB-INF/view/StuMessageDetails.jsp";
	}
	


}
