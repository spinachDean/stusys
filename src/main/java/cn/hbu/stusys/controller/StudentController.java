package cn.hbu.stusys.controller;

import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.service.IStudentService;
import cn.hbu.stusys.util.StringConst;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	IStudentService studentService;

	/**
	 * 查询自己的详细信息
	 * 使用异步方法，防止查询的人数太多占用主线程
	 * @param request
	 * @param id
	 * @return
	 */
	@GetMapping("/getDetailInfo")
	public Callable<String> getStudentDetails(final HttpServletRequest request)
	{
		return new Callable<String>() {
			public String call() throws Exception {
				Student stu=(Student) request.getSession().getAttribute(StringConst.USER);
				request.setAttribute(StringConst.DETAIL,studentService.getStudentDetailInfo(stu.getId()));
				return "/WEB-INF/view/StuMessageDetails.jsp";
			}
		};

	}
	@GetMapping("/login")
	public @ResponseBody String loginStudent(HttpServletRequest request,String username,String password)
	{
		Student stu=new Student();
		stu.setId("20151101029");
		request.getSession().setAttribute(StringConst.USER,stu);
		return "学生模拟登录成功";
	}
}

